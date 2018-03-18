package Algo;

public class power_in_log_n {

	public static long power;
	
	//finding a^b in log(b) time
		public static long power_mod(long b,long temp,long out){
			
			if(temp<=b)
			{
				long ans=power_mod(b,temp<<1,(out*out)%1000000007);
				
				if(power>=temp)
				{
					ans=(ans*out)%1000000007;
					power-=temp;
				}
				
				return ans;
			}
			else
				return 1;
		}
		
		// finding (a^n)%mod in log(n) with recursion
		
		public static long power(long a,long n,long mod){
			if(n==0)
				return 1;
			if(n==1)
				return a%mod;
			long t = power(a,n/2,mod)%mod;
			
			return (((t*t)%mod)*power(a,n%2,mod))%mod;
		}
		
		// finding (a^n)%mod in log(n) without recursion
		
		public static long power_1(long a,long n,long mod){
			
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

//java.util.Arrays.sort(check, new java.util.Comparator<long[]>() {
//
//	  public int compare(long[] a,long[] b) {
//
//	    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? (a[1] < b[1] ? -1 : 1) : 1));
//
//	  }
//
//	});
//
//
