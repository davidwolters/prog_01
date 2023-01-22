# def get_initials(name):
#    return '.'.join([i[0].capitalize() for i in name.replace("-", " ").split(" ")]) + '.' if name else ''

def get_initials(full_name):
    alpha_name = full_name.replace("-", " ")
    names = alpha_name.split(" ")
    initials = ""
    for name in names:
        if not name: continue
        initials += name[0].capitalize() + "."
    return initials




def test_get_initials():
    names = ['edvard Blom', 'Jonny gunnar Persson', 'Tommy Persson-Carlsson', '', '123']
    expected = ['E.B.', 'J.G.P.', 'T.P.C.', '', '1.']

    for i in range(0, len(names)):
        res = get_initials(names[i])
        print(res, names[i], "\texpected:", expected[i], "passed:", res == expected[i])

if __name__ == '__main__':
    test_get_initials()