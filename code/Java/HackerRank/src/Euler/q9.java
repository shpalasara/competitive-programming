package Euler;

import java.util.Scanner;

public class q9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt(),n;
		int[] ans = new int[3001];
		
		for(int i=1;i<3001;i++)
		{
			int j=2999;
			int k=3000;
			
			while(j>i)
			{	
				if((i*i+j*j)==(k*k))
				{
					if((i+j+k)<3001)
						ans[i+j+k] = Math.max(ans[i+j+k], i*j*k);
					j--;
					k--;
				}
				else if((i*i+j*j)<k*k)
					k--;
				else 
					j--;

				if(j==k)
					j--;
			}
		}
		
		while(t-->0)
		{
			n=sc.nextInt();
			
			if(ans[n]>0)
				System.out.println(ans[n]);
			else
				System.out.println("-1");
			
		}
		
		sc.close();
	}

}
