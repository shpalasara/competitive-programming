package April_16;

import java.util.*;

public class COLOR {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine()),R,G,B,ln,N,ans;
		String str;
		
		while(T-->0)
		{
			R=G=B=0;
			N=Integer.parseInt(sc.nextLine());
			str = sc.nextLine();
			ln=str.length();
			
			for(int i=0;i<ln;i++)
			{
				if(str.charAt(i)=='R')
					R++;
				else if(str.charAt(i)=='G')
					G++;
				else
					B++;
			}
			
			ans = N-Math.max(R, Math.max(G, B));
			
			System.out.println(ans);
		}
		sc.close();
	}
}
