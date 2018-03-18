package round_353_2;

import java.util.Scanner;

public class Restoring_Painting {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n,a,b,c,d;
		long ans=0;
		
		n=sc.nextInt();
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		d=sc.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			if((i+b-c)>0 && (i+a-d)>0 && (i+a+b-c-d)>0 && (i+b-c)<=n && (i+a-d)<=n && (i+a+b-c-d)<=n)
				ans=ans+(long)n;
		}
		
		System.out.println(ans);
		sc.close();
	}
}
