import java.util.*;

public class forgoten_language {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		while(T-->0)
		{
			int N = sc.nextInt(),K=sc.nextInt();
			sc.nextLine();
			String[] dict = sc.nextLine().split(" ");
			boolean[] check = new boolean[N];
			for(int i=0;i<N;i++)
				check[i]=false;
			
			for(int i=0;i<K;i++)
			{
				String[] temp = sc.nextLine().split(" ");
				for(int j=1;j<temp.length;j++)
				{
					for(int k=0;k<N;k++)
					{
						if(!check[k] && temp[j].compareToIgnoreCase(dict[k])==0)
						{
							check[k]=true;
						}
					}
				}
			}
			for(int i=0;i<N;i++)
			{
				if(check[i])
					System.out.print("YES ");
				else
					System.out.print("NO ");
			}
			System.out.println();
		}
		sc.close();
	}
}
