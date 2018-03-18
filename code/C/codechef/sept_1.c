#include<stdio.h>

int data[250001][2];

int abst(int x)
{
	if(x<0)
		return -x;
	return x;
}

int main()
{
	int T,N,i,j,index;
	long long ans;
	scanf("%d",&T);
	while(T--)
	{
		ans=0;
		//index=0;
		scanf("%d",&N);
		for(i=0;i<N;i++)
		{
			for(j=0;j<N;j++)
			{
				scanf("%d",&index);
				data[index-1][0]=i;
				data[index-1][1]=j;
			}
		}
	
		for(i=1;i<N*N;i++)
		{
			ans+=abst(data[i][0]-data[i-1][0])+abst(data[i][1]-data[i-1][1]);
		}	

		printf("%lld\n",ans);
	}	
	return 0;
}
