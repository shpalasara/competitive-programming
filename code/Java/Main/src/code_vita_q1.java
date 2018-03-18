import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class code_vita_q1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean[] check = new boolean[6000001];
		ArrayList<Long> prime = new ArrayList<Long>();
		HashSet<Long> h = new HashSet<Long>();
		
		long su=0;
		
		for(int i=2;i<6000001;i++)
		{
			if(!check[i])
			{
				for(int j=i+i;j<6000001;j+=i)
					check[j]=true;
				
				prime.add((long)i);
				h.add((long)i);
				su+=(long)i;
			}
		}

		//System.out.println(su);
//		for(int i=0;i<100;i++)
//			System.out.println(prime.get(i));
//		
		int ans=0,i=2;
		
		long n = sc.nextLong(),sum=5; 
		
		while((n-sum)>=0 && i<prime.size())
		{
			if(sum<6000001)
			{
				if(h.contains(sum))
				{
					ans++;
					//System.out.println("HM "+sum);
				}
			}
			else
			{
				boolean prm = true;
				
				for(int j=2;j<=Math.sqrt(sum);j++)
				{
					if(sum%j==0)
					{
						prm = false;
						break;
					}
				}
				
				if(prm)
				{
					ans++;
					//System.out.println("n "+sum);
				}
			}
			
			sum = sum+prime.get(i++);
		}
		
		System.out.println(ans);
		
		sc.close();
	}

}
