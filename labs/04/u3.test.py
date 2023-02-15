import u3
from u1 import get_url_content
from socket import setdefaulttimeout
from lib import func_result_test


def test_is_url():
    func_result_test(
        'is_url',
        [
            ['http://asdf.se'],
            ['/asdf'],
            ['#asdf'],
            ['asdf'],
            ['tel:asdf'],
            ['']
        ],
        [True, True, False, False, False, False],
        u3.is_url
    )


def test_is_abs():
    func_result_test(
        'is_abs',
        [[i] for i in ['/asdf', 'http://asdf.se', '#asdf', '']],
        [False, True, False, False],
        u3.is_abs
    )


def test_get_full_urls():
    func_result_test(
        'get_full_urls',
        [
            [
                'https://www.a.se',
                '<a href="/asdf"> <a href=""> <a href="https://asdf.se">'
            ],
            [
                'https://a.se/',
                ''
            ]
        ],
        [
            {'https://www.a.se/asdf', 'https://asdf.se'},
            set()
        ],
        u3.get_full_urls
    )


def test_is_url_dead():
    func_result_test(
        'is_url_dead',
        [['dead'], ['https://www.google.com'], ''],
        [True, False, True],
        u3.is_url_dead
    )


def test_print_full_links_from_sites():
    links = ['https://www.wolters.se',
             'https://www.it.uu.se/katalog/bylastname']

    for link in links:
        print(u3.get_full_urls(link, get_url_content(link)))


def test_print_dead_urls_from_sites():
    urls = ['https://www.wolters.se',
            'https://www.it.uu.se/katalog/bylastname']

    for url in urls:
        print(u3.print_dead_urls(u3.get_full_urls(url, get_url_content(url))))


if __name__ == '__main__':
    test_is_url()
    test_is_abs()
    test_get_full_urls()
    test_is_url_dead()
    test_print_full_links_from_sites()
    test_print_dead_urls_from_sites()
