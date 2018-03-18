package Easy;

import java.util.*;

public class LAPIN {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t=Integer.parseInt(sc.nextLine()),length;
		int[] freq_f = new int[26];
		int[] freq_s = new int[26];
		boolean out;
		String str;
		
		while(t-->0)
		{
			out=true;
			str=sc.nextLine();
			length=str.length();
			
			for(int i=0;i<length/2;i++)
				freq_f[str.charAt(i)-'a']++;
			
			for(int i=(length+1)/2;i<length;i++)
				freq_s[str.charAt(i)-'a']++;
			
			for(int i=0;i<26;i++)
			{
				if(freq_f[i]!=freq_s[i])
					out=false;
				freq_f[i]=0;
				freq_s[i]=0;
			}
			
			if(out)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}
}
