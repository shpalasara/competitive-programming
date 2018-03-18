package codesprint;

import java.util.Scanner;

public class Combination_Lock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] data = new int[5];
		int[] out = new int[5];
		
		for(int i=0;i<5;i++)
			data[i] = sc.nextInt();
		
		for(int i=0;i<5;i++)
			out[i] = sc.nextInt();
		
		int ans=0;
		
		for(int i=0;i<5;i++)
		{
			if(data[i]>out[i])
				ans += Math.min(data[i]-out[i], 9-data[i]+out[i]+1);
			else
				ans += Math.min(out[i]-data[i], 9-out[i]+data[i]+1);
		}
		
		System.out.println(ans);
		sc.close();
	}

}
