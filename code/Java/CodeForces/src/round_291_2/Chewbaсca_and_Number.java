package round_291_2;

import java.util.*;

public class Chewbaсca_and_Number {

	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		long x= sc.nextLong();
		long ans=0,temp=1,index;
		
		//String str = sc.nextLine(),ans;
		//int length=str.length();
		
		//for(int i=0;i<length;i++)
		//{
		//	if(str.ch)
		//}
		
		do
		{
			index=x%10;
			
			if(index>=5)
			{
				if(index!=9 || x/10!=0)
					index=9-index;
			}
			ans=ans+index*temp;
			
			x=x/(long)10;
			
			temp=temp*(long)10;
		} while(x!=0);
		
		System.out.println(ans);
		
		sc.close();
	}
}
