from uppgift3 import bytintill, bubblesort

def test_bytintill():
    print("\n==== TESTING bytintill() ====")
    lists = [
        [4, 3, 2, 1],
        [1, 9, 2, 3, 1],
        [],
        [2, 1],
        [1, 2]
    ]

    expected = [
        [3, 2, 1, 4],
        [1, 2, 3, 1, 9],
        [],
        [1, 2],
        [1, 2]
    ]

    for i in range(0, len(lists)):
        original = lists[i].copy()
        bytintill(lists[i])
        if lists[i] != expected[i]:
            print(f"Test {i+1} failed. result = {lists[i]}, expected = {expected[i]}")
        else:
            print(f"Test {i+1} passed. {original} => {lists[i]}")
    
def test_bubblesort():
    print("\n==== TESTING bubblesort() ====")
    lists = [
        [4, 3, 2, 1],
        [1, 9, 2, 3, 1],
        [],
        [2, 1],
        [1, 2]
    ]

    expected = [
        [1, 2, 3, 4],
        [1, 1, 2, 3, 9],
        [],
        [1, 2],
        [1, 2]
    ]

    for i in range(0, len(lists)):
        sorted = bubblesort(lists[i])
        if sorted != expected[i]:
            print(f"Test {i+1} failed. result = {sorted}, expected = {expected[i]}")
        else:
            print(f"Test {i+1} passed. {lists[i]} => {sorted}")

if __name__ == '__main__':
    test_bytintill()
    test_bubblesort()

