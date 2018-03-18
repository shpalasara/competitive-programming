import java.util.*;

public class OR_game {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt(),x=sc.nextInt();
		int[] data = new int[n];
		int[] prev = new int[n];
		int[] after = new int[n];
		
		//System.out.println("hello");
		for(int i=0;i<n;i++)
			data[i]=sc.nextInt();
		//Arrays.sort(data);
		
		prev[0]=0;
		for(int i=1;i<n;i++)
			prev[i]=prev[i-1]|data[i-1];
		
		after[n-1]=0;
		for(int i=n-2;i>=0;i--)
			after[i]=after[i+1]|data[i+1];
		
		long ans=0,max=data[0];
		long mul=1;
		for(int i=0;i<k;i++)
			mul*=x;
		
		ans=(mul*data[0])|after[0]|prev[0];
		
		//System.out.println("fine");
		for(int i=1;i<n;i++)
		{
			if(ans < ((mul*data[i])|after[i]|prev[i]))
				ans=(mul*data[i])|after[i]|prev[i];
			//long temp=;
			/*if(((mul*max)|data[i]|ans)<((mul*data[i])|max|ans))
			{
				ans|=max;
				max=data[i];
			}
			else
				ans|=data[i];*/
		}
		//ans|=(mul*max);
		System.out.println(ans);
		sc.close();
	}
}
