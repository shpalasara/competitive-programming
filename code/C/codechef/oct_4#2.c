#include<stdio.h>

int abst(int x)
{
	if(x>0)
		return x;
	return -x;
}

int main()
{
	int T,i,j;
	double A,check=1.0/120.0;
	scanf("%d",&T);
	while(T--)
	{
		scanf("%lf",&A);
		for(i=0;i<12;i++)
		{
			for(j=0;j<60;j++)
			{
				if((double)abst(60*i-j*11)-2*A<2*check && (double)abst(60*i-j*11)-2*A>-2*check)
				{
					printf("%02d:%02d\n",i,j);	
				}
				else if((double)abst(60*i-j*11)-2*(360-A)<2*check && (double)abst(60*i-j*11)-2*(360-A)>-2*check)
				{
					printf("%02d:%02d\n",i,j);
				}
			}
		}	
	}
	return 0;
}
