package round_359_2;

import java.util.Scanner;

public class Robbers_watch {

	/**
	 * @param args
	 */
	public static int ans=0;
	public static String str_n,str_m;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		
		int length_n = find_length_base_seven(n-1);
		int length_m = find_length_base_seven(m-1);
		
		str_n = generate_base_seven(n-1);
		str_m = generate_base_seven(m-1);
				
//		System.out.println(length_n);
//		System.out.println(length_m);

//		int temp = length_n;
//		for(int i=str_n.length();i<temp;i++)
//		{
//			//length_n++;
//			str_n +="0";
//		}
//		
//		temp = length_m;
//		for(int i=str_m.length();i<temp;i++)
//		{
//			//length_m++;
//			str_m +="0";
//		}

//		System.out.println(str_n);
//		System.out.println(str_m);
		
		if(length_n+length_m>7)
			System.out.println("0");
		else
		{
			String str = "";
			generate(length_n,length_m,0,str);
			System.out.println(ans);
		}
		
		sc.close();
	}
	
	public static void generate(int length_n,int length_m,int index,String str){
		
		if(index>=length_n+length_m)
		{
			if(check(str,length_n,length_m))
			{
//				System.out.println(str);
				ans++;
			}
			return;
		}
		
		String temp;
		
		for(int i=0;i<7;i++)
		{
			temp = str+""+i;
			generate(length_n,length_m,index+1,temp);
		}
	}
	
	public static boolean check(String str,int length_n,int length_m){
		
		int[] count = new int[7];
		
		for(int i=0;i<str.length();i++)
			count[str.charAt(i)-'0']++;
		
		if(count[0]<=1 && count[1]<=1 && count[2]<=1 && count[3]<=1 && count[4]<=1 && count[5]<=1 && count[6]<=1)
		{
			String n1 = str.substring(0, length_n);
			String m1 = str.substring(length_n);
			
			if(Integer.parseInt(n1)<=Integer.parseInt(str_n) && Integer.parseInt(m1)<=Integer.parseInt(str_m))
				return true;
		}
		
		return false;
	}

	public static int find_length_base_seven(int data){
		
		int up = 7,ans=1;
		
		while(data>=up)
		{
			ans++;
			up = up*7;
		}
		
		return ans;
	}
	
	public static String generate_base_seven(int data){
		
		int up=1,length=1,i;
		String str="";
		
		while((up*7)<=data)
		{
			up*=7;
			length++;
		}
		
		while(length>0)
		{
			if(data<up)
				str+="0";
			else
			{
				for(i=1;i<7;i++)
				{
					if(up*i<=data && up*(i+1)>data)
					{
						str += ""+i;
						data-=up*i;
						break;
					}
				}
			}
			
			up/=7;
			length--;
		}
		return str;
	}
}
