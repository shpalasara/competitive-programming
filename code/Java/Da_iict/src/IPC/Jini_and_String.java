package IPC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Jini_and_String {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int k = Integer.parseInt(sc.nextLine());
		
		int[] index = new int[26]; 
		
		for(int i=0;i<26;i++)
			index[i] = Integer.MAX_VALUE;
		
		boolean[] check = new boolean[26];
		boolean[] che = new boolean[26];
		
		for(int i=0;i<str.length();i++)
		{	
			if(!check[str.charAt(i)-'a'])
			{
				index[str.charAt(i)-'a'] = i;
				check[str.charAt(i)-'a'] = true;
			}
			else
				che[str.charAt(i)-'a'] = true;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<26;i++)
		{
			if(!che[i] && check[i])
				list.add(index[i]);
		}
		
		Collections.sort(list);
		
		//System.out.println(list.size());
		
		if(list.size()<k)
			System.out.println(-1);
		else
			System.out.println(str.charAt(list.get(k-1)));
		sc.close();
	}

}
