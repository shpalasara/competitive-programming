package wonder_fund;

import java.util.*;

public class Slime_Combining {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),i=1,index=0;
		
		while(n/i>0)
		{
			index++;
			i=i<<1;
		}
		
		i=i>>1;
			
		while(n>0 && i>0)
		{
			if(n>=i)
			{
				n-=i;
				System.out.print(index+" ");
			}
			index--;
			i=i>>1;
		}
		System.out.println();
		sc.close();
	}
}
