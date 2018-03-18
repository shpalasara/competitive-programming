#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int freq[26];
    char data[1000000];
    int N,i,j,bg;
    scanf("%d",&N);
    while(N--)
    {
	bg=0;
        scanf("%s",data);
        for(i=0;i<26;i++)
            freq[i]=0;
        i=0;
        while(data[i]!='\0')
	{
            if(freq[data[i]-'a']==0)
		bg++;
	    freq[data[i++]-'a']++;
	}
        if(bg%2==0)
            printf("Boy\n");
        else
            printf("Girl\n");
        i=0;
        for(j=25;j>=0;j--)
        {
            while(freq[j]>0)
            {
                if(i==0)
		{
                    printf("%c",'A'+j);
			i=1;
		}
                else
                    printf("%c",'a'+j);
                freq[j]--;
            }
        }
	printf("\n");
    }
    
    return 0;
}

