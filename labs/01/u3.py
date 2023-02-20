import math



a = int(input("a: "))
b = int(input("b: "))
c = int(input("c: "))


def get_area_sq(a, b, c):
	s = (a + b + c)/2
	print(s*(s-a)*(s-b)*(s-c))
	print(math.sqrt(s*(s-a)*(s-b)*(s-c)))

get_area_sq(a, b, c)






