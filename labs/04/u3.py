from u2 import get_all_links
from urllib.parse import urljoin
from urllib.request import urlopen
from lib import ok_print, err_print
import socket


def is_url(str: str) -> bool:
    return not (str.startswith('mailto:') or str.startswith('tel:'))


def is_abs(str: str) -> bool:
    return str.startswith('http:') or str.startswith('https:')


def get_full_urls(urlbase: str, text: str) -> set[str]:
    urls = set()
    for url in get_all_links(text):
        if not is_url(url):
            continue
        urls.add(
            url if is_abs(url) else urljoin(urlbase, url)
        )
    return urls


def get_dead_urls(urls: set[str]) -> set[str]:
    socket.setdefaulttimeout(3)
    dead_urls = set()
    for url in urls:
        print(f"Checking {url} [...]", end="\t")
        try:
            urlopen(url)
            ok_print("Success")
        except:
            err_print("Error")
            dead_urls.add(url)
    return dead_urls