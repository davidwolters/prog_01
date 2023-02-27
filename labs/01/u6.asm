
###############################################################
#         						 	 	 	 	 			  #
#  Ett program som läser in en serie tal och skriver ut 	  #
#  snittet av samtliga tal som läses in						  #
#         						 	 	 	 	 			  #
#                   Registerallokering:						  #
# $v0										int num			  #
# $s0										int sum			  #
# $s1										int count		  #
###############################################################


.data
inst: .asciiz "\nEnter a number (0 to exit)\n> "
res: .asciiz "\nThe average is: "
no_inp: .asciiz "\nYou need to enter at least one number!"


.text

# while True:
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
	beq $v0, 0, exit

	# count += 1
	add $s1, $s1, 1

	j loop

exit:

# if sum == 0: at_least_one()
beq $s0, 0, at_least_one

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

# exit()
li $v0, 10
syscall


at_least_one:
	# print(no_inp)
	li $v0, 4
	la $a0, no_inp
	syscall
	
	j loop
