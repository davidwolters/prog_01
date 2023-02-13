def func_result_test(name: str, input: list, expected: list, func, expect_error = False):
    OK_START = '\033[92m'
    ERR_START = '\033[91m'
    END = '\033[0m'
    print(f"\n==== TESTING {name}() ====")
    for i in range(0, len(input)):
        corr = expected[i]
        res = None
        try:
            res = func(*input[i])
        except Exception as e:
            if not expect_error:
                print(f"{ERR_START}Test {i+1} failed ({input[i]}).\n\tAn exception occured:\n\t{e}{END}")
            else: print(f"{OK_START}Test {i+1} passed.\n\t{input[i]} caused an exception as expected:\n\t{e}{END}")
            continue

        if corr == res:
            print(f"{OK_START}Test {i+1} passed.\n\t{input[i]} => {res}{END}")
        else:
            print(
                f"{ERR_START}Test {i+1} failed ({input[i]}).\n\tExpected\t\'{corr}\'\n\tgot\t\t\'{res}\'{END}")


def ok_print(str: str):
    print(f"\033[92m{str}\033[0m")


def err_print(str: str):
    print(f"\033[91m{str}\033[0m")