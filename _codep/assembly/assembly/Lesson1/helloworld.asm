; Hello World Program 
; Compile with: $ nasm -f elf helloworld.asm
; Link with (64 bit systems require elf_i386 option): ld -m elf_i386  helloworld.o -o helloworld
; Run with: ./helloworld
; MacOS: $ nasm -f macho helloworld.asm && ld -macosx_version_min 10.7.0 -o helloworld helloworld.o && ./helloworld

SECTION .data
msg db 'Hello World!', 0Ah ;assgin msg variable with your message string

SECTION .text
global _start

_start: ; this means that this program has its own point of entry without the use of the main function
    mov edx, 13 ; number of bytes to write -  one for each letter plus 0Ah (line feed character)
	mov ecx, msg ; move the memory address of our message string into ecx
	mov ebx, 1 ; write to the STDOUT file
	mov eax, 4 ;invoke SYS_WRITE (kernel opcode 4)
	int 80h
