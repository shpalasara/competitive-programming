package stoch_3;

import java.util.*;
public class q2 {

		public static void main(String[] args) {
			
			int S0 = 30, K = 29, T = 120, N=100,n=10;
			double St[] = new double[N], v = 0.25/365, rn = 0.05/365;
			double sum = 0;
			Random r = new Random();
			
			for(int i=0;i<N;i++){
				
				int count = 0;
				double W = 0;
				
				for(int j=0;j<n*T;j++){
					double random = r.nextDouble();
					if(random < 0.5)
						count++;
					else count--;
				}
				
				W = count/Math.sqrt(n);
				St[i] = S0*Math.exp((rn-v*v/2)*T + v*W);
				sum += Math.max(St[i]-K,0);;
			}
			
			double stimulationPrice = Math.exp(-rn*T)*sum/N;
			
			System.out.println(stimulationPrice);
			/*
			double d1 = (Math.log((double)S0/K) + (rn+v*v/2)*T)/(v*Math.sqrt(T));
			double d2 = d1-v*Math.sqrt(T);
			
			double x=r.nextDouble(),y=r.nextDouble();
			
			double s=x*x+y*y;
			
			while(s>1 || s==0)
			{
				x=2*r.nextDouble()-1;
				y=2*r.nextDouble()-1;
				
				s=x*x+y*y;
				
			}
			double t=Math.sqrt(-2*Math.log(s)/s);
			
			double val1 = x*t,val2 = y*t;
			
			
			double c = S0*val1 - K*Math.exp(-rn*T)*val2;
			
			System.out.println(c);
			*/
		}	
}
