#include<stdio.h>

int recursion(int n,int cycle)
{
	if(n==1)
		return 1;
	else if(n%2==0)
		return(recursion(n/2,++cycle));
	else
	{
		cycle++;
		int temp=1<<cycle;
		return(temp+recursion(n/2,cycle));
	}
}

int main()
{
	int T,n;
	scanf("%d",&T);
	while(T--)
	{
		scanf("%d",&n);
		printf("%d\n",recursion(n,0));
	}
	return 0;
}
