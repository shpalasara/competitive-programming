import java.util.*;

public class Gemstones {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(),ans=0;
		sc.nextLine();
		boolean[][] check = new boolean[N][26];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<26;j++)
				check[i][j]=false;
		
		for(int i=0;i<N;i++)
		{
			String str=sc.nextLine();
			for(int j=0;j<str.length();j++)
				check[i][str.charAt(j)-'a']=true;
		}
		
		for(int i=0;i<26;i++)
		{
			int j;
			for(j=0;j<N;j++)
				if(!check[j][i])
					break;
			if(j==N)
				ans++;
		}
		
		System.out.println(ans);
		sc.close();
	}
}