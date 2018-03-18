package snapdeal;
import java.util.*;

public class q1 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),q=sc.nextInt();
		int[] data = new int[n];
		
		for(int i=0;i<n;i++)
			data[i]=sc.nextInt();
		
		int x,k,type,j;
		for(int i=0;i<q;i++)
		{
			x=sc.nextInt();
			k=sc.nextInt();
			type=sc.nextInt();
			if(type==0)
			{
				for(j=0;j<n;j++)
					if(data[j]>x)
						break;
				if(n-j+1>k)
					System.out.println(data[j+k-1]);
				else
					System.out.println("-1");
			}
			else
			{
				for(j=1;j<n;j++)
					if(data[j-1]<x && data[j]>=x)
						break;
				if(j>=k)
					System.out.println(data[j-k]);
				else
					System.out.println("-1");
			}
		}
		sc.close();
	}
}
