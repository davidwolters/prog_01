from uppgift1 import is_sorted

def test_is_sorted():
    print("\n==== TESTING is_sorted() ====")
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
        should_be_sorted = i in sorted_lists
        if sorted != should_be_sorted:
            print(f"Test {i+1} failed. {lists[i]} => {sorted}, expected {should_be_sorted}")
        else:
            print(f"Test {i+1} passed. sorted {lists[i]} => {sorted}")

if __name__ == '__main__':
    test_is_sorted()
