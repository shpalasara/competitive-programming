package round_375_2;

import java.util.Scanner;

public class Meeting_Friends {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int ans1  = Math.abs(a-b)+Math.abs(a-c);
		int ans2  = Math.abs(a-b)+Math.abs(b-c);
		int ans3  = Math.abs(a-c)+Math.abs(b-c);
		
		System.out.println(Math.min(ans3, Math.min(ans1,ans2)));
		
	}

}
