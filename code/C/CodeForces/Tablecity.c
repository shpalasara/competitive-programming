#include<stdio.h>

int main()
{
	int i=0;
	printf("2001\n");
	for(i=1;i<=1000;i++)
		printf("%d 1 %d 2\n",i,i);
	//printf("1000 1 1000 2\n");
	printf("1000 1 1000 2\n");
	for(i=1000;i>0;i--)
		printf("%d 1 %d 2\n",i,i);	
	return 0;
}
