#include<stdio.h>

//int array[1000000];

int main()
{
	int T,i,j,k,temp;
	scanf("%d",&T);
	int array[T];	
		
	scanf("%d",&array[0]);
	for(i=1;i<T;i++)
	{
		scanf("%d",&temp);
		for(j=0;j<i;j++)
		{
			if(temp<array[j])
			{
				k=array[j];
				array[j]=temp;
				temp=k;
			}
		}
		array[i]=temp;
	}
	for(i=0;i<T;i++)
		printf("%d\n",array[i]);	
	
	return 0;
}
