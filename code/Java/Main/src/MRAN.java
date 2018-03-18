import java.util.Scanner;


public class MRAN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(),n=sc.nextInt();
		double[] pre = new double[t];
		double[] act = new double[t];
			
		System.out.println("Enter the predicated output :");
		
		for(int i=0;i<t;i++)
			pre[i] = sc.nextDouble();
		
		System.out.println("Enter the actual output :");
		
		for(int i=0;i<t;i++)
			act[i] = sc.nextDouble();
		
		int[][] diff = new int[n][n]; 
		
		// row --> actual ..... col --> predicted
		
		for(int i=0;i<t;i++)
			diff[(int)act[i]-1][(int)pre[i]-1]++;
		
		System.out.println("Overall Accuracy");
		
		int total_sum=0,mid=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==j)
					mid+=diff[i][j];
				total_sum+=diff[i][j];
			}
		}
		
		System.out.println(100*(((double)(mid))/((double)(total_sum))));
		
		double ans=0,geo_mean=1,temp;
		total_sum=0;
		
		System.out.println("Average Accuracy :");
		
		for(int i=0;i<n;i++)
		{
			total_sum = 0;
			for(int j=0;j<n;j++)
				total_sum+=diff[i][j];
			
			temp = (double)diff[i][i]/(double)total_sum;
			geo_mean = geo_mean*temp*100;
			ans+= temp;
		}
		
		geo_mean = Math.pow(geo_mean, (double)1/(double)n);
		ans = (ans*100)/n;
		System.out.println(ans);
		
		
		System.out.println("Geometric Mean Accuracy");
		System.out.println(geo_mean);
		
	}

}
