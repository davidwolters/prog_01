


.data
inst: .asciiz "\nEnter a number\n> "
res: .asciiz "\nThe average is: "
no_inp: .asciiz "\nYou need to enter at least one number!"


# num (tmp) $v0
# sum $s0
# count $s1
# $t1		Temporary to hold 1
.text

main:

# while true:
loop:
# print(inst)
li $v0, 4
la $a0, inst
syscall

# num = int(input())
li $v0, 5
syscall

# sum += num
add $s0, $s0, $v0

# if num == 0: break
beq $v0, $zero, exit

# count += 1
li $t1, 1
add $s1, $s1, $t1

j loop

exit:
beq $s0, $zero, at_least_one

# sum /= count
div $s0, $s0, $s1

# print(res)
li $v0, 4
la $a0, res
syscall

# print(sum)
li $v0, 1
move $a0, $s0
syscall

li $v0, 10
syscall


at_least_one:
# print(no_inp)
li $v0, 4
la $a0, no_inp
syscall
j loop