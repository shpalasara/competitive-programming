import java.util.*;

public class alternating_character {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(),ans;
		sc.nextLine();
		while(T-->0)
		{
			ans=0;
			String str=sc.nextLine();
			for(int i=0;i<str.length()-1;i++)
			{
				if(str.charAt(i)==str.charAt(i+1))
					ans++;
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
