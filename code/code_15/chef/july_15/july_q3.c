#include<stdio.h>

int main()
{
	long long int T,N,K,today,left,ans,temp;
	scanf("%lld",&T);
	while(T--)
	{
		scanf("%lld %lld",&N,&K);
		today=0;left=0;ans=0;temp=0;
		while(N--)
		{
			scanf("%lld",&today);
			if(left>=today)
			{
				left=left-today;
				if(left!=0)
					left--;			
			
			}
			else
			{
				temp=today/K;
				if(temp>0)
				{
					ans+=temp;
					today=today-(temp*K);
				}
				if(left>=today)
				{
					left=left-today;
					if(left!=0)
						left--;							
				}
				else
				{
					left=K+left-today;
					if(left!=0)
						left--;	
					ans++;
				}
			} 
		}
		printf("%lld\n",ans);
	}
	return 0;
}
