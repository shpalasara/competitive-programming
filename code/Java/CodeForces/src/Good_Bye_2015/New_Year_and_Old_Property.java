package Good_Bye_2015;

import java.util.*;

public class New_Year_and_Old_Property {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		long a =sc.nextLong(),b=sc.nextLong(),temp=1,t,t2,ans=0;
		int length_a=0,length_b=0;
		
		while((a/temp)!=0)
		{
			length_a++;
			temp*=2;
		}
		
		temp=1;
		while((b/temp)!=0)
		{
			length_b++;
			temp*=2;
		}
		
		//System.out.println("a "+length_a+" b "+length_b);
		
		if(length_a<length_b)
		{
			if(length_a>=2)
			{
				temp=((long)1<<(length_a))-1;
				t=1;
				//System.out.println("temp "+temp);
				
				t2=temp & (~t);
				while(t2>=a)
				{
					ans++;
					t=t<<1;
					t2=temp & (~t);
				}
			}
			
			for(int i=length_a+1;i<length_b;i++)
				ans+=(i-1);
			
			//System.out.println(ans);
			
			if(length_b>=2)
			{
				temp=((long)1<<(length_b))-1;
				t=((long)1)<<(length_b-2);
				//System.out.println("temp "+temp);
				
				t2=temp & (~t);
				while(t>0 && t2>=a && t2<=b)
				{
					ans++;
					t=t>>1;
					t2=temp & (~t);
				}
			}
		}
		else
		{
			temp=((long)1<<(length_a))-1;
			t=1;
			//System.out.println("temp "+temp);
			t2=temp & (~t);
			while(t2>b)
			{
				t=t<<1;
				t2=temp & (~t);
				//System.out.println("t2 "+t2);
			}
			//System.out.println("hii "+t2);	
			while(t2>=a && t2<=b)
			{
				ans++;
				t=t<<1;
				t2=temp & (~t);
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
