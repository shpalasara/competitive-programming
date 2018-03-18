package round_352_2;

import java.util.Scanner;

public class Summer_Camp {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String str="";
		int i=1;
		
		while(str.length()<1000)
		{
			str+=""+i;
			i++;
		}
		
		i=sc.nextInt();
		System.out.println(str.charAt(i-1));
		sc.close();
	}
}
