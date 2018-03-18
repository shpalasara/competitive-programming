package daiict;

import java.util.*;

public class Grid_and_tiles {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int ans;
		
		if(n%2==0 || m%2==0)
			ans=(n*m)/2;
		else
		{
			if(n==1 && m==1)
				ans=1;
			else if(n==1)
				ans=(m-1)/2+1;
			else if(m==1)
				ans=(n-1)/2+1;
			else
				ans=(n*(m-1))/2+(n+1)/2;
		}
		System.out.println(ans);
		sc.close();
	}
}
