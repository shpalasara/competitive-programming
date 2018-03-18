package round_357_2;

import java.util.Scanner;

public class Economy_Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt(),n1,n2,temp;
		
		n1 = n/1234567;
		temp = n%1234567;
		
		boolean check = false;
		
		for(int i=0;i<=n1 && !check;i++)
		{
			int m = temp + i*(1234567);
			
			int m1,m2;
			m1 = m/123456;
			m2 = m%123456;
			
			for(int j=0;j<=m1 && !check;j++)
			{
				int nm = (m2 + j*123456);
				
				if(nm%1234==0)
					check = true;
			}
		}
		
		if(check)
			System.out.println("YES");
		else
			System.out.println("NO");
		
		sc.close();
	}

}
