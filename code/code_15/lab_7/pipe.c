#include<stdio.h>
#include<stdlib.h>
//#include<unilib.h>

void main()
{
	int p[4][2];

	pipe(p[0]);
	pipe(p[1]);
	pipe(p[2]);
	pipe(p[3]);

	int ch1,ch2,ch3;
	
	if((ch1=fork())==0)
	{
	
	}
	else if((ch2=fork())==0)
	{

	}
	else if((ch3=fork())=0)
	{

	}
	
	if(ch1!=0 && ch2!=0 && ch2!=0)
	{
		int no_msg,i=0;
		printf("Enter the number of messages:\n");
		scanf("%d",&no_msg);
		
		for(i=0;i<no_msg;i++)
		{
			printf("");
		}
	}
		
}
