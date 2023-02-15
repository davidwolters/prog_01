import u2
from lib import func_result_test


def test_get_next_link():
    func_result_test(
        "get_next_link",
        [
            ['asdf"'],
            [''],
            ['asdf']
        ],
        [
            'asdf',
            '',
            ''
        ],
        u2.get_next_link
    )


def test_will_be_anchor():
    func_result_test(
        'will_be_anchor',
        [
            ['<a, <b'],
            ['asdfadsf <a'],
            [''],
            ['< a']
        ],
        [False, True, False, False],
        u2.will_be_anchor
    )


def test_get_link_parts():
    func_result_test(
        'get_link_parts',
        [
            ["<a href='asdf'>"],
            ['href="asdfhref="fdsa'],
            ['<a HREF="asdf">'],
            [''],
            ['href="']
        ],
        [
            ['<a', 'asdf">'],
            ['', 'asdf', 'fdsa'],
            ['<a', 'asdf">'],
            [''],
            ['', '']
        ],
        u2.get_link_parts
    )


def test_get_all_links():
    func_result_test(
        'get_all_links',
        [
            ['<link HREF="asdf"><A href="asdf"><video href="1234"><a href="hello"'],
            [''],
            ['href=']
        ],
        [
            {'asdf', 'hello'},
            set(),
            set()
        ],
        u2.get_all_links
    )


if __name__ == '__main__':
    test_get_next_link()
    test_will_be_anchor()
    test_get_link_parts()
    test_get_all_links()
    print('==== TESTING print_links_from_url ====')
    u2.print_links_from_url('https://www.uu.se')
