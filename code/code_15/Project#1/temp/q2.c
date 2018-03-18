#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <ctype.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>

void main() {

  int i, stat;
  pid_t pid[5];
  for (i=0; i<5; i++)
     if ((pid[i] = fork()) == 0){
         sleep(1);
         exit(100+i);
     }
  for (i=0; i<5; i++) {
     pid_t cpid = wait(&stat);
     if (WIFEXITED(stat))
        printf("Child %d terminated with status: %d\n",  
                cpid, WEXITSTATUS(stat));
  }
}
