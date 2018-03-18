#include<stdio.h>
#define max 100000

int main()
{
    int n,i,min,resorses=0,count,index;
    scanf("%d",&n); 
    int check[1010]={0};
    int data[n];
    long long ans=0;

    for(i=0;i<n;i++)
    {
        scanf("%d",&data[i]);
    }
    count=n;
    index=0;
    int right=1,left=0;

    while(count>0)
    {   
        if(index>=0 && index<n && data[index]<=resorses && check[index]==0)
        {
            check[index]=1;
            resorses++;
            count--;
        }
        if(count>0 && index<=0)
        {
            right=1;
            left=0;
            index++;
            ans++;
        }
        else if(count>0 && index>=n-1)
        {
            left=1;
            right=0;
            index--;
            ans++;
        }
        else if(right==1)
            index++;
        else if(left==1)
            index--;
    }
	if(n!=1)
    		printf("%lld\n",--ans);
	else
		printf("0\n");    
	return 0;
}
