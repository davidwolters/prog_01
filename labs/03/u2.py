import random as r
from u1 import get_words, lowercase, get_alpha, list_to_dict, get_most_freq_word

def get_following_words(words: list[str]) -> dict[str, list[str]]:
    dict = {}

    for i in range(len(words) - 1):
        current_word = words[i]
        next_word = words[i+1]
        if current_word in dict:
            dict[current_word].append(next_word)
        else:
            dict[current_word] = [next_word]
    return dict

def get_most_frequent_follower(words: dict[str, list[str]]):
    max_len = 0
    max_word = ''
    for word in words:
        if len(words[word]) > max_len:
            max_len = len(words[word])
            max_word = words[word]
            
    max_follow_word, max_follow_freq = get_most_freq_word(list_to_dict(words[word]))
    return (max_word, max_len, max_follow_word, max_follow_freq)

def get_text_from_following_words(words: dict[str, list[str]], num_words: int) -> str:
    """Uppgift 3. Generar en slumpmässig text där varje ord följs av ett ord som i texten följer ordet."""
    text = []
    while len(text) < num_words:
        text = [r.choice(list(words))]
        for _ in range(num_words - 1):
            key = text[-1]
            if not key in words:
                break
            text.append(r.choice(words[key]))
    return ' '.join(text)


def get_following_words_from_text(text: str) -> dict[str, list[str]]:
    return get_following_words(get_words(text))

def get_random_following_text(text: str, num_words: int):
    following_words = get_following_words_from_text(text)
    return get_text_from_following_words(following_words, num_words)
