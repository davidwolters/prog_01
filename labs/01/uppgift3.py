from uppgift1 import get_digit_sum

def print_digit_sums():
    i = 1
    while i < 10000: 
        if get_digit_sum(i) ** 3 == i:
            print(i)
        i += 1

if __name__ == '__main__':
    print_digit_sums()





