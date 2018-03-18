package May_16;

import java.util.Scanner;

public class SEAGCD2 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		long[][] dp = new long[101][100001];
		long[] pre_sum = new long[100001];
		long[] temp = new long[100001];
		long[][] nCr = new long[100001][101];
		long[] fact = new long[101];
			
		// Finding nCr
		for(int i=0;i<100001;i++)
		{
			for(int j=0;j<=i && j<101;j++)
			{
				if(i==0 || j==0)
					nCr[i][j]=1;
				else
					nCr[i][j]=(nCr[i-1][j-1]+nCr[i-1][j])%1000000007;
			}
		}
		
		//Finding factorial
		fact[0]=1;
		for(int i=1;i<101;i++)
			fact[i]=(i*fact[i-1])%1000000007;
		
		/*
		for(int i=0;i<=5;i++)
		{
			for(int j=0;j<=i;j++)
				System.out.print(nCr[i][j]+" ");
			System.out.println();
		}
		*/
		
		for(int i=1;i<101;i++)
		{
			temp[0]=0;
			
			for(int j=1;j<100001;j++)
			{
				if(i==1)
					dp[i][j]=1;
				else
					dp[i][j] = (i+((long)(i-1)*pre_sum[j-1])%1000000007)%1000000007;
				
				temp[j] = (temp[j-1]+dp[i][j])%1000000007; 
			}
			
			for(int j=0;j<100001;j++)
				pre_sum[j]=temp[j];
		}
		
		int t=sc.nextInt(),n,m,count,ini;
		long ans;
		
		/*
		for(int i=1;i<=10;i++)
		{
			for(int j=1;j<=10;j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}
		*/
		
		while(t-->0)
		{
			n=sc.nextInt();
			m=sc.nextInt();
			ans=dp[m][n];
			ini=0;
			int[] point= new int[m+1];
			boolean[] check = new boolean[m+1];
			
			for(int i=2;i<m+1;i++)
			{
				if(!check[i])
				{
					count=0;
					for(int j=i;j<m+1;j+=i)
					{
						count++;
						if(!check[j])
							ini++;
						check[j]=true;
					}
					
					for(int j=2;j<=count;j++)
						ans=ans-(((fact[j]*nCr[n][j])%1000000007)*nCr[count][j])%1000000007;
					
					if(ans<0)
						ans+=1000000007;
				}
			}
			
			System.out.println(ans);
		}
		sc.close();
	}
}
