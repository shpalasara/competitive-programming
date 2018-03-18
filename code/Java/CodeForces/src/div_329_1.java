import java.util.*;

public class div_329_1 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),t,ans=0;
		int[][] count = new int[n][26];
		boolean[] ok = new boolean[n];
		int[][] c_final = new int[n][3];
		String temp;
		sc.nextLine();
		
		for(int i=0;i<n;i++)
		{
			ok[i]=true;
			t=0;
			temp=sc.nextLine();
			for(int j=0;j<temp.length() && t<3;j++)
			{
				if(count[i][temp.charAt(j)-'a']==0)
					t++;
				count[i][temp.charAt(j)-'a']++;
			}
			if(t<3)
			{
				c_final[i][2]=t;
				c_final[i][0]=temp.charAt(0)-'a';
				for(int j=1;j<temp.length() && t>1;j++)
				{
					if(temp.charAt(j)!=temp.charAt(0))
					{
						c_final[i][1]=temp.charAt(j)-'a';
						break;
					}
				}
			}
			else
				ok[i]=false;
		}
		
		for(int i=0;i<26;i++)
		{
			for(int j=i+1;j<26;j++)
			{
				t=0;
				for(int k=0;k<n;k++)
				{
					if(ok[k])
					{
						//System.out.print("Hii  ");
						if((c_final[k][2]==2 && ((i==c_final[k][0] && j==c_final[k][1]) || (j==c_final[k][0] && i==c_final[k][1]))) || (c_final[k][2]==1 && (i==c_final[k][0] || j==c_final[k][0])))
						{
							if(c_final[k][2]==2)
								t+=count[k][c_final[k][0]]+count[k][c_final[k][1]];
							else
								t+=count[k][c_final[k][0]];
							//System.out.print(k+" ");
						}
					}
				}
				//System.out.println();
				if(t>ans)
					ans=t;
				//System.out.println(t);
			}
		}
		/*for(int i=0;i<n;i++)
		{
			if(ok[i])
			{
				for(int j=0;j<26;j++)
				{
					System.out.print(count[i][j]+" ");
				}
				System.out.println();
			}
			else
				System.out.println(i);
		}*/
		System.out.println(ans);
		sc.close();
	}
}
