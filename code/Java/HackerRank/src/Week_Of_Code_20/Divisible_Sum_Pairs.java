package Week_Of_Code_20;

import java.util.Scanner;

public class Divisible_Sum_Pairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt(),ans=0;
		int[] data = new int[n];
		
		for(int i=0;i<n;i++)
			data[i]=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if((data[i]+data[j])%k==0 /*&& ((data[i]+data[j])/k)%2==0 */)
					ans++;
			}
		}
		
		System.out.println(ans);
	}
}
