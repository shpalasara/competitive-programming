package Easy;
import java.util.*;

public class COOLING {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(),n,index_p,index_w,ans;
		
		while(t-->0)
		{
			ans=0;
			n=sc.nextInt();
			int[] pies = new int[n];
			int[] weight = new int[n];
			
			for(int i=0;i<n;i++)
				pies[i]=sc.nextInt();
			
			for(int i=0;i<n;i++)
				weight[i]=sc.nextInt();
			
			Arrays.sort(pies);
			Arrays.sort(weight);
			
			index_w=n-1;

			for(index_p=n-1;index_p>=0;index_p--)
			{
				if(pies[index_p]<=weight[index_w])
				{
					ans++;
					index_w--;
				}
			}
			System.out.println(ans);
		}
	}
}
