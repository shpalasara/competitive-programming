package hack_101_June_16;

import java.util.Scanner;

public class Points_On_a_Line {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[][] data = new int[n][2];
		boolean x=true,y=true;
		
		
		for(int i=0;i<n;i++)
		{
			data[i][0] = sc.nextInt();
			data[i][1] = sc.nextInt();
		}
		
		for(int i=1;i<n;i++)
		{
			if(data[i][0]!=data[i-1][0])
				x=false;
			if(data[i][1]!=data[i-1][1])
				y=false;
		}
		
		if(x || y)
			System.out.println("YES");
		else
			System.out.println("NO");
		
		sc.close();
	}

}
