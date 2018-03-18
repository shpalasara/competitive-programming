package Good_Bye_2015;

import java.util.Scanner;

public class New_Year_and_Days {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String str= sc.nextLine();
		String[] part = str.split(" ");
		int value = Integer.parseInt(part[0]),ans;
		
		if(part[2].equalsIgnoreCase("week"))
		{
			if(value<5)
				ans=(366-(3+value))/7+1;
			else
				ans=(366-(value-4))/7+1;
		}
		else
		{
			if(value<30)
				ans=12;
			else if(value==30)
				ans=11;
			else
				ans=7;
		}
		System.out.println(ans);
		 
		sc.close();
	}
}
