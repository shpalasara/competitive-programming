package Euler;

import java.util.Scanner;

public class q5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt(),n;
		long ans;
		
		while(t-->0)
		{
			n = sc.nextInt();
			ans = 1L;
			
			for(int i=2;i<=n;i++)
				ans = lcm(ans,(long)i);
			
			System.out.println(ans);
		}
		
		sc.close();
	}

	public static long lcm(long x,long y){
		
		long ans,gcd;
		
		gcd = gcd(x,y);
		ans = (x/gcd)*y;
		
		return ans;
	}
	
	public static long gcd (long x, long y){
		
		long temp;
		
		while(y!=0)
		{
			temp = x%y;
			x = y;
			y = temp;
		}
		
		return x;
	}
}
