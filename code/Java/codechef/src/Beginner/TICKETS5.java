package Beginner;

import java.io.PrintWriter;
import java.util.Scanner;

public class TICKETS5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = Integer.parseInt(sc.nextLine());
		boolean ans;
		
		while(t-->0)
		{
			ans = true;
			char[] str = sc.nextLine().toCharArray();
			
			if(str[0]==str[1])
				ans = false;
			else
			{
				for(int i=2;i<str.length && ans;i++)
					if(str[i]!=str[i-2])
						ans = false;
			}
			
			if(ans)
				out.println("YES");
			else
				out.println("NO");
		}
		
		out.close();
		sc.close();
	}

}
