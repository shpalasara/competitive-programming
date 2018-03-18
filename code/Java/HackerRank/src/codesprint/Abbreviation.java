package codesprint;

import java.util.Scanner;

public class Abbreviation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int q = Integer.parseInt(sc.nextLine());
		
		while(q-->0)
		{
			String a = sc.nextLine();
			String b = sc.nextLine();
			
			int cap=0;
			
			for(int i=0;i<a.length();i++)
			{
				if(a.charAt(i)<='Z')
					cap++;
			}
			
			int[][] dp = new int[a.length()+1][b.length()+1];
			int[][] dp_count = new int[a.length()+1][b.length()+1];
			
			for(int i=0;i<a.length()+1;i++)
			{
				dp[i][0] = 0;
				dp_count[i][0] = 0;
			}
			
			for(int i=0;i<b.length()+1;i++)
			{
				dp[0][i] = 0;
				dp_count[0][i] = 0;
			}
			
			int a1,b1,ans=0,count=0;
			
			for(int i=0;i<a.length();i++)
			{
				for(int j=0;j<b.length();j++)
				{
					b1 = b.charAt(j)-'A';
					
					if(a.charAt(i)<='Z')
					{
						a1 = a.charAt(i)-'A';

						if(a1==b1)
						{
							dp[i+1][j+1] = dp[i][j]+1;
							dp_count[i+1][j+1] = dp_count[i][j]+1;
						}
						else
						{
							dp[i+1][j] = dp[i][j];
							dp_count[i+1][j] = dp[i][j];
						}
					}
					else
					{
						a1 = a.charAt(i)-'a';

						if(a1==b1)
						{
							dp[i+1][j+1] = dp[i][j]+1;
							dp_count[i+1][j+1] = dp_count[i][j];
						}
						else
						{
							dp[i+1][j] = dp[i][j];
							dp_count[i+1][j] = dp[i][j];
						}
					}
					
					if(ans<dp[i+1][j+1])
					{	
						ans = dp[i+1][j+1];
						count = dp_count[i+1][j+1];
					}
					else if(ans==dp[i+1][j+1] && count<dp_count[i+1][j+1])
						count = dp_count[i+1][j+1];
				}
			}
	
//			for(int i=0;i<a.length()+1;i++)
//			{
//				for(int j=0;j<b.length()+1;j++)
//					System.out.print(dp[i][j]+" ");
//				System.out.println();
//			}
//			System.out.println();
//			
//			for(int i=0;i<a.length()+1;i++)
//			{
//				for(int j=0;j<b.length()+1;j++)
//					System.out.print(dp_count[i][j]+" ");
//				System.out.println();
//			}
//			
//			System.out.println(dp[a.length()][b.length()]);
			
			if(ans==b.length())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}

}
