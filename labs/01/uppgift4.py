from uppgift2 import next_in_sequence

def test_get_sequence_length():
    sl_6 = get_sequence_length(6)
    sl_5 = get_sequence_length(5)
    sl_1 = get_sequence_length(1)
    sl_100 = get_sequence_length(100)

    if sl_6 == 9: print("sl(6) = 9, passed")
    else: print("sl(6) = 9, failed, got", sl_6)

    if sl_5 == 6: print("sl(5) = 6, passed")
    else: print("sl(5) = 6, failed, got", sl_5)

    if sl_1 == 1: print("sl(1) = 1, passed")
    else: print("sl(1) = 1, failed, got", sl_1)

    if sl_100 == 26: print("sl(100) = 26, passed")
    else: print("sl(100) = 26, failed, got", sl_100)

def get_sequence_length(n: int):
    seq_len = 1
    while n > 1:
        seq_len += 1
        n = next_in_sequence(n)
    return seq_len


if __name__ == '__main__':
    test_get_sequence_length()

