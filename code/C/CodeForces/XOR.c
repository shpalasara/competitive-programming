#include<stdio.h>

int main()
{
	int N,temp,ans;
	scanf("%d",&N);
	scanf("%d",&ans);
	N--;
	while(N--)
	{
		scanf("%d",&temp);
		ans=ans^temp;
	}
	printf("%d\n",ans);
	return 0;	
}
