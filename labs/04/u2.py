from u1 import get_url_content


def get_next_link(text: str) -> str:
    return text[:text.find('"')]


def will_be_anchor(text: str) -> bool:
    return text.split("<")[-1].startswith('a')


def get_all_links(text: str) -> set[str]:
    links = set()
    parts = ''.join(
        text.lower().replace("'", '"').rsplit()
    ).split('href="')

    for i, part in enumerate(parts):
        if i == 0 or not will_be_anchor(parts[i - 1]):
            continue
        links.add(get_next_link(part))
    print()
    return links


def print_links_from_url(url: str):
    for link in sorted(get_all_links(get_url_content(url))):
        print(link)
