package stoch;

import java.util.*;

public class q5 {

	public static void main(String[] args){
		
		Random rand = new Random();
		
		double n=100;
		double t=1;
		double t0=0.25;
		double M0=0.3*Math.sqrt(n);
		int loop=1000,count=0,ans=0;		
		
		for(int i=0;i<loop;i++)
		{
			for(int j=0;j<25;j++)
			{
				if(rand.nextBoolean())
					count++;
				else
					count--;
				
				//if(count==3)
				//	break;
			}
			
			if(count==3)
				ans++;
			count=0;
		}
		
		System.out.println((double)ans/loop);
	}
}
