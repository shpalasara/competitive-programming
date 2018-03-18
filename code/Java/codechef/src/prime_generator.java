import java.util.*;

public class prime_generator {

	static boolean[] ans = new boolean[1000000001];
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(),start,end;
		boolean temp=false;
		ans[1]=true;
		
		for(int i=2;i<Math.sqrt(100000000);i++)
		{
			if(!ans[i])
			{
					long j=i*2,count=2;
					while(j<100000000)
					{
						ans[(int)j]=true;
						count++;
						j=i*count;
					}
				
			}
		}
		
		while(t-->0)
		{
			start=sc.nextInt();
			end=sc.nextInt();
			for(int i=start;i<=end;i++)
			{
				if(i<100000000-1)
				{
					if(!ans[i])
						System.out.println(i);
				}
				else
				{
					temp=false;
					for(int j=2;j<Math.sqrt(i);j++)
					{
						if(i%j==0)
						{
							temp=true;
							break;
						}
					}
					if(!temp)
						System.out.println(i);
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
