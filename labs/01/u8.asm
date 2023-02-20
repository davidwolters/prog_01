
.data
base: .space 40
comma: .asciiz ", "

.text

main:
	la $s0, base
	la $s1, 0

# while True:
load_list:
	# newnum = int(input)
	li $v0, 5
	syscall

	# Memory[addr] = newnum
	sw $v0, ($s0)

 	# if newnum == 0: break
	beq $v0, $zero, check_palindrome
	
	# if count == 9: break
	beq $s1, 9, check_palindrome

	# addr += 1
	add $s0, $s0, 4
	
	# count += 1
	add $s1, $s1, 1

	j load_list
	
check_palindrome:

	#addr2 = base
	la $s2, base
	
	# is_palindrome = True
	li $s3, 1
	
	# while True:
	pal_loop:
	
		
		# num_1 = Memory[addr]
		lw $t1, ($s0)
		
		# num_2 = Memory[addr2]
		lw $t2, ($s2)
		
		# if addr2 >= addr: break
		bge $s2, $s0, print_res
		
		# if num_1 == 0: addr2 += 4
		beqz $t1, skip_check_2
		# if num_2 == 0: addr -= 4
		beqz $t2, skip_check_1
		
		# if num_1 != num_2: is_palindrome = False
		bne $t1, $t2, not_palindrome
		j inc
	
		skip_check_1:
			add $s0, $s0, 4
			j inc
		skip_check_2:
			sub $s2, $s2, 4
			
		inc:
		
		# num_2 += 4
		add $s2, $s2, 4
		
		# num-1 -= 4
		sub $s0, $s0, 4
		
		j pal_loop
		

not_palindrome:
	li $s3, 0
	j inc

print_res:
li $v0, 1
move $a0, $s3
syscall
		
		
		
	
