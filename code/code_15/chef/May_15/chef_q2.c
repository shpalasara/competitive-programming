#include<stdio.h>
#define mod 1000000007

void quicksort(long long int *x,int first,int last){

    long long int pivot,j,temp,i;

     if(first<last){
         pivot=first;
         i=first;
         j=last;

         while(i<j){
             while(x[i]<=x[pivot]&&i<last)
                 i++;
             while(x[j]>x[pivot])
                 j--;
             if(i<j){
                 temp=x[i];
                  x[i]=x[j];
                  x[j]=temp;
             }
         }

	temp=x[pivot];
	x[pivot]=x[j];
	x[j]=temp;
	quicksort(x,first,j-1);
	quicksort(x,j+1,last);

	}
}

int main()
{
	int T,N,i,j,k;
	long long ans=0,temp,t;			//module with (10^9+7)
	scanf("%d",&T);
	for(i=0;i<T;i++)
	{
		scanf("%d",&N);
		long long data[N];		
		for(j=0;j<N;j++)
		{
			scanf("%lld",&data[j]);
			//for(k=0;k<j;k++)
			//{
			//	if(data[k]>=temp)
			//	{
			//		t=data[k];
			//		data[k]=temp;
			//		temp=t;
			//	}
			//}
			//data[j] = temp;
		}
		quicksort(data,0,N-1);		
		
		long long int p = 0;
		long long int q = 0;
 
		for (j = 0; j < N; j++)
		{
			p = (2 * p + data[j]) % mod;
			q = (2 * q + data[N - 1 - j]) % mod;
		}	
		printf("%lld\n",(q+mod-p)%mod);
		ans=0;
	}
	return 0;
}



//int power(int base,int pow)
//{
//	int result=1;
//	while(pow)
//	{
//		result*=base;
//		pow--;
//	}
//	return result;

//}



		//for(j=0;j<N;j++)
		//	printf("%ld ",data[j]);
		//printf("\n");
		//long long int pow=1;
		//for(j=0;j<N;j++)
		//{
		//	ans+=data[j]*(1<<j)/*power(2,j)*/ - data[j]*(1<<(N-j-1))/*power(2,(N-j-1))*/;
		//	ans = ans%(1000000007);
		//	data[j]=0;
		//}
		//for(j=0;j<N;j++)
		//{
		//	for(k=0;k<)
		//}
		//ans = (ans+1000000007)%1000000007;
