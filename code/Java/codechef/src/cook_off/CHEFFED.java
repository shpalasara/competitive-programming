package cook_off;

import java.util.Scanner;

public class CHEFFED {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),ans=0;
		int t1,t2,t3;
		int i = Math.max(n-100,1);
		
		for(;i<=n;i++)
		{
			t1 = i;
			t2 = sum_dig(t1);
			t3 = sum_dig(t2);
			
			if((t1+t2+t3)==n)
				ans++;
		}
		
		System.out.println(ans);
		
		sc.close();
	}

	public static int sum_dig(int data){
		
		int out=0;
		
		while(data!=0)
		{
			out+=data%10;
			data/=10;
		}
		
		return out;
	}
}
