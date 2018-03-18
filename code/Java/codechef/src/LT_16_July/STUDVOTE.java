package LT_16_July;

import java.io.PrintWriter;
import java.util.Scanner;

public class STUDVOTE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt(),n,k,temp,ans;
		
		while(t-->0)
		{
			n = sc.nextInt();
			k = sc.nextInt();
			ans = 0;
			
			int[] count = new int[n];
			
			for(int i=0;i<n;i++)
			{
				temp = sc.nextInt()-1;
				
				if(i==temp)
					count[temp] = Integer.MIN_VALUE;
				else
					count[temp]++;
			}
			
			for(int i=0;i<n;i++)
			{
				if(count[i]>=k)
					ans++;
			}
			out.println(ans);
		}
		
		out.close();
		sc.close();
	}

}
