import java.util.*;

public class team_member_2 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n,count=0,temp=0;
		n=sc.nextInt();
		int[][] data = new int[n*(2*n-1)][3];
		int[] out = new int[2*n];
		
		for(int i=0;i<2*n-1 && count<n*(2*n-1);i++)
		{
			for(int j=0;j<=i;j++)
			{
				data[count][0]=sc.nextInt();
				data[count][1]=i+2;
				data[count][2]=j+1;
				count++;
			}
		}
		
		java.util.Arrays.sort(data, new java.util.Comparator<int[]>() {

			  public int compare(int[] a,int[] b) {

			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));

			  }

			});
		//System.out.println(count);
		
		//for(int i=0;i<count;i++)
		//	System.out.println(data[i][0]+" "+data[i][1]+" "+data[i][2]+" ");
			
		for(int i=0;i<count && temp<2*n;i++)
		{
			if(out[data[n*(2*n-1)-i-1][1]-1]==0 && out[data[n*(2*n-1)-i-1][2]-1]==0)
			{
				out[data[n*(2*n-1)-i-1][1]-1]=data[n*(2*n-1)-i-1][2];
				out[data[n*(2*n-1)-i-1][2]-1]=data[n*(2*n-1)-i-1][1];
				temp+=2;
			}
		}
		
		for(int i=0;i<2*n;i++)
			System.out.print(out[i]+" ");
		
		System.out.println();
		sc.close();
	}
}
