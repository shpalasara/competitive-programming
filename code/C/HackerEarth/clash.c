#include<stdio.h>

int main()
{
	int T,ans;			//0 for adam 1 for bob
	long long int a,b,c,temp,start,end;
	scanf("%d",&T);
	while(T--)
	{
		ans=0;
		scanf("%lld %lld %lld",&a,&b,&c);
		temp=1;
		while(temp*b<c)
		{
			end=temp*b;
			temp*=a;
			start=temp;
			ans++;
		}
		if(ans%2==0)
			printf("Adam\n");
		else
			printf("Bob\n");
	}
	return 0;
}
