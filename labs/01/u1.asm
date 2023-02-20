
.data
inst_1: .asciiz "Enter first number\n> "
inst_2: .asciiz "\nEnter second number\n> "
res: .asciiz "\nResult is: "

.text
main:

li $v0,4
la $a0, inst_1
syscall

li $v0, 5
syscall
move $s0, $v0

li $v0, 4
la $a0, inst_2
syscall

li $v0, 5
syscall
add $s0, $s0, $v0
div $s0, $s0, 2

li $v0, 4
la $a0, res
syscall

li $v0, 1 
move $a0, $s0
syscall

li $v0, 10
syscall

