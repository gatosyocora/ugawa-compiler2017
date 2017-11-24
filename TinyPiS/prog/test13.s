	.section .data
	@ 大域変数の定義
_Pi_var_xxx:
	.word 0
_Pi_var_yyy:
	.word 0
_Pi_var_answer:
	.word 0
	.section .text
	.global _start
_start:
	@ 式をコンパイルした命令列
	ldr r0, =#100
	ldr r1, =_Pi_var_xxx
	str r0, [r1, #0]
	ldr r0, =#160
	ldr r1, =_Pi_var_yyy
	str r0, [r1, #0]
	ldr r0, =_Pi_var_xxx
	ldr r0, [r0, #0]
	str r1, [sp, #-4]!
	mov r1, r0
	ldr r0, =_Pi_var_yyy
	ldr r0, [r0, #0]
	add r0, r1, r0
	ldr r1, [sp], #4
	bl __pi_runtime_print
	ldr r0, =_Pi_var_yyy
	ldr r0, [r0, #0]
	bl __pi_runtime_print
	ldr r0, =_Pi_var_xxx
	ldr r0, [r0, #0]
	ldr r1, =_Pi_var_answer
	str r0, [r1, #0]
	@ EXITシステムコール
	ldr r0, =_Pi_var_answer
	ldr r0, [r0, #0]
	mov r7, #1
	swi #0
__pi_runtime_print:
	str r0, [sp, #-4]!
	str r1, [sp, #-4]!
	str r2, [sp, #-4]!
	str r3, [sp, #-4]!
	ldr r1, =buf
	add r3, r1, #8
loop:
	and r2, r0, #15
	cmp r2, #10
	add r2, r2, #48
	addcs r2, r2, #7
	sub r3, r3, #1
	strb r2, [r3]
	lsr r0, r0, #4
	cmp r3, r1
	bcs loop
	mov r7, #4
	mov r0, #1
	mov r2, #9
	swi #0
	ldr r3, [sp], #4
	ldr r2, [sp], #4
	ldr r1, [sp], #4
	ldr r0, [sp], #4
	bx r14
	.section .data
	@ print用のデータ
buf:
	.space 8, '0'
	.byte	0x0a @ 末端文字
