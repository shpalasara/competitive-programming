#include<stdio.h>
#include<string.h>

char str1[200001],str2[200001];

int main()
{
	int T,i,j,k,length,shift,x,y;			//For the first line y=0 and for second line y=1
	scanf("%d",&T);
	while(T--)
	{
		shift=0;
		scanf("%s",str1);
		scanf("%s",str2);
		length = strlen(str1);
		//if(str1[0]=='#' && str2[0]=='#')
			//printf("No\n");
		//else
		//{
			j=1;
			k=0;
			for(i=0;i<length;i++)
			{
				if(str1[i]=='#' && str2[i]=='#')
				{
					printf("No\n");
					j=0;
					break;
				}
				else if(str1[i]=='#')
				{
					if(k==0)
					{
						y=1;k=1;
					}
					else if(y==0)
					{
						y=1;
						shift++;
					}
				}
				else if(str2[i]=='#')
				{
					if(k==0)
					{
						y=0;k=1;
					}
					else if(y==1)
					{
						y=0;
						shift++;
					}
				}
			}
		if(i==length && j!=0)
			printf("Yes\n%d\n",shift);
		else if(j!=0)
			printf("No\n");
		//}
	}
	return 0;
}
