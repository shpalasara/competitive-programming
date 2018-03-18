package week_of_code_30;

import java.io.PrintWriter;
import java.util.Scanner;

public class Melodious_password {

	/**
	 * @param args
	 */
	static char[] vowels = {'a','e','i','o','u'};
	static char[] consonants = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
	static PrintWriter out;
	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		Recursion( "", true, n);
		Recursion( "", false, n);
		
		out.println(count);
		
		out.close();
		sc.close();
	}

	public static void Recursion(String str,boolean vow,int size){
		
		if(size==1)
		{
			if(vow)
			{
				for(int i=0;i<vowels.length;i++)
				{
					out.println(str+vowels[i]);
					count++;
				}
			}
			else
			{
				for(int i=0;i<consonants.length;i++)
				{
					out.println(str+consonants[i]);
					count++;
				}
			}
		}
		else
		{
			if(vow)
			{
				for(int i=0;i<vowels.length;i++)
					Recursion( str+vowels[i], !vow, size-1); 
			}
			else
			{
				for(int i=0;i<consonants.length;i++)
					Recursion( str+consonants[i], !vow, size-1); 
			}
		}
	}
}
