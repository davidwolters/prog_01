from lib import single_param_test
from uppgift2 import get_following_words, solve


def test_get_following_words():
    single_param_test(
        'get_following_words',
        ['hej och hej och jag'.rsplit()],
        [{'hej': ['och', 'och'], 'och': ['hej', 'jag']}],
        get_following_words
    )


def test_solve():
    single_param_test(
        "solve",
        ['texts/test2.txt'],
        [{
            'a': ['a', 'b'],
            'b': ['c'],
            'c': ['d'],
            'd': ['e'],
            'e': ['f'],
            'f': ['g'],
            'g': ['g', 'a']
        }],
        solve
    )


if __name__ == '__main__':
    test_get_following_words()
    test_solve()
