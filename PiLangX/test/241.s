	.section .data
	@ 大域変数の定義
_Pi_var_x:
	.word 0
	.section .text
	.global _start
_start:
	@ main関数を呼出す．戻り値は r0 に入る
	bl main
	@ EXITシステムコール
	mov r7, #1
	swi #0
main:
	@ prologue
	str r11, [sp, #-4]!
	mov r11, sp
	str r14, [sp, #-4]!
	str r1, [sp, #-4]!
	sub sp, sp, #0
	mov r0, #0
	ldr r0, =#5
	ldr r1, =_Pi_var_x
	str r0, [r1, #0]
L1:
	ldr r0, =#1
	cmp r0, #0
	beq L2
	b L2
	ldr r0, =#3
	ldr r1, =_Pi_var_x
	str r0, [r1, #0]
	b L1
L2:
	ldr r0, =_Pi_var_x
	ldr r0, [r0, #0]
	b L0
	mov r0, #0
L0:
	@ epilogue
	add sp, sp, #0
	ldr r1, [sp], #4
	ldr r14, [sp], #4
	ldr r11, [sp], #4
	bx r14
