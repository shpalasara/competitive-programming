import java.util.*;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N,ans=0,freq=0,temp;
		N=sc.nextInt();
		sc.nextInt();
		sc.nextLine();
		String[] data = new String[N];
		data[0]=sc.nextLine();
		for(int i=1;i<N;i++)
		{
			data[i]=sc.nextLine();
			for(int j=0;j<i;j++)
			{
				temp=OR(data[i],data[j]);
				if(temp>ans)
				{
					ans=temp;
					freq=1;
				}
				else if(temp==ans)
					freq++;
			}
		}
		System.out.println(ans+"\n"+freq);
		sc.close();
	}
	
	public static int OR(String one,String two)
	{
		int ans=0;
		for(int i=0;i<one.length();i++)
		{
			if(one.charAt(i)=='1' || two.charAt(i)=='1')
				ans++;
		}
		return ans;
	}
}
