

.data
inst_1: .asciiz "Enter first side:\n> "
inst_2: .asciiz "\nEnter second side:\n> "
inst_3: .asciiz "\nEnter third side:\n> "
res: .asciiz "\nSquared area: "

.text
main:

# print(inst_1)
li $v0, 4
la $a0, inst_1
syscall

# first = int(input)
li $v0, 5
syscall
move $s0, $v0

# print(inst_2
li $v0, 4
la $a0, inst_2
syscall

# second = int(input)
li $v0, 5
syscall
move $s1, $v0

# print(inst_3)
li $v0, 4
la $a0, inst_3
syscall

# third = int(input)
li $v0, 5
syscall

# s = (first + second + third) / 2
add $s2, $s0, $s1		# s = first + second
add $s2, $s2, $v0		# s = s + third
div $s2, $s2, 2			# s = s / 2


sub $s0, $s2, $s0		# first = s - first
sub $s1, $s2, $s1		# second = s - second
sub $v0, $s2, $v0		# third = s - third

mul $s2, $s2, $s0		# s = s * first
mul $s2, $s2, $s1		# s = s * second
mul $s2, $s2, $v0		# s = s * third


# print(res)
li $v0, 4
la $a0, res
syscall

# print(s)3
li $v0, 1
move $a0, $s2
syscall