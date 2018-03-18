#include<stdio.h>

int main()
{
	int T,N,x,y,i,check_1,check_2,min_x,min_y,max_x,max_xy,max_y,index_min_x,index_min_y,index_max_x,index_max_y,s_max,sy_max,index_s_max;
	scanf("%d",&T);
	while(T--)
	{	
		index_min_x=0;
		index_min_y=0;
		index_max_x=0;
		index_max_y=0;
		index_s_max=0;
		scanf("%d",&N);
		scanf("%d %d",&x,&y);
		min_x=x;
		s_max=-1000000001;
		sy_max=-1000000001;
		min_y=y;
		max_x=x;
		max_xy=y;
		max_y=y;
		for(i=1;i<N;i++)
		{
			check_1=0;
			check_2=0;
			scanf("%d %d",&x,&y);
			if(x>max_x)
			{
				index_s_max=index_max_x;
				s_max=max_x;
				sy_max=max_xy;
				index_max_x=i;
				max_x=x;
				max_xy=y;
				if(y==max_y)
					index_max_y=i;
				if(y==min_y)
					index_min_y=i;
				check_1=1;
			}
			else if(x>s_max)
			{
				if(x!=max_x || !(y>max_y || y<min_y))
				{
					index_s_max=i;
					sy_max=y;
					s_max=x;
				}
			}
			if(x<min_x)
			{
				min_x=x;
				index_min_x=i;
				if(y==max_y)
					index_max_y=i;
				if(y==min_y)
					index_min_y=i;
				check_2=1;
			}
			if(y>max_y)
			{
				index_max_y=i;
				max_y=y;
				if(x==max_x && check_1==0)
				{
					index_s_max=index_max_x;
					s_max=max_x;
					sy_max=max_xy;
					index_max_x=i;
					max_xy=y;
				}
				if(x==min_x && check_2==0)
					index_min_x=i;
				
			}
			if(y<min_y)
			{
				index_min_y=i;
				min_y=y;
				if(x==max_x && check_1==0)
				{
					index_s_max=index_max_x;
					s_max=max_x;
					sy_max=max_xy;
					max_xy=y;
					index_max_x=i;
				}
				if(x==min_x && check_2==0)
					index_min_x=i;
			}
			/*if(x==max_x && y>max_y)
			{
				index_max_x=i;
				index_max_y=
			}*/
		}
		if(N==1)
		{
			printf("1\n1 NW\n");
		}
		else
		{
			if(index_max_x==index_max_y)
			{
				printf("1\n%d SW\n",index_max_x+1);
			}
			else if(index_max_x==index_min_y)
			{
				printf("1\n%d NW\n",index_max_x+1);
			}
			else if(index_min_x==index_max_y)
			{
				printf("1\n%d SE\n",index_min_x+1);
			}
			else if(index_min_x==index_min_y)
			{
				printf("1\n%d NE\n",index_min_x+1);
			}
			else
			{
				printf("2\n");
				if(max_xy>sy_max)
				{
					printf("%d SW\n",index_max_x+1);
					printf("%d NW\n",index_s_max+1);
				}
				else
				{
					printf("%d NW\n",index_max_x+1);
					printf("%d SW\n",index_s_max+1);
				}
			}
		}
	}
	return 0;
}
