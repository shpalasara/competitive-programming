package round_428_2;

import java.util.Scanner;

public class Arya_and_Bran {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int ans=1000,temp,left;
		
		int pre_sum;
		
		pre_sum = sc.nextInt();
		if(k<=8 && pre_sum>=k)
			ans = 1;
		left = Math.max(0, pre_sum-8);
		pre_sum -= left;
		for(int i=1;i<n;i++)
		{
			temp = sc.nextInt();
			if(temp>=8)
			{
				pre_sum += 8;
				left += temp-8;
			}
			else
			{
				left += temp;
				temp = Math.min(8, left);
				left -= temp;
				pre_sum += temp;
			}
			
			if(pre_sum>=k)
				ans = i+1;
		}
		
		if(ans==1000)
			System.out.println(-1);
		else
			System.out.println(ans);
		
		sc.close();
	}
}
