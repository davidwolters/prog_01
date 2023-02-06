
def get_file_contents(file_name):
    try:
        file = open(file_name)
        contents = file.read()
        file.close()
        return contents
    except Exception as ex:
        print(ex)
        return ""


def lowercase(string: str):
    return string.lower()


def get_words(string: str):
    return string.rsplit()


def get_alpha(string: str):
    a = ''
    for char in string:
        if char.isalpha() or char == ' ' or char == "\n":
            a += char if char != "\n" else ' '
    return a
    # return ''.join(filter(lambda s: s.isalpha() or s == ' ', string))


def get_num_words(list):
    return len(list)


def list_to_dict(list: list):
    dict = {}
    for word in list:
        dict[word] = dict[word] + 1 if word in dict else 1
    return dict


def get_num_unique_words(words: dict):
    return len(words)


def get_most_freq_word(words: dict):
    max_freq = 0
    max_word = ''
    for word in words:
        if words[word] > max_freq:
            max_freq = words[word]
            max_word = word
    return (max_word, max_freq)


def solve(file):
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
