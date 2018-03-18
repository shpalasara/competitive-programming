import java.util.Scanner;


public class Maximum_Difference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(),n,max,min,ans;
		int[] data = new int[101];
		
		while(t-->0)
		{
			n=sc.nextInt();
			
			for(int i=0;i<n;i++)
				data[i]=sc.nextInt();
			
			max = data[n-1];
			min = data[n-1];
			ans=0;
			
			for(int i=n-2;i>=0;i--)
			{
				if(data[i]>max)
				{
					max = data[i];
					min = data[i];
				}
				else
					min = Math.min(min, data[i]);
				
				ans = Math.max(ans, max-min);
			}
			
			System.out.println(ans);
		}
		sc.close();
	}

}
