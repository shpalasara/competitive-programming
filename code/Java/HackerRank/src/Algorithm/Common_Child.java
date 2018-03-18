package Algorithm;

import java.util.*;

public class Common_Child {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String s1=sc.nextLine(),s2=sc.nextLine();
		int length_1=s1.length(),length_2=s2.length();
		int[][] dp = new int[length_1][length_2];
		
		for(int i=0;i<length_1;i++)
		{
			for(int j=0;j<length_2;j++)
			{
				if(i==0 && j==0)
				{
					if(s1.charAt(i)==s2.charAt(j))
						dp[i][j]++;
				}
				else if(i==0)
				{
					if(s1.charAt(i)==s2.charAt(j))
						dp[i][j]=1;
					else
						dp[i][j]=dp[i][j-1];
				}
				else if(j==0)
				{
					if(s1.charAt(i)==s2.charAt(j))
						dp[i][j]=1+dp[i-1][j];
					else
						dp[i][j]=dp[i-1][j];
				}
				else
				{
					if(s1.charAt(i)==s2.charAt(j))
						dp[i][j]=1+dp[i-1][j-1];
					else
						dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[length_1-1][length_2-1]);
		sc.close();
	}
}
