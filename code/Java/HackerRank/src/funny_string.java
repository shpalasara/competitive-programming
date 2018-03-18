import java.util.*;

public class funny_string {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
			String str = sc.nextLine();
			int length=str.length(),i;
			for(i=0;i<length/2;i++)
			{
				if(Math.abs(str.charAt(i)-str.charAt(i+1))!=Math.abs(str.charAt(length-i-1)-str.charAt(length-i-2)))
					break;
			}
			if(i==length/2)
				System.out.println("Funny");
			else
				System.out.println("Not Funny");
		}
		sc.close();
	}
}
