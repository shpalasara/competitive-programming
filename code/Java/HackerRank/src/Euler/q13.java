package Euler;

import java.math.BigInteger;
import java.util.Scanner;

public class q13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		BigInteger ans,t1;
		
		ans = new BigInteger("0");
		
		while(n-->0)
		{
			t1 = new BigInteger(sc.nextLine());
			ans = ans.add(t1);
		}
		
		System.out.println(ans.toString().substring(0, 10));
		
		sc.close();
	}

}
