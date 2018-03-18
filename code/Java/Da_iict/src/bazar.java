import java.util.*;

public class bazar {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		long m=sc.nextInt(),n=sc.nextInt(),max=0,count_0=0,index_max,col_ful=0,flop=0;
		String[] data = new String[(int)m];
		long[][] row_1 = new long[(int)m][2];
		long[] col_1 = new long[(int)n];
		boolean[] ans = new boolean[(int)n];
		boolean[] temp_ans = new boolean[(int)n];
		sc.nextLine();
		for(int i=0;i<m;i++)
		{
			row_1[i][1]=i;
			data[i] = sc.nextLine();
			for(int j=0;j<n;j++)
			{
				if(data[i].charAt(2*j)=='1')
				{
					row_1[i][0]++;
					col_1[j]++;
				}
			}
			if(row_1[i][0]>max)
			{
				max=row_1[i][0];
				index_max=i;
			}
		}
		for(int i=0;i<n;i++)
		{
			if(col_1[i]==0)
				count_0++;
			else if(col_1[i]==m)
				col_ful++;
		}
		
		//for(int i=0;i<n;i++)
		//	System.out.print(col_1[i]+" ");
		
		//System.out.println();
		if(max<count_0+col_ful)
			System.out.println(count_0+" "+col_ful+count_0);
		else
		{
			java.util.Arrays.sort(row_1, new java.util.Comparator<long[]>() {

				  public int compare(long[] a,long[] b) {

				    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));

				  }

				});
			//for(int i=0;i<n;i++)
				//System.out.println(row_1[i][0]+" "+row_1[i][1]);
			int temp=(int)m-1,temp_max_1=(int)max,temp_max_2=(int)max;
			for(int i=0;i<n;i++)
			{
				if(data[temp].charAt(2*i)=='1')
					ans[i]=true;
				else
					ans[i]=false;
			}
			temp--;
			while(row_1[temp][0]==max)
			{
				
				for(int i=0;i<n;i++)
				{
					temp_ans[i]=ans[i];
					if(data[temp].charAt(2*i)=='0' && ans[i])
					{
						temp_ans[i]=false;
						temp_max_1--;
					}
				}
				for(int i=0;i<n;i++)
				{
					temp_ans[i]=ans[i];
					if(data[temp].charAt(2*i)!='0' && ans[i])
					{
						ans[i]=false;
						temp_max_2--;
					}
				}
				if(temp_max_2<temp_max_1)
				{
					for(int i=0;i<n;i++)
						ans[i]=temp_ans[i];
				}
				else
				{
					temp_max_1=temp_max_2;
					flop++;
				}
				temp--;
			}
			if(temp_max_1<count_0+col_ful)
			{
				System.out.println(count_0+" "+col_ful+count_0);
			}
			else
			{
				while(temp>=0)
				{
					for(int i=0;i<n;i++)
					{
						temp_ans[i]=ans[i];
						if(data[temp].charAt(2*i)=='0' && ans[i])
						{
							temp_ans[i]=false;
							temp_max_1--;
						}
					}
					for(int i=0;i<n;i++)
					{
						temp_ans[i]=ans[i];
						if(data[temp].charAt(2*i)!='0' && ans[i])
						{
							ans[i]=false;
							temp_max_2--;
						}
					}
					if(temp_max_2<temp_max_1)
					{
						for(int i=0;i<n;i++)
							ans[i]=temp_ans[i];
					}
					else
						temp_max_1=temp_max_2;
					temp--;
				}

				if(temp_max_1<count_0+col_ful)
				{
					System.out.println(count_0+" "+col_ful+count_0);
				}
				else
				{
					//System.out.println();
				}
			}
		}
		sc.close();
	}
}
