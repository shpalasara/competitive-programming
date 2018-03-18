package round_331_2;

import java.util.Arrays;
import java.util.Scanner;

public class Wilbur_and_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] data = new int[n];
		long ans=0;
		
		for(int i=0;i<n;i++)
		{
			data[i]=sc.nextInt();
			if(i==0)
				ans = Math.abs(data[i]);
			else
				ans +=(long)Math.abs(data[i-1]-data[i]);
		}
		System.out.println(ans);
		sc.close();
	}

}
