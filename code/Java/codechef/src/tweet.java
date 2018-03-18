import java.util.*;

public class tweet {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt(),ans=0,temp;
		boolean[] button = new boolean[n];
		String str;
		String[] split = new String[2];
 		sc.nextLine();
		while(k-->0)
		{
			str=sc.nextLine();
			if(str.charAt(2)!='O')
			{
				split=str.split(" ");
				temp=Integer.parseInt(split[1]);
				if(!button[temp-1])
				{
					button[temp-1]=true;
					ans++;
				}
				else
				{
					button[temp-1]=false;
					ans--;
				}
			}
			else
			{
				for(int i=0;i<n;i++)
				{
					button[i]=false;
				}
				ans=0;
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
