#include<stdio.h>

struct temp
{
	int b;
	char str[20];
	char str1[20];
}*a;

int main()
{
	char _temp;
	//a.b = 10;
	//int a=1;
	//char b[15];
	//printf("Enter any integer number:%d \n",a);
	//printf("Enter the string of b:\n");
	//scanf("%[^\n]",b);
	//printf("Entered string is \n%s\n",b);
	//printf("Enter any number:\n");
	//scanf("%d",(a->b));
	//printf("The number is :%d",a->b);
	//char name[2][10];
	printf("Enter your name:");
	scanf("%[^\n]",((char *)&a+(int)(&a->str)));

	scanf("%c",&_temp);	

	printf("Enter another name:");
	scanf("%[^\n]",((char *)&a+(int)(&(a->str1))));

	//printf("Address is %d",&a);
	printf("Your Name is %s\n",((char *)&a+(int)(&(a->str))));
	printf("Your Name is %s\n",((char *)&a+(int)(&(a->str1))));
	
	return 0;
}
