#include<stdio.h>

int main()
{
	long long int N,A,temp,count;
	scanf("%lld",&N);
	while(N--)
	{
		count=0;
		scanf("%lld",&A);
		temp = A;
		while(temp/5!=0)
		{
			if(temp%10==0)
				temp/=10;
			//++count;
			else if(temp%5==0)
			{
				temp/=5;
				count++;
			}		
			else
				break;	
			if(count/2!=0 && count%2==0)
				A*=4;
		}		
		if(count%2==1)
			A*=4;
		printf("%lld\n",A);
	}

	return 0;
}
