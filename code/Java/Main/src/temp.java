import java.util.Scanner;


public class temp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
//		System.out.println(Integer.toBinaryString(n));
//		System.out.println(Integer.toBinaryString(-n));
		
		
		for(int i=1;i<n;i++)
			System.out.println(i+" "+Integer.toBinaryString(i & -i));
		
//		double e = Math.E - 2.0;
//		int ans,prev=-1 , i=1 , count=0 , pprev=0;
//		String str="";
//		long out = 0,out_1 = 0;
//		
//		for(i=1;i<=n;i++)
////		while(sc.nextInt()!=0)
//		{
//			ans = (int)Math.floor(e*(double)i);
////			i++;
//			if(ans==prev)
//			{
//				count++;
//				System.out.print((ans-pprev)+" ");
//				out_1 += (long)ans;
//				pprev = ans;
//			}
////				str += "1";
////			else if(i!=1)
////				str += "0";
//			prev = ans;
//			out += (long)ans;
////			System.out.print((i-1)+" "+ans+" ");
//		}
//		System.out.println();
//		System.out.println("ans "+out);
//		System.out.println("doubled "+out_1);
//		System.out.println("diff "+(out-out_1));
//		System.out.println(count);
		
//		int count = 0;
//		String str1 = "";
//		
//		for(int i=0;i<str.length();i++)
//		{
//			count = 0;
//			while(i<str.length() && str.charAt(i)=='0')
//			{
//				i++;
//				count++;
//			}
//			str1 += ""+count;
//		}
//		
//		for(int i=1;i<str1.length();i++)
//		{
//			if(str1.charAt(i)==str1.charAt(i-1))
//				System.out.print(1);
//			else
//				System.out.print(0);
//		}
		
//		int n = sc.nextInt();
//		String[] grid = new String[n];
//		
//		for(int i=0;i<n;i++)
//			grid[i] = sc.nextLine();
//		
//		int[] blue = new int[grid[0].length()];
//		
//		int[] red = new int[n];
//		
//		int[] green_c = new int[grid[0].length()];
//		int[] green_r = new int[n];
//		
//		int ans=0;
//		
//		for(int i=0;i<n;i++)
//		{
//			for(int j=0;j<grid[i].length();j++)
//			{
//				if(grid[i].charAt(j)=='B')
//					blue[j]++;
//				else if(grid[i].charAt(j)=='R')
//					red[i]++;
//				else if(grid[i].charAt(j)=='G')
//				{
//					green_c[j]++;
//					green_r[i]++;
//				}
//				else
//					continue;
//				
//				if(j>0 && grid[i].charAt(j)=='R' && grid[i].charAt(j-1)=='.')
//					ans++;
//				
//				if(i>0 && grid[i].charAt(j)=='B' && grid[i-1].charAt(j)=='.')
//					ans++;
//			}
//		}
//		
//		for(int i=0;i<blue.length;i++)
//		{
//			if(blue[i]>0)
//				ans++;
//		}
//		
//		for(int i=0;i<n;i++)
//		{
//			if(red[i]>0)
//				ans+=red[i];
//		}
//		
//		for(int i=0;i<green_c.length;i++)
//		{
//			if(green_c[i]>0 && blue[i]==0)
//				ans++;
//		}
//		
//		for(int i=0;i<n;i++)
//		{
//			if(green_r[i]>0 && red[i]==0)
//				ans++;
//		}
//		
//		System.out.println(ans);
		
		sc.close();
	}

}
