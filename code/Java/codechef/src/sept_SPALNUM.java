import java.util.*;

public class sept_SPALNUM {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(),L,R;
		long ans;
		boolean[] palindrom = new boolean[100010];
		for(int i=1;i<10;i++)
			palindrom[i]=true;
		for(int i=10;i<100010;i++)
		{
			int j;
			String temp=""+i;
			for(j=0;j<temp.length()/2;j++)
			{
				if(temp.charAt(j)!=temp.charAt(temp.length()-j-1))
					break;
			}
			if(j==temp.length()/2)
				palindrom[i]=true;
			else
				palindrom[i]=false;
		}
		while(T-->0)
		{
			ans=0;
			L=sc.nextInt();
			R=sc.nextInt();
			for(int i=L;i<=R;i++)
			{
				if(palindrom[i])
					ans+=i;
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
