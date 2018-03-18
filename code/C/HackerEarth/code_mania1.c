#include<stdio.h>

int main()
{
	int N,K,i,temp;
	scanf("%d %d",&N,&K);
	int data[N],index[N];
	for(i=0;i<N;i++)
	{
		scanf("%d",&temp);
		index[temp-1]=i;
		data[i]=temp;
	}
	if(K>=N)
	{
		//printf("fine\n");
		for(i=0;i<N;i++)
			printf("%d ",N-i);
		printf("\n");
	}
	else
	{
		//printf("good\n");
		i=0;
		while(K>0 && i<N)
		{
			temp=data[i];
			if(temp!=N-i)
			{
				data[i]=N-i;
				data[index[N-i-1]]=temp;
				index[temp-1]=index[N-i-1];
				index[N-i-1]=i;
				K--;
			}
			i++;
		}
		for(i=0;i<N;i++)
			printf("%d ",data[i]);
		printf("\n");
	}
	return 0;
}
