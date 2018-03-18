package Euler;

import java.io.PrintWriter;
import java.util.Scanner;

public class q6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		long[] ans = new long[10001];
		int t = sc.nextInt(),n;
		long sqr=0,sum=0;
		
		ans[0]=0;
		for(int i=1;i<10001;i++)
		{
			sqr = sqr+(long)(i*i);
			sum +=i;
			
			ans[i] = Math.abs(sum*sum-sqr);
		}
		
		while(t-->0)
		{
			n =sc.nextInt();
			out.println(ans[n]);
		}
		
		out.close();
		sc.close();
	}

}
