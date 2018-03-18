#include<stdio.h>

int main()
{
	int T,N,K,i,j,temp,ans;
	scanf("%d",&T);
	for(i=0;i<T;i++)
	{
		ans=0;
		scanf("%d %d",&N,&K);
		for(j=0;j<N;j++)
		{
			scanf("%d",&temp);
			ans = (ans+temp)%2;
		}
		if(ans==0)
		{
			if(K==1)
				printf("odd\n");
			else
				printf("even\n");
		}		
		else
			printf("even\n");
	}
	return 0;
}
