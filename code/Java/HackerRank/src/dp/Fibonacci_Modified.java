package dp;

import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci_Modified {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t1 = sc.nextInt(),t2 = sc.nextInt(),n = sc.nextInt();
		
		BigInteger a1,a2,a3;
		
		a1 = new BigInteger(""+t1);
		a2 = new BigInteger(""+t2);
		a3 = a2;
		
		n-=2;
		while(n-->0)
		{
			a3 = new BigInteger("0");
			a3 = a3.add(a1).add(a2.pow(2));
			a1 = a2;
			a2 = a3;
		}
		
		System.out.println(a3.toString());
		sc.close();
	}

}
