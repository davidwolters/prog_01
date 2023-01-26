from uppgift2 import get_initials

def test_get_initials():
    print("\n==== TESTING get_initials() ====")
    names = ['edvard Blom', 'Jonny gunnar Persson', 'Tommy Persson-Carlsson', '', '123']
    expected = ['E.B..', 'J.G.P.', 'T.P.C.', '', '1.']

    for i in range(0, len(names)):
        res = get_initials(names[i])
        correct = expected[i]
        if res != correct:
            print(f"Test {i+1} failed. result = {res}, expected = {correct}")
        else:
            print(f"Test {i+1} passed. {names[i]} => {res}")

if __name__ == '__main__':
    test_get_initials()
