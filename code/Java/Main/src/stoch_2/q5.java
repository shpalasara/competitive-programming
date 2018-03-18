package stoch_2;

import java.util.*;

public class q5 {

	public static void main(String[] args){
		
		double time = 0,t=0;
		int I = 0;
		double S[] = new double[100];
		int lambda_max = 26,T = 10;
		Random r = new Random();
		double u1 = r.nextDouble();
		t=t-Math.log(u1)/lambda_max;
		double lambda_t=0;
			
		while(t < T){
			
			double u2 = r.nextDouble();
			if (t>=0 && t<5)
	    		lambda_t=t/5;
	  		else  
	    		lambda_t=1+5*(t-5);
				
			if (u2<=(lambda_t/lambda_max)){
	    			I=I+1;
	    			S[I]=t;
			}
			u1=r.nextDouble();
			t=t-Math.log(u1)/lambda_max;
		}
		
		for(int i=1;i<100;i++)
		{
			if(S[i]==0)
				break;
			System.out.println(i+" "+S[i]);
		}
	}
}
