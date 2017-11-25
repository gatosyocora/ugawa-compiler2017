	.section .data
	@ 大域変数の定義
_Pi_var_aaa:
	.word 0
_Pi_var_bbb:
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
	@prologue
	str r11, [sp, #-4]!
	mov r11, sp
	str r14, [sp, #-4]!
	str r1, [sp, #-4]!
	sub sp, sp, #4
	ldr r0, =#10
	ldr r1, =_Pi_var_aaa
	str r0, [r1, #0]
	ldr r0, =#15
	ldr r1, =_Pi_var_bbb
	str r0, [r1, #0]
	ldr r0, =_Pi_var_aaa
	ldr r0, [r0, #0]
	str r1, [sp, #-4]!
	mov r1, r0
	ldr r0, =_Pi_var_bbb
	ldr r0, [r0, #0]
	and r0, r1, r0
	ldr r1, [sp], #4
	str r0, [r11, #-12]
	ldr r0, [r11, #-12]
	mvn r0, r0
	str r0, [sp, #-4]!
	bl x
	add sp, sp, #4
	mov r0, #0
L0:
	@epilogue
	add sp, sp, #4
	ldr r1, [sp], #4
	ldr r14, [sp], #4
	ldr r11, [sp], #4
	bx r14
x:
	@prologue
	str r11, [sp, #-4]!
	mov r11, sp
	str r14, [sp, #-4]!
	str r1, [sp, #-4]!
	sub sp, sp, #4
	ldr r0, =_Pi_var_bbb
	ldr r0, [r0, #0]
	str r0, [r11, #-12]
	ldr r0, [r11, #4]
	mvn r0, r0
	add r0, r0, #1
	str r0, [r11, #4]
	ldr r0, [r11, #-12]
	str r1, [sp, #-4]!
	mov r1, r0
	ldr r0, [r11, #4]
	orr r0, r1, r0
	ldr r1, [sp], #4
	mov r0, #0
L1:
	@epilogue
	add sp, sp, #4
	ldr r1, [sp], #4
	ldr r14, [sp], #4
	ldr r11, [sp], #4
	bx r14
