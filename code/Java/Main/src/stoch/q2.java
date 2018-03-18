package stoch;

import java.util.*;

public class q2 {
	
	static long[][] ncr = new long[105][105];
	
	public static double sn(int m,int n){
		
		double ans;
		if((n+m)%2==0)
			ans = ncr[n][(n+m)/2];
		else return 0;
		
		for(int i=1;i<=n;i++)
			ans /= 2;
		return ans;
	}
	
	public static double probab(int n,int r){
		double ans = 0.0;
		
		for(int i=r;i<=n;i++)
			ans += sn(i,n);
		
		for(int i=r-1;i>=0;i--)
			ans += sn(2*r-i,n);
		
		return ans;
	}
	
	public static void main(String[] args){
	
		ncr[0][0] = 1;
		ncr[1][1] = 1;
	
		int n=20,r=3;
		
		for(int i=2;i<=n;i++)
			ncr[i][0] = 1;
		
		for(int i=2;i<=n;i++){
			for(int j=1;j<=i;j++){
				ncr[i][j] = ncr[i-1][j-1] + ncr[i-1][j];
			}
		}
		
		Random rand = new Random();
		double temp;
		int x=0,ans=0,loop=10000;
		
		
		for(int i=0;i<loop;i++)
		{
			for(int j=0;j<n;j++)
			{
				temp=rand.nextDouble();
				
				if(temp>0.5)
					x++;
				else 
					x--;
				
				if(x>=r)
					break;
			}
			
			if(x>=r)
				ans++;
			x=0;
		}
		
		System.out.println("Practicaly P(M_100>=10) is :"+(double)ans/loop);
		
		System.out.println("Theoriticaly P(M_100>=10) is :"+probab(n,r));
	}
}
