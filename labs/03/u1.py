def get_file_contents(file_name: str) -> str:
    """Open a file via realtive filepath, and retreive its contents.
    If any error occurrs, it is caught and not propagated, empty string is returned.
    """
    try:
        file = open(file_name)
        contents = file.read()
        file.close()
        return contents
    except Exception as ex:
        print(ex)
        return ""


def lowercase(string: str) -> str:
    return string.lower()


def get_words(string: str) -> list[str]:
    return string.rsplit()

def get_alpha(string: str) -> str:
    """Return a string with only alpha-chars, whitespaces and newlines. """
    alpha_str = ''
    for char in string:
        if char.isalpha() or char == ' ' or char == "\n":
            alpha_str += char if char != "\n" else ' '
    return alpha_str

def get_num_words(list: list[str]) -> int:
    return len(list)


def list_to_dict(list: list[str]) -> dict[str, int]:
    """Returns a dictionary containing each word and # occurences in list."""
    dict = {}
    for word in list:
        dict[word] = dict[word] + 1 if word in dict else 1
    return dict


def get_num_unique_words(words: dict[str, int]) -> int:
    return len(words)

def get_most_freq_word(words: dict[str, int]) -> tuple[str, int]:
    max_freq = 0
    max_word = ''
    for word in words:
        if words[word] > max_freq:
            max_freq = words[word]
            max_word = word
    return (max_word, max_freq)

def solve(file: str) -> dict:
    """Reads a file and returns information regarding its contents.
    Returns:
        - Number of words
        - Number of unique words (shift-case and punctuation is ignored)
        - Number of occurrences of most frequent word 
        - Most frequent word
    """
    text = get_file_contents(file)
    words = get_words(lowercase(get_alpha(text)))
    word_dict = list_to_dict(words)
    num_words = get_num_words(words)
    num_unique_words = get_num_unique_words(word_dict)
    (most_freq, max_freq) = get_most_freq_word(word_dict)

    return {
        "num_words": num_words,
        "num_unique_words": num_unique_words,
        "max_freq": max_freq,
        "most_freq": most_freq
    }
