import java.util.*;

public class Terrible_Chandu {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t=Integer.parseInt(sc.nextLine());
		
		while(t-->0)
		{
			StringBuffer data = new StringBuffer(sc.nextLine());
			data.reverse();
			System.out.println(data);
		}
	}
}
