package round_287_2;

import java.util.Scanner;

public class Guess_Your_Way_Out {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int h=sc.nextInt();
		long n = sc.nextLong();
		
		System.out.println(go(h, n, true));
		sc.close();
	}

	public static long go(int h,long n,boolean left){
		
		long ans,temp;
		
		if(n==0)
			return 0;
		
		if(h==0)
			return 0;
		
		/*if(h==1 && n==1)
		{
			if(left)
				return 1;
			else
				return 2;
		}*/
		
		if(left)
		{
			//System.out.println("left "+n);
			temp = 1L<<(h-1);
			ans = (1L<<h);
			temp = temp-n;
			
			if(temp>=0)
				return 1L+go(h-1, n , false);
			else
				return ans+go(h-1, -temp , true);
		}
		else
		{
			//System.out.println("right "+n);
			temp = 1L<<(h-1);
			ans = (1L<<h);
			temp = temp-n;
			
			if(temp>=0)
				return ans+go(h-1, n , false);
			else
				return 1L+go(h-1, -temp , true);
		}
	}
}
