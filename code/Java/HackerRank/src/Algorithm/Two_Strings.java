package Algorithm;

import java.util.*;

public class Two_Strings {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t=Integer.parseInt(sc.nextLine()),length;
		String str;
		boolean[] s1 = new boolean[26];
		boolean[] s2 = new boolean[26];
		boolean ans;
		
		while(t-->0)
		{
			ans=false;
			
			for(int i=0;i<26;i++)
				s2[i]=s1[i]=false;

			str=sc.nextLine();
			length=str.length();
			
			for(int i=0;i<length;i++)
				s1[str.charAt(i)-'a']=true;
			
			str=sc.nextLine();
			length=str.length();
			
			for(int i=0;i<length;i++)
				s2[str.charAt(i)-'a']=true;
			
			for(int i=0;i<26;i++)
				if(s1[i] && s2[i])
					ans=true;
			
			if(ans)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
		sc.close();
	}
}
