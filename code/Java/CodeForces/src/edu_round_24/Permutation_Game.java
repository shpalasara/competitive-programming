package edu_round_24;

import java.util.Scanner;

public class Permutation_Game {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] l = new int[m];
		
		for(int i=0;i<m;i++)
			l[i] = sc.nextInt();
		
		boolean[] check = new boolean[n+1];
		int[] ans = new int[n+1];
		int t;
		boolean ok = true;
		
		for(int i=1;i<m && ok;i++)
		{
			t = (l[i] - l[i-1] + n)%n;
			if(t==0)
			{
//				if(check[n])
//					ok = false;
//				check[n] = true;
				if(ans[l[i-1]]==0 || ans[l[i-1]]==n)
					ans[l[i-1]] = n;
				else
					ok = false;
			}
			else
			{
//				if(check[t])
//					ok = false;
//				check[t] = true;
				if(ans[l[i-1]]==0 || ans[l[i-1]]==t)
					ans[l[i-1]] = t;
				else
					ok = false;
			}
		} 
			
		if(ok)
		{
			for(int i=1;i<=n && ok;i++)
			{
				if(ans[i]!=0)
				{
					if(!check[ans[i]])
						check[ans[i]] = true;
					else
						ok = false;
				}
			}
			
			if(ok)
			{
				int index = 1;
				for(int i=1;i<=n;i++)
				{
					if(ans[i]==0)
					{
						while(index<=n && check[index])
							index++;
						ans[i] = index;
						check[index] = true;
						index++;
					}
					System.out.print(ans[i]+" ");
				}
				System.out.println();
			}
			else
				System.out.println(-1);
		}
		else
			System.out.println(-1);
		sc.close();
	}
}
