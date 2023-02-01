from u1 import find_all_emails, print_emails_from_url


def test_find_all_emails():
    texts = [
        'asdfasdf asdf@asdf.se asdf @ asedf.se asdf.as aasdjf@asdf asdf@asdf.se david.dellby.wolters@asdf.se.se'
    ]
    for text in texts:
        print(find_all_emails(text))


if __name__ == '__main__':
    test_find_all_emails()
    print_emails_from_url('https://www.it.uu.se/katalog/bylastname')
