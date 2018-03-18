import java.util.*;

public class Barcode {

	public static long[][] nCr = new long[1001][1001];
	
	public static void main()
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt();
		int[] data = new int[k];
		for(int i=0;i<k;i++)
			data[i]=sc.nextInt();
		
		Arrays.sort(data);
		
		for(int i=0;i<k;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(data[j]%data[i]==0)
				{
					data[j]=0;
					break;
				}
			}
		}
		sc.close();
	}
}
