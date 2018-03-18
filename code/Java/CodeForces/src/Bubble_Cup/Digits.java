package Bubble_Cup;

import java.math.BigInteger;
import java.util.Scanner;

public class Digits {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();

		StringBuilder out = new StringBuilder("");
		
		for(int i=0;i<str.length()-1;i++)
			out.append(str.charAt(i)+"+");
		out.append(str.charAt(str.length()-1));
		
		System.out.println(out.toString());
		
		BigInteger ans = new BigInteger("0");
		
		for(int i=0;i<str.length();i++)
			ans = ans.add(new BigInteger(""+str.charAt(i)));
		
		
		
		str = ans.toString();
		out = new StringBuilder("");
		
		for(int i=0;i<str.length()-1;i++)
			out.append(str.charAt(i)+"+");
		out.append(str.charAt(str.length()-1));
		
		System.out.println(out.toString());
		
		ans = new BigInteger("0");
		
		for(int i=0;i<str.length();i++)
			ans = ans.add(new BigInteger(""+str.charAt(i)));
		
		out = new StringBuilder("");
		
		
		str = ans.toString();
		out = new StringBuilder("");
		
		for(int i=0;i<str.length()-1;i++)
			out.append(str.charAt(i)+"+");
		out.append(str.charAt(str.length()-1));
		
		System.out.println(out.toString());
		
		sc.close();
	}
}
