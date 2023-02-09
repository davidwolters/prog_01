from lib import single_param_test, func_result_test
from u2 import get_text_from_successors, get_word_successors, get_successors_from_text, get_successor_text
import random as r
import u1 as u


def test_get_word_successors():
    func_result_test(
        "get_word_successors",
        [
            ['a b c d a b f'.rsplit(), 2],
            ['hej och hej och hejsan'.rsplit(), 1]
        ],
        [
            {('a', 'b'): ['c', 'f'], ('b', 'c'): ['d'],
             ('c', 'd'): ['a'], ('d', 'a'): ['b']},
            {('hej',): ['och', 'och'], ('och',): ['hej', 'hejsan']}
        ],
        get_word_successors
    )


def test_get_successors_from_text():
    func_result_test(
        "get_successors_from_text",
        [
            ['a b c d a b f', 2],
            ['hej och hej och hejsan', 1]
        ],
        [
            {('a', 'b'): ['c', 'f'], ('b', 'c'): ['d'],
             ('c', 'd'): ['a'], ('d', 'a'): ['b']},
            {('hej',): ['och', 'och'], ('och',): ['hej', 'hejsan']}
        ],
        get_successors_from_text
    )


def get_texts():
    return {f"test{i}.txt": (u.get_file_contents(f"texts/test{i}.txt"), r.randint(1, 3)) for i in range(1, 5)}


def test_get_text_from_successors():
    print("\n==== TESTING get_text_from_successors() ====")
    for file, (content, n) in get_texts().items():
        print(f"\n\t#### TEXT: {file}, n={n} ####\n\t", end='')
        print(get_text_from_successors(get_successors_from_text(content, n), 40))


def test_get_successor_text():
    print("\n==== TESTING get_successor_text() ====")
    for file, (content, n) in get_texts().items():
        print(f"\n\t#### TEXT: {file}, n={n} ####\n\t", end='')
        print(get_successor_text(content, 40, n))


if __name__ == '__main__':
    test_get_word_successors()
    test_get_successors_from_text()
    test_get_text_from_successors()
    test_get_successor_text()
