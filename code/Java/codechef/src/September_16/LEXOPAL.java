package September_16;

//Accepted

import java.io.PrintWriter;
import java.util.Scanner;

public class LEXOPAL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = Integer.parseInt(sc.nextLine()),length;
		boolean pali;
		
		while(t-->0)
		{
			pali = true;
			char[] str = sc.nextLine().toCharArray();
			length = str.length;
			char ch;
			
			for(int i=0;i<length/2 && pali;i++)
			{
				if(str[i]=='.' && str[length-i-1]=='.')
				{
					str[i] = 'a';
					str[length-i-1] = 'a';
				}
				else if(str[i]=='.')
				{
					ch = str[length-i-1];
					str[i] = ch;
				}
				else if(str[length-i-1]=='.')
				{
					ch = str[i];
					str[length-i-1] = ch;
				}
				else if(str[i]!=str[length-i-1])
						pali = false;
			}
			
			if(length%2==1)
			{
				if(str[length/2]=='.')
					str[length/2] = 'a';
			}
			
			if(pali)
			{
				for(int i=0;i<length;i++)
					out.print(str[i]);
				out.println();
			}
			else
				out.println("-1");
		}
		sc.close();
		out.close();
	}

}
