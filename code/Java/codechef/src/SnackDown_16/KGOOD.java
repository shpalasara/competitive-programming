package SnackDown_16;

import java.util.Arrays;
import java.util.Scanner;

public class KGOOD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=Integer.parseInt(sc.nextLine()),k,ans,i,j,temp_ans;
		int[] count = new int[26];
		
		while(t-->0)
		{
			ans=Integer.MAX_VALUE;
			String[] str = sc.nextLine().split(" ");
			k=Integer.parseInt(str[1]);
			
			for(i=0;i<str[0].length();i++)
				count[str[0].charAt(i)-'a']++;
			
			Arrays.sort(count);
			
			i=0;
			j=25;
			
			while(count[i]==0 && i<26)
				i++;
			
			if(i>=26)
				ans=0;
			
			for(j=i;j<26;j++)
			{
				temp_ans=0;
				for(int l=i;l<26;l++)
				{
					if(l<j)
						temp_ans+=count[l];
					else if(Math.abs(count[l]-count[j])>k)
						temp_ans+=Math.abs(count[l]-count[j])-k;
				}
				//System.out.println(temp_ans+" "+j);
				ans=Math.min(ans, temp_ans);					
			}
			
			for(i=0;i<26;i++)
				count[i]=0;
//			for(int i=0;i<26;i++)
//			{
//				if(count[i]!=0)
//				{
//					for(int j=i+1;j<26;j++)
//					{
//						if(count[j]!=0)
//						{
//							if(count[i]>k+count[j])
//							{
//								ans+=count[i]-count[j]-k;
//								count[i]=k+count[j];
//							}
//							else if(count[j]>k+count[i])
//							{
//								ans+=count[j]-count[i]-k;
//								count[j]=k+count[i];
//							}
//						}
//					}
//					count[i]=0;
//				}
//			}
			
			System.out.println(ans);
		}
		sc.close();
	}

}
