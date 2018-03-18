import java.util.*;

public class Grid_search {
	
	public static String[] data = new String[1000];
	public static String[] checker = new String[1000];
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int R,C,r,c;
		int T = sc.nextInt();
		while(T-->0)
		{
			R= sc.nextInt();
			C= sc.nextInt();
			sc.nextLine();
			for(int i=0;i<R;i++)
					data[i]=sc.nextLine();
			r= sc.nextInt();
			c= sc.nextInt();
			sc.nextLine();
			for(int i=0;i<r;i++)
				checker[i]=sc.nextLine();
			
			boolean stop=false,_stop=false;
			
			for(int i=0;i<R && !stop ;i++)
			{
				for(int j=0;j<C && !stop;j++)
				{
					_stop=false;
					if(checker[0].charAt(0)==data[i].charAt(j))
					{
						int k=0,l=0;
						for(k=0;k<r && !_stop;k++)
						{
							for(l=0;l<c && !_stop;l++)
							{
								if(i+k>=R || j+l>=C || checker[k].charAt(l)!=data[i+k].charAt(j+l))
									_stop=true;
								if(k==r-1 && l==c-1 && checker[k].charAt(l)==data[i+k].charAt(j+l))
									stop=true;
							}
						}
						//if(k==r && l==c)
						//	stop=true;
					}
				}
			}
			if(stop)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}
}
