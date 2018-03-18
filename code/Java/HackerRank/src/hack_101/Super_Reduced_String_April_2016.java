package hack_101;

import java.util.*;

public class Super_Reduced_String_April_2016 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int length,index=0;
		String str,ans;
		
		
			str = sc.nextLine();
			ans = "";
			length = str.length();
			
			for(int i=0;i<length;i++)
			{
				if(ans.length()==0)
				{
					if(i<length-1 && str.charAt(i)==str.charAt(i+1))
						i++;
					else
					{
						ans+= str.charAt(i);
						index++;
					}
				}
				else
				{
					if(str.charAt(i)==ans.charAt(index-1))
					{
						ans = ans.substring(0, index-1);
						index--;
					}
					else if(i<length-1 && str.charAt(i)==str.charAt(i+1))
						i++;
					else
					{
						ans+= str.charAt(i);
						index++;
					}
				}
			}
			
			if(index==0 || ans.length()==0)
				System.out.println("Empty String");
			else
				System.out.println(ans);
			
		
		sc.close();
	}
}
