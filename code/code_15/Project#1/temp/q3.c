#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <ctype.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>

void main()
{

  int i, stat;
  pid_t cpid;
  if (fork() == 0) {
     printf("Child pid = %d\n", getpid());
     sleep(3);
     exit(1);
  } else {
  /* use with -1 to wait on any child (with options) */
     while ((cpid = waitpid(-1, &stat, WNOHANG)) == 0) {
         sleep(1);
         printf("No terminated children\n");
     }
     printf("Reaped %d with exit status: %d\n",  
                cpid, WEXITSTATUS(stat));
  }
}
