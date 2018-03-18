package Loc_June_17;

import java.io.PrintWriter;
import java.util.Scanner;

public class RIDDLE99 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		int A,B,M,ans;
		
		while(t-->0)
		{
			A = sc.nextInt();
			B = sc.nextInt();
			M = sc.nextInt();
			
			ans = (B/M) - (A-1)/M;
			out.println(ans);
		}
		
		sc.close();
		out.close();
	}
}
