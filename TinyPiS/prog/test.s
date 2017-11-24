	.section .data
	@ 大域変数の定義
_Pi_var_xxx:
	.word 0
_Pi_var_yyy:
	.word 0
_Pi_var_aaa:
	.word 0
_Pi_var_answer:
	.word 0
	.section .text
	.global _start
_start:
	@ 式をコンパイルした命令列
	ldr r0, =#10
	ldr r1, =_Pi_var_xxx
	str r0, [r1, #0]
	ldr r0, =#2
	ldr r1, =_Pi_var_yyy
	str r0, [r1, #0]
	ldr r0, =_Pi_var_xxx
	ldr r0, [r0, #0]
	str r1, [sp, #-4]!
	mov r1, r0
	ldr r0, =_Pi_var_yyy
	ldr r0, [r0, #0]
	mul r0, r1, r0
	ldr r1, [sp], #4
	ldr r1, =_Pi_var_aaa
	str r0, [r1, #0]
	ldr r0, =_Pi_var_aaa
	ldr r0, [r0, #0]
	str r1, [sp, #-4]!
	mov r1, r0
	ldr r0, =_Pi_var_xxx
	ldr r0, [r0, #0]
	sub r0, r1, r0
	ldr r1, [sp], #4
	ldr r1, =_Pi_var_answer
	str r0, [r1, #0]
	@ EXITシステムコール
	ldr r0, =_Pi_var_answer
	ldr r0, [r0, #0]
	mov r7, #1
	swi #0
