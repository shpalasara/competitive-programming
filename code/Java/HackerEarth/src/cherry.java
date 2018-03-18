import java.util.*;

public class cherry {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(),N,total;
		while(T-->0)
		{
			N=sc.nextInt();
			total=0;
			sc.nextLine();
			int[] row = new int[N];
			int[] col = new int[N];
			for(int i=0;i<N;i++)
			{
				String str=sc.nextLine();
				for(int j=0;j<N;j++)
				{
					if(str.charAt(j)=='#')
					{
						row[i]++;
						col[j]++;
						total++;
					}
				}
			}
			if(total%2==0)
			{
				int temp=0,i;
				for(i=0;i<N;i++)
				{
					temp+=row[i];
					if(temp==total/2)
						break;
				}
				if(i!=N)
					System.out.println("YES");
				else
				{
					temp=0;
					for(i=0;i<N;i++)
					{
						temp+=col[i];
						if(temp==total/2)
							break;
					}
					if(i!=N)
						System.out.println("YES");
					else
						System.out.println("NO");
				}
			}
			else
				System.out.println("NO");
		}
		sc.close();
	}
}
