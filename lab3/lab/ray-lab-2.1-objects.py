import time
import logging
import ray

if ray.is_initialized:
    ray.shutdown()
ray.init(address='auto', logging_level=logging.ERROR)


# Exercise 2.1) Create large lists and python dictionaries,
# put them in object store. Write a Ray task to process them.


@ray.remote
def list_and_dict_avg(_list: list, _dict: dict):
    time.sleep(15)

    # print list and dict head
    print(_list[:10])
    print(list(_dict.items())[:10])

    list_avg = sum(_list) / len(_list)
    dict_avg = sum(_dict.values()) / len(_dict)

    return list_avg, dict_avg


large_list = [i ** 2 + 6 * i + 10 for i in range(10000000)]
large_dict = {f"key_{i}": i ** 2 + 6 * i + 10 for i in range(10000000)}

large_list_ref = ray.put(large_list)
large_dict_ref = ray.put(large_dict)

result = ray.get(list_and_dict_avg.remote(large_list_ref, large_dict_ref))
print(f"Result: {result}")
