#include<stdio.h>

int main()
{
	int T,N,A,min,i;
	scanf("%d",&T);
	while(T--)
	{
		min=1000000;
		scanf("%d",&N);
		i=N;
		while(i--)
		{
			scanf("%d",&A);
			if(A<min)
				min=A;
		}
		long long int t1=min,t2=N-1;
		printf("%lld\n",t1*t2);
	}	
	return 0;
}
