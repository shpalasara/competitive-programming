package round_330_2;

import java.util.Scanner;

public class Vitaly_and_Night {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		int n=sc.nextInt(),m=sc.nextInt(),ans=0,a1,a2;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				a1=sc.nextInt();
				a2=sc.nextInt();
				if(a1==1 ||a2==1)
					ans++;
			}
		}
		
		System.out.println(ans);
		sc.close();
	}

}
