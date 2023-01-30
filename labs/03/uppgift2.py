from uppgift1 import get_words, lowercase, get_alpha, get_file_contents


def get_following_words(words: list):
    following_words = {}

    for i in range(len(words)-1):

        following_words[words[i]] = (
            following_words[words[i]] + [words[i+1]]
            if words[i] in following_words
            else [words[i+1]]
        )
    return following_words


def get_following_alpha_words(text: str):
    return get_following_words(get_words(lowercase(get_alpha(text))))


def solve(filename: str):
    return get_following_alpha_words(get_file_contents(filename))
