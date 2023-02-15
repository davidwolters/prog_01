from u2 import get_all_links
from urllib.parse import urljoin
from urllib.request import urlopen
from lib import ok_print, err_print
import socket


def is_url(str: str) -> bool:
    return str.startswith('http') or str.startswith('/') or str.startswith('www')


def is_url_absolute(str: str) -> bool:
    return str.startswith('http:') or str.startswith('https:')


def get_absolute_url(urlbase: str, url: str) -> str:
    if is_url_absolute(url):
        return url
    return urljoin(urlbase, url)


def get_full_urls(urlbase: str, content: str) -> set[str]:
    urls = set()
    for url in get_all_links(content):
        if not is_url(url):
            continue
        urls.add(get_absolute_url(urlbase, url))
    return urls


def is_url_dead(url: str) -> bool:
    socket.setdefaulttimeout(3)
    try:
        urlopen(url)
    except:
        return True
    return False


def print_dead_urls(urls: set[str]) -> set[str]:
    dead_urls = set()
    for url in urls:

        print(f"Checking {url} [...]", end="\t")
        if not is_url_dead(url):
            ok_print('Alive')
        else:
            dead_urls.add(url)
            err_print('Dead')

    return dead_urls
