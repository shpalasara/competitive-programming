#include<stdio.h>

int main()
{
	long long int T,A,B,i,j,ans,temp;
	scanf("%lld",&T);
	while(T--)
	{
		ans=0;
		scanf("%lld %lld",&A,&B);
		if(A==B)
			ans=0;
			//printf("0\n");
		else 
		{
			if(A>B)
			{
				//temp=A;
				while(A>B)
				{
					ans++;
					A/=2;
				}
			}			
			temp=B;
			while(A<temp)
			{
				//printf("here0\n");
				ans++;
				temp/=2;
			}
			//printf("%lld\n",temp);
			while(A!=temp && A!=1)
			{
				//printf("here\n");
				A/=2;	
				if(A==temp)
				{
					ans+=2;
					break;
				}
				temp/=2;			
				ans+=2;	
			}
		}
		printf("%lld\n",ans);	
	}
	return 0;
}
