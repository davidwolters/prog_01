import urllib.request


def possible_email(str: str):
    """Function to check if a string is possibly a substring of an email.

    This substring is defined as a string only containing alpha-chars, '.' and '@',
    where '@' can at most occurr once.

    test@ ==> True
    asdf ==> True
    asdf@asdf# ==> False
    asdf asdf ==> False
    """
    return (
        str.replace('.', '').replace('@', '').isalpha() and
        str.count('@') <= 1
    )


def is_email(str: str):
    """Function to check if a string is an email.

    An email is defined as two set of substrings containing ONLY alpha-chars and '.', separated by an @
    with the last substring containing at least one '.' for the domain.

    test@test ==> False
    test.test@test ==> False
    test@test.test ==> True
    test#@test.test ==> False
    a.b@b.a ==> True
    """
    parts = str.replace('.', '').split('@')
    return (
        len(parts) == 2 and
        parts[0].isalpha() and
        parts[1].isalpha() and
        str.split('@')[1].count('.') >= 1
    )


def find_all_emails(text: str):
    emails = set()
    start = 0
    for i in range(len(text)):
        if possible_email(text[start:i]):
            continue
        if is_email(text[start:i-1]):
            emails.add(text[start:i-1])
        start = i
    if is_email(text[start:]):
        emails.add(text[start:])
    return emails


def get_url_content(url: str):
    file = urllib.request.urlopen(url)
    content = file.read()
    return content.decode('utf-8')


def print_emails_from_url(url: str, prefix: str = ''):
    for email in sorted(find_all_emails(get_url_content(url))):
        print(prefix + email)
