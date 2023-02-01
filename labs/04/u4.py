from u3 import get_dead_urls
from u1 import print_emails_from_url
from lib import ok_print

def get_working_urls(urls: set[str]) -> set[str]:
    return urls.difference(get_dead_urls(urls))


def print_emails_for_urls(urls: set[str]):
    for url in sorted(urls):
        ok_print(url)
        print_emails_from_url(url, prefix='\t')
