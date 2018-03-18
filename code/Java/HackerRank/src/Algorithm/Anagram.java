package Algorithm;

import java.util.*;

public class Anagram {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t=Integer.parseInt(sc.nextLine()),length,ans;
		String temp;
		int[] count = new int[26];
		
		while(t-->0)
		{
			ans=0;
			temp=sc.nextLine();
			length=temp.length();
			if(length%2==0)
			{
				for(int i=0;i<length/2;i++)
					count[temp.charAt(i)-'a']++;
				
				for(int i=length/2;i<length;i++)
					count[temp.charAt(i)-'a']--;
				
				for(int i=0;i<26;i++)
				{
					ans+=Math.abs(count[i]);
					count[i]=0;
				}
				
				System.out.println(ans/2);
			}
			else
				System.out.println("-1");
		}
		sc.close();
	}
}
