
###############################################################
#         						 	 	 	 	 			  #
#  Ett program som läser in två tal och skriver ut A^2 + B^2  #
#         						 	 	 	 	 			  #
#                   Registerallokering:						  #
# $s0										int num_1		  #
# $v0										int num_2		  #										
###############################################################


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


# num_1 = int(input())
li $v0, 5
syscall
move $s0, $v0

# print(inst_2)
li $v0, 4
la $a0, inst_2
syscall

# num_2 = int(input))
li $v0, 5
syscall

# num_1 = num_1*num_1 + num_2*num_2
mul $s0, $s0, $s0
mul $v0, $v0, $v0
add $s0, $s0, $v0


# print(res)
li $v0, 4
la $a0, res
syscall

# print(num_1)
li $v0,1
move $a0, $s0
syscall
