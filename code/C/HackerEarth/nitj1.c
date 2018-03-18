#include<stdio.h>

int remain_power;

long long int power_mod(long long int x,int m,int count)
{
	if(2*count<=remain_power)
	{
		long long int ans=power_mod((x*x)%m,m,2*count);
		if(count<=remain_power)
		{
			remain_power-=count;
			return (ans*x)%m;
		}
		else
			return ans;
	}
	else
	{
		remain_power-=count;
		return x;
	}
}

int main()
{
	long long int A,B,K,T,i,temp,ans;
	int mod;
	scanf("%lld",&T);
	while(T--)
	{
		ans=0;
		mod=1;
		scanf("%lld %lld %lld",&A,&B,&K);
		remain_power=B;
		for(i=0;i<K;i++)
			mod*=10;
		temp=power_mod(A,mod,1)%mod;
		for(i=0;i<K && temp>0;i++)
		{
			ans+=temp%10;
			temp/=10;
		}
		printf("%lld\n",ans);
	}
	return 0;
}
