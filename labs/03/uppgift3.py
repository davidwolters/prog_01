import random
from uppgift1 import get_words, lowercase, get_alpha


def get_word_successors(words: list, n: int):
    dict = {}
    for i in range(len(words) - n):
        word_tuple = tuple(words[i:i+n])
        dict[word_tuple] = (
            dict[word_tuple] + [words[i+n]]
            if word_tuple in dict
            else [words[i+n]]
        )
    return dict


def get_successors_from_text(text: str, n: int):
    return get_word_successors(get_words(lowercase(get_alpha(text))), n)


def get_successor_text(text: str, num_words: int, n: int):
    return get_text_from_following_words(get_successors_from_text(text, n), num_words)


def get_text_from_following_words(words: dict, num_words: int):
    keys = list(words.keys())
    text = list(keys[random.randint(0, len(keys) - 1)])
    for _ in range(1, num_words - 1):
        key = tuple([text[-i] for i in range(len(keys[0]), 0, - 1)])
        if key in keys:
            possible = words[key]
            text.append(possible[random.randint(0, len(possible) - 1)])
        else:
            break
    return ' '.join(text)
