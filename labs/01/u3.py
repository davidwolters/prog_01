import math

a = int(input("a: "))
b = int(input("b: "))
c = int(input("c: "))


def get_area_sq(a, b, c):
    s = (a + b + c)/2
    a = s - a
    b = s - b
    c = s - c
    print(s*a*b*c)


get_area_sq(a, b, c)
