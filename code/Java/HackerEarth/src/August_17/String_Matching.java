package August_17;

import java.util.Scanner;

public class String_Matching {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int n = Integer.parseInt(sc.nextLine());
		String[] data = sc.nextLine().split(" ");
		
		int[] val = new int[n];
		boolean[] check = new boolean[10];
		
		for(int i=0;i<n;i++)
		{
			val[i] = Integer.parseInt(data[i]);
			check[val[i]] = true;
		}	
		
		int count = 0,left=0,right=-1,ind,min;
		int[] index = new int[10];
		long ans=0;
		
		for(int i=0;i<10;i++)
			index[i] = -1;
		
		for(int i=0;i<str.length();i++)
		{
			if(check[str.charAt(i)-'0'])
			{
				if(index[str.charAt(i)-'0']==-1)
					count++;
				index[str.charAt(i)-'0'] = i;
			}
			
			if(count>=n)
			{
				min = 100001;
				ind = 0;
				
				for(int j=0;j<10;j++)
				{
					if(check[j] && min>index[j])
					{
						min = index[j];
						ind = j;
					}
				}
				
				if(right!=-1)
				{
					right = i-right;
					ans += (long)(right*(left+1));
				}	
				
				left = min;
				
				ans += (long)(left+1);
				index[ind] = -1;
				count--;
				right = i+1;
			}

//			System.out.println(ans);
		}
		
		if(ans!=0 && right!=-1)
		{
			right = str.length() - right;
//			System.out.println(left+" "+right);
			ans += right*(left+1);
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}
