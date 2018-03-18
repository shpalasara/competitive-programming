#include<stdio.h>

int main()
{
	int N,K,A,x,y,i,count;
	long long int ans;
	scanf("%d",&N);
	int data[N];
	int check[N];
	for(i=0;i<N;i++)
	{
		scanf("%d",&data[i]);
		check[i]=0;
	}
	scanf("%d",&K);
	int shop[K];
	for(i=0;i<K;i++)			//K -> Total number of shop
		scanf("%d",&shop[i]);
	scanf("%d",&A);
	while(A--)
	{
		count=0;
		ans=0;
		scanf("%d %d",&x,&y);
		for(i=x-1;count<y;i++)
		{
			i%=K;
			if(check[shop[i]-1]==0)
			{
				ans+=data[shop[i]-1];
				check[shop[i]-1]=1;
			}
			count++;
		}
		for(i=0;i<N;i++)
			check[i]=0;
		printf("%lld\n",ans);
	}
	return 0;
}
