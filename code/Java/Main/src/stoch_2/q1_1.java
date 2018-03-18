package stoch_2;

import java.util.*;

public class q1_1 {

	public static void main(String[] args){
		
		Random rn = new Random();
		double x,y;
		int loop = 10000,count=0;
		
		for(int i=0;i<loop;i++)
		{
			x=rn.nextDouble();
			y=rn.nextDouble();
			
			if(Math.sqrt(Math.pow(1-x*x, 3))>=y)
				count++;
		}
		
		System.out.println("Exact value is :"+((double)(3)/16)*((double)(22)/7));
		
		System.out.println("Approximate value is for "+loop+" iteration:"+(double)count/loop);
	
		loop = 100000;
		count=0;
		
		for(int i=0;i<loop;i++)
		{
			x=rn.nextDouble();
			y=rn.nextDouble();
			
			if(Math.sqrt(Math.pow(1-x*x, 3))>=y)
				count++;
		}
		
		System.out.println("Approximate value is for "+loop+" iteration:"+(double)count/loop);
		
		
		loop = 1000000;
		count=0;
		
		for(int i=0;i<loop;i++)
		{
			x=rn.nextDouble();
			y=rn.nextDouble();
			
			if(Math.sqrt(Math.pow(1-x*x, 3))>=y)
				count++;
		}
		
		System.out.println("Approximate value is for "+loop+" iteration:"+(double)count/loop);
	}
}

// The exact value of this integration is 3*pi/16 

/*
Exact value is :0.5892857142857143
Approximate value is for 10000 iteration:0.5819
Approximate value is for 100000 iteration:0.58625
Approximate value is for 1000000 iteration:0.589177

*/