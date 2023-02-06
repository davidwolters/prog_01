import u1 as u
from lib import single_param_test


def test_get_file_contents():
    single_param_test(
        "get_file_contents",
        [
            "texts/test_get_file_contents_0.txt",
            "texts/test_get_file_contents_1.txt",
            "texts/test_get_file_contents_2.txt",
            "texts/test_get_file_contents_3.txt",
            "texts/test_get_file_contents_4.txt",
        ],
        ['hello there', '1 2 3 4', '', '\n', 'this is a text'],
        u.get_file_contents
    )


def test_lowercase():
    single_param_test(
        "lowercase", ['ASDF', '**', '', 'a', 'Ö'], ['asdf', '**', '', 'a', 'ö'], u.lowercase
    )


def test_get_words():
    single_param_test(
        "get_words",
        ['a b c', '', 'a-b-c'],
        [['a', 'b', 'c'], [], ['a-b-c']],
        u.get_words
    )


def test_get_alpha():
    single_param_test(
        "get_alpha",
        ['alpha', '**', 'a-b-c'],
        ['alpha', '', 'abc'],
        u.get_alpha
    )


def test_get_num_words():
    single_param_test(
        "get_num_words",
        [['a', 'b', 'c'], []],
        [3, 0],
        u.get_num_words
    )


def test_list_to_dict():
    single_param_test(
        "list_to_dict",
        [['a', 'a'], ['a', 'b', 'c'], []],
        [{'a': 2}, {'a': 1, 'b': 1, 'c': 1}, {}],
        u.list_to_dict
    )


def test_get_num_unique_words():
    single_param_test(
        "get_num_unique_words",
        [{'a': 5, 'b': 4}, {}],
        [2, 0],
        u.get_num_unique_words
    )


def test_get_most_freq_word():
    single_param_test(
        "get_most_freq_word",
        [{'a': 2, 'b': 5, 'c': 5}, {}],
        [('b', 5), ('', 0)],
        u.get_most_freq_word
    )


def test_solve():
    single_param_test(
        "solve",
        ['texts/test2.txt'],
        [{
            "num_words": 10,
            "num_unique_words": 7,
            "max_freq": 3,
            "most_freq": "a"
        }],
        u.solve
    )


if __name__ == '__main__':
    test_get_file_contents()
    test_lowercase()
    test_get_words()
    test_get_alpha()
    test_get_num_words()
    test_list_to_dict()
    test_get_num_unique_words()
    test_get_most_freq_word()
    test_solve()
