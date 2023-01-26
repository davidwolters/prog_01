from uppgift3 import bubblesort
import random
import time

def time_bubblesort(lists):
    start = time.time()
    for list in lists:
        bubblesort(list)
    elapsed = time.time() - start
    return elapsed / len(lists)

def time_sort(lists):
    start = time.time()
    for list in lists:
        list.sort()
    elapsed = time.time() - start
    return elapsed / len(lists)
    
def random_list(len: int):
    list = []
    for i in range(0, len):
        list.append(random.randint(0, len-1))
    return list

def get_random_lists(len: int, num_lists: int):
    lists = []
    for i in range(0, min(len, num_lists)):
        lists.append(random_list(len))
    return lists

def test_bubble_sort_limits():
    max_time = 0
    times = {} 
    len = 1
    while max_time < 10:
        lists = get_random_lists(len, 100)
        bs_time = time_bubblesort(lists)
        s_time = time_sort(lists)
        len += 20
        max_time = bs_time if bs_time > max_time else max_time 
        print(f"{len}: {bs_time} / {s_time} = {bs_time/max(1, s_time)}")
    print(times)