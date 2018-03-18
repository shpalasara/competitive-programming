import java.util.*;

public class game_of_throne_1 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String str=sc.nextLine();
		int[] count = new int[26];
		
		for(int i=0;i<str.length();i++)
		{
			count[str.charAt(i)-'a']++;
		}
		
		int i;
		if(str.length()%2==0)
		{
			for(i=0;i<26;i++)
				if(count[i]%2!=0)
					break;
			if(i==26)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		else
		{
			int counter=0;
			for(i=0;i<26;i++)
				if(count[i]%2!=0)
					counter++;
			if(counter==1)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}
}
