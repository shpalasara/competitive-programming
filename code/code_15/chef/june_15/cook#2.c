#include<stdio.h>

int main()
{
	long long int T,K,i,j,count,R_B,/*L_B,*/regular=1;			//R_B---(  .. L_B---)
	char data[100002],temp;
	scanf("%lld",&T);
	scanf("%c",&temp);		//scaning \n

	for(i=0;i<T;i++)
	{
		R_B=0;
		//L_B=0;
		count=0;
		regular=1;
		scanf("%c",&temp);
		while(1)
		{
			data[count++]=temp;
			if(temp=='(')
				R_B++;
			else
			{	
				if(R_B>0)
					R_B--;
				else
					regular=0;
			}
			scanf("%c",&temp);
			if(temp=='\n')
				break;
		}

		if(R_B!=0)
			regular=0;
		//scanf("%c",&temp);
		scanf("%lldd",&K);
		scanf("%c",&temp);

		if(regular==1)
		{
			for()
		
			//if(K<=2)
			//{
			//	for(j=1;j<count;j++)
			//		printf("%c",data[j]);
			//	printf("\n");
			//}
			//else
				//printf("-1\n");
		}
		else
		{
			if(K==1)
			{
				for(j=0;j<count;j++)
					printf("%c",data[j]);
				printf("\n");
			}
			else
				printf("-1\n");
		}
	}
	return 0;
}
