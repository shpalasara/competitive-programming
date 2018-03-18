    #include<stdio.h>
    #include<stdlib.h>
     
    long long int wt[100000];
    long long int data[100000];
    long long int MN[100000][3];
    long long int K[100001][501];
	long long int freq[201];

    long long int max(long long int a,long long int b) { return (a > b)? a : b; }
    long long int knapSack(int W, long long int wt[], long long int val[], long long int n)
    {
    long long int i, w;
    // long long int K[n+1][W+1];
    // Build table K[][] in bottom up manner
    for (i = 0; i <= n; i++)
    {
    for (w = 0; w <= W; w++)
    {
    if (i==0 || w==0)
    K[i][w] = 0;
    else if (wt[i-1] <= w)
    K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
    else
    K[i][w] = K[i-1][w];
    }
    }
    return K[n][W];
    }
    int separate_funt(long long int data[],long long int wt[],long long int N)
    {
    //long long int sep;
    long long int i,j=N-1,temp;
    for(i=0;i<=j;i++)
    {
    if(data[i]<0)
    {
    if(data[j]<0)
    i--;
    else
    {
    temp = data[i];
    data[i]=data[j];
    data[j]=temp;
    temp = wt[i];
    wt[i] = wt[j];
    wt[j] = temp;
    }
    j--;
    }
    }
    return i;
    }
    int main()
    {
    long long int T,N,K,M,total,count;
    long long int L,R,C;
    scanf("%lld",&T);
     
    while(T--)
    {
    total=0;count=0;
    scanf("%lld %lld %lld",&N,&K,&M);
    int i,j,l,change=-1,d_change=-1;
    for(i=0;i<N;i++)
    {
	    scanf("%lld",&data[i]);
	    total+=data[i];
	    data[i]=-data[i];
	    wt[i]=201;
    }

	for(i=0;i<201;i++)
		freq[i]=0;	

    for(i=0;i<M;i++)
    {
	change=-1;
	d_change=-1;

	j=1;
	scanf("%lld %lld %lld",&L,&R,&C);
	
	freq[C]++;

	if(freq[C]>1)
	{
		for(l=0;l<count;l++)
		{
			if(MN[l][2]==C)
			{
				if(MN[l][0]>=L && MN[l][1]<=R)
				{
					MN[l][0]=L; MN[l][1]=R; j=0;
					if(change>=0)d_change=l;
					change=l;
					freq[C]--;
					//printf("K1\n");
				}
				else if(MN[l][1]+1>=L && MN[l][0]<=L)
				{
					if(MN[l][1]<R)
						MN[l][1]=R;
					j=0;
					if(change>=0)d_change=l;
					change=l;
					freq[C]--;
					//printf("K2\n");
				}
				else if(MN[l][0]<=R+1 && MN[l][1]>=R)
				{
					if(MN[l][0]>L)
						MN[l][0]=L;
					j=0;
					if(change>=0)d_change=l;
					change=l;
					freq[C]--;
					//printf("K3\n");
				}
			}
			if(change>=0)
			{
				L=MN[change][0];
				R=MN[change][1];
			}
			if(d_change>=0)
			{
				MN[change][0]=0;MN[change][1]=0;MN[change][2]=0;
				//printf("K4\n");
				break;
			}
		} 
	}

	if(j==1)
	{
		MN[count][0]=L;
		MN[count][1]=R;
		MN[count][2]=C;
		count++;
		//printf("K0\n");
	}
    }
    for(i=0;i<count;i++)
    {
	//printf("%lld %lld %lld\n",MN[i][0],MN[i][1],MN[i][2]);
    	for(j=MN[i][0]-1;j<MN[i][1];j++)
   	 {
    		if(wt[j]>MN[i][2])
   			 wt[j]=MN[i][2];
    	}
    }
    long long int lim = separate_funt(data,wt,N);
     
    long long int temp = knapSack(K, wt, data, lim);
     
    printf("%lld\n",total+temp);
    }
    return 0;
    } 


/*
			if(MN[count-1][2]==C)
			    {
			    if(MN[count-1][0]<=L && MN[count-1][1]>=L)
			    {
			    if(MN[count-1][1]<R)
			    MN[count-1][1]=R;
			    j=0;
			    }
			    else if(MN[count-1][0]<=R && MN[count-1][1]>=R)
			    {
			    if(MN[count-1][0]>L)
			    MN[count-1][1]=L;
			    j=0;
			    }
			    else if(MN[count-1][0]>=L && MN[count-1][1]<=R)
			    {
			    MN[count-1][0]=L;
			    MN[count-1][1]=R;
			    j=0;
			    }
			    }

*/
