import java.util.*;

public class palindrom {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(),count,i;
		String str;
		sc.nextLine();
		int[] freq = new int[26];
		while(T-->0)
		{
			for(i=0;i<26;i++)
				freq[i]=0;
			count=0;
			str=sc.nextLine();
			for(i=0;i<str.length();i++)
			{
				freq[str.charAt(i)-'a']++;
			}
			i=0;
			while(count<2 && i<26)
			{
				if(freq[i++]%2!=0)
					count++;
			}
			if(count>=2)
				System.out.println("No");
			else
				System.out.println("Yes");
		}
		sc.close();
	}
}
