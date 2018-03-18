#include<stdio.h>

int main()
{
	int T,N,i,j,count,prev,now,temp;
	long long int ans;
	scanf("%d",&T);
	while(T--)
	{
		//ans=0;
		count=0;
		scanf("%d %d",&N,&prev);
		ans=N;
		//int data[N];

		for(i=1;i<N;i++)
		{
			scanf("%d",&now);
			if(now>=prev)
			{
				count++;
				ans+=count;
			}
			else
				count=0;
			prev=now;
		}
		printf("%lld\n",ans);
	}
	return 0;
}
