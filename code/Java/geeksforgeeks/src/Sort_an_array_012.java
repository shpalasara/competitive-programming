import java.util.Scanner;


public class Sort_an_array_012 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(),n,ze,tw,cur,temp;
		int[] data = new int[101];
		
		while(t-->0)
		{
			n=sc.nextInt();
			
			for(int i=0;i<n;i++)
				data[i]=sc.nextInt();
			
			ze=0;
			cur=0;
			tw=n-1;
			
			
			while(cur<=tw)
			{
				if(data[cur]==0)
				{
					temp = data[ze];
					data[ze++]=0;
					data[cur++]=temp;
				}
				else if(data[cur]==1)
				{
					cur++;
				}
				else
				{
					temp = data[tw];
					data[tw--] = 2;
					data[cur] = temp;
				}
			}
			
			for(int i=0;i<n;i++)
				System.out.print(data[i]+" ");
			System.out.println();
		}
		sc.close();
	}

}
