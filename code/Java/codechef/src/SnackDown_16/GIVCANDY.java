package SnackDown_16;

import java.util.Scanner;

public class GIVCANDY {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long t=sc.nextInt(),a,b,c,d,gcd;
		
		while(t-->0)
		{
			a=sc.nextLong();
			b=sc.nextLong();
			c=sc.nextLong();
			d=sc.nextLong();
			
			a = Math.abs(a-b);
			
			gcd = gcd(c,d);
			
			if(a==0 || a%gcd==0)
				System.out.println(0);
			else
			{
				
				System.out.println(Math.min(a%gcd, gcd-a%gcd));
			}
		}
		sc.close();
	}
	
	public static long gcd(long a,long b){
		
		a=Math.abs(a);
		b=Math.abs(b);
		
		long temp;
		while(b!=0)
		{
			temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}

}
