#include<stdio.h>

int main()
{
	int T,N,M,dirty,index,temp;
	scanf("%d",&T);
	while(T--)
	{
		scanf("%d %d",&N,&M);
		dirty=(M-1)/N;

		if(N%2==0)
		{
			//if(M%2==0)
			temp=M%N;
			if(temp==0)
				temp=N;
			if(temp%2==0)
				index=N-((temp-2)/2);
			else
				index=temp/2+1;
		}
		else
		{
			temp=M%(2*N);
			if(temp==0)
				temp=N;
			if((temp-1)/N>0)
			{
				temp = temp-N;
				if(temp%2==0)
					temp-=1;
				else
					temp+=1;
			}
			if(temp%2==0)
				index=N-((temp-2)/2);
			else
				index=temp/2+1;
		}
		printf("%d %d\n",index,dirty);
		index=0;dirty=0;
	}
	return 0;
}
