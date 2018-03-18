#include<stdio.h>

int main()
{
	int T,d1,m1,y1,d2,m2,y2,day,start,i;
	int months[]={31,28,31,30,31,30,31,31,30,31,30,31};
	//mod -1 tue -2 wed -3 thu -4 fri -5 sat -6 sun -0
	long long int ans;
	scanf("%d",&T);
	while(T--)
	{
		ans=0;
		day=1;
		start=1900;
		scanf("%d %d %d %d %d %d",&d1,&m1,&y1,&d2,&m2,&y2);
		//Finding the day at the beginnig of the starting year
		while(start<y1)
		{
			if((start%100!=0 && start%4==0) || (start%100==0 && start%400==0))
				day=(day+2)%7;
			else
				day=(day+1)%7;
			start++;
		}		
		//printf("start %d\n",start);				
		//If the date of the starting time >13 than we can't get the 13th day so m1++
		if(d1>13)
		{
			m1++;
			if(m1>12)
			{
				//We are moving on to the next year so changing the first day of that month
				if((y1%100!=0 && y1%4==0) || (y1%100==0 && y1%400==0))
					day=(day+2)%7;
				else
					day=(day+1)%7;
				y1++;
				m1=1;
			}
		}
		//printf("month %d year %d\n",m1,y1);
		if(d2>=13)
		{
			m2++;
			if(m2>12)
			{
				y2++;
				m2=1;
			}
		}
		for(i=1;i<m1;i++)
		{
			if(i!=2)
				day=(day+months[i-1])%7;
			else
			{
				if((y1%100!=0 && y1%4==0) || (y1%100==0 && y1%400==0))
					day=(day+29)%7;
				else
					day=(day+28)%7;
			}
		}
		while(y1<y2 || m1<m2)
		{
			if((day+12)%7==5)
				ans++;
			//if(i!=2)
			//	day=(day+months[i-1])%7;
			if(m1==2)
			{
				if((y1%100!=0 && y1%4==0) || (y1%100==0 && y1%400==0))
					day=(day+29)%7;
				else
					day=(day+28)%7;
			}	
			else
				day = (day+months[m1-1])%7;		
			m1++;
			if(m1==13)
			{
				m1=1;
				y1++;
			}	
		}
		printf("%lld\n",ans);
	}
	return 0;
}
