#include<stdio.h>

int main()
{
	int T;
	scanf("%d",&T);
	char _temp;
	scanf("%c",&_temp);
	double i,j,N,shift=0,ans=0,loop;
	char temp;
	for(i=0;i<T;i++)
	{
		while(1)
		{
			scanf("%c",&temp);
			if(temp=='T')
				shift+=2;
			else if(temp=='S')
				shift++;
			else //if(temp=='\n')
				break;
		}
		scanf("%lf",&N);
		scanf("%c",&temp);
		loop = (int)((12*N)/(shift));
		//printf("Loop is %.0lf\n",loop);
		for(j=1;j<=loop;j++)
		{
			ans += (12*N)-(shift*j);
		}
		printf("%.0lf\n",ans);
		ans=0;
		shift=0;
		loop=0;
	}
	return 0;
}
