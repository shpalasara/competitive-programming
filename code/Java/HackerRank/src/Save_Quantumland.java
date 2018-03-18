import java.util.*;

public class Save_Quantumland {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt(),n,ans;
		int[] data = new int[110];
		
		while(t-->0)
		{
			ans=0;
			n=sc.nextInt();
			data[0]=sc.nextInt();
			for(int i=1;i<n;i++)
			{
				data[i]=sc.nextInt();
				if(data[i]==0 && data[i-1]==0)
				{
					ans++;
					data[i]=1;
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
