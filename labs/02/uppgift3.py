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



