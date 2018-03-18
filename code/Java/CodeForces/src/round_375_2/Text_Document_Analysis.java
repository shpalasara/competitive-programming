package round_375_2;

import java.util.Scanner;

public class Text_Document_Analysis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String data = sc.nextLine();
		
		n = data.length();
		int ans1 = 0;
		int ans2 = 0;
		int i=0,temp;
		
		while(i<n)
		{
			while(i<n && data.charAt(i)=='_')
				i++;
			
			if(i<n && data.charAt(i)=='(')
			{
				i++;
				temp=0;
				while(i<n && data.charAt(i)!=')')
				{
					if(data.charAt(i)=='_')
					{
						if(temp>0)
							ans1++;
						temp=0;
					}
					else
						temp++;
					
					i++;
				}
				
				if(temp>0)
					ans1++;
				
				i++;
			}
//			else if(data.charAt(i)=='_')
//			{
//				i++;
//				temp=0;
//				while(i<n && data.charAt(i)!='_')
//				{
//					temp++;
//					i++;
//				}
//				ans2 = Math.max(ans2, temp);
//			}
			else
			{
				temp = 0;
				//i++;
				while(i<n && (data.charAt(i)!='_' && data.charAt(i)!='(' && data.charAt(i)!=')'))
				{
					temp++;
					i++;
				}
//				
//				if(data.charAt(i)=='_')
//					i++;
				
				ans2 = Math.max(ans2, temp);
			}
			
			//System.out.println(ans1+" "+ans2);
		}
		
		System.out.println(ans2+" "+ans1);
		
		sc.close();
	}

}
