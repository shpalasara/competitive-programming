package stoch;

import java.util.*;

public class q1 {

	public static void main(String[] args){
	
		Random rand = new Random();
		int ans=0,x=0,y=0,z=0;
		double temp;
		
		for(int i=0;i<1000;i++)
		{
			for(int j=0;j<1000000;j++)
			{
				temp=rand.nextDouble();
				
				if(temp>0.5)
					x++;
				else 
					x--;
				
				if(x==0)
					break;
			}
			if(x==0)
				ans++;
			
			x=0;
		}

		System.out.println("For 1-D motion "+(double)ans/1000);
		
		ans=0;
		
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<1000000;j++)
			{
				temp=rand.nextDouble();
				
				if(temp<0.25)
					x++;
				else if(temp<0.5)
					x--;
				else if(temp<0.75)
					y++;
				else
					y--;
				
				if(x==0 && y==0)
					break;
			}
			
			if(x==0 && y==0)
				ans++;
			x=0;
			y=0;
		}
		
		System.out.println("For 2-D motion "+(double)ans/100);
		ans=0;
		
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<1000000;j++)
			{
				temp=rand.nextDouble();
				
				if(temp<1.0/6)
					x++;
				else if(temp<2.0/6)
					x--;
				else if(temp<3.0/6)
					y++;
				else if(temp<4.0/6)
					y--;
				else if(temp<5.0/6)
					z++;
				else
					z--;
				
				if(x==0 && y==0 && z==0)
					break;
			}
			
			if(x==0 && y==0 && z==0)
				ans++;
			x=0;
			y=0;
			z=0;
		}
		
		System.out.println("For 3-D motion "+(double)ans/100);
		
	}
}
