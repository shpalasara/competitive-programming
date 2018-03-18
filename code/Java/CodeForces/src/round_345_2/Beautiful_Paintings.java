package round_345_2;

import java.util.Arrays;
import java.util.Scanner;

public class Beautiful_Paintings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int n=sc.nextInt(),ans=0,less=0,prev_less=1;
			int[] data =  new int[n];
			
			for(int i=0;i<n;i++)
				data[i]=sc.nextInt();
			
			Arrays.sort(data);
			int i=1;
			
			while(i<n && data[i-1]==data[i])
			{
				prev_less++;
				i++;
			}	
			
			while(i<n)
			{
				less=1;
				while(i+1<n && data[i]==data[i+1])
				{
					less++;
					i++;
				}	
				
				ans+= Math.min(prev_less, less);
				prev_less = Math.max(prev_less, less);
				i++;
			}
			
			System.out.println(ans);
			sc.close();
	}

}
