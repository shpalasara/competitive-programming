#include<stdio.h>

int output[100001]={0};

int main()
{
	int T,n,i,length,index,count,prev,temp;
	scanf("%d",&T);
	while(T--)
	{
		scanf("%d",&n);
		index=1;
		output[i]=i;
		count=1;
		prev=1;
		if(n==1)
			output[0]=1;
		else
		{
			while(count<n)
			{
				index=(count+1)%(n-count);
				while(index>=0)
				{
					if(output[prev]==0)
                    			{
						index--;
                        			if(index<0)
                            				break;
                   			}
					prev++;
					prev%=n;
				}
				output[prev++]=++count;
				prev%=n;
			}
			//output[prev]=++count;
		}
		for(i=0;i<n;i++)
		{
			//pr.print('X');
			printf("X%d ",output[i]);
			output[i]=0;
			//pr.print();
		}
		printf("\n");
	}
	return 0;
}
