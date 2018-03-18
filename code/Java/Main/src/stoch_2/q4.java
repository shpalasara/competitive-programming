package stoch_2;

import java.util.*;

public class q4 {

	public static void main(String[] args){
		
		Random rn = new Random();
		int loop=10;
		//double[] data = new double[loop];
		double x,y,c=2;
		
		for(int i=0;i<loop;i++)
		{
			do
			{
				x=rn.nextDouble();
				y=rn.nextDouble();
				
			} while(x<funt(y)/c);
			
			System.out.println(x);
		}
		System.out.println();
	}
	
	public static double funt(double x){
		
		return 30*(x*x-2*x*x*x+x*x*x*x);
		// Maximum value of  this function is 30/16
	}
}
