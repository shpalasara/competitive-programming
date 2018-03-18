package April_16;

import java.util.*;

public class BIPIN3 {

	public static long power;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		long n,k,ans;
		
		while(t-->0)
		{
			n=sc.nextLong();
			k=sc.nextLong();
			
			power = n-1;
			ans=power_mod(power,1,k-1);
			
			ans = (ans*k)%1000000007;
			
			System.out.println(ans);
		}
		sc.close();
	}
	
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
}
