#include<stdio.h>
#include<string.h>

int main()
{
	char str1[1001],str2[1001];
	//char[1001] str2;
	scanf("%s %s",str1,str2);
	
	int i=0,ans=0,ones_1=0,ones_2=0;
	if(strlen(str1)!=strlen(str2))
		printf("-1\n");
	else
	{
		while(str1[i]!='\0' && str1[i]!='\n')
		{
			if(str1[i]=='1')
				ones_1++;
			if(str2[i]=='1')
				ones_2++;

			if(str1[i]!=str2[i])
				ans++;
			i++;
		
		}
		if(ones_1==ones_2)
		{
			ans=ans>>1;
			printf("%d\n",ans);
		}
		else
			printf("-1\n");
	}
	return 0;
}
