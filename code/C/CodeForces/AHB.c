#include<stdio.h>

int abst(int x)
{
	if(x>0)
		return x;
	return -x;
}

int main()
{
	int a,b,ans=0,temp=1,d1,d2;
	scanf("%d %d",&a,&b);
	while(a!=0 || b!=0)
	{
		d1=a%10;
		d2=b%10;
		a/=10;
		b/=10;
		ans+=abst(d1-d2)*temp;
		temp*=10;
	}
	printf("%d\n",ans);
	return 0;	
}
