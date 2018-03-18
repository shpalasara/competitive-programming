package educ_round_1;
import java.util.*;

public class Trricky_sum {

	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		long ans,i,n;
		while(t-->0)
		{
			n=sc.nextInt();
			ans=(n*(n+1))/2;
			for(i=1;i<=n;i*=2)
				ans-=2*i;
			System.out.println(ans);
		}
		sc.close();
	}
}
