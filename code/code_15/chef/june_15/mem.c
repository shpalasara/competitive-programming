#include<stdio.h>

int main()
{
	int T,N,i,j;
	long long int prev=0,now=0,ans=0;
	scanf("%d",&T);
	for(i=0;i<T;i++)
	{
		scanf("%d",&N);
		for(j=0;j<N;j++)
		{
			scanf("%lld",&now);
			if(now>prev)
				ans+=now-prev;
			prev=now;
		}
		printf("%lld\n",ans);
		ans=0;
		prev=0;
	}
	return 0;
}
