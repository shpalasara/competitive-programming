#include<stdio.h>

long long cmpfunc (const void * a, const void * b)
{
   return ( *(long long*)a - *(long long*)b );
}

int main()
{
	int n,i;
	scanf("%d",&n);
	long long data[n],ans;
	for(i=0;i<n;i++)
	{
		scanf("%lld",&data[i]);
	}
	qsort(data, n, sizeof(long long), cmpfunc);
	
	ans=data[n-1];
	for(i=n-2;i>=0;i--)
	{
		if((n-i)*data[i]>ans)
			ans=(n-i)*data[i];
	}
	printf("%lld\n",ans);
	return 0;
}
