import random
import time
import math
import logging
import ray

if ray.is_initialized:
    ray.shutdown()
ray.init(address='auto', logging_level=logging.ERROR)

# Exercise 3.1) Modify the Actor class MethodStateCounter and add/modify methods that return the following:
# a) - Get number of times an invoker name was called
# b) - Get a list of values computed by invoker name
# c) - Get state of all invokers
# Exercise 3.2) Modify method invoke to return a random int value between [5, 25]


CALLERS = ["A", "B", "C"]


@ray.remote
class MethodStateCounter:
    def __init__(self):
        self.invokers_calls = {CALLER: 0 for CALLER in CALLERS}
        self.invokers_values = {CALLER: [] for CALLER in CALLERS}

    def invoke(self, name):
        # pretend to do some work here
        time.sleep(0.5)

        # update times invoked
        self.invokers_calls[name] += 1

        # update values
        value = random.randint(5, 25)
        self.invokers_values[name].append(value)

        return value

    def get_invoker_calls(self, name):
        return self.invokers_calls[name]

    def get_invoker_values(self, name):
        return self.invokers_values[name]

    def get_all_invokers_state(self):
        return {
            CALLER: {
                "calls": self.invokers_calls[CALLER],
                "values": self.invokers_values[CALLER]
            }
            for CALLER in CALLERS
        }


# Create an instance of our Actor
worker_invoker = MethodStateCounter.remote()
print(worker_invoker)

# Iterate and call the invoke method by random callers and keep track of who
# called it.

for _ in range(10):
    name = random.choice(CALLERS)
    worker_invoker.invoke.remote(name)

# Invoke a random caller and fetch the value or invocations of a random caller

print('method callers')
for _ in range(10):
    random_invoker = random.choice(CALLERS)
    value = ray.get(worker_invoker.invoke.remote(random_invoker))
    calls = ray.get(worker_invoker.get_invoker_calls.remote(random_invoker))
    values = ray.get(worker_invoker.get_invoker_values.remote(random_invoker))
    print(f"Named caller: {random_invoker} returned {value}\n"
          f"In total this {random_invoker} was called {calls} times and returned values: {values}")

# Fetch the count and values of all callers
print("ALL_INVOKERS_STATE:")
print(ray.get(worker_invoker.get_all_invokers_state.remote()))
