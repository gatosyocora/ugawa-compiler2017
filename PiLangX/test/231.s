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
	sub sp, sp, #8
	mov r0, #0
	str r0, [r11, #-12]
	str r0, [r11, #-16]
	ldr r0, =#3
	str r0, [r11, #-12]
	ldr r0, [r11, #-12]
	bl __pi_runtime_print
	ldr r0, [r11, #-16]
	b L0
	mov r0, #0
L0:
	@ epilogue
	add sp, sp, #8
	ldr r1, [sp], #4
	ldr r14, [sp], #4
	ldr r11, [sp], #4
	bx r14
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
