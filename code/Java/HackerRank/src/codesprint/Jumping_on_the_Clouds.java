package codesprint;

import java.util.*;

public class Jumping_on_the_Clouds {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),ans=0;
		boolean[] data = new boolean[n];

		for(int i=0;i<n;i++)
		{
			if(sc.nextInt()==1)
				data[i]=true;
			else
				data[i]=false;
		}
		
		for(int i=0;i<n-1;i++)
		{
			if(i+2<n && !data[i+2])
			{
				i++;
				ans++;
			}
			else
			{
				ans++;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
