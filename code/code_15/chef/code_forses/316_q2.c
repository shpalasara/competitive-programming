#include<stdio.h>

int main()
{
	long long int n,m,mid;		//n ->total number m ->number selected by misha
	scanf("%lld %lld",&n,&m);
	if(n%2==0)
	{
		mid=n/2;
		if(m==mid+1)
			printf("%lld\n",mid);
		else if(m==mid)
			printf("%lld\n",mid+1);
		else if(m<mid)
			printf("%lld\n",m+1);
		else
			printf("%lld\n",m-1);
	}
	else
	{
		mid=(n-1)/2+1;
		if(m==mid)
		{
			if(n==1)
				printf("1\n");
			else
				printf("%lld\n",m-1);
		}
		else if(m<mid)
			printf("%lld\n",m+1);
		else
			printf("%lld\n",m-1);
	}
	return 0;
}
