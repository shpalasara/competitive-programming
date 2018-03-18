package round_404_2;

import java.util.Scanner;

public class Anton_and_Fairy_Tale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong(),m = sc.nextLong();
		
		if(n==0)
			System.out.println(m);
		else if((m-n)>=0)
			System.out.println(n);
		else
		{
			long temp = (long)Math.sqrt((n-m)<<1) - 1L;
			
			while(true)
			{
				long t = (temp*(temp+1L))>>1;
				if(t>=(n-m))
					break;
				temp++;
			}
			
//			System.out.println(temp);
			System.out.println(m+temp);
		}
		sc.close();
	}

}
