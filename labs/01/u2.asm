

.data
inst_1: .asciiz "Enter first number (A):\n> "
inst_2: .asciiz "\nEnter second number (B):\n> "
res: .asciiz "\nResult (A*A + B*B): "


.text
main:

# print(inst_1)
li $v0, 4
la $a0, inst_1
syscall


#first = int(input())
li $v0, 5
syscall
move $s0, $v0

# print(inst_2)
li $v0, 4
la $a0, inst_2
syscall

# second = int(input))
li $v0, 5
syscall

# first = first*first + second*second
mul $s0, $s0, $s0
mul $s1, $v0, $v0
add $s0, $s0, $s1


# print(res)
li $v0, 4
la $a0, res
syscall

# print (first)
li $v0,1
move $a0, $s0
syscall
