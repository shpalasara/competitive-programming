import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner sc =new Scanner(System.in);
		String S1,S2 = new String();
		int output=0;
		S1 = sc.nextLine();
		S2 = sc.nextLine();
		String temp = S1;
		String _temp = S2;
		
		if(S1.length()<S2.length())
			System.out.println("0");
		else
		{
			for(int i=0;i<=S1.length()-S2.length();i++)
			{
				int j;
				for(j=i;j<i+S2.length() && j<S1.length();j++)
				{
					for(int k=0;k<S2.length();k++)
					{
						if(temp.charAt(j)==_temp.charAt(k))
						{
							if(temp.length()-1>j)
								temp = temp.substring(0,j)+'0'+temp.substring(j+1);
							else if(temp.length()-1==j)
								temp = temp.substring(0,j)+'0';
							if(_temp.length()-1>k)
								_temp = _temp.substring(0,k)+'x'+_temp.substring(k+1);
							else if(_temp.length()-1==k)
								_temp = _temp.substring(0,k)+'x';
							
							break;
						}
						
					}
				}
				
				for(j=i;j<i+S2.length();)
				{
					if(temp.charAt(j)!='0' && temp.charAt(j)!='?')
						break;
					j++;
				}
				
				if(j==i+S2.length())
					output++;
				
				temp = S1;
				_temp = S2;
			}
			System.out.println(output);
		}
		
		
		sc.close();
		
		
	}
}
