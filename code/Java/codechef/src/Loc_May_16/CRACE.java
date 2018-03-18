package Loc_May_16;

import java.util.Scanner;

public class CRACE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(),n;
		
		while(t-->0)
		{
			n=sc.nextInt();
			
			if(n%2==0)
				System.out.println("JACK");
			else
				System.out.println("JENNY");
		}
		sc.close();
	}

}
