import u2

def test_get_all_links():
    links = ['https://www.wolters.se',
             'https://www.it.uu.se/katalog/bylastname']

    for link in links:
        print_links_from_url(link)


if __name__ == '__main__':
    test_get_all_links()
