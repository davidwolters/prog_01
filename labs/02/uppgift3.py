import random
import time




def bytintill(list):
    swapped = False
    for i in range(0, max(0, len(list) - 1)):
        if list[i] > list[i+1]:
            list[i], list[i+1] = list[i+1], list[i] 
            swapped = True
    return swapped

def bubblesort(list):
    sorted_list = list.copy()
    while bytintill(sorted_list):
        pass
    return sorted_list

def random_list(len: int):
    return [random.randint(0, len-1) for _ in range(0, len)] 

def test_bubble_sort_limits():
    max_time = 0
    times = {} 
    len = 2800
    while max_time < 10:
        list = random_list(len)
        bs_start = time.time()
        bubblesort(list)
        bs_time = time.time() - bs_start
        times[len] = {}
        times[len]['bs'] = bs_time

        s_start = time.time()
        list.sort()
        s_time = time.time() - s_start
        times[len]['s'] = s_time
        len += 20

        max_time = bs_time if bs_time > max_time else max_time 
        print(f"{len}: {bs_time} / {s_time} = {bs_time/s_time}")
    print(times)


if __name__ == '__main__':
    test_bubble_sort_limits()

