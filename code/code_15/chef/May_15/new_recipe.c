#include<stdio.h>

int main()
{
	int T,i,j,N,data,ans=0,war=0,min=10000;
	scanf("%d",&T);
	for(i=0;i<T;i++)
	{
		scanf("%d",&N);
		for(j=0;j<N;j++)
		{
			scanf("%d",&data);
			if(data<2)
				war=1;				
			if(data<min)
				min=data;

			ans+=data;
		}
		if(war==1)
			printf("-1\n");	
		else
			printf("%d\n",ans-min+2);
		
		min=10000;
		ans=0;	
		war=0;
	}
	return 0;
}
