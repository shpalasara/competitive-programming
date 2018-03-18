import java.util.*;

public class guga_function {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),temp=2,_temp=2;
		long ans=0;
		if(n>2)
			ans=1;
		for(int i=n-1;i>2;i--)
		{
			_temp=2;
			temp=(temp*2)%1000000009;
			for(int j=n-i+1;j>2;j--)
			{
				_temp=(_temp*2)%1000000009;
				ans+=_temp;
			}
			ans+=temp;
		}
		System.out.println(ans);
		sc.close();
	}
}
