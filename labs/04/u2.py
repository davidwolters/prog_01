from u1 import get_url_content


def get_next_link(text: str) -> str:
    pos = text.find('"')
    return text[:pos] if pos != -1 else ''


def will_be_anchor(text: str) -> bool:
    return '<' in text and text.split("<")[-1].startswith('a')


def get_link_parts(text: str) -> list[str]:
    return ''.join(
        text.lower().replace("'", '"').rsplit()
    ).split('href="')


def get_all_links(text: str) -> set[str]:
    links = set()
    parts = get_link_parts(text)

    for i, part in enumerate(parts):
        if i == 0 or not will_be_anchor(parts[i - 1]):
            continue
        links.add(get_next_link(part))
    return links


def print_links_from_url(url: str):
    for link in sorted(get_all_links(get_url_content(url))):
        print(link)
