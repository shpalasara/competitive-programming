#include<stdio.h>

int main()
{
	int N,i,days=0,count=0;
	scanf("%d",&N);
	long long int data[N],temp,prev,check;

	scanf("%lld",&data[0]);
	prev=data[0];
	count++;
	for(i=1;i<N;i++)
	{
		scanf("%lld",&temp);

		if(temp>prev)
		{
			if(days==0)
				days++;
		}		
		else
			data[count++]=temp;
		prev=temp;
	}
	
	while(1)
	{
		check=days;
		prev=data[0];
		//printf("%lld ",data[0]);
		temp=1;
		for(i=1;i<count;i++)
		{
			//printf("%lld ",data[i]);
			if(data[i]>prev)
			{
				if(days==check)
				{	
					days++;
					temp=i;
				}
			}		
			else
				data[temp++]=data[i];
			prev=data[i];	
		}
		//printf("\n");
		if(days==check)
			break;
		count=temp;
	}
	printf("%d\n",days);
	return 0;
}
