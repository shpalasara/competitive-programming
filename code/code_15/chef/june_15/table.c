#include<stdio.h>
#include<math.h>

int main()
{
	int T,N,M,i,j,k;
	int temp=1;
	long long int ans[2000][2000];
	for(i=0;i<2000;i++)
	{
		for(j=0;j<2000;j++)
		{
			if(i==0)
				ans[i][j]=j+2;
			else if(j==0)
				ans[i][j]=i+2;
		}
	}
	scanf("%d"&T);
	for(i=0;i<N;i++)
	{
		scanf("%d %d",&N,&M);
		if(N==1)
			
		for(j=0;j<;j++)
		{

		}
	}
	return 0;
}
