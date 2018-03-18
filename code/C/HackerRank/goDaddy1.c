#include<stdio.h>

int main()
{
	long long d,n,ans;
	scanf("%lld %lld",&n,&d);

	if(n%2==0)
		ans=n/2+d;
	else
		ans=n/2+d+1;
	
	printf("%lld\n",ans);
	return 0;
}
