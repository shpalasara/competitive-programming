package LT_16_March;

import java.util.*;

public class ABABAABA {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T=Integer.parseInt(sc.nextLine()),index,length,a,b;
		String str,ans;
		int[] count_a = new int[5001];
		int[] count_b = new int[5001];
		
		while(T-->0)
		{
			a=0;
			b=0;
			
			index=-1;
			str=sc.nextLine();
			length=str.length();
			
			for(int i=0;i<length && index==-1;i++)
			{
				if(str.charAt(i)=='A')
					a++;
				else
					b++;
				
				if(i+1<length && str.charAt(i)==str.charAt(i+1) && (i+2>=length || str.charAt(i)!=str.charAt(i+2)) && (i==0 || str.charAt(i-1)!=str.charAt(i)))
					index=i;
			}
			
			if(index!=-1)
			{
				ans=str.substring(0, index)+str.substring(index+1);
				System.out.println(ans);
			}
			else
			{
				if(a==2)
					System.out.println("A");
				else if(b==2)
					System.out.println("B");
				else
					System.out.println("-1");
			}
			
		}
		sc.close();
	}
}
