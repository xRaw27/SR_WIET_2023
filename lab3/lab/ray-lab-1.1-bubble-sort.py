import time
import logging

import numpy as np
import sortednp
import ray

import cProfile

if ray.is_initialized:
    ray.shutdown()
ray.init(address='auto', logging_level=logging.ERROR)


# Exercise 1.1) Try using local bubble sort and remote bubble sort,
# show difference


def bubble_sort(arr: np.array):
    for i in range(len(arr)):
        swapped = False
        for j in range(0, len(arr) - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True
        if not swapped:
            break


@ray.remote
def merge(arr1: np.array, arr2: np.array) -> np.array:
    return sortednp.merge(arr1, arr2)


@ray.remote
def remote_bubble_sort(arr: np.array):
    arr_copy = arr.copy()
    bubble_sort(arr_copy)
    return arr_copy


def sequential_bubble_sort(arr: np.array):
    arr_copy = arr.copy()
    bubble_sort(arr_copy)
    return arr_copy


def parallel_bubble_sort(arr: np.array):
    arr_split = np.array_split(arr, 8)
    results = ray.get([remote_bubble_sort.remote(arr_split[i]) for i in range(8)])
    res_01 = merge.remote(results[0], results[1])
    res_23 = merge.remote(results[2], results[3])
    res_45 = merge.remote(results[4], results[5])
    res_67 = merge.remote(results[6], results[7])
    res_03 = merge.remote(ray.get(res_01), ray.get(res_23))
    res_47 = merge.remote(ray.get(res_45), ray.get(res_67))
    res_07 = merge.remote(ray.get(res_03), ray.get(res_47))
    return ray.get(res_07)


array = np.random.rand(15000)
array_sorted = np.sort(array.copy())

print(f"Array: {array}")
print(f"Array len: {len(array)}")

print('Sequential sort')
sequential_start_time = time.time()
result_sequential = sequential_bubble_sort(array)
assert np.array_equal(array_sorted, result_sequential)
print(f"Sequential sort duration: {time.time() - sequential_start_time}")
# cProfile.run("sequential_bubble_sort(array)")

print('Parallel sort')
parallel_start_time = time.time()
result_parallel = parallel_bubble_sort(array)
assert np.array_equal(array_sorted, result_parallel)
print(f"Parallel sort duration: {time.time() - parallel_start_time}")
# cProfile.run("parallel_bubble_sort(array)")

ray.shutdown()
