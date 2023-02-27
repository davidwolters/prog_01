
################################################################
#         						 	 	 	 	 			   #
#  Ett program som läser in en serie tal och skriver ut 	   #
#  1 om talserien är ett palindrom, annars 					   #
#         						 	 	 	 	 			   #
#                   Registerallokering:						   #
# $v0										int newnum		   #
# $s0										int addr		   #
# $s1										int count		   #
# $s2										int addr2		   #
# $s3										bool is_palindrome #
# $t1										int num_1		   #
# $t2										int num_2		   #
################################################################

.data
base: .space 40
inst: .asciiz "Enter a number (0 to exit)\n> "

.text

main:
	# addr = base
	la $s0, base

# while True:
load_list:

	# print(inst, end="")
	li $v0, 4
	la $a0, inst
	syscall

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
		
		# if num_1 == 0: addr -= 4; continue
		beqz $t1, skip_check_1
		# if num_2 == 0: addr2 += 4; continue
		beqz $t2, skip_check_2
		
		# if num_1 != num_2: not_palindrome()
		bne $t1, $t2, not_palindrome
		
		j inc
	
		# (if num_1 == 0)
		skip_check_1:
			# addr -= 4
			sub $s0, $s0, 4
			# continue
			j pal_loop
		skip_check_2:
			# addr2 += 4
			add $s2, $s2, 4
			# continue
			j pal_loop
			
		inc:
		# num_2 += 4
		add $s2, $s2, 4
		
		# num-1 -= 4
		sub $s0, $s0, 4
		
		j pal_loop
		

not_palindrome:
	# is_palindrome = False
	li $s3, 0
	# print_res()
	j print_res

print_res:

# print(int(is_palindrome(), end="")
li $v0, 1
move $a0, $s3
syscall
