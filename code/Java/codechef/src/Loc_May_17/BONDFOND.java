package Loc_May_17;

import java.util.Scanner;

public class BONDFOND {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long n,temp;
		int bit;
		
		while(t-->0)
		{
			n = (1L<<62) + 1L;
			temp = n;
			bit = 0;
			
			while(temp>0)
			{
				bit++;
				temp = temp>>1;
			}
			
			bit--;
			System.out.println(Math.min(n-(1L<<bit), (1L<<(bit+1))-n));
		}
		sc.close();
	}
}
