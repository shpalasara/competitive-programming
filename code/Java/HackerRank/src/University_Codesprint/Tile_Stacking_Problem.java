package University_Codesprint;

import java.util.Scanner;

public class Tile_Stacking_Problem {

	static long mod = (long)(1e9+7);
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		long[] dp = new long[n+1];
//		long[] t_dp = new long[n];
		long[] sum = new long[n+1];
		
		for(int j=0;j<=Math.min(n, k);j++)
			dp[j] = 1;
		sum[0] = dp[0];
		for(int i=1;i<=n;i++)
			sum[i] = (sum[i-1] + dp[i])%mod;
		
		for(int i=1;i<m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(j>k)
					dp[j] = (sum[j] - sum[j-k-1] + mod)%mod;
				else
					dp[j] = sum[j]%mod;
			}
			
			sum[0] = dp[0];
			for(int j=1;j<=n;j++)
			{
				sum[j] = (sum[j-1] + dp[j])%mod;
			}
		}
		
		System.out.println(dp[n]);
	}
}
