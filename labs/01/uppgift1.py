
def test_get_digit_sum():
    ds_123 = get_digit_sum(123)
    ds_1001 = get_digit_sum(1001)
    ds_0 = get_digit_sum(0)
    ds_120514 = get_digit_sum(120514)

    if ds_123 == 6: print("ds(123) = 6, passed")
    else: print("ds(123) = 6, failed, got", ds_123)

    if ds_1001 == 2: print("ds(1001) = 2, passed")
    else: print("ds(1001) = 2, failed, got", ds_1001)

    if ds_0 == 0: print("ds(0) = 0, passed")
    else: print("ds(0) = 0, failed, got", ds_0)

    if ds_120514 == 13: print("ds(120514) = 13, passed")
    else: print("ds(120514) = 13, failed, got", ds_120514)

def get_digit_sum(number: int):
    sum = 0
    while number > 0:
        remainder = number % 10 # resten när man delar talet med 20 (1004 -> 4)
        sum = sum +  remainder # lägg till den på summan
        number = number // 10 # // är division med heltal som resultat 
    return sum

if __name__ == '__main__':
    test_get_digit_sum() 