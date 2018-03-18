import java.util.*;

public class fractions {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),min=3000;
		long sum=0,ans=3000000,temp;
		int[] data= new int[n];
		
		for(int i=0;i<n;i++)
		{
			data[i]=sc.nextInt();
			if(data[i]<min)
				min=data[i];
		}
		
		for(int i=min;i>0;i--)
		{
			//System.out.println("ans : "+i);
			sum=0;
			for(int j=0;j<n;j++)
			{
				temp=data[j]/i;
				while(temp!=1 && data[j]/(temp-1)==i)
					temp--;
				if(data[j]/temp!=i)
				{
					sum=3000000;
					break;
				}
				sum+=temp;
				//System.out.print(temp+" ");
			}
			if(sum<ans)
				ans=sum;
			//System.out.println();
		}
		System.out.println(ans);
		sc.close();
	}
}
