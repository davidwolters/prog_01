from lib import single_param_test
from uppgift3 import get_text_from_following_words, get_word_successors
import uppgift1 as u


# def test_get_following_n_words():


if __name__ == '__main__':
    c = u.get_file_contents("texts/test4.txt").replace("\n", ' ')
    # print((u.get_alpha(c)))
    w = get_word_successors(c.rsplit(), n=3)
    print(get_text_from_following_words(w, 20))
