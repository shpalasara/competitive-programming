#include<stdio.h>
#include<math.h>

int main()
{
	long long int T,x,y,ans,temp,i;
	scanf("%lld",&T);
	while(T--)
	{
		ans=0;
		scanf("%lld %lld",&x,&y);
		if(y==x)
			printf("-1\n");
		else if(y>x)
			printf("0\n");
		else
		{
			temp=x-y;		
			for(i=1;i<sqrt(temp);i++)
			{
				if(temp%i==0)
				{
					if(i>y)
						ans++;
					if(temp/i>y)
						ans++;
				}
			}
			i=sqrt(temp);
			if(i*i!=temp)
				ans++;
			ans++;	
			printf("%lld\n",ans);
		}
	}
	return 0;
}
