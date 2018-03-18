package May_16;

import java.util.*;

public class LADDU {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t=Integer.parseInt(sc.nextLine()),lines,laddus,rank,severity,ans;
		
		while(t-->0)
		{
			laddus=0;
			String[] str=sc.nextLine().split(" ");
			lines = Integer.parseInt(str[0]);
			
			while(lines-->0)
			{
				String[] data = sc.nextLine().split(" ");
				
				if(data[0].compareTo("CONTEST_WON")==0)
				{
					rank = Integer.parseInt(data[1]);
					
					if(rank<20)
						laddus+= 300+20-rank;
					else
						laddus+=300;
				}
				else if(data[0].charAt(0)=='T')
				{
					laddus+=300;
				}
				else if(data[0].charAt(0)=='B')
				{
					severity = Integer.parseInt(data[1]);
					laddus+=severity;
				}
				else
				{
					laddus+=50;
				}
			}
			
			if(str[1].charAt(0)=='N')
				ans=laddus/400;
			else
				ans=laddus/200;
			
			System.out.println(ans);
		}
		
		sc.close();
	}
}
