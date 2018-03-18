#include<stdio.h>

int main()
{
	long long int n,i,ans=1;
	scanf("%lld",&n);
	while(n>1)
	{
		if(n%2!=0)
			ans++;
		n=n>>1;
	}
	printf("%lld\n",ans);
	return 0;
}
