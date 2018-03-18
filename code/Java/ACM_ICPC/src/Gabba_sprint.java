import java.util.*;

public class Gabba_sprint {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T,m,n,s,p,q,temp;
		int[] virat = new int[100010];
		int[] rohit = new int[100010];
		
		T=sc.nextInt();
		while(T-->0)
		{
			n=sc.nextInt();
			m=sc.nextInt();
			s=sc.nextInt();
			p=sc.nextInt();
			q=sc.nextInt();
			
			
			if(p+1>n)
			{
					virat[0]=m+(p+1-m+1)%(n-m+1);
					
			}
			else
				virat[0]=p+1;
				
			for(int i=1;i<s;i++)
			{
					if(virat[i-1]+p>n)
						virat[i]=m+(virat[i-1]+p-m+1)%(n-m+1);
					else
						virat[i]=p+virat[i-1];
			}
			

			for(int i=0;i<s;i++)
				System.out.print(virat[i]+" ");
			System.out.println();
			
			if(q+1>n)
			{
				if(m!=1)
					rohit[0]=m+(q+1-m+1)%(n-m+1);
				else
					rohit[0]=(q+1)%(n+1);
			}
			else
				rohit[0]=q+1;
				
			for(int i=1;i<s;i++)
			{
				if(m!=0)
				{
					if(rohit[i-1]+q>n)
						rohit[i]=m+(rohit[i-1]+q-m+1)%(n-m+1);
					else
						rohit[i]=q+rohit[i-1];
				}
				else
				{
					//if(rohit[i-1]+q>n)
						rohit[i]=(rohit[i-1]+q)%(n);
						if(rohit[i]==0)
							rohit[i]=n;
					//else
					//	rohit[i]=rohit[i-1]+q;
				}
			}
			
			
			for(int i=0;i<s;i++)
				System.out.print(rohit[i]+" ");
			System.out.println();
			
			long ans=0;
			for(int i=0;i<s;i++)
			{
				
				if(virat[i]==rohit[i])
					ans++;
				virat[i]=0;
				rohit[i]=0;
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
// 20 13 15 5 12