
###############################################################
#         						 	 	 	 	 			  #
#  Ett program som läser in en serie tal och skriver ut det	  #
#  största													  #
#         						 	 	 	 	 			  #
#                   Registerallokering:						  #
# $s0										int max			  #
# $v0										int tal			  #
###############################################################


.data
inst_1: .asciiz "\nEnter a number (0 to exit)\n> "
res: .asciiz "\nThe greatest number is: "

.text


loop:

# print(inst_1)
li $v0, 4
la $a0, inst_1
syscall

# tal = int(input)
li $v0, 5
syscall

# if tal > max: update_max()
bgt $v0, $s0, update_max

# if tal == 0: exit()
beq $v0, 0, exit

j loop

update_max:
# max = tal
move $s0, $v0
j loop


exit:
# print(res)
li $v0, 4
la $a0, res
syscall

# print(max)
li $v0, 1
move $a0, $s0
syscall
