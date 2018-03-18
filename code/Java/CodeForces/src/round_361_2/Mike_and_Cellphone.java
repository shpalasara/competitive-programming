package round_361_2;

import java.util.Scanner;

public class Mike_and_Cellphone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		
		boolean left=false,right=false,up=false,bottom=false,zero=false;
		boolean[] check = new boolean[10];
		
		for(int i=0;i<n;i++)
		{
			check[str.charAt(i)-'0'] = true;
			
			if(str.charAt(i)=='1')
			{
				up = true;
				left = true;
			}
			else if(str.charAt(i)=='2')
			{
				up = true;
			}
			else if(str.charAt(i)=='3')
			{
				up = true;
				right = true;
			}
			else if(str.charAt(i)=='4')
			{
				left = true;
			}
			else if(str.charAt(i)=='5')
			{
				continue;
			}
			else if(str.charAt(i)=='6')
			{
				right = true;
			}
			else if(str.charAt(i)=='7')
			{
				left = true;
				bottom = true;
			}
			else if(str.charAt(i)=='8')
			{
				bottom = true;
			}
			else if(str.charAt(i)=='9')
			{
				bottom = true;
				right = true;
			}
			else
				zero = true;
		}
		
		if(!zero && check[8] && !check[7] && !check[9])
				System.out.println("NO");
		else if((zero && up) || (left && right && bottom && up))
			System.out.println("YES");
		else
			System.out.println("NO");
		sc.close();
	}

}
