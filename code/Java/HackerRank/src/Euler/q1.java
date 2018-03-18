package Euler;

import java.io.PrintWriter;
import java.util.Scanner;

public class q1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt(),n;
		long temp,t1,p;
		long ans;
		
		while(t-->0)
		{
			ans = 0;
			n = sc.nextInt();
			
			t1 = n-1;
			
			p = t1/3;
			temp = (3L*p*(p+1));
			ans = temp>>1; 
			
			p = t1/15;
			temp = (15L*p*(p+1));
			ans = ans - (temp>>1);
			
			p = t1/5;
			temp = (5L*p*(p+1));
			ans = ans + (temp>>1);
			
			//out.println(ans);
			
			
			out.println(ans);
		}
		
		out.close();
		sc.close();
	}

}
