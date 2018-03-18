import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class moin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] data = str.split(",");
		pair[][] input = new pair[data.length][2];
		int[][] inp = new int[data.length][3];
		
		for(int i=0;i<data.length;i++)
		{
			String[] tmp;
			if(i==0)
				tmp = data[i].split("/");
			else
				tmp = data[i].substring(1).split("/");
			
			input[i][0] = new pair();
			input[i][1] = new pair();
			String[] t1 = tmp[0].split(":");
			//System.out.println(t1[0]);
			input[i][0].hh = Integer.parseInt(t1[0]);
			input[i][0].mm = Integer.parseInt(t1[1]);
			inp[i][0] = input[i][0].hh*60 + input[i][0].mm;
			
			String[] t2 = tmp[1].split(":");
			//System.out.println(t2[0]);
			input[i][1].hh = Integer.parseInt(t2[0]);
			input[i][1].mm = Integer.parseInt(t2[1]);
			inp[i][1] = input[i][1].hh*60 + input[i][1].mm;
			
			inp[i][2] = i;
		}
		
		java.util.Arrays.sort(inp, new java.util.Comparator<int[]>() {
		
			  public int compare(int[] a,int[] b) {
		
			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? (a[1] < b[1] ? -1 : 1) : 1));
		
			  }
		
			});
		
		int ans=1,index=0,in=0,temp_ans=1;
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for(int i=1;i<inp.length;i++)
		{
			while(!set.isEmpty() && set.first()<=inp[i][0])
			{
				temp_ans--;
				set.pollFirst();
			}
			if(inp[i][0]<inp[in][1])
			{
				temp_ans ++;
				if(temp_ans>ans)
				{
					ans = temp_ans;
					index = inp[i][2];
				}
				set.add(inp[i][1]);
			}
			else
			{
				in++;
				i = in;
				temp_ans = 1;
				set = new TreeSet<Integer>();
			}
		}
		
		System.out.println(ans);
		System.out.println(input[index][0].hh+":"+input[index][0].mm);
//		for(int i=0;i<input.length;i++)
//			System.out.println(input[i][0]+" "+input[i][1]);
		
		sc.close();
	}

	public static class pair {
		int hh;
		int mm;
	}
}
