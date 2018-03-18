import java.util.*;

public class ACM_2 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		long ans=0,total_x=0,total_y=0;
		
		long[] x = new long[N];
		long[] y = new long[N];
		
		for(int i=0;i<N;i++)
		{
			x[i]=sc.nextLong();
			y[i]=sc.nextLong();
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
		
		long x0=x[0],y0=y[0];
		
		for(int i=0;i<N;i++)
		{
			x[i]-=x0;
			total_x+=x[i];
			y[i]-=y0;
			total_y+=y[i];
		}
		
		//for(int i=0;i<N;i++)
		//	System.out.println(x[i]);
		
		for(int i=N-1;i>0;i--)
		{
			total_x-=x[i];
			ans+=Math.abs((long)i*x[i]-total_x)%1000000007;
			
			total_y-=y[i];
			ans+=Math.abs((long)i*y[i]-total_y)%1000000007;
			
			ans=ans%1000000007;
		}
		
		System.out.println(ans%1000000007);
		sc.close();
	}
}
