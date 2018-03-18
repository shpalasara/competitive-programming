package June_16;

import java.util.Scanner;

public class DEVARRAY {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n,q,min,max,t;
		n=sc.nextInt();
		q=sc.nextInt();
		
		min = max = sc.nextInt();
		
		for(int i=1;i<n;i++)
		{
			t=sc.nextInt();
			min = Math.min(min, t);
			max = Math.max(max, t);
		}
		
		while(q-->0)
		{
			t=sc.nextInt();
			
			if(t>=min && t<=max)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		sc.close();
	}

}
