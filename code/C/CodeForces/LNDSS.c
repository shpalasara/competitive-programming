#include<stdio.h>

int main()
{
	int n,prev,data,max=0,temp=1;
	scanf("%d %d",&n,&prev);
	n--;
	while(n--)
	{
		scanf("%d",&data);
		if(data>=prev)
			temp++;
		else
		{	
			if(max<temp)
				max=temp;
			temp=1;
		}			
		prev=data;	
	}
	if(max<temp)
		max=temp;
	printf("%d\n",max);
	return 0;
}
