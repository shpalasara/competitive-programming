package round_352_2;

import java.util.Scanner;

public class Different_is_Good {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine()),ans=0;
		String str = sc.nextLine();
		
		if(n>26)
			System.out.println("-1");
		else
		{
			int[] count = new int[26];
			
			for(int i=0;i<n;i++)
				count[str.charAt(i)-'a']++;
			
			for(int i=0;i<26;i++)
			{
				if(count[i]>1)
					ans+=count[i]-1;
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
