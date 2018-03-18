package stoch_2;

import java.util.*;

public class q6 {

	public static void main(String[] args){

		Random rn = new Random();
		int loop =100000,mean=0,strDev=1;
		double x,y,s,t;
		int N = 1000;
		int[] count = new int[2*N+1];
		double  MAX = 5;
		
		while(loop-->0)
		{
			x=2*rn.nextDouble()-1;
			y=2*rn.nextDouble()-1;
			
			s=x*x+y*y;
			
			while(s>1 || s==0)
			{
				x=2*rn.nextDouble()-1;
				y=2*rn.nextDouble()-1;
				
				s=x*x+y*y;
				
			}
			t=Math.sqrt(-2*Math.log(s)/s);
			
//			System.out.println((mean+strDev*x*t)+" "+(mean+strDev*y*t));
			double val = (mean+strDev*x*t);
			count[(int)((val/MAX)*N+N)]++;
			val = (mean+strDev*y*t);
			count[(int)((val/MAX)*N+N)]++;
		}
		for(int i=0;i<2*N+1;i++)
			System.out.println(((double)(i-N)*MAX/N)+" "+count[i]);
	}
}
//Marsaglia polar method