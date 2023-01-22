
def test_print_sequence():
    print_sequence(6)
    print_sequence(5)
    print_sequence(1)
    print_sequence(100)

def next_in_sequence(n: int):
    if n % 2 == 0:
        return n // 2
    return (n * 3) + 1

def print_sequence(n: int):
    while n > 1:
        print(n, end=", ")
        n = next_in_sequence(n)
    print(1)

if __name__ == '__main__':
    test_print_sequence()