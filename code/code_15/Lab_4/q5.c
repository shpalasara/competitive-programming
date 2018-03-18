#include<stdio.h>
#include<signal.h>

void func( int sig )
{
	printf("Oops! -- I got a signal\n");
}
int main()
{
	int i;
	signal(SIGINT, func);
	//catch terminal interrupts
	for (i = 0; i < 20; ++i ) {
		printf("IT 215 lab on signals\n");
		sleep (1);
	}
	return 0;
}
