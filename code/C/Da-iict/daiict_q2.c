#include<stdio.h>

int main()
{
	int T,ans;
	long long int n,temp;
	scanf("%d",&T);
	while(T--)
	{
		ans=0;temp=3;
		scanf("%lld",&n);
		if(n<=1)
			ans=0;
		else if(n<=3)
			ans=1;
		else
		{
			if(n%3==0)
				n--;
			while(n>0)
			{
				n/=3;
				ans++;
			}
		}
		printf("%d\n",ans);
	}
	return 0;
}
/*
while(n>temp)
{
	ans++;
	temp*=3;
}*/
