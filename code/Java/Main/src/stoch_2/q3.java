package stoch_2;

import java.util.*;

public class q3 {

	static double prob[]={0.3,0.2,0.35,0.15};
	
	public static void main(String[] args){
		
		Random rn = new Random();
		double x,c=2.0;
		int X,loop=10;
		
		//First approach 
		
		System.out.println("First");
		
		for(int i=0;i<loop;i++)
		{
			x=rn.nextDouble();
			
			if(x<prob[0])
				X=1;
			else if(x<prob[0]+prob[1])
				X=2;
			else if(x<prob[0]+prob[1]+prob[2])
				X=3;
			else
				X=4;
			
			System.out.print(X+" ");
		}
		System.out.println();
		
		// Second approach (Acceptance Rejection Method for c=2.0) 
		
		System.out.println("Second");
		
		for(int i=0;i<loop;i++)
		{
			X = (int)(rn.nextDouble()*4);
			x= rn.nextDouble();
			
			while(x>prob[X]/(c*0.25))
			{
				X = (int)(rn.nextDouble()*4);
				x= rn.nextDouble();
			}
			
			System.out.print(X+1+" ");
		}
		System.out.println();
	}
}
/*
First
3 2 3 4 3 2 2 3 1 4 
Second
3 4 3 2 2 3 1 2 1 1 
*/