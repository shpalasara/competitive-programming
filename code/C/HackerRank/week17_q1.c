#include<stdio.h>

int main()
{
	//long long int first[2],second[2],third[2],forth[2];
	long long int T,N,i,x,y,temp;
	scanf("%lld",&T);
	while(T--)
	{
		scanf("%lld",&N);
		temp=N/4;
		if(N%4==0)
		{
			temp=(N-1)/4;
			x=-2-temp*2;
			y=x;
		}
		else if(N%4==1)
		{
			x=1+temp*2;
			y=-temp*2;
		}
		else if(N%4==2)
		{
			x=1+temp*2;
			y=2+temp*2;
		}
		else
		{
			x=-2-temp*2;
			y=-x;
		}
		printf("%lld %lld\n",x,y);
	}
	return 0;
}
