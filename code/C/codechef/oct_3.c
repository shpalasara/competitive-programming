#include<stdio.h>

int main()
{
	int N,M,C,i,j=0,index=0;
	scanf("%d %d %d",&N,&M,&C);
	int upper[1001]={0},lower[1001]={0};
	long long mul[C],sum=0,temp=0;
	long long ans;	
	//mul[C]=0;

	for(i=0;i<N;i++)
	{
		scanf("%lld",&temp);
		upper[temp-1]++;
	}

	for(i=0;i<M;i++)
	{
		scanf("%lld",&temp);
		lower[temp-1]++;
	}

	for(i=0;i<C+1;i++)
	{
		mul[i]=((long long)upper[i]*(long long)lower[i])%1000000007;
		
		if(mul[i]!=0)
		{
			mul[index++]=mul[i];
			sum+=mul[i];
		}
	}
	//temp=1;

	//long long prev_left[index],total;
	
	//for(i=0;i<index;i++)
	//{
	//	temp=(temp*mul[i])%1000000007;
	//}
	
	long long data[index];
	//temp=mul[0];

	for(i=0;i<index;i++)
	{
		data[i]=mul[i];
		//data[i]=(temp*mul[i+1])%1000000007;
		//temp=(temp+mul[i+1])%1000000007;
	}
	
	for(i=0;i<index-1;i++)
	{
		ans=0;
		temp=data[0];
		for(j=0;j<index-i-1;j++)
		{
			data[j]=(temp*mul[j+i+1])%1000000007;
			ans=(ans+data[j])%1000000007;
			temp=(temp+data[j+1])%1000000007;
			//ans[i]+=temp*data[]
		}
		printf("%lld ",ans);
	}
	
	for(i=index-1;i<C;i++)
		printf("0 ");

	printf("\n");
	return 0;
}

/*out[index-1]=temp;
	
	for(i=0;i<index;i++)
		prev_left[i]=temp/mul[i];	
		
	for(i=index;i<C;i++)
		out[i]=0;
	
	for(i=index-2;i>=0;i++)
	{
		total=0
		for(j=0;j<index;j++)
			total = (total+prev_left[i])%1000000007;
	
		for(j=0;j<index;j++)
			prev_left[j]=total-prev_left[j]		
	}
	for(i=0;i<C;i++)
	{
		if(i>=index-1)
		{
			printf("0 ");	
		}
		else
		{
			long ans=0,temp_mul=1;
			temp=sum;

			for(j=0;j<=i;j++)
			{
				temp_mul = (temp_mul*mul[j])%1000000007;
				temp-=mul[j];
			}

			for(j=i;j<index;j++)
			{
				ans=(ans+temp*mul[j])%1000000007;				
				temp-=mul[j+1];
			}
		}
	}*/
