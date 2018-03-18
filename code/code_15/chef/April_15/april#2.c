#include<stdio.h>
#include<math.h>

int main(){

	int T;
	scanf("%d",&T);
	int N,i,j,k,count=0;
	int A[10000];
	double ans;
	for(i=0;i<T;i++)
	{
		scanf("%d",&N);
		//temp = sqrt((long)N);
		for(j=1;j<=sqrt(N);j++)
		{
			if(N%j==0)
			{
				A[count] = j;
				count++;
				ans+=j;
			}
		}
		for(j=0;j<count;j++)
		{
			//for(k=2;k<count;k++)
			//{
			//	if((A[j]*A[k])%N==0)
			//		ans+=A[j]*A[k];
			//}
			if(N/A[j]!=A[j])
				ans+=N/A[j];		
		}
		//ans+=N;
		printf("%.0lf\n",ans);
		ans=0;
		count=0;
	}
	return 0;
}
