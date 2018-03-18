#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <ctype.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>

void handle_sigchld(int sig) {
   pid_t pid;
   int status;

   while (1) {
      //printf("hii\n");
      pid = waitpid(-1, &status, WNOHANG);
      if (pid <= 0)    /* No more zombie children to reap. */
         break;
      printf("Reaped child %d\n", pid);
   }
   sleep(1);
}

int main() {
   int i;
   signal(SIGCHLD, handle_sigchld);
   for (i = 0; i < 3; i++) {
      if (fork() == 0) {
        /* Child-process code. */        
	printf("Hello from child %d\n", getpid());
        sleep(2);
        exit(0); /* Term child */
      }
   }
   /* Parent-process code. */
   while (1) /* Wait for children */
      pause(); /* to terminate. */
   return 0;
}

/*
***Output of this***

Hello from child 9769
Hello from child 9770
Hello from child 9771
hii
Reaped child 9769
hii
Reaped child 9770
hii
Reaped child 9771
hii
hii
^C
shalin@shalin-laptop:~/Desktop/code_15/Project#1/temp$ ./a.out
Hello from child 9773
Hello from child 9774
Hello from child 9775
hii
Reaped child 9773
hii
Reaped child 9774
hii
Reaped child 9775
hii
hii
^C
shalin@shalin-laptop:~/Desktop/code_15/Project#1/temp$ ./a.out
Hello from child 9777
Hello from child 9778
Hello from child 9779
hii
Reaped child 9777
hii
Reaped child 9778
hii
hii
Reaped child 9779
hii


*/
