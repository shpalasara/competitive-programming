#include<stdio.h>
#include<math.h>

int main()
{
	long long int T,N,i,ans,first,second;
	scanf("%lld",&T);
	while(T--)
	{
		first=2;second=3;
		scanf("%lld",&N);
		if(N==1 || N==second || N==first)
			ans=N;
		else
		{
			ans=3;
			i=second;
			second+=first;
			first=i;
			while(N>=second)
			{
				i=second;
				second+=first;
				first=i;
				//if(N>=second)
					ans++;
			}
		}
		printf("%lld\n",ans);
	}
	return 0;
}



/*		temp=N;
		printf("%lld\n",temp);
		_temp = temp<<1;
		printf("%lld\n",temp);
		temp = sqrt(_temp);
		while(1)
		{
			if((temp*(temp+1))>=_temp)
			{
				ans=temp;
				break;
			}
			temp++;
		}

			if(temp*temp!=N)
			{
				even=temp;
				while(even*(even+1)<N)
					even++;
				temp++;
			}
			else
			{
				even=temp-1;
				while(even*(even+1)<N)
					even++;
			}
			ans = 1+2*(temp-1);


		if(N==1)
			ans=1;
		else
		{
			temp =sqrt(N);
			even=temp-1;

			while(even*(even+1)<N)
				even++;
			while(temp*temp<N)
				temp++;
			even=2*even;
			temp=1+2*(temp-1);
			if(even<temp)
				ans=even;
			else
				ans=temp;
		}
*/
