package round_324;
import java.util.*;

public class Kolya_and_Tanya {

	static long MOD=1000000007;
	
	public static void main(){
		
		Scanner sc = new Scanner(System.in);
		long n=sc.nextLong(),ans=1,i,temp=1,mul;
		long comb;
		
		for(i=0;i<3*n;i++)
			ans=(ans*3)%MOD;
		
		for(i=0;i<n-1;i++)
		{
			temp=(3*2*1*temp)%MOD;
			ans=(ans-temp*n)%MOD;
		}
		ans=(ans-1)%MOD;
		System.out.println(ans);
		sc.close();
	}
	public static long combination(long n,long r)
	{
		long ans=1,i;
		for(i=n;i>r;i--)
			ans=(ans*i)%MOD;
		for(i=2;i<=r;i++)
			ans=(ans/i)%MOD;
		return ans;
	}
}
