package round_354_2;

import java.util.Scanner;

public class Nicholas_and_Permutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int min,max,min_index=0,max_index=0,temp,ans;

		min=max=sc.nextInt();
		
		for(int i=1;i<n;i++)
		{
			temp=sc.nextInt();
			
			if(temp>max)
			{
				max=temp;
				max_index=i;
			}
			else if(temp<min)
			{
				min=temp;
				min_index=i;
			}
		}
		
		ans = Math.max(Math.max(max_index, min_index), Math.max(n-1-max_index, n-1-min_index));
		
		System.out.println(ans);
		sc.close();
	}

}
