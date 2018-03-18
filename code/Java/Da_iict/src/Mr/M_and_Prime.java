package Mr;

import java.util.ArrayList;
import java.util.Scanner;

public class M_and_Prime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean[] check = new boolean[20001];
		
		for(int i=2;i<20001;i++)
		{
			if(!check[i])
			{
				list.add(i);
				for(int j=i+i;j<20001;j+=i)
					check[j] = true;
			}
		}
		
//		for(int i=0;i<list.size();i++)
//			System.out.println(list.get(i));
		
		int n,ans;
		
		while(t-->0)
		{
			n = sc.nextInt();
			
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i)>=n)
				{
					if(i==0)
						ans = list.get(i);
					else
					{
						if((n-list.get(i-1)) > (list.get(i)-n))
							ans =  list.get(i) ; 
						else
							ans = list.get(i-1);
					}
					System.out.println(ans);
					break;
				}
			}
		}
		
		sc.close();
	}

}
