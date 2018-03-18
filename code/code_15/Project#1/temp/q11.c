#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <ctype.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>

int main() {
    pid_t cpid; 
    char buf[10]; 
    int i;

    if ((cpid = fork()) == 0) {
        setpgrp();
        printf("Child pgid = %d\n", getpgrp());
        for (i=0; i<3; i++) 
            if (fork() == 0)
                while (1);
        while (1);
    } else {
        sleep(1);
        if (fork() == 0) {
           sprintf(buf, "%d", cpid);
           execlp("ps", "ps", "-Opgid", "-p", buf, "--ppid", buf, NULL);
        }
        sleep(1);
        kill(-cpid, SIGINT); 
   }
}
