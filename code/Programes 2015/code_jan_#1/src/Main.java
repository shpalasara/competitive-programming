//Chef and Stones

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		//Enter The Number of Test Cases
		int T = sc.nextInt();
		int N;
		long K;
		while(T>0)
		{
			N = sc.nextInt();
			K = sc.nextLong();
			long[] A = new long[N];
			//long[] B = new long[N];
			
			for(int i=0;i<N;i++)
			{
				A[i] = sc.nextLong();
				A[i] = (int) K/A[i];
			}
			long largest = 0;
			long temp;
			
			for(int i=0;i<N;i++)
			{
				temp = sc.nextLong();
				if(largest<temp*A[i])
					largest = temp*A[i];
			}
				
			System.out.println(largest);
				//B[i] = sc.nextLong();
			T--;
		}
		
		sc.close();
	}
	
}
