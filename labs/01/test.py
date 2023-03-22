# För att undvika att ett textmeddelande begripa av en robot kan man röra om det lite lätt - tillräckligt för att en robot inte ska förstå, och samtidigt så lätt att en människa faktiskt kan förstå. Ett enkelt sätt kan vara att byta plats på bokstäverna parvis, så att t.ex. “abcd” blir “badc”. Om texten har udda tecken byts inte det sista. Byte sker endast mellan tecken som är bokstäver i det engelska alfabetet (använd string.ascii_letters), så t.ex. “ab cd” blir “ba cd” då mellanslag ej är en bokstav. Första paret tecken är “ab” och blir “ba” och då är det andra paret av tecken “ c” och byter då alltså inte plats. Sista “d” är ensamt och byter då alltså inte plats.

# Skriv en python funktion scramble() som tar en text (typ str) som parameter och returnerar en text där bokstäverna har bytt plats enligt ovan. Funktionen ska klara alla längder av strängar, även tomma strängen(som ska returnera tomma strängen). Funktionen ska inte ha någon sidoeffekt. Ett tips på problem uppdelning är att börja men en funktionsom gör detta för strängar av längden exakt två. Den ska alltså byta plats på tecknen om begge är bokstäver. Sedan löses det ursprungliga problemet med att anropa dne innuti en loop. Du får inte använda modulen re, högre ordningens funktioner (som filter(), eller list comprehension.

import string


def swap(str: str, i: int) -> str:
    """Return the string with characters at position str[i] and str[i+1] swapped."""
    return str[:i] + str[i + 1] + str[i] + str[i+2:]


def should_swap(text: str, i: int) -> bool:
    """True if text[i] and text[i+1] both are ascii_letters."""
    return text[i] in string.ascii_letters and text[i+1] in string.ascii_letters


def scramble(text: str):
    """Swaps places of all pairs of ascii chars, with a step length of 2."""
    for i in range(0, len(text)-1, 2):
        text = swap(text, i) if should_swap(text, i) else text
    return text


def test_scramble(input: string, expected: string):
    """Test function. Prints correct if scramble(input) == expected. If function throws error prints error."""
    try:
        res = scramble(input)
        print(f"scramble(\"{input}\") = \"{res}\"", end=": ")
        status = "correct" if res == expected else f"error, expected: \"{expected}\""
        print(status)
    except Exception as e:
        print(f"ERROR: scramble(\"{input}\") caused an error.", e)


def uppgift():
    test_scramble("asdf", "safd")
    test_scramble("as df", "sa df")
    test_scramble("", "")
    test_scramble("abcde", "badce")
    test_scramble("---", "---")
    test_scramble("--ab--", "--ba--")


if __name__ == "__main__":
    uppgift()
