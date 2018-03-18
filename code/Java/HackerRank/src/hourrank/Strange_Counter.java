package hourrank;

import java.util.Scanner;

public class Strange_Counter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n =sc.nextLong();
		
		System.out.println(time(3,0,n));
		
		sc.close();
	}

	public static long time(long val,long time,long n){
		
		if(n>val)
			return time(val*2,time,n-val);
		return time+(val-n+1);
	}
}
