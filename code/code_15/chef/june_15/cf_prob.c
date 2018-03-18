#include<stdio.h>
	
int main()
{
	int T,i,j;
	long long int T1,T2,t1,t2,temp;
	double ans;
	scanf("%d",&T);
	for(i=0;i<T;i++)
	{
		scanf("%lld",&T1);
		scanf("%lld",&T2);
		scanf("%lld",&t1);
		scanf("%lld",&t2);

		if(t1==0 && t2==0)
		{
			if(T1>=T2)
				ans = 1/(T1+1);
			else
				ans = 1/(T2+1);
		}
		else if(t1==0 || t2==0)
		{
			temp = t1|t2;
			if(T1>=T2)
			{
				if(T2-(temp)+1>0)
					ans = (T2+1-temp)*(temp+1)+((temp)*(temp+1))/2;
					//ans = (T2+1-(temp/2))*(temp+1);
				else
					ans = ((T2+2)*(T2+1))/2;
					//ans = ((temp)*(temp)+(temp))/2;
				//temp = (T1+1)*(T2+1);
				//printf("%lf\n",ans);
			}
			else
			{
				if(T1-(temp)+1>0)
					ans = (T1+1-temp)*(temp+1)+(temp*(temp+1))/2;
					//ans = (T1+1-(temp/2))*(temp+1);
				else
					ans = ((T1+2)*(T1+1))/2;
			}
			ans /=(T1+1);
			ans /=(T2+1);	
		}		
		else
		{
		}		
		printf("%lf\n",ans);
		ans=0;
	}
	return 0;
}
