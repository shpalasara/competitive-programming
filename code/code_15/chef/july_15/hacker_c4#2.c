#include<stdio.h>

int main()
{
	int N,a,count,days=0;
	scanf("%d",&N);
	long long int data[N],i,j,k,check,prev,temp;

	scanf("%lld",&data[0]);
	prev=data[0];

	k=0;count=1;
	for(a=1;a<N;a++)
	{
		scanf("%lld",&temp);
		if(temp<prev)
		{
			if(k==1)
				data[count++]=temp;
			else
				data[count-1]=temp;
			k=0;					//0 indicates that in prev check it is in this bracket
		}
		else
		{
			k=1;
			if(days==0)
				days++;
		}
		prev=temp;
	}
	while(1)
	{
		check=days;
		prev=data[0];
		temp=1;
		k=0;
		printf("%lld ",data[0]);
		for(i=1;i<count;i++)
		{
			printf("%lld ",data[i]);
			if(data[i]<prev )
			{
				if(k==1)
					data[temp++]=prev;
				else
					data[temp-1]=prev;
				k=0;
			}
			else if(data[i]>prev)
			{
				k=1;
				if(days==check)
				{
					//temp=i;
					days++;
				}	
			}
			prev=data[i];	
		}
		printf("\n");
		if(days==check)
			break;
		count=temp;
	}
	printf("%d\n",days);

	return 0;
}
