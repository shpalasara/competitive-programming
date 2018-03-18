#include<stdio.h>

long long int power_funt(int a,int b)
{
	long long int ans=1;			//(a^b)%(1000000007)
	while(b--)
	{
		ans = (ans*a)%1000000007;
	}
	return ans;
}

int main()
{
	int n,m,k;
	//long long int ans=0;
	scanf("%d %d %d",&n,&m,&k);
	if(k==1 || n<k)
		printf("%lld\n",power_funt(m,n));
	else if(k%2==0)
	{
		if(n!=k)
			printf("%d\n",m);
		else
			printf("%lld\n",power_funt(m,k/2));
	}
	else
	{
		if(n!=k)
			printf("%lld\n",power_funt(m,2));
		else
			printf("%lld\n",power_funt(m,(k+1)/2));
	}
	return 0;
}
