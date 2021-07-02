// https://blog.packagecloud.io/eng/2016/04/05/the-definitive-guide-to-linux-system-calls/
// example of GCC inline assembly
// Run it in Ubuntu

int main(int argc, char *argv[]) {
    unsigned int syscall_nr = 1;
    int exit_status = 42;

    asm ("movl %0, %%eax\n"
    	 "movl %1, %%ebx\n"
    	 "int $0x80"
    	 : /* output parameters, we aren't outputting anything, no none */
    	   /* (none) */
    	 : /* input parameters mapped to %0 and %1, respectively */
    	 "m" (syscall_nr), "m" (exit_status)
    	 : /* registers that we are "clobbering", unneeded since we are calling exit */
    	 "eax", "ebx"
    	  );
}