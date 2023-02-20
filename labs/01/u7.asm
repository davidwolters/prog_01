
.data
base: .space 40
comma: .asciiz ", "

.text

main:
	# addr = base
	la $s0, base
	
	# count = 0
	li $s1, 0

# while True:
load_list:
	# newnum = int(input)
	li $v0, 5
	syscall

	# Memory[addr] = newnum
	sw $v0, ($s0)

 	# if newnum == 0: break
	beq $v0, $zero, print
	
	# if count == 9: break
	beq $s1, 9, print

	# addr += 1
	add $s0, $s0, 4
	
	# count += 1
	add $s1, $s1, 1

	j load_list

print:
	# addr = base + count
	move $s0, $s1
	mul $s0, $s0, 4
	la $t1, base
	add $s0, $s0, $t1
	
	# while true
	print_loop:
		
		# num = Memory[addr]
		lw $t1, ($s0)
		
		# if count == -1: break
		beq $s1, -1, exit
		
		# if num != 0:
		beqz $t1, skip_print:

		# print(num + comma)
		li $v0, 1
		move $a0, $t1
		syscall
		li $v0, 4
		la $a0, comma
		syscall
		
		skip_print:
		
		# addr -= 1
		sub $s0, $s0, 4
		
		# count -= 1
		sub $s1, $s1, 1
		j print_loop

exit:
# exit()
li $v0, 10
syscall
