package stoch_2;

import java.util.*;

public class q2 {

	public static void main(String[] args){
		
		Random rn = new Random();
		double sum,ans=0;
		int count;
		int loop[] = {100, 1000, 10000};
		
		for(int t=0;t<loop.length;t++)
		{
			for(int i=0;i<loop[t];i++)
			{
				count=0;
				sum=0;
				
				while(sum<=1)
				{
					sum+=rn.nextDouble();
					count++;
				}
				ans+=count;
			}
			ans/=(double)loop[t];
			
			System.out.println(ans);
		}
	}	
}
/*

2.55
2.71755
2.7316717550000003

Actual value is : e = 2.71828
*/