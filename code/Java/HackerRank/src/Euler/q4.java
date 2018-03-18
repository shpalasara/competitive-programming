package Euler;

import java.util.ArrayList;
import java.util.Scanner;

public class q4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(),n,temp,index;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=100000;i<1000000;i++)
		{
			if(palindrom(""+i))
			{
				//System.out.println(i);
				for(int j=100;j<1000;j++)
				{
					if(i%j==0)
					{
						temp = i/j;
						if(temp>=100 && temp<1000)
						{
							list.add(i);
							break;
						}	
					}
				}
			}
		}
		
		//System.out.println(list.size());
		
		//for(int i=0;i<list.size();i++)
		//	System.out.println(list.get(i));
		
		while(t-->0)
		{
			n = sc.nextInt();
			index = 0;
			temp = 0;
			
			while(index<list.size() && list.get(index)<=n)
				index++;
			
			System.out.println(list.get(index-1));
		}
		
		sc.close();
	}

	public static boolean palindrom(String str){
		
		int length = str.length();
		
		//System.out.println(str);
		
		for(int i=0;i<(length/2);i++)
		{
			if(str.charAt(i)!=str.charAt(length-i-1))
				return false;
		}
		
		return true;
	}
}
