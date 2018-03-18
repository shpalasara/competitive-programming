import java.util.*;

public class div_329_2 {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),x1=sc.nextInt(),x2=sc.nextInt(),k,b;
		long[][] y = new long[n][2];
		boolean check=false;
		
		for(int i=0;i<n;i++)
		{
			k=sc.nextInt();
			b=sc.nextInt();
			y[i][0]=(long)k*x1+(long)b;
			y[i][1]=(long)k*x2+(long)b;
		}
		java.util.Arrays.sort(y, new java.util.Comparator<long[]>() {

			  public int compare(long[] a, long[] b) {

			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? (a[1] < b[1] ? -1 : 1) : 1));

			  }
		});
		//Return 1 if a[0]-b[0]>0 else -1
		//Means it will swap in when the return value is -1
		
		
		for(int i=1;i<n;i++)
		{
			if(y[i][1]<y[i-1][1] && y[i][0]!=y[i-1][0])
			{
				check=true;
				break;
			}
		}
		
		if(check)
			System.out.println("YES");
		else
			System.out.println("NO");
		
		sc.close();
	}
}
