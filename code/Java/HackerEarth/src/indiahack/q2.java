package indiahack;
import java.util.*;

public class q2 {

	public static void main(String[] args){
		
		long[][] nCr = new long[1001][1001];
		
		for(int i=1;i<1001;i++)			//indicates n
		{
			for(int j=0;j<=i;j++)		//indicates r
			{
				if(j==0 || i==j)
					nCr[i][j]=1;
				else
				{
					nCr[i][j]=nCr[i-1][j]+nCr[i-1][j-1];
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(),n,temp;
		long ans;
		
		while(t-->0)
		{
			temp=0;
			ans=0;
			n=sc.nextInt();
			while(2*temp<=n)
			{
				ans+=nCr[n-temp][temp];
				//System.out.println(ans+" just");
				temp++;
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
