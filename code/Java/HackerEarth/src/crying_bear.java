import java.util.*;

public class crying_bear {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int[] cnt = new int[str.length()];
		int[] desh = new int[str.length()];
		long ans=0;
		int temp=0,total,count,cnt_desh=0,start=0,end=0,temp_start=0,temp_end=0,middle=0,temp_middle=0;
		boolean check=false;
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='_')
				cnt_desh++;
			if(str.charAt(i)==';')
			{
				if(check)
				{
					desh[i]=cnt_desh;
				}
				else
				{
					cnt_desh=0;
					check=true;
				}
				temp++;
				//index=i;
			}
			cnt[i]=temp;
		}
		
		
		total=temp;
		
		/*for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i)=='_' && str.charAt(i-1)==';')
			{
				count=1;
				while(++i<str.length() && str.charAt(i)=='_')
				{
					count++;
				}
				if(i<str.length() && str.charAt(i)!='_')
				{
					ans+=(power(count)*(long)cnt[i-count-1]*((long)total-(long)cnt[i-count-1]))%1000000007;
				}
				i--;
			}
		}*/
		int  i=0;
		check=false;
		while(str.charAt(i)!=';')
			i++;
		while(i<str.length())
		{
			
			while(i<str.length() && str.charAt(i)==';')
			{
				temp_start++;
				i++;
			}
			while(i<str.length() && str.charAt(i)=='_')
			{
				temp_middle++;
				i++;
			}
			while(i<str.length() && str.charAt(i)==';')
			{
				temp_end++;
				i++;
			}
			if(!check)
			{
				start=temp_start;
			}
		}
		//for(int i=0;i<str.length();i++)
		//{
			
		//}
		System.out.println(ans);
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
