from lib import single_param_test
from u2 import get_following_words, get_text_from_following_words, get_following_words_from_text, get_random_following_text
import random as r
import u1 as u


def test_get_following_words():
    single_param_test(
        "get_following_words",
        [
            'a b c d a b f'.rsplit(),
            'hej och hej och hejsan'.rsplit()
        ],
        [
            {'a': ['b', 'b'], 'b': ['c', 'f'], 'c':  ['d'], 'd': ['a']},
            {'hej': ['och', 'och'], 'och': ['hej', 'hejsan']}
        ],
        get_following_words
    )


def test_get_following_words_from_text():
    single_param_test(
        "get_following_words_from_text",
        [
            'a b c d a b f',
            'hej och hej och hejsan'
        ],
        [

            {'a': ['b', 'b'], 'b': ['c', 'f'], 'c':  ['d'], 'd': ['a']},
            {'hej': ['och', 'och'], 'och': ['hej', 'hejsan']}
        ],
        get_following_words_from_text
    )


def get_texts():
    return {f"test{i}.txt": u.get_file_contents(f"texts/test{i}.txt") for i in range(1, 5)}


def test_get_text_from_following_words():
    print("\n==== TESTING get_text_from_following_words() ====")
    for file, content in get_texts().items():
        print(f"\n\t#### TEXT: {file} ####\n\t", end='')
        print(get_text_from_following_words(get_following_words_from_text(content), 40))

def test_get_random_following_text():
    print("\n==== TESTING get_random_following_text() ====")
    for file, content in get_texts().items():
        print(f"\n\t#### TEXT: {file} ####\n\t", end='')
        print(get_random_following_text(content, 40))


if __name__ == '__main__':
    test_get_following_words()
    test_get_following_words_from_text()
    test_get_text_from_following_words()
    test_get_random_following_text()
