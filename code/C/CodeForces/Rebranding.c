#include<stdio.h>

int main()
{
	int n,m,i,j;
	scanf("%d %d",&n,&m);
	char str[n+2],prev[5],aft[5];
	char next[26];	
	//int freq[26];
	scanf("%s",str);
	
	//for(i=0;i<26;i++)
		//freq[i]=0;
	
	for(i=0;i<26;i++)
	{
		next[i]='a'+i;
		//freq[str[i]-'a']++;
	}
	
	while(m--)
	{
		scanf("%s %s",prev,aft);
		for(i=0;i<26;i++)
		{
			if(next[i]==prev[0])
			{
				next[i]=aft[0];
				//printf("Hii1 %d\n",i);
			}
			else if(next[i]==aft[0])
			{
				next[i]=prev[0];
				//printf("Hii2 %d\n",i);
			}
		}
		//printf("%s\n",str);
	}

	//for(i=0;i<26;i++)
	//	printf("%c\n",next[i]);		

	for(i=0;i<n;i++)
	{
		str[i]=next[str[i]-'a'];
		/*if(next[i]!='a'+i)
		{
			for(j=0;j<n;j++)
			{
				if(str[j]=='a'+i)
					str[j]=next[i];
			}
		}*/
	}
		
	printf("%s\n",str);

	return 0;
}

/*
		if(prev[0]!=aft[0] && (freq[prev[0]-'a']>0 || freq[aft[0]-'a']>0))
		{
			for(i=0;i<n;i++)
			{
				if(str[i]==prev[0])
				{
					str[i]=aft[0];
					freq[prev[0]-'a']--;
					freq[aft[0]-'a']++;
				}
				else if(str[i]==aft[0])
				{
					freq[prev[0]-'a']++;
					freq[aft[0]-'a']--;
					str[i]=prev[0];
				}
			}
		}
*/
