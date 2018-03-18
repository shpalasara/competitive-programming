package VK_Cup;

import java.util.Scanner;

public class Bear_and_Game {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),t=0,t1,ans=15;
		
		while(n-->0)
		{
			t1=sc.nextInt();
			
			if((t1-t)>15)
				break;

			ans = Math.min(t1+15, 90);
			
			t=t1;
		}
		
		System.out.println(ans);
		sc.close();
	}

}
