package summer_long_1;

// wrong approach

import java.util.Scanner;

public class Aryans_stuck_again {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.nextLine());
		String text,script;
		int[] sum = new int[100001];
		int text_sum,length;
		boolean check;
		
		while(t-->0)
		{
			check = false;
			text_sum = 0;
			text = sc.nextLine();
			script = sc.nextLine();
			length = text.length();
			
			for(int i=0;i<length;i++)
				text_sum+=text.charAt(i)-'a';
			
			sum[0] = script.charAt(0)-'a';
			for(int i=1;i<script.length();i++)
				sum[i] = sum[i-1]+(script.charAt(i)-'a');
			
			if(sum[length-1]==text_sum)
				System.out.println("YES");
			else
			{
				for(int i=0;i<script.length()-length;i++)
				{
					if(sum[length+i]-sum[i]==text_sum)
					{
						check=true;
						break;
					}
				}
				
				if(check)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

}
