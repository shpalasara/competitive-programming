#include<stdio.h>

int main()
{
	int T,N,i,j,k,total=0;
	int temp,check=0;
	int data[50];
	int ans[50];
	scanf("%d",&T);
	for(i=0;i<T;i++)
	{
		total=0;
		check=0;
		scanf("%d",&N);
		for(j=0;j<N;j++)
		{
			scanf("%d",&data[j]);
			ans[j]=0;			
			//printf("%d\n",ans[j]);
			total+=data[j];
			if(data[j]>=N)
				check=1;
		}
		/*if(N==1 && total==0)
			printf("0\n");
		else */
		if(total==N && check==0)
		{
			j=0;
			while(total!=0)
			{
				//printf("fine\n");
				temp = data[j];
								//if(temp!=0)
								//{
				k=(j+1)%N;
				while(temp!=0)
				{
					//	printf("hello\n");
					if(k!=j && ans[k]==0)
					{
						if(check==1 || data[k]!=0)
						{
						    ans[k]=(j+1)%(N+1);							
						    temp--;
						    total--;
						}
					}
					if(k==N-1)
						check=1;
					k=(k+1)%N;
				}	
				check=0;							//}
				j=(j+1)%N;
			}
			//printf("here i am\n");
			for(j=0;j<N;j++)
			{
				printf("%d ",ans[j]);
				ans[j]=0;
				data[j]=0;
			}
			printf("\n");
		}
		else
			printf("-1\n");
	}

	return 0;
}
