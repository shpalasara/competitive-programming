import java.util.*;

public class GCD_Table {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long[] data = new long[n*n];
		
		for(int i=0;i<n*n;i++)
			data[i]=sc.nextLong();
		
		Arrays.sort(data);
		
		//for(int i=0;i<n*n;i++)
			//System.out.print(data[i]+" ");
		
		int count=1;
		for(int i=n*n-2;i>=0;i--)
		{
			if(data[i]==data[i+1])
				count++;
			else
			{
				if(count%2==1)
				{
					System.out.print(data[i+1]+" ");
				}
				count=1;
			}
		}
		//if(data[0]!=data[1])
			//System.out.print(data[0]+" ");
		if(count==n*n)
		{
			for(int i=0;i<n;i++)
				System.out.print(data[i]+" ");
		}
		System.out.println();
		sc.close();
	}
}
