#include<stdio.h>

void main()
{
	int i=1;
	i = mul(&i);
	printf("The number is %d",i);
}

int mul(int *i)
{
	printf("\nThe number is %d",*i);
	return 4*(*i);
}
