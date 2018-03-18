package codesprint;

import java.util.Scanner;

public class Short_Palindrome {

	/**
	 * @param args
	 */
	public static long mod = (long)(1e9+7);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int length = str.length();
		long[] count = new long[26];
		
		long[][] l_ans = new long[length][26];
		long[][] r_ans = new long[length][26];
		
		int[] prev_index = new int[length];
		int[] c_prev = new int[26];
		
		for(int i=0;i<26;i++)
			c_prev[i] = -1;
		
		for(int i=0;i<length;i++)
		{
			//if(c_prev[str.charAt(i)-'a']==-1)
			//{
				for(int j=0;j<26;j++)
					l_ans[i][j] = count[j];
			//}
			/*else
			{
				int index = c_prev[str.charAt(i)-'a'];
				
				for(int j=0;j<26;j++)
					l_ans[i][j] = (count[j]+l_ans[index][j])%mod;
			}*/
			
			prev_index[i] = c_prev[str.charAt(i)-'a'];
			c_prev[str.charAt(i)-'a']=i;
			count[str.charAt(i)-'a']++;
		}
		
		//int[] next_index = new int[length];
		int[] c_next = new int[26];
		
		long ans=0;
		
		for(int i=0;i<26;i++)
		{
			c_next[i] = -1;
			count[i] = 0;
		}
		
		for(int i=length-1;i>=0;i--)
		{
			if(c_next[str.charAt(i)-'a']==-1)
			{
				for(int j=0;j<26;j++)
					r_ans[i][j] = count[j];
			}
			else
			{
				int index = c_next[str.charAt(i)-'a'];
				
				for(int j=0;j<26;j++)
					r_ans[i][j] = (count[j]+r_ans[index][j])%mod;
			}
			
			//next_index[i] = c_next[str.charAt(i)-'a'];
			c_next[str.charAt(i)-'a']=i;
			count[str.charAt(i)-'a']++;
			
			if(prev_index[i]!=-1)
			{
				int index = prev_index[i];
				
				for(int j=0;j<26;j++)
					ans = (ans + r_ans[i][j]*l_ans[index][j])%mod;
				
				//System.out.println(i+" "+ans);
			}
		}
		
		System.out.println(ans);
		sc.close();
	}

}
