//Find the number of holes in the string

#include<stdio.h>

int main()
{
	int T,ans;
	char temp;
	scanf("%d",&T);
	scanf("%c",&temp);

	while(T--)
	{
		ans=0;
		scanf("%c",&temp);
		while(temp!='\n')
		{
			if(temp=='A' || temp=='D' || temp=='O' || temp=='P' || temp=='Q' || temp=='R')
				ans++;
			else if(temp=='B')
				ans+=2;
			scanf("%c",&temp);	
		}
		printf("%d\n",ans);
	}
	return 0;
}
