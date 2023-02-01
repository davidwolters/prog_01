from u3 import get_full_urls, get_dead_urls
from u1 import get_url_content
from socket import setdefaulttimeout


def test_get_full_links():
    links = ['https://www.wolters.se',
             'https://www.it.uu.se/katalog/bylastname']

    for link in links:
        print(get_full_urls(link, get_url_content(link)))


def test_get_dead_urls():
    urls = ['https://www.wolters.se',
            'https://www.it.uu.se/katalog/bylastname']

    for url in urls:
        print(get_dead_urls(get_full_urls(url, get_url_content(url))))


if __name__ == '__main__':
    # test_get_full_links()
    test_get_dead_urls()
