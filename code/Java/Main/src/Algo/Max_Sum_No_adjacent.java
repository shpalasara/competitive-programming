package Algo;

import java.util.Arrays;
import java.util.Scanner;

public class Max_Sum_No_adjacent {

	/**
	 * @param args
	 */
	
	static int[] data;
	static int[] ans;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(),n;
		
		while(t-->0)
		{
			n=sc.nextInt();
			data = new int[n];
			ans = new int[n];
			
			for(int i=0;i<n;i++)
				data[i]=sc.nextInt();
			
			if(n==1)
				System.out.println(data[0]);
			else if(n==2)
				System.out.println(Math.max(data[0], data[1]));
			else
			{
				ans[n-1] = data[n-1];
				ans[n-2] = Math.max(data[n-1], data[n-2]);
				
				System.out.println(answer(0,n));
			}
			
			Arrays.fill(data, 0);
			Arrays.fill(ans, 0);
		}
		sc.close();
	}
	
	public static int answer(int index,int n){
		
		//if(ans[index]!=0)
		if(index>=n-2 || (index<n && ans[index]!=0))
			return ans[index];
		
		ans[index] = Math.max(data[index]+answer(index+2,n), answer(index+1,n));
		
		return ans[index];
	} 

}
