#include<stdio.h>

int max(int a,int b)
{
	if(a>b)
		return a;
	return b;
}

int main()
{
	int day,i;
	long long ans=0;
	for(i=1;i<=5;i++)
	{
		scanf("%d",&day);
		ans+=max(0,100-10*(day-i));
	}
	printf("%lld\n",ans);
	return 0;
}
