#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <ctype.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>

void handle_sigint(int sig) {
    printf("Caught signal %d\n", sig);
}

int main() {
   signal(SIGINT, handle_sigint);
   while (1) {
      /* System call to wait for a signal to arrive. */
      pause();
   }
   return 0;
}
