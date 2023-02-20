

.data
inst: .asciiz "\nEnter a number:\n> "
res: .asciiz "The greatest number is: "
one: .word 1

.text

main:
# print(inst)
li $v0, 4
la $a0, inst
syscall

# a = int(input)
li $v0, 5
syscall
move $s0, $v0

# print(inst)
li $v0, 4
syscall

# b = int(input)
li $v0, 5
syscall
move $s1, $v0

# print(inst)
li $v0, 4
syscall


# c = int(input)
li $v0, 5
syscall
move $s2, $v0

sgt $s5, $s0, $s1	# AB = int(a > b)
sgt $s6, $s0, $s2	# AC = int(a > c)
sgt $s7, $s1, $s2	# BC = int(b > c)

## each multiplication will evaluate to 0 if number is not largest, so either:
# a + 0 + 0 or
# 0 + b + 0 or
# 0 + 0 + c
# technically more effecient than doing jumps, as ASM does not need to precompute branches
# max = a*AB*AC + b*(1-AB)*BC + c*(1-AC)*(1-BC)
mul $s4,$s0,$s5		# max = a * AB
mul $s4,$s4,$s6		# max = a * AC


li $t7, 1
sub $t0, $t7, $s5	# BA = 1 - AB
mul $t1, $s1, $t0	# tmp = b*BA
mul $t1, $t1, $s7	# tmp = tmp*BC
add $s4, $s4, $t1	# max = res + tmp

sub $t2, $t7, $s7	# CB = 1 - BC
sub $t3, $t7, $s6	# CA = 1 - AC
mul $t1, $s2, $t2	# tmp = b * CB
mul $t1, $t1, $t3	# tmp = b * CA
add $s4, $s4, $t1	# max = res + tmp

# print(res)
li $v0, 4
la $a0, res
syscall

# print(max)
li $v0, 1
move $a0, $s4
syscall
