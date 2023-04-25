import random
import time
import math
import logging
import ray

if ray.is_initialized:
    ray.shutdown()
ray.init(address='auto', logging_level=logging.ERROR)


# Exercise 3.3) Take a look on implement parralel Pi computation
# based on https://docs.ray.io/en/master/ray-core/examples/highly_parallel.html
#
# Implement calculating pi as a combination of actor (which keeps the
# state of the progress of calculating pi as it approaches its final value)
# and a task (which computes candidates for pi)


@ray.remote
def pi_worker(sample_size, ps):
    in_count = 0
    for i in range(sample_size):
        x = random.random()
        y = random.random()
        if x * x + y * y <= 1:
            in_count += 1
    ps.update.remote(in_count)


@ray.remote
class PiSupervisor:
    def __init__(self, batches, sample_size):
        self.batches = batches
        self.sample_size = sample_size
        self.finished = 0
        self.current_in_count = 0
        self.current_sample_count = 0
        self.pi = 0

    def work(self, ps):
        [pi_worker.remote(self.sample_size, ps) for _ in range(self.batches)]

    def update(self, in_count):
        self.finished += 1
        self.current_in_count += in_count
        self.current_sample_count += self.sample_size
        self.pi = self.current_in_count / self.current_sample_count * 4

    def state(self):
        return self.finished, self.batches, self.pi


SAMPLE_COUNT = 1000 * 1000
FULL_SAMPLE_COUNT = 10 * 1000 * 1000 * 1000
BATCHES = int(FULL_SAMPLE_COUNT / SAMPLE_COUNT)

sup = PiSupervisor.remote(BATCHES, SAMPLE_COUNT)
sup.work.remote(sup)

while True:
    time.sleep(0.5)
    finished, batches, pi = ray.get(sup.state.remote())
    if finished == batches:
        print(f"RESULT PI: {pi}")
        break
    print(f"FINISHED: {finished}/{batches}, CURRENT PI: {pi}")
