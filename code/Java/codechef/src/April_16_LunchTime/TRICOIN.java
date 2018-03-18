package April_16_LunchTime;

import java.util.*;

public class TRICOIN {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		long n,temp;
		
		while(t-->0)
		{
			n=sc.nextLong();
			temp=(long)Math.sqrt(n);
			
			while((temp*(temp+1))/2<=n)
				temp++;
			
			System.out.println(temp-1);
		}
		sc.close();
	}
}
