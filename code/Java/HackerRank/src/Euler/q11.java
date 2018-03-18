package Euler;

import java.util.Scanner;

public class q11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] data = new int[20][20];
		int ans = 0;
		
		for(int i=0;i<20;i++)
			for(int j=0;j<20;j++)
				data[i][j] = sc.nextInt();
		
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				if((i+3)<20)
					ans = Math.max(ans, data[i][j]*data[i+1][j]*data[i+2][j]*data[i+3][j]);
				if((j+3)<20)
					ans = Math.max(ans, data[i][j]*data[i][j+1]*data[i][j+2]*data[i][j+3]);
				if((i+3)<20 && (j+3)<20)
					ans = Math.max(ans, data[i][j]*data[i+1][j+1]*data[i+2][j+2]*data[i+3][j+3]);
				if((i-3)>=0 && (j+3)<20)
					ans = Math.max(ans, data[i][j]*data[i-1][j+1]*data[i-2][j+2]*data[i-3][j+3]);
			}
		}
		System.out.println(ans);
		sc.close();
	}

}
