#include<stdio.h>
 
long long ans[10000000];

long long funct(long long data)
{
	if(data<10000000)
		return ans[data];
	else if(data/2+data/3+data/4>data)
		return (funct(data/2)+funct(data/3)+funct(data/4));
	else
		return data;
}

long long max(long long x,long long y)
{
	if(x>y)
		return x;
	return y;
}
 
int main()
{
	int i;
	for(i=0;i<12;i++)
		ans[i]=i;
	for(i=12;i<10000000;i++)
	{
		ans[i]=max(i,ans[i/2]+ans[i/3]+ans[i/4]);
	}

	long long data,ans_temp;


	while(scanf("%lld",&data)!=EOF)
	{
		if(i>=10000000)
			ans_temp=funct(data);
		else
			ans_temp=ans[data];
		printf("%lld\n",ans_temp);
	}
	return 0;
} 
