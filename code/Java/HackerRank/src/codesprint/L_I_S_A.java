package codesprint;

// Accepted
// https://www.hackerrank.com/contests/world-codesprint-5/challenges/longest-increasing-subsequence-arrays

import java.util.Scanner;

public class L_I_S_A {

	/**
	 * @param args
	 */
	public static long mod = (long)(1e9+7);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int p = sc.nextInt();
		int m,n;
		long ans;
		
		long[] fact = new long[500001];
		long[] inv_fact = new long[500001];
		fact[0]=1;
		inv_fact[0]=1;
		
		
		for(int i=1;i<500001;i++)
			fact[i] = ((long)i*fact[i-1])%mod;
		
		for(int i=1;i<500001;i++)
			inv_fact[i] = power(fact[i],mod-2);
		
		while(p-->0)
		{
			m = sc.nextInt();
			n = sc.nextInt();
			
			long[] pow_1 = new long[m-n+1];
			long[] pow = new long[m-n+1];
			pow_1[0]=1;
			pow[0]=1;
			
			for(int i=1;i<m-n+1;i++)
			{
				pow_1[i] = ((long)(n-1)*pow_1[i-1])%mod;
				pow[i] = ((long)n*pow[i-1])%mod;
			}
			
			if(m==n || n==1)
				ans = 1L;
			else
			{
				ans=0;
				
				for(int x=0;x<=m-n;x++)
					ans = (ans+((((fact[m-1-x]*inv_fact[n-1])%mod)*inv_fact[m-n-x])%mod)*((pow_1[m-n-x]*pow[x])%mod))%mod;
			}
			
			System.out.println(ans);
		}
		
		sc.close();
	}
	
	public static long power(long a,long n){
		
		long ans=1;
		
		while(n!=0)
		{
			if(n%2==1)
				ans=(ans*a)%mod;
			
			a = (a*a)%mod;
			n=n>>1;
		}
		return ans;
	}

}
