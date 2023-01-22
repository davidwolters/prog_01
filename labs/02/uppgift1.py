

def is_sorted(list):
    for i in range(0,max(0, len(list)-1)):
        if (list[i] > list[i+1]):
            return False
    return True



def test_is_sorted():
    lists = [
        [1,5,7,99],
        [3,7,0,8],
        [1,2,3,4],
        [1,1,0],
        [],
        [1, 2, 3, 4, 5, 1]
    ]

    sorted_lists = [0, 2, 4]

    for i in range(0, len(lists)):
        sorted = is_sorted(lists[i])
        print(lists[i], "\n\tsorted:", sorted, "expected:", i in sorted_lists, "passed:\t", sorted == (i in sorted_lists))

if __name__ == '__main__':
    test_is_sorted()