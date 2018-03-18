#include<stdio.h>

int main()
{
	int length,p,q;
	scanf("%d %d %d",&length,&p,&q);
	double ans = (double)p*((double)length/(double)(p+q));
	printf("%lf\n",ans);
}
