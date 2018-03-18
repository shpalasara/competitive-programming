import java.util.*;

public class Once_Again {

	public static void main(){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),T=sc.nextInt(),index=0;
		int[] data= new int[n];
		for(int i=0;i<n;i++)
		{
			data[i]=sc.nextInt();			
		}
		Arrays.sort(data);
		int[] count = new int[n];
		count[0]=1;
		
		for(int i=1;i<n;i++)
		{
			if(data[i]==data[i-1])
				count[index]++;
			else
			{
				count[++index]++;
			}		
		}
		sc.close();
	}
}
