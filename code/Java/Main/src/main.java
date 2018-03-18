import java.util.*;

public class main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		double temp=-5,ans=-25;
		
		System.out.println(temp+" "+ans);
		
		temp=sc.nextInt();
		temp/=ans;
		System.out.println(temp+" "+ans);
		if(temp<0)
			System.out.println("hello");
		sc.close();
	}
}
