package pizza_shop;

public class main {

	/**
	 * @param args
	 */

	public static int ans=0,new_ans=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "sabu";
		
		recur("",4,str);
		System.out.println(ans);
		System.out.println(new_ans);
	}
	
	public static void recur(String str,int in,String data){
		
		if(in==0)
		{
			int count=0,c=0;
			
			
			if(str.charAt(0)=='s')
				count++;
			if(str.charAt(1)=='a' )
				count++;
			if(str.charAt(2)=='b' )
				count++;
			if(str.charAt(3)=='u')
				count++;
			
			for(int i=0;i<4;i++)
			{
				if(str.charAt(i)=='a' || str.charAt(i)=='b' || str.charAt(i)=='u')
					c++;
				if(str.charAt(i)=='v' || str.charAt(i)=='w' || str.charAt(i)=='x' || str.charAt(i)=='y' || str.charAt(i)=='z')
					count=100;
			}
			
//			if(str.charAt(1)=='s' || str.charAt(1)=='a' || str.charAt(1)=='b' || str.charAt(1)=='u')
//				count++;
//			if(str.charAt(2)=='s' || str.charAt(2)=='a' || str.charAt(2)=='b' || str.charAt(2)=='u')
//				count++;
//			if(str.charAt(3)=='s' || str.charAt(3)=='a' || str.charAt(3)=='b' || str.charAt(3)=='u')
//				count++;
			
			if(count==1 && c>0)
			{
				ans++;
				if(str.charAt(0)=='s')
				{
					System.out.println(str);
					new_ans++;
				}
			}
			return ;
		}
		
		for(int i=0;i<26;i++)
			recur( str+""+(char)(i+'a'), in-1,data);
	}
}
