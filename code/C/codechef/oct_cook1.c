#include<stdio.h>

int abst(int a)
{
	if(a>0)
		return a;
	return -a;
}

int main()
{
	int T,size,n,max1,max2,index1,index2,i,j,check;
	int data[1000010];
	scanf("%d",&T);
	while(T--)
	{
		check=1;
		scanf("%d",&size);
		
		for(i=0;i<size;i++)
		{	
			scanf("%d",&data[i]);
		}
		
		if(size<=2)
			printf("YES\n");
		else
		{
			if(data[0]>data[1])
			{
				max1=data[0];
				max2=data[1];
				index1=0;
				index2=1;
			}
			else
			{
				max2=data[0];
				max1=data[1];
				index1=1;
				index2=0;
			}

			for(i=2;i<size;i++)
			{
				if(data[i]>=max2 /*&& i-2<=index2 */&& abst(index1-index2)<2)
				{
					if(data[i]>=max1)
					{
						index2=i-1;
						index1=i;
						max2=max1;
						max1=data[i];
					}
					else
					{
						max2=data[i];
						index2=i-1;
						index1++;
					}
				}
				else
				{
					check=0;
					break;
				}	
			}

			if(check==1)
				printf("YES\n");
			else
				printf("NO\n");
		}
	}
	return 0;
}
