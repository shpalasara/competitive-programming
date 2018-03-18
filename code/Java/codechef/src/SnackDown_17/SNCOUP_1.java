package SnackDown_17;

// Wrongly understood

import java.util.Scanner;

public class SNCOUP_1 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine()),n,ans;
		
		while(t-->0)
		{
			n = Integer.parseInt(sc.nextLine());
			ans = 0;
			char[][] ch = new char[2][n+2];
			
			ch[0] = sc.nextLine().toCharArray();
			ch[1] = sc.nextLine().toCharArray();
			
			boolean[] hor = new boolean[n+1];
			boolean[] ver = new boolean[n+1];
			
			for(int i=0;i<n;i++)
			{
				if(ch[0][i]=='*' || ch[1][i]=='*')
				{
					if(ch[0][i]=='*' && ch[1][i]=='*')
						hor[i] = true;
					
					if(i==0)
						ver[i]=true;
					else if(i==n-1)
					{
						if(i>0 && !ver[i-1])
							ver[i-1] = true;
					}
					else
					{
						if(i>0 && !ver[i-1])
							ver[i-1] = true;
						ver[i] = true;

					}
				}
			}
//			System.out.println(ans);
			System.out.println("Horizontal");
			for(int i=0;i<n;i++)
			{
				if(hor[i])
					System.out.print(1);
				else
					System.out.print(0);
			}
			System.out.println();
			System.out.println("vertical");
			for(int i=0;i<n;i++)
			{
				if(ver[i])
					System.out.print(1);
				else
					System.out.print(0);
			}
			System.out.println();
			
			int max = 0,t1;
			
			for(int i=0;i<n;i++)
			{
				if((ch[0][i]=='*' || ch[1][i]=='*') && !(ch[0][i]=='*' && ch[1][i]=='*'))
				{
					t1 = 0;
					if(!(i>0 && hor[i-1]) && !((i+1)<n && hor[i+1]))
					{
						hor[i] = false;
						t1++;
					}
					if(i>0 && (ch[0][i-1]!='*' && ch[1][i-1]!='*') && ver[i-1])
					{
						ver[i-1] = false;
						t1++;
					}
					if((i+1)<n && (ch[0][i+1]!='*' && ch[1][i+1]!='*') && ver[i+1])
					{
						ver[i+1] = false;
						t1++;
					}
					max = Math.max(max, t1);
				}
			}
//			ans -= max;
			
			System.out.println("Horizontal");
			for(int i=0;i<n;i++)
			{
				if(hor[i])
					System.out.print(1);
				else
					System.out.print(0);
			}
			System.out.println();
			System.out.println("vertical");
			for(int i=0;i<n;i++)
			{
				if(ver[i])
					System.out.print(1);
				else
					System.out.print(0);
			}
			System.out.println();
			System.out.println();
//			System.out.println(ans);
		}
		sc.close();
	}
}
