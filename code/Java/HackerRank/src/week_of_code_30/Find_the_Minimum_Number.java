package week_of_code_30;

import java.util.Scanner;

public class Find_the_Minimum_Number {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),n1;
		StringBuilder ans = new StringBuilder("min(int, ");
		String temp = "min(int, ";
		
		n1 = n-2;
		while(n1-->0)
			ans.append(temp);
		n--;
		ans.append("int");
		
		while(n-->0)
			ans.append(')');
		
		System.out.println(ans.toString());
		
		sc.close();
	}

}
