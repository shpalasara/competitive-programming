package round_331_2;

import java.util.Scanner;

public class Wilbur_and_Swimming_Pool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),ans;
		int[][] data = new int[n][2];
		
		for(int i=0;i<n;i++)
		{
			data[i][0] = sc.nextInt();
			data[i][1] = sc.nextInt();
		}
		
		if(n==1)
			System.out.println("-1");
		else if(n==2)
		{
			if(data[0][0]==data[1][0] || data[0][1]==data[1][1])
				System.out.println("-1");
			else
				System.out.println(Math.abs(data[0][0]-data[1][0])*Math.abs(data[0][1]-data[1][1]));
		}
		else if(n==3)
		{
			double dist1,dist2,dist3;
			dist1 = Math.pow((data[0][0]-data[1][0]),2)+Math.pow((data[0][1]-data[1][1]),2);
			dist2 = Math.pow((data[0][0]-data[2][0]),2)+Math.pow((data[0][1]-data[2][1]),2);
			dist3 = Math.pow((data[1][0]-data[2][0]),2)+Math.pow((data[1][1]-data[2][1]),2);
			
			if(dist1==dist2+dist3)
			{
				System.out.println((int)Math.sqrt(dist2*dist3));
			}
			else if(dist2==dist3+dist1)
			{
				System.out.println((int)Math.sqrt(dist1*dist3));
			}
			else if(dist3==dist1+dist2)
			{
				System.out.println((int)Math.sqrt(dist1*dist2));
			}
			else
				System.out.println("-1");
			
			//int m1 = (data[0][1]-data[1][1])/(data[][])
//			if(data[0][0]==data[1][0] && data[1][1]==data[2][1])
//			{
//				System.out.println(Math.abs(data[0][0]-data[2][0])*Math.abs(data[0][1]-data[2][1]));
//				if(data[0][1]==data[2][1])
//					System.out.println(Math.abs(data[0][1]-data[1][1])*Math.abs(data[0][0]-data[2][0]));
//				else if(data[1][1]==data[2][1])
//					System.out.println(Math.abs(data[0][1]-data[1][1])*Math.abs(data[1][0]-data[2][0]));
//				else
//				System.out.println("-1");
//			}
//			else if(data[1][0]==data[2][0] && data[2][1]==data[0][1])
//			{
//				System.out.println(Math.abs(data[0][0]-data[1][0])*Math.abs(data[0][1]-data[1][1]));
//			}
//			else if(data[2][0]==data[0][0] || data[0][1]==data[1][1])
//			{
//				System.out.println(Math.abs(data[1][0]-data[2][0])*Math.abs(data[1][1]-data[2][1]));
//			}
//			else
//				System.out.println("-1");
		}
		else
		{
			double dist1,dist2,dist3;
			dist1 = Math.pow((data[0][0]-data[1][0]),2)+Math.pow((data[0][1]-data[1][1]),2);
			dist2 = Math.pow((data[0][0]-data[2][0]),2)+Math.pow((data[0][1]-data[2][1]),2);
			dist3 = Math.pow((data[0][0]-data[3][0]),2)+Math.pow((data[0][1]-data[3][1]),2);
			
			if(dist1==dist2+dist3)
			{
				System.out.println((int)Math.sqrt(dist2*dist3));
			}
			else if(dist2==dist3+dist1)
			{
				System.out.println((int)Math.sqrt(dist1*dist3));
			}
			else if(dist3==dist1+dist2)
			{
				System.out.println((int)Math.sqrt(dist1*dist2));
			}
			else
				System.out.println("-1");
		}
		sc.close();
	}

}
