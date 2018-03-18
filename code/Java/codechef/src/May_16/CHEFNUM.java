package May_16;

import java.util.Scanner;

public class CHEFNUM {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		long[] pre_sum = new long[1000001];
		long ans;
		boolean[] check;
		String str;
		int length,temp,num;
		
		pre_sum[0]=0;
		
		for(int i=1;i<1000001;i++)
		{
			check = new boolean[17];
			ans=0;
			str = ""+i;
			length = str.length();
			
			for(int j=0;j<length;j++)
			{
				temp=0;
				for(int k=j;k<length;k++)
				{
					temp = temp ^ (int)(str.charAt(k)-'0');
					
					if(temp>=0 && temp<17 && !check[temp])
					{
						check[temp] = true;
						ans+=temp;
					}
				}
			}
			
			if(i<=250)
				System.out.println(i+" "+ans);
			
			pre_sum[i] = (pre_sum[i-1]+ans)%1000000007;
		}
		
		int t=sc.nextInt(),l,r;
		
		while(t-->0)
		{
			l=sc.nextInt();
			r=sc.nextInt();
			
			ans = (pre_sum[r]-pre_sum[l-1])%1000000007;
			
			if(ans<0)
				ans+=1000000007;
			
			System.out.println(ans);
		}
		sc.close();
	}
}
