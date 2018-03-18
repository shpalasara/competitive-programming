#include<stdio.h>
#include<string.h>

int same=0; 
char arr[11];
char pre[11];

int recurssion(char *stack,char *array,char *output,int index_s,int index_a,int index_o)
{
	if(array[index_a]=='\0')
	{
		while(index_s>0)
		{
			output[index_o++]=stack[--index_s];
		}
		output[index_o]='\0';
		//printf("%s\n",output);
		if(!strcmp(arr,output))
			same++;
		if(pre[0]=='\0')
			strcpy(pre,output);
		else if(!strcmp(pre,output))
			return 0;
		else
			strcpy(pre,output);
		return 1;
	}
	else
	{
		if(index_s<=0)
		{
			stack[index_s++]=array[index_a++];
			return (recurssion(stack,array,output,index_s,index_a,index_o));
		}
		else
		{
			char str_s[11];
			char str_a[11];
			char str_o[11];
			int i_o=index_o;
			int i_s=index_s;
			int i_a=index_a;
			strcpy(str_s,stack);
			strcpy(str_a,array);
			strcpy(str_o,output);
			stack[index_s++]=array[index_a++];
			str_o[i_o++]=str_s[--i_s];
			return(recurssion(stack,array,output,index_s,index_a,index_o)+recurssion(str_s,str_a,str_o,i_s,i_a,i_o));
		}
	}
}

int main()
{
	scanf("%s",arr);
	char stack[11];
	char output[11];
	pre[0]='\0';
	stack[0]='\0';
	output[0]='\0';
	printf("%d %d\n",same,recurssion(stack,arr,output,0,0,0));
	return 0;
}
