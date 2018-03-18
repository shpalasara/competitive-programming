#include<stdio.h>

int main()
{
	long long int x,y,k;
	double ans,ans_1;
	scanf("%lld %lld",&x,&y);
	if(y>x)
		printf("-1\n");
	else if(x==y)
	{
		ans=x;
		printf("%.12f\n",ans);
	}
	else
	{
		k=1;
		ans=(double)(x-y)/(double)2;
		k=(int)ans/y;
		//printf("Hello %f\n",ans);
		while(y<=ans/k)
		{
			//printf("%lld\n",k);
			k++;
		}
		ans/=(k-1);
		k=1;
		ans_1=(double)(x+y)/(double)2;
		k=(int)ans_1/y;
		while(y<=ans_1/k)
		{
			k++;
		}
		ans_1/=(k-1);
		if(ans<ans_1)
			printf("%.12f\n",ans);
		else
			printf("%.12f\n",ans_1);
	}	
	return 0;
}
