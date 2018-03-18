package codeAgon;

import java.util.Scanner;

public class CA_17_q2 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int k = Integer.parseInt(sc.nextLine());
		
		int[] freq = new int[26];
		
		for(int i=0;i<str.length();i++)
			freq[str.charAt(i)-'a']++;
		
		StringBuilder ans = new StringBuilder("");
		
		for(int i=0;i<str.length();i++)
		{
			if(freq[str.charAt(i)-'a']>=k)
				ans.append(str.charAt(i));
		}
		
		System.out.println(ans.toString());
		
		sc.close();
	}
}
