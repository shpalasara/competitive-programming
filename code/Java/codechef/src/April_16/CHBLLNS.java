package April_16;

import java.util.*;

public class CHBLLNS {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(),R,G,B,K;
		long ans;
		
		while(t-->0)
		{
			ans=0;
			R=sc.nextInt();
			G=sc.nextInt();
			B=sc.nextInt();
			K=sc.nextInt();
			
			if(R>=K-1)
				ans+=(long)(K-1);
			else
				ans+=(long)(R);
			
			if(G>=K-1)
				ans+=(long)(K-1);
			else
				ans+=(long)(G);
			
			if(B>=K-1)
				ans+=(long)(K-1);
			else
				ans+=(long)(B);
			
			ans++;
			
			System.out.println(ans);
		}
		sc.close();
	}
}
