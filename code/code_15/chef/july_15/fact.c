//Find number of zeroes at the end of N!.

#include<stdio.h>

int main()
{
	long long int T,N,i,ans;
	scanf("%lld",&T);
	while(T--)
	{
		ans=0;
		i=5;
		scanf("%lld",&N);
		while(N/i!=0)
		{
			ans+=N/i;
			i*=5;
		}
		printf("%lld\n",ans);
	}
	return 0;
}
