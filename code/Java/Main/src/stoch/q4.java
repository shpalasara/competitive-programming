package stoch;

import java.util.Scanner;

public class q4 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		double pi=22.0/7;
		double e=2.718;
		double fact_actual=1,fact_aprox=Math.sqrt(2*pi*(double)n);
		
		for(int i=2;i<=n;i++)
			fact_actual*=i;
		
		for(int i=0;i<n;i++)
			fact_aprox*=(n+0.0)/e;
		
		System.out.println(fact_actual);
		
		System.out.println(fact_aprox);
		
		System.out.println("The difference is "+(fact_actual-fact_aprox));
		
		sc.close();
	}
}
