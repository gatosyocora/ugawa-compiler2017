	.section .data
	@ 大域変数の定義
_Pi_var_aaa:
	.word 0
_Pi_var_bbb:
	.word 0
_Pi_var__CCC_:
	.word 0
_Pi_var_ddd:
	.word 0
_Pi_var_answer:
	.word 0
	.section .text
	.global _start
_start:
	@ 式をコンパイルした命令列
	ldr r0, =#10
	ldr r1, =_Pi_var_aaa
	str r0, [r1, #0]
	ldr r0, =#5
	ldr r1, =_Pi_var_bbb
	str r0, [r1, #0]
	ldr r0, =#3
	ldr r1, =_Pi_var__CCC_
	str r0, [r1, #0]
	ldr r0, =_Pi_var_aaa
	ldr r0, [r0, #0]
	str r1, [sp, #-4]!
	mov r1, r0
	ldr r0, =_Pi_var_bbb
	ldr r0, [r0, #0]
	add r0, r1, r0
	ldr r1, [sp], #4
	ldr r1, =_Pi_var_ddd
	str r0, [r1, #0]
	ldr r0, =_Pi_var_aaa
	ldr r0, [r0, #0]
	mvn r0, r0
	ldr r1, =_Pi_var_aaa
	str r0, [r1, #0]
	ldr r0, =_Pi_var_aaa
	ldr r0, [r0, #0]
	str r1, [sp, #-4]!
	mov r1, r0
	ldr r0, =_Pi_var__CCC_
	ldr r0, [r0, #0]
	and r0, r1, r0
	ldr r1, [sp], #4
	ldr r1, =_Pi_var_bbb
	str r0, [r1, #0]
	ldr r0, =_Pi_var_bbb
	ldr r0, [r0, #0]
	str r1, [sp, #-4]!
	mov r1, r0
	ldr r0, =_Pi_var_ddd
	ldr r0, [r0, #0]
	orr r0, r1, r0
	ldr r1, [sp], #4
	ldr r1, =_Pi_var_aaa
	str r0, [r1, #0]
	ldr r0, =_Pi_var_ddd
	ldr r0, [r0, #0]
	str r1, [sp, #-4]!
	mov r1, r0
	ldr r0, =#2
	mul r0, r1, r0
	ldr r1, [sp], #4
	str r1, [sp, #-4]!
	mov r1, r0
	ldr r0, =_Pi_var__CCC_
	ldr r0, [r0, #0]
	str r1, [sp, #-4]!
	mov r1, r0
	ldr r0, =_Pi_var_aaa
	ldr r0, [r0, #0]
	add r0, r1, r0
	ldr r1, [sp], #4
	add r0, r1, r0
	ldr r1, [sp], #4
	ldr r1, =_Pi_var_bbb
	str r0, [r1, #0]
	ldr r0, =_Pi_var_bbb
	ldr r0, [r0, #0]
	str r1, [sp, #-4]!
	mov r1, r0
	ldr r0, =_Pi_var_ddd
	ldr r0, [r0, #0]
	add r0, r1, r0
	ldr r1, [sp], #4
	ldr r1, =_Pi_var_answer
	str r0, [r1, #0]
	@ EXITシステムコール
	ldr r0, =_Pi_var_answer
	ldr r0, [r0, #0]
	mov r7, #1
	swi #0
