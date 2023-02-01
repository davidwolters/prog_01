from u4 import get_working_urls, print_emails_for_urls


def test_print_emails_for_urls():
    urls = get_working_urls('https://www.it.uu.se/katalog/bylastname')
    print_emails_for_urls(urls)




if __name__ == '__main__':
    test_print_emails_for_urls()