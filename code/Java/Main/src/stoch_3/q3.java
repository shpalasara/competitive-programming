package stoch_3;

import java.util.*;

public class q3 {

	public static void main(String[] args){
		
		Random rn = new Random();
		int w,b,n,loop=100;
		double prob,x,out;
		long ans=0;
		
		for(int i=0;i<loop;i++)
		{
			w=5;
			b=7;
			n=100;
			
			while(n-->0)
			{
				prob = (double)w/(w+b);
				x=rn.nextDouble();
				
				if(x<prob)
					w++;
				else
					b++;
			}
			
			ans+=(long)w;
		}
		
		out = (double)ans/loop;
		
		//System.out.println("M_100 : "+out);
		
		System.out.println("m_100 :"+out/(5+7+100));
		
		System.out.println("Theoretical value :"+5.0/12);
	}
}

// The theoretical answer : 5/12