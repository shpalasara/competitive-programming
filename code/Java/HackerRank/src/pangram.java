import java.util.*;

public class pangram {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String str=sc.nextLine();
		boolean[] check = new boolean[26];
		
		for(int i=0;i<26;i++)
			check[i]=false;
			
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)<='z' && str.charAt(i)>='a')
				check[str.charAt(i)-'a']=true;
			else if(str.charAt(i)<='Z' && str.charAt(i)>='A')
				check[str.charAt(i)-'A']=true;
			else
				continue;
		}
		int i;
		
		for(i=0;i<26;i++)
		{
			if(!check[i])
				break;
		}
		if(i==26)
			System.out.println("pangram");
		else
			System.out.println("not pangram");
		sc.close();
	}
}
