package round_359_2;

import java.util.Scanner;

public class Free_Ice_Cream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] str = new String[2];
		str = sc.nextLine().split(" ");
		
		long n=Integer.parseInt(str[0]),x=Integer.parseInt(str[1]),ans1=0;
		
		while(n-->0)
		{
			str = sc.nextLine().split(" ");
			
			if(str[0].charAt(0)=='+')
				x+=Integer.parseInt(str[1]);
			else
			{
				if(x<Integer.parseInt(str[1]))
					ans1++;
				else
					x-=Integer.parseInt(str[1]);
			}
		}
		
		System.out.println(x+" "+ans1);
		sc.close();
	}

}
