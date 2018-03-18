package SnackDown_17;

import java.util.Scanner;

public class SNELECT {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		
		while(t-->0)
		{
			char[] str = sc.nextLine().toCharArray();
			boolean check = false,conv=false;
			
			for(int i=0;i<str.length;i++)
			{
				if(str[i]=='m')
				{
					if(i>0 && str[i-1]=='s')
						str[i-1] = '.';
					else if(i<str.length-1 && str[i+1]=='s')
						str[i+1] = '.';
				}
			}
			
			int s=0,m=0;
			
			for(int i=0;i<str.length;i++)
			{
				//System.out.print(str[i]);
				if(str[i]=='s')
					s++;
				else if(str[i]=='m')
					m++;
			}
//			System.out.println(s+" "+m);
			if(s>m)
				System.out.println("snakes");
			else if(s<m)
				System.out.println("mongooses");
			else
				System.out.println("tie");
		}
		
		sc.close();
	}
}
