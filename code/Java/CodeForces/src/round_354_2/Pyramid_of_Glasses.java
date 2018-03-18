package round_354_2;

import java.util.Scanner;

public class Pyramid_of_Glasses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),t=sc.nextInt(),temp_ans=0;
		double[][] data = new double[11][11];
		//int[] ans = new int[t+1];
		boolean check; 
		
		for(int i=1;i<t+1;i++)
		{
			data[0][0]+=1;
			if(i==1)
				temp_ans=1;
			
			for(int j=1;j<n;j++)
			{
				for(int k=0;k<j+1 && k<n;k++)
				{
					check = false;
					
					if(data[j][k]<1)
						check = true;
					
					if(k==0)
					{
						if(data[j-1][0]>1)
							data[j][0]+= ((double)data[j-1][0]-1)/2;
					}
					else if(k==j)
					{
						if(data[j-1][k-1]>1)
							data[j][k]+= ((double)data[j-1][k-1]-1)/2;
					}
					else
					{
						if(data[j-1][k]>1)
							data[j][k]+=((double)data[j-1][k]-1)/2;
						if(data[j-1][k-1]>1)
							data[j][k]+=((double)data[j-1][k-1]-1)/2;
					}
						
					if(data[j][k]>=1 && check)
						temp_ans++;
				}
				
				for(int k=0;k<j;k++)
				{
					if(data[j-1][k]>1)
						data[j-1][k]=1;
				}
			}
			
//			for(int j=0;j<n;j++)
//			{
//				for(int k=0;k<=j;k++)
//					System.out.print(data[j][k]+" ");
//				System.out.println();
//			}
//			
//			System.out.println(temp_ans);
			
			//ans[i]=temp_ans;
		}
		
		
		System.out.println(temp_ans);
		sc.close();
	}

}
