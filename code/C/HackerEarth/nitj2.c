#include<stdio.h>
#include<math.h>

int main()
{
	int N,Q,K,i,j,count,temp;
	scanf("%d %d",&N,&Q);
	int prime_no[N];
	int counter[10000]={0};
	prime_no[0]=1;
	for(i=2;i<=N;i++)
	{
		count=0;
		for(j=2;j<=sqrt(i);j++)
		{
			if(i%j==0)
			{
				temp=i/j;
				count=prime_no[temp];
				if(temp%j!=0)
					count+=prime_no[j];
				break;
			}
		}
		if(count==0)
		{
			prime_no[i]=1;
			counter[1]++;
		}
		else
		{
			prime_no[i]=count;
			counter[count]++;
		}
	}

	//for(i=0;i<N;i++)
		//printf("%d ",prime_no[i]);
	while(Q--)
	{
		scanf("%d",&K);
		if(K>sqrt(N))
			printf("0\n");
		else
			printf("%d\n",counter[K]);
	}
	return 0;
}
