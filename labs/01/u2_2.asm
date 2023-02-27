
###############################################################
#         						 	 	 	 	 			  #
#  Ett program som läser in 3 tal och skriver ut det största  #
#         						 	 	 	 	 			  #
#                   Registerallokering:						  #
# $s0										int a (also max)  #
# $s1										int b			  #
# $v0										int c			  #
###############################################################




.data
inst: .asciiz "\nEnter a number:\n> "
res: .asciiz "\nThe greatest number is: "



.text


# print(inst)
li $v0, 4
la $a0, inst
syscall

# a = int(input())
li $v0, 5
syscall
move $s0, $v0


# print(inst)
li $v0, 4
la $a0, inst
syscall

# b = int(input())
li $v0, 5
syscall
move $s1, $v0


# print(inst)
li $v0, 4
la $a0, inst
syscall

# c = int(inpput())
li $v0, 5
syscall

	# if a > b: a_gt_b()
	bge $s0, $s1, a_gt_b
after_a_gt_b:
	# elif b > a: check_b()
	bge $s1, $s0, b_gt_a
after_b_gt_a:

	# else:
	#     a = c
	#     print_res()
	move $s0, $v0
	j print_res


a_gt_b:
	# if a > c:
	#    print_res()
	bge $s0, $v0, print_res
	j after_a_gt_b


b_gt_a:
	# if b > c:
	#    b_gt()
	bge $s1, $v0, b_gt
	j after_b_gt_a

b_gt:
	# a = b
	move $s0, $s1

	# print_res()
	j print_res


print_res:
	# print(res)
	li $v0, 4
	la $a0, res
	syscall

	# print(a)
	li $v0, 1
	move $a0, $s0
	syscall