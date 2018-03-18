package round_345_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Watchmen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),count;
		int[][] data = new int[n][3];
		long ans=0;
		
		for(int i=0;i<n;i++)
		{
			data[i][0]=sc.nextInt();
			data[i][1]=sc.nextInt();
			data[i][2]=i;
		}
		
		java.util.Arrays.sort(data, new java.util.Comparator<int[]>() {

			  public int compare(int[] a,int[] b) {

			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));

			  }

			});
		
		count=1;
		for(int i=0;i<n-1;i++)
		{
			if(data[i][0]==data[i+1][0])
				count++;
			else
			{
				ans+= ((long)count*(long)(count-1))/2;
				count=1;
			}
		}
		ans+= ((long)count*(long)(count-1))/2;
		
		//System.out.println(ans);
		
		java.util.Arrays.sort(data, new java.util.Comparator<int[]>() {

			  public int compare(int[] a,int[] b) {

			    return (a[1] < b[1] ? -1 : (a[1] == b[1] ? 0 : 1));

			  }

			});
		
//		System.out.println();
//		for(int i=0;i<n;i++)
//			System.out.println(data[i][0]+" "+data[i][1]);
//		
//		System.out.println();
		
		count=1;
		for(int i=0;i<n-1;i++)
		{
			if(data[i][1]==data[i+1][1])
				count++;
			else
			{
				ans+= ((long)count*(long)(count-1))/2;
				count=1;
			}
		}
		ans+= ((long)count*(long)(count-1))/2;
		
		//System.out.println(ans);
		
		java.util.Arrays.sort(data, new java.util.Comparator<int[]>() {

			  public int compare(int[] a,int[] b) {

			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? (a[1] < b[1] ? -1 : a[1] == b[1] ? 0 : 1) : 1));
			  }

			});
		
		count=1;
		for(int i=0;i<n-1;i++)
		{
			if(data[i][0]==data[i+1][0] && data[i][1]==data[i+1][1])
				count++;
			else
			{
				ans-= ((long)count*(long)(count-1))/2;
				count=1;
			}
		}
		ans-= ((long)count*(long)(count-1))/2;
		
		System.out.println(ans);
		
		sc.close();
	}

}
