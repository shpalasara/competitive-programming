package Easy;
import java.util.*;

public class CIELAB {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int A=sc.nextInt(),B=sc.nextInt(),ans,temp;
		ans=A-B;
		temp=ans%10;
		
		if(ans!=9)
			ans=ans-(temp)+(temp+1)%10;
		else
			ans=1;
		System.out.println(ans);
		sc.close();
	}
}