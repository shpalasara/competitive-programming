package codeAgon;

import java.util.Scanner;

public class Jesse_and_Two_Strings {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t=Integer.parseInt(sc.nextLine()),len_a,len_b,size=1001,max_a,max_b;
		int[][] dp1 = new int[size][size];
		char[][] ch1 = new char[size][size];
		boolean[] check1 = new boolean[26];
		int[][] dp2 = new int[size][size];
		char[][] ch2 = new char[size][size];
		boolean temp;
		String a,b;
		
		while(t-->0)
		{
			a=sc.nextLine();
			b=sc.nextLine();
			len_a=a.length();
			len_b=b.length();
			max_a=0;
			max_b=0;
			temp=false;
			
			for(int i=0;i<len_a;i++)
			{
				for(int j=len_a-1;j>=i;j--)
				{
					if(j==i)
					{
						if(i>0 && j+1<len_a)
							dp1[i][j]=dp1[i-1][j+1]+1;
						else
							dp1[i][j]=1;
						ch1[i][j]=a.charAt(i);
					}
					else if(a.charAt(i)==a.charAt(j))
					{
						if(i==0 || j==len_a-1)
							dp1[i][j]=2;
						else
							dp1[i][j]=dp1[i-1][j+1]+2;
					}
					else
					{
						if(i==0 || j==len_a-1)
							dp1[i][j]=0;
						else
							dp1[i][j]=Math.max(dp1[i-1][j], dp1[i][j+1]);
					}
					if(dp1[i][j]>max_a)
						max_a=dp1[i][j];
				}
			}
			
			for(int i=0;i<len_b;i++)
			{
				for(int j=len_b-1;j>=i;j--)
				{
					if(j==i)
					{
						if(i>0 && j+1<len_b)
							dp2[i][j]=dp2[i-1][j+1]+1;
						else
							dp2[i][j]=1;
						ch2[i][j]=b.charAt(i);
					}
					else if(b.charAt(i)==b.charAt(j))
					{
						if(i==0 || j==len_b-1)
							dp2[i][j]=2;
						else
							dp2[i][j]=dp2[i-1][j+1]+2;
					}
					else
					{
						if(i==0 || j==len_b-1)
							dp2[i][j]=0;
						else
							dp2[i][j]=Math.max(dp2[i-1][j], dp2[i][j+1]);
					}
					if(dp2[i][j]>max_b)
						max_b=dp1[i][j];
				}
			}
			
			if(max_a%2==1 && max_b%2==1)
			{
				for(int i=0;i<len_a;i++)
				{
					for(int j=len_a-1;j>=i;j--)
					{
						if(dp1[i][j]==max_a)
							check1[ch1[i][j]-'a']=true;
					}
				}
				
				for(int i=0;i<len_b && !temp;i++)
				{
					for(int j=len_b-1;j>=i && !temp;j--)
					{
						if(dp2[i][j]==max_b && check1[ch2[i][j]-'a'])
							temp=true;
					}
				}
				
				if(temp)
					System.out.println(max_a+max_b);
				else
					System.out.println(max_a+max_b-1);
			}
			else
				System.out.println(max_a+max_b);
			
			for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
				{
					dp1[i][j]=dp2[i][j]=0;
					ch1[i][j]=ch2[i][j]='\0';
				}
			}
			
			for(int i=0;i<26;i++)
				check1[i]=false;
		}
		
		sc.close();
	}
}
