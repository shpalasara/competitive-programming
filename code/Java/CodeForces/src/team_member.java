import java.util.*;

public class team_member {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),temp,_max,_index;
		ArrayList<Integer> max = new ArrayList<Integer>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		//int[][] max = new int[2*n-1][3];
		int[] out = new int[2*n];
		
		for(int i=0;i<2*n-1;i++)
		{
			//max[i][0]=0;
			max.add(0);
			index.add(0);
			for(int j=0;j<=i;j++)
			{
				temp=sc.nextInt();
				if(temp>max.get(i)/*max[i][0]*/)
				{
					//max[i][0]=temp;
					max.set(i, temp);
					index.set(i, j+1);			//i should be i+2 and j should be j+1
					//max[i][1]=i+1;
					//max[i][2]=j;			//collumn number
				}
			}
		}
		
		/*java.util.Arrays.sort(max, new java.util.Comparator<int[]>() {

			  public int compare(int[] a,int[] b) {

			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));

			  }

			});

		for(int i=0;i<2*n-1;i++)
			System.out.println(max[i][0]+" "+max[i][1]+" "+max[i][2]);
		*/
		/*for(int i=2*n-2;i>=0;i--)
		{
			if(max[i][0]!=0)
			{
				out[max[i][1]]=max[i][2]+1;
				out[max[i][2]]=max[i][1]+1;
				if(max[i][2]<2*n-1)
					max[max[i][2]][0]=0;
			}
		}*/
		int i=0;
		while(i<2*n)
		{
			_max=max.get(0);
			_index=0;
			for(int j=1;j<max.size();j++)
			{
				if(_max<max.get(j))
				{
					_max=max.get(j);
					_index=j;
				}
			}
			//out[_index]=index.get(_index);
			//out[index.get(_index)]=_index+1;
			//max.set(_index, 0);
			//max.remove(_index-i);
			//if(index.get(_index)!=0)
			//	max.set(index.get(_index),0);
				//max.remove(index.get(_index-i));
			i+=2;
		}
		
		for(i=0;i<2*n;i++)
			System.out.print(out[i]+1+" ");
		sc.close();
	}
}
