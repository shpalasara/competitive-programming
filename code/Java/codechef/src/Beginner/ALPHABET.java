package Beginner;

import java.io.PrintWriter;
import java.util.Scanner;

public class ALPHABET {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		String str = sc.nextLine();
		boolean[] jeff = new boolean[26];
		
		for(int i=0;i<str.length();i++)
			jeff[str.charAt(i)-'a'] = true;
		
		int n = Integer.parseInt(sc.nextLine());
		boolean[] check = new boolean[26];
		boolean ans;
		
		while(n-->0)
		{
			ans = true;
			String data = sc.nextLine();
			
			for(int i=0;i<data.length();i++)
				check[data.charAt(i)-'a'] = true;
			
			for(int i=0;i<26;i++)
			{
				if(check[i] && !jeff[i])
					ans = false;
				check[i] = false;
			}
			
			if(ans)
				out.println("Yes");
			else
				out.println("No");
		}
		
		out.close();
		sc.close();
	}

}
