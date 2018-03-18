import java.util.*;

public class ACM_1 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T,N,Q;
		long ans;
		T=sc.nextInt();
		while(T-->0)
		{
			ans=0;
			N=sc.nextInt();
			Q=sc.nextInt();
			
			int[] data = new int[N];
			for(int i=0;i<N;i++)
				data[i]=sc.nextInt();
			
			Arrays.sort(data);
			
			for(int i=1;i<N;i++)
				ans+=(data[i]-data[i-1])*Q;
			
			System.out.println(ans);
		}
		sc.close();
	}
}
