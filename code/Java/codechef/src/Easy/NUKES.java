package Easy;

import java.util.*;

public class NUKES {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		long a,n,k,i;
		a=sc.nextInt();
		n=sc.nextInt();
		k=sc.nextInt();
		long[] out = new long[(int)k];
		
		n++;
		for(i=0;i<k;i++)
		{
			out[(int)i]=a%n;
			a/=n;
			//n*=n;
		}
		
		out[(int)k-1]%=(int)n+1;
		/*for(i=0;(i+n+1)<a;i+=n+1)
		{
			recur(out,1,n);
		}
		out[0]+=a-i;
		*/
		for(i=0;i<k;i++)
			System.out.print(out[(int)i]+" ");
	
		sc.close();
	}
	
	public static int recur(int[] out,int index,int n){
		
		out[index]++;
		
		if(out[index]>n)
		{
			out[index]=0;
			recur(out,index+1,n);
		}
		return 0;
	}
}
