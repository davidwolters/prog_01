import random as r
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


def get_text_from_successors(words: dict, num_words: int):
    keys = list(words)
    text = list(r.choice(keys))
    for _ in range(1, num_words - 1):
        key = tuple(text[-len(keys[0]):])
        if not key in keys:
            break
        text.append(r.choice(words[key]))
    return ' '.join(text)


def get_successor_text(text: str, num_words: int, n: int):
    return get_text_from_successors(get_successors_from_text(text, n), num_words)
