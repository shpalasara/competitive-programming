package November_15;
import java.util.*;

public class chef_and_cake {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(),temp;
		int n,m;
		while(t-->0)
		{
			n=sc.nextInt();
			m=sc.nextInt();
			
			if(n==1 || m==1)
				System.out.println("Yes");
			else if(m==0)
				System.out.println("No 1");
			else
			{
				if((temp=GCD(n,m))!=1)
					System.out.println("No "+n/temp);
				else
					System.out.println("Yes");
			}

		}
		sc.close();
	}
	public static int GCD(int a, int b)
	{
		int temp;
		if(a<b)
		{
			temp=b;
			b=a;
			a=temp;
		}
		while(b!=0)
		{
			temp=b;
			b=a%b;
			a=temp;
		}
		return a;
	}
}
