package week_of_code_30;

import java.util.Scanner;

public class Candy_Replenishing_Robot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n,t;
		n = sc.nextInt();
		t = sc.nextInt();
		int bag = n,added = 0,temp;
		
		while(t-->0)
		{
			if(bag<5)
			{
				added += n-bag;
				bag = n;
			}
			temp = sc.nextInt();
			bag -= temp; 
		}
		
		System.out.println(added);
		sc.close();
	}

}
