package Beginner;

import java.util.Scanner;

public class TWEED {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.nextLine());
		
		while(t-->0)
		{
			String[] str = sc.nextLine().split(" ");
			int n = Integer.parseInt(str[0]);
			boolean even = true;
			
			String[] data = sc.nextLine().split(" ");
			
			for(int i=0;i<n;i++)
			{
				if(Integer.parseInt(data[i])%2==1)
					even = false;
			}
			
			if(n==1 && even && str[1].equalsIgnoreCase("Dee"))
				System.out.println("Dee");
			else
				System.out.println("Dum");
		}
		sc.close();
	}

}
