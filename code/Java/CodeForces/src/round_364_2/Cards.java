package round_364_2;

import java.io.PrintWriter;
import java.util.Scanner;

public class Cards {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt(),sum=0;
		int[] data = new int[n];
		boolean[] check = new boolean[n];
		
		for(int i=0;i<n;i++)
		{
			data[i] = sc.nextInt();
			sum+=data[i];
		}
		
		sum = sum<<1;
		sum/=n;
		
		for(int i=0;i<n;i++)
		{
			if(!check[i])
			{
				out.print((i+1)+" ");
				
				for(int j=i+1;j<n;j++)
				{
					if(!check[j] && data[j]==sum-data[i])
					{
						check[j]=true;
						out.println(j+1);
						break;
					}
				}
				
				check[i]=true;
			}
		}
		
		out.close();
		sc.close();
	}

}
