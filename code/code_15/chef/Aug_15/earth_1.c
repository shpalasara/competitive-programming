#include<stdio.h>
#define MAXSTACK 10000
#define EMPTYSTACK -1

void push( char );
char pop();
int empty();
int full();

int top = EMPTYSTACK;
char items[MAXSTACK];




void push(char c) {
   items[++top] = c;
}

char pop() {
   return items[top--];
}

int full()  {
   return top+1 == MAXSTACK;
}

int empty()  {
   return top == EMPTYSTACK;
}


int main()
{
	long long int n,i,count=0;
	char temp,ch,ch1;
	scanf("%lld",&n);
	scanf("%c",&temp);

	while(n--)
	{
		scanf("%c",&temp);
		count=0;
		while(temp!='\n')
		{
			count++;
			if(top>=0)
			{
				ch=pop();
				if(ch!=temp && top>=0)
				{
					ch1=pop();
					if(ch1==temp)
						count++;
					else
						push(ch1);
				}
				else if(ch==temp)
					count++;
				else
					push(temp);
			}
			else
				push(temp);
			scanf("%c",&temp);
		}
		printf("%lld\n",count);
	}
	return 0;
}
