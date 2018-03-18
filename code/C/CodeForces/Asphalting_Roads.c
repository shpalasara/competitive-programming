#include<stdio.h>

int main()
{
	int n,i,j,min_x,min_y,max_x,max_y,x,y;
	scanf("%d",&n);
	int x_line[51]={0},y_line[51]={0};
	long long day=1;

	for(i=0;i<n*n;i++)
	{
		scanf("%d %d",&x,&y);
		if(x_line[x-1]==0 && y_line[y-1]==0)
		{
			printf("%lld ",day);
			x_line[x-1]=1;
			y_line[y-1]=1;
			day++;
		}
		else
			day++;
	}
	return 0;
}
