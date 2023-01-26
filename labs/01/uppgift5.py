from uppgift4 import get_sequence_length

def print_max_seq_len():
    max_at = 0
    max_len = 0
    i = 1
    while i < 51:
        seq_len = get_sequence_length(i)
        print(i, "has sequence length", seq_len)
        if seq_len > max_len:
            max_at = i
            max_len = seq_len
        i += 1
    print("maximum at", max_at, "is", max_len)


if __name__ == '__main__':
    print_max_seq_len()

