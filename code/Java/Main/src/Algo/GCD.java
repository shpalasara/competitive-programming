package Algo;

public class GCD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Time complexity is O(log(a+b))
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
