
def is_sorted(list):
    for i in range(0,max(0, len(list)-1)):
        if (list[i] > list[i+1]):
            return False
    return True

