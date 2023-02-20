

.data
inst_1: .asciiz "\nEnter a number (0 to exit)\n< "
res: .asciiz "\nThe highest number is: "
deb: .asciiz "\nUpdating highest\n"

.text

main:
j loop


loop:
# print(inst_1)
li $v0, 4
la $a0, inst_1
syscall

# tal = int(input)
li $v0, 5
syscall
move $s1, $v0

# if tal > highest: highest = tal
bgt $v0, $s0, update_highest

# if tal == 0: break
beq $v0, $zero, exit


update_highest:
move $s0, $s1
j loop


exit:
# print(res)
li $v0, 4
la $a0, res
syscall

# print(highest)
li $v0, 1
move $a0, $s0
syscall