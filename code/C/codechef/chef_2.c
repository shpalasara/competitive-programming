#include<stdio.h>

int main()
{
	int T,N,K,i,L,R;
	char data[2002];
	scanf("%d",&T);
	while(T--)
	{
		scanf("%d %d",&N,&K);
		for(i=0;i<N;i++)
		{
			if(i%2==0)
				data[i]='(';
			else
				data[i]=')';
		}
		while(K--)
		{
			scanf("%d %d",&L,&R);
			for(i=L;i<=R;i++)
			{
				if((i-L)%2==0)
					data[i]='(';
				else
					data[i]=')';
			}
		}
		data[N]='\0';
		printf("%s\n",data);
	}
	return 0;
}
