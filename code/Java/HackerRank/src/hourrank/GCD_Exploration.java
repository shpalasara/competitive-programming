package hourrank;
import java.util.*;

public class GCD_Exploration {

	public static long length;
	public static String out="";
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		long n=sc.nextLong(),a=sc.nextLong(),b=sc.nextLong();
		
		length=gcd(a,b);
		String data=""+n;
		//System.out.println(length);
		out=output(data,1);
		System.out.println(out);
		sc.close();
	}
	
	public static String output(String data,long _temp)
	{
		if(_temp<=length)
		{
			String temp=data+data;
			out=output(temp,2*_temp);
			if(length>=_temp)
			{
				//System.out.println(length);
				length-=_temp;
				out+=data;
			}
			return out;
		}
		else
		{
			return "";
		}
	}
	
	public static long gcd(long a, long b)
	{
		long temp;
		if(a<b)
		{
			temp=b;
			b=a;
			a=temp;
		}
		while(b!=0)
		{
			temp=b;
			b=a%b;
			a=temp;
		}
		return a;
	}
}


/*
			data+=temp;
			//System.out.print(temp);
			//now+=_temp;
			length-=_temp;
			String out=output(data,temp+temp,length,now,2*_temp);
			if(_temp<=length)
			{
				//now+=_temp;
				length-=_temp;
				return(temp+out);
			}
			else
				return(out);
*/