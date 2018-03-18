#include<stdio.h>


void quicksort(long long int *x,long long int *ans,int first,int last){
    int pivot,j,i;
    long long int temp,_temp;
	
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
		_temp=ans[i];
		ans[i]=ans[j];
		ans[j]=_temp;
             }
         }

         temp=x[pivot];
         x[pivot]=x[j];
         x[j]=temp;
	_temp=ans[pivot];
	ans[pivot]=ans[j];
	ans[j]=_temp;
         quicksort(x,ans,first,j-1);
         quicksort(x,ans,j+1,last);
    }
}

int main()
{
	int T,N,M,i,j,k;
	long long int x,y;
	long long int ans[100000];
	long long int X[100000];	
	scanf("%d",&T);
	for(i=0;i<T;i++)
	{
		scanf("%d",&N);
		for(j=0;j<N;j++)
		{
			scanf("%d",&M);
			ans[j]=j;
			scanf("%lld %lld",&X[j],&y);

			for(k=1;k<M;k++)
			{
				scanf("%lld %lld",&x,&y);

				if(x>X[j])
					X[j]=x;		
			}
		}
		/*for(j=0;j<N-1;j++)
		{
			for(k=j+1;k<N;k++)
			{
				if(X[j]>X[k])
					ans[j]++;
				else
					ans[k]++;
			}
			printf("%d ",ans[j]);
		}
		printf("%d\n",ans[N-1]);*/

		quicksort(X,ans,0,N-1);

		for(j=0;j<N;j++)
			X[ans[j]]=j;
		for(j=0;j<N;j++)
			printf("%lld ",X[j]);	
		printf("\n");
	}
	return 0;
}

