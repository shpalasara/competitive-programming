#include<stdio.h>
#include<string.h>

int main()
{
	int T,i;
	char data[110];
	int count[26];

	scanf("%d",&T);
	while(T--)
	{
		for(i=0;i<26;i++)		
			count[i]=0;

		scanf("%s",data);
		for(i=0;i<strlen(data);i++)
			count[data[i]-'A']++;

		if(count['L'-'A']>=2 && count['T'-'A']>=2 && count['I'-'A']>=2 && count['M'-'A']>=2)
		{
			if((strlen(data)==9 && count['E'-'A']==1) || count['E'-'A']>=2)
				printf("YES\n");
			else
				printf("NO\n");	
		}
		else
			printf("NO\n");		
		
	}
	return 0;
}
