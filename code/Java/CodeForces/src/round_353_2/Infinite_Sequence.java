package round_353_2;

import java.util.*;

public class Infinite_Sequence {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),diff;
		
		diff = b-a;
		
		if(diff==0)
			System.out.println("YES");
		else if(diff>0 && c>0)
		{
			if(diff%c==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		else if(diff<0 && c<0)
		{
			if(Math.abs(diff)%Math.abs(c)==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		else
			System.out.println("NO");
		
		sc.close();
	}
}
