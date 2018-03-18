package stoch_2;

import java.util.*;

public class q1_2 {

	public static void main(String[] args){
		
		Random rn = new Random();
		double x,y;
		double pi=22.0/7;
		int loop = 1000000,count=0,size=1000;
		
		for(int i=0;i<loop;i++)
		{
			x=rn.nextDouble()*size;
			y=rn.nextDouble();
			
			if(x*Math.pow(1+x*x, -2)>=y)
				count++;
		}
		
		System.out.println("Approximate answer: "+((double)count/loop)*size);
		
		
		loop = 1000000;
		count=0;
		size=1;
		
		//Here x indicates theta
		
		for(int i=0;i<loop;i++)
		{
			x=rn.nextDouble()*(pi/2);
			y=rn.nextDouble()/2;
			
			if((Math.sin(2*x)/2)>=y)
				count++;
		}
		
		System.out.println("Approximate answer: "+((double)count*pi)/(loop*4));
	}
}
/*
Approximate answer: 0.496
Approximate answer: 0.5002729285714286
*/