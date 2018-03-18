package Algorithm;

import java.util.*;

public class Make_it_Anagram {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String a1 = sc.nextLine(),a2=sc.nextLine();
		int[] freq = new int[26];
		int ans=0;
		
		for(int i=0;i<a1.length();i++)
			freq[a1.charAt(i)-'a']++;
		
		for(int i=0;i<a2.length();i++)
			freq[a2.charAt(i)-'a']--;
		
		for(int i=0;i<26;i++)
			ans+=Math.abs(freq[i]);
		
		System.out.println(ans);
		sc.close();
	}
}
