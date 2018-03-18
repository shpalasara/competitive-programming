package codesprint;

import java.util.*;

public class Beautiful_Triplets {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),d=sc.nextInt(),temp,ans=0;
		int[] count = new int[20001];
		
		for(int i=0;i<n;i++)
		{
			temp=sc.nextInt();
			count[temp]++;
		}
		
		for(int i=0;i<20001;i++)
		{
			if(count[i]>0 && d+i<20001 && count[d+i]>0 && (2*d+i)<20001 && count[2*d+i]>0)
				ans+=count[i]*count[d+i]*count[2*d+i];
		}
		
		System.out.println(ans);
		sc.close();
	}
	
}
