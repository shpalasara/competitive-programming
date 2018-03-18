package Algorithm;

import java.util.*;

public class The_Love_Letter_Mystery {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t=Integer.parseInt(sc.nextLine()),ans,length;
		String data;
		
		while(t-->0)
		{
			ans=0;
			data=sc.nextLine();
			length=data.length();
			
			for(int i=0;i<length/2;i++)
				ans+=Math.abs(data.charAt(i)-data.charAt(length-1-i));
			
			System.out.println(ans);
		}
		sc.close();
	}
}
