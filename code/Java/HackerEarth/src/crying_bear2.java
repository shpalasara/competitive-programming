import java.util.*;

public class crying_bear2 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String str= sc.nextLine();
		int[] desh = new int[str.length()];
		int[] coma = new int[str.length()];
		int i=0,count=0,total_desh=0,total_coma=0;
		long ans=0;
		
		
		while(str.charAt(i)=='_')
			i++;
		while(str.charAt(i)==';')
		{
			coma[count]++;
			total_coma++;
			i++;
		}
		while(i<str.length())
		{
			while(i<str.length() && str.charAt(i)=='_')
			{
				desh[count]++;
				total_desh++;
				i++;
			}
			if(i==str.length() && str.charAt(i-1)=='_')
			{
				total_desh-=desh[count];
				desh[count]=0;
			}
			count++;
			while(i<str.length() && str.charAt(i)==';')
			{
				coma[count]++;
				total_coma++;
				i++;
			}
		}
		
		//for(i=0;i<count;i++)
		//	System.out.println(coma[i]);
		//for(i=0;i<count;i++)
			//System.out.println(desh[i]);
		
		//System.out.println("check"+coma[2]);
			
		for(i=0;i<count;i++)
		{
			long _desh=desh[i];
			long prev=coma[i];
			long next=0;
			if(i+1<count)
				next=coma[i+1]; 
			
			for(int j=i;j<count;j++)
			{
				ans=(ans+power(_desh)*(long)prev*(next))%1000000007;
				_desh+=desh[j+1];
				//if(j+1<count)
					next+=coma[j+2];
				//else
					//next=0;
			}

			_desh=desh[i];
			prev=coma[i];
			//next=0;
			//if(i+1<count)
				next=coma[i+1]; 
			
			for(int j=i-1;j>=0;j--)
			{
				_desh+=desh[j];
				prev+=coma[j];
				//if(j<count)
					//next+=coma[j+1];
				//else
					//next=0;
				ans=(ans+power(_desh)*(long)prev*(next))%1000000007;
			}
		}
		System.out.println(ans%1000000007);
		sc.close();
	}
	
	public static long power(long x)
	{
		long ans=1;
		for(;x>32;x-=32)
		{
			ans=(ans<<16)%1000000007;
		}
		while(x>0)
		{
			ans=(ans*2)%1000000007;
			x--;
		}
		
		return (ans-1)%1000000007;
	}
}
