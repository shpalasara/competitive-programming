#include<stdio.h>

int freq[1000001];

int main()
{
	int T,N,H,i,j,low,high;
	long long max,temp;
	scanf("%d",&T);
	while(T--)
	{
		scanf("%d %d",&N,&H);
		for(i=0;i<N;i++)
			freq[i]=0;
		for(i=0;i<N;i++)
		{
			scanf("%d %d",&low,&high);
			freq[low]+=1;
			if(high+1<N)
				freq[high+1]-=1;
		}
		max=freq[0];
		//printf("%d ",freq[0]);
		for(i=1;i<N;i++)
		{
			freq[i]+=freq[i-1];
			//printf("%d ",freq[i]);
			if(H==1 && freq[i]>max)
				max=freq[i];
			else if(i<H)
				max+=freq[i];
			//else 
		}
		if(H!=1)
		{
			temp=max;
			for(i=1;i<=N-H;i++)
			{
				if(temp>max)
					max=temp;
				temp=temp-freq[i-1]+freq[i+H-1];
			}
			if(temp>max)
				max=temp;
		}

		long long z = N;
		long long q = H;
		z = z*q-max;
		printf("%lld\n",z);
	}
	return 0;
}

/*

		max=0;sum=0;min_y=1000000;max_y=0;
		scanf("%d %d",&N,&H);
		for(i=0;i<N;i++)
			freq[i]=0;
		for(i=0;i<N;i++)
		{
			scanf("%d %d",&low,&high);
			if(min_y>low)
				min_y=low;
			if(max_y<high)
				max_y=high;
			if(low<H)
			{
				if(high>=H)
					max=max+H-low;
				else
					max+=high-low+1;
			}
			for(j=low;j<=high;j++)
			{
				freq[j]++;
				//if(j<H)
				//	max++;
			}
		}
		//printf("%d\n",max);
		if(min_y==0)
			min_y=1;
		for(i=min_y;i<=max_y-H+1;i++)
		{
			if(i==0)
			{
				for(j=0;j<H;j++)
					max+=freq[j];
			}
			else
			{
			if(H!=1)
			{
				if(max<max-freq[i-1]+freq[i+H-1])
					max=max-freq[i-1]+freq[i+H-1];
			}
			else
			{
				if(max<freq[i])
					max=freq[i];
			}			
			//printf("%d\n",max);
			//}
		}
		printf("%d\n",N*H-max);

*/
