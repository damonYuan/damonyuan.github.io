; http://mikeos.sourceforge.net/write-your-own-os.html#requirements

    BITS 16 ; tells the NASM assembler that we're working in 16-bit mode
start:
    mov ax, 07C0h ; Set up 4k stack space after this bootloader
	add ax, 288 ; (4096 + 512) / 16 bytes per paragraph
	mov ss, ax
	mov sp, 4096

	mov ax, 07C0h ; set data segment to where we're loaded
	mov ds, ax

	mov si, text_string ; put string position into SI
    call print_string ; Call our string-printing routine

	jmp $ ; Jump here - infinite loop!

	text_string db 'This is my cool new OS!', 0

print_string: ; Routine: output string in SI to screen
    mov ah, 0Eh ; int 10h 'print char' function

.repeat: 
    lodsb ; Get character from string
	cmp al, 0
	je .done ; If char is zero, end of string
	int 10h ; otherwise, print it
	jmp .repeat

.done: 
    ret ; returns back into the code that called it

	times 510-($-$$) db 0 ; Pad remainder of boot sector with 0s
	dw 0xAA55 ; The standard PC boot signature

