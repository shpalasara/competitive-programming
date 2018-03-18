package SnackDown_16;

import java.util.Scanner;

public class NDIFFPAL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(),n;
		String ans,temp="abcdefghijklmnopqrstuvwxyz";
		
		while(t-->0)
		{
			n=sc.nextInt();
			ans = "";
			
			while(n>=26)
			{
				ans+=temp;
				n-=26;
			}
			if(n!=0)
				ans+=temp.substring(0, n);
			
			System.out.println(ans);
		}
		sc.close();
	}

}
