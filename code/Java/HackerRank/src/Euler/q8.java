package Euler;

import java.util.Scanner;

public class q8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine()),n,k,ans,temp,i;
		String[] str = new String[2];
		
		while(t-->0)
		{
			str = sc.nextLine().split(" ");
			n = Integer.parseInt(str[0]);
			k = Integer.parseInt(str[1]);
			
			String data = sc.nextLine();
			temp = 1;
			i=0;
			
			while(i<k)
			{
				temp = temp*(data.charAt(i)-'0');
				i++;
			}
			ans = temp;
			
			for(i=k;i<data.length();i++)
			{
				temp = temp*(data.charAt(i)-'0');
				
				if(data.charAt(i-k)!='0')
					temp = temp/(data.charAt(i-k)-'0');
				else
				{
					temp = 1;
					for(int j=i-k+1;j<=i;j++)
						temp = temp*(data.charAt(j)-'0');	
				}
				ans = Math.max(temp, ans);
			}
			
			System.out.println(ans);
		}
		
		sc.close();
	}

}
