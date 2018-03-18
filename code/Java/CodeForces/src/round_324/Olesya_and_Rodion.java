package round_324;
import java.util.*;

public class Olesya_and_Rodion {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),t=sc.nextInt();
		String str="";
		if(n==1 && t==10)
			System.out.println("-1");
		else
		{
			if(t!=10)
			{
				while(n-->0)
					str+=t;
			}
			else
			{
				while(n-->1)
					str+=1;
				str+=0;
			}
			System.out.println(str);
		}
		sc.close();
	}
}
