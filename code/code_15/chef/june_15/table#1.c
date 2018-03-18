#include<stdio.h>

#define mod 1000000000

/*long long int combination(int n,int m)			//nCm
{
	int i=0;
	long long int ans=1;
	if(n==m)
		return 1;
	for(i=0;i<m;i++)
	{
		ans=ans*(n-i);
		ans=(ans/(i+1))%mod;
	}	
	return ans; 
}
*/
//void main
//{
//	printf("%lld\n",combination());
//}
long long int nCr[4000][4000];		
long long int array[2001][2001];

int main()
{
	int T,N,M,i,j,k;
	for(i=0;i<4000;i++)		//n from nCr
	{
		for(j=0;j<=i;j++)	//r from nCr
		{
			if(j==0 || i==j || i==0)
				nCr[i][j]=1;
			else
				nCr[i][j]=(nCr[i-1][j]+nCr[i-1][j-1])%mod;
		}
	}

	long long int ans,temp;
	scanf("%d",&T);
	for(i=0;i<T;i++)
	{
		ans=0;
		scanf("%d %d",&N,&M);

		for(j=0;j<N;j++)
		{	
			temp=1;
			for(k=0;k<M+1;k++)
			{
				if(j==0 || k==0)
				{
					//array[j][k]=(combination(k+M-1,M-1))%mod;
					array[j][k]=nCr[k+M-1][M-1];
				}
				else
				{
					temp=(temp+array[j-1][k])%mod;
					array[j][k]=(temp*array[0][k])%mod;		
				}
				if(j==N-1)		
					ans=(ans+array[j][k])%mod;
			
				//printf("%lld ",array[j][k]);
			}
		}
		printf("%lld\n",ans);
	}
	return 0;
}

