def single_param_test(name: str, input: list, expected: list, func):
    print(f"\n==== TESTING f{name}() ====")
    for i in range(0, len(input)):
        corr = expected[i]
        res = func(input[i])
        if corr == res:
            print(f"Test {i+1} passed. {input[i]} => {res}")
        else:
            print(f"Test {i+1} failed. Expected {corr}, got {res}")

