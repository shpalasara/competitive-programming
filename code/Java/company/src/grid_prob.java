import java.util.Scanner;


public class grid_prob {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hii");
		System.out.println(args[0]+" ");
		
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt(),c = sc.nextInt();
		int[][] colour = new int[r][c];
		
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				colour[i][j] = sc.nextInt();
			}
		}
		
		int[][] col_up = new int[c][3];
		int[][] col_bot = new int[c][3];
		
		for(int i=0;i<c;i++)
		{
			col_up[i][0] = Integer.MAX_VALUE;
			col_up[i][1] = Integer.MAX_VALUE;
			col_up[i][2] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<c;i++)
		{
			col_bot[i][0] = Integer.MIN_VALUE;
			col_bot[i][1] = Integer.MIN_VALUE;
			col_bot[i][2] = Integer.MIN_VALUE;
		}
		
		int[][] row_up = new int[r][3];
		int[][] row_bot = new int[r][3];
		
		for(int i=0;i<r;i++)
		{
			row_up[i][0] = Integer.MAX_VALUE;
			row_up[i][1] = Integer.MAX_VALUE;
			row_up[i][2] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<r;i++)
		{
			row_bot[i][0] = Integer.MIN_VALUE;
			row_bot[i][1] = Integer.MIN_VALUE;
			row_bot[i][2] = Integer.MIN_VALUE;
		}
		
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				col_up[j][colour[i][j]] = Math.min(col_up[j][colour[i][j]], i);
				col_bot[j][colour[i][j]] = Math.max(col_bot[j][colour[i][j]], i);
				
				row_up[i][colour[i][j]] = Math.min(row_up[i][colour[i][j]], j);
				row_bot[i][colour[i][j]] = Math.max(row_bot[i][colour[i][j]], j);
			}
		}
		
		double ans=0.0,diff,hight;
		
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<3;j++)
			{
				for(int k=0;k<3;k++)
				{
					if(j!=k)
					{
						if(row_bot[i][k]!=Integer.MIN_VALUE && row_up[i][j]!=Integer.MAX_VALUE)
						{
							diff = (double)Math.abs(row_bot[i][k]-row_up[i][j]);
							hight = 0;
							
							for(int l=0;l<c;l++)
							{
								if(col_up[l][3-j-k]!=Integer.MAX_VALUE)
									hight = Math.max(hight, Math.abs(col_up[l][3-j-k]-i));
								
								if(col_bot[l][3-j-k]!=Integer.MIN_VALUE)
									hight = Math.max(hight, Math.abs(col_bot[l][3-j-k]-i));
							}
							
							ans = Math.max(ans, hight*diff);
						}
					}
				}
			}
		}
		
		System.out.println(ans/2);
		
		sc.close();
	}

}
