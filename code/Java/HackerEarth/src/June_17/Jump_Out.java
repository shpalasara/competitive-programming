package June_17;

import java.util.Scanner;

public class Jump_Out {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans=n+1,temp;
		
		for(int i=0;i<n;i++)
		{
			temp = sc.nextInt();
			if(temp>=(n-i))
				ans = Math.min(ans, i+1);
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}
