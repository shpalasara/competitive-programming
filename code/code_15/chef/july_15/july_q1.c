#include<stdio.h>

int main()
{
	int T,count;
	int black,blue,red,green,yellow,orange;
	char data[10];
	char s[6];
	scanf("%d",&T);
	//scanf("%c",&temp);			//Scanning Enter'\n'

	while(T--)
	{
		count=0;
		black=0;blue=0;red=0;green=0;yellow=0;orange=0;		
	
		while(count<6)
		{
			scanf("%s",data);
			if(data[0]=='b')
			{
				if(data[2]=='a')
				{
					s[count++]='A';
					black++;
				}				
				else
				{
					s[count++]='U';
					blue++;
				}
			}
			else if(data[0]=='r')
			{
				s[count++]='R';
				red++;
			}
			else if(data[0]=='g')
			{
				s[count++]='G';
				green++;
			}	
			else if(data[0]=='y')
			{
				s[count++]='Y';
				yellow++;			
			}
			else if(data[0]=='o')
			{
				s[count++]='O';
				orange++;		
			}
		}		

		//printf("%s\n",s);
		if(black>2 || blue>2 || red>2 || green>2 || yellow>2 || orange>2)
		{
			if((s[0]==s[5]) && ((s[0]==s[3]) || (s[0]==s[2])))
				printf("YES\n");
			else if((s[0]==s[4]) && ((s[0]==s[2]) || (s[0]==s[3])))
				printf("YES\n");
			else if((s[1]==s[3]) && ((s[1]==s[5]) || (s[1]==s[4])))
				printf("YES\n");
			else if((s[1]==s[2]) && ((s[1]==s[4]) || (s[1]==s[5])))
				printf("YES\n");
			else
				printf("NO\n");
		}
		else
			printf("NO\n");
	}
	return 0;
}
