#include<stdio.h>

int main(){

	int T;
	scanf("%d",&T);
	int a,b,c,i,j,N,temp,ans=0;
	for(i=0;i<T;i++)
	{
		scanf("%d",&N);
		for(j=0;j<=N;j++)
		{
			if(j==N)
			{
				if(b!=a)
					ans++;
			}
			else if(j==0)
			{
				scanf("%d",&a);
			}
			else if(j==1)
			{
				scanf("%d",&b);
				if(a!=b)
					ans++;
			}
			else //if(j==2)
			{
				scanf("%d",&c);
				if(a!=b || b!=c)
					ans++;
				a=b;
				b=c;
			}
		}
		printf("%d\n",ans);
		ans=0;
	}
	return 0;
}
