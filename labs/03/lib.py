

def single_param_test(name: str, input: list, expected: list, func):
    func_result_test(name, [[i] for i in input], expected, func)


def func_result_test(name: str, input: list, expected: list, func):
    OK_START = '\033[92m'
    ERR_START = '\033[91m'
    END = '\033[0m'
    print(f"\n==== TESTING {name}() ====")
    for i in range(0, len(input)):
        corr = expected[i]
        res = func(*input[i])
        if corr == res:
            print(f"{OK_START}Test {i+1} passed.\n\t{input[i]} => {res}{END}")
        else:
            print(
                f"{ERR_START}Test {i+1} failed ({input[i]}).\n\tExpected\t\'{corr}\'\n\tgot\t\t\'{res}\'{END}")
