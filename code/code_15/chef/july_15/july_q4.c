#include<stdio.h>
#include<stdlib.h>

int cmpfunc (const void * a, const void * b)
{
   return ( *(long long int*)a - *(long long int*)b );
}

long long int A[100000];
long long int money[10000000];
long long int ans[10000000];
long long int min[100000];

int main()
{
	long long int T,N,K,M,i,j,k,temp,total,count;
	double avg;
	long long int L,R,C;
	scanf("%lld",&T);
	while(T--)
	{
		avg=0;total=0;
		scanf("%lld %lld %lld",&N,&K,&M);
		
		for(i=0;i<N;i++)
		{
			scanf("%lld",&A[i]);
			total+=A[i];
		}
		avg=total/N;
		count=0;

		for(i=0;i<M;i++)
		{
			scanf("%lld %lld %lld",&L,&R,&C);
			temp=K/C;
			ans[i]=total;
			k=0;
			//printf("temp %lld\n",temp);
			
			if(temp>0)
			{

				for(j=L-1;j<R;j++)
				{
					if(A[j]<avg)
						min[k++]=A[j];
				}
				qsort(min,k,sizeof(long long int),cmpfunc);
				
				if(count!=0)
				{
					for()
				}
				for(j=0;j<temp;j++)
					ans[i]-=minInArray[j];
				long long int _temp = A[j];
						
						if(count==0 && j==0)
						{
							ans[count++]=total-A[j];
							money[count++]=K-C;
						}
						else if(j!=0)
						{
						}
			}
		}
		qsort(ans,M,sizeof(long long int),cmpfunc);
		printf("%lld\n",ans[M-1]);
	}
	return 0;
}


/*
//long long int minInArray[temp];
				count=0;
				for(j=L-1;j<R;j++)
				{
					if(A[j]<avg)
					{
						long long int _temp = A[j];
						if(count<temp)
						{
							for(k=0;k<count;k++)
							{
								if(_temp<minInArray[k])
								{	
									long long int itemp=minInArray[k];
									minInArray[k]=_temp;
									_temp=itemp;
								}
								
							}
							minInArray[count++]=_temp;
							//printf("%lld ",A[j]);
						//	qsort(minInArray,count,sizeof(long long int),cmpfunc);
						}
						else if(A[j]<minInArray[count-1])
						{
							for(k=0;k<count;k++)
							{
								if(_temp<minInArray[k])
								{	
									long long int itemp=minInArray[k];
									minInArray[k]=_temp;
									_temp=itemp;
								}
								
							}
							//minInArray[count-1]=A[j];
							//qsort(minInArray,count,sizeof(long long int),cmpfunc);
						}
					}
				}
				//qsort(minInArray,count,sizeof(long long int),cmpfunc);
				for(j=0;j<temp;j++)
					ans[i]-=minInArray[j];
				//printf("%lld\n",ans[i]);

*/
