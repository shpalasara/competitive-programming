package placement_drive;

import java.util.Arrays;
import java.util.Scanner;

public class T02_Q01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),diff,left,right;
		int[] data = new int[n];
		
		for(int i=0;i<n;i++)
			data[i] = sc.nextInt();
		
		Arrays.sort(data);
	
		left = data[n-2];
		right = data[n-3];
		diff = Math.max(data[n-1]-left, data[n-1]-right);
		
		for(int i=n-4;i>=0;i-=2)
		{
			diff = Math.max(diff, left-data[i]);
			left = data[i];
			
			if(i-1>=0)
			{
				diff = Math.max(diff, right-data[i-1]);
				right = data[i-1];
			}
		}
		diff = Math.max(diff, Math.abs(left-right));
		
		System.out.println(diff);
		sc.close();
	}

}
