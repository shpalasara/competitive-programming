package CodeBar;

import java.util.*;

public class Semusa_Modified_Cipher {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(),n;
		long prev=0,now=1,temp;
		String ans="";
		char ch;
		
		for(int i=0;i<95;i++)
		{
			ch=(char)('A'+((now-1)%26));
			ans+=""+ch;
			temp=now+prev;
			prev=now;
			now=temp;
		}
		
		//System.out.println(ans.substring(0, 8));
		while(t-->0)
		{
			n=sc.nextInt();
			System.out.println(ans.substring(0, n));
		}
		
		sc.close();
	}
}
