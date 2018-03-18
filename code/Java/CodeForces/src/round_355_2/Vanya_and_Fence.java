package round_355_2;

import java.util.Scanner;

public class Vanya_and_Fence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),h=sc.nextInt(),ans=0;
		
		while(n-->0)
		{
			if(h<sc.nextInt())
				ans++;
			ans++;
		}
		
		System.out.println(ans);
		sc.close();
	}

}
