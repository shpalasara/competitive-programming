package hack_101_May_16;

import java.util.Arrays;
import java.util.Scanner;

public class Maximum_Perimeter_Triangle {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),ans=-1;
		int[] l = new int[n];
		
		for(int i=0;i<n;i++)
			l[i]=sc.nextInt();
		
		Arrays.sort(l);
		
		for(int i=n-3;i>=0;i--)
		{
			if(l[i]+l[i+1]>l[i+2])
			{
				ans=i;
				break;
			}
		}
		
		if(ans==-1)
			System.out.println(ans);
		else
			System.out.println(l[ans]+" "+l[ans+1]+" "+l[ans+2]);
		sc.close();
	}
}
