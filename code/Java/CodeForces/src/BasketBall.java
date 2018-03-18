import java.util.*;

public class BasketBall {

	public static int n_count,m_count,n,m;
	public static int[] n_data,m_data;
	//public static int[] n_sum,m_sum;
	public static ArrayList<Integer> n_sum,m_sum;
	public static void main(String[] args){
		
		n_sum = new ArrayList<Integer>();
		m_sum = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();m=sc.nextInt();
		n_data = new int[n];
		m_data = new int[m];
		//n_sum = new int[1<<(n+1)];
		//m_sum = new int[1<<(m+1)];
		n_count=n;m_count=m;
		int ans=0;
		
		for(int i=0;i<n;i++)
			n_data[i]=sc.nextInt();
			//n_sum.add(sc.nextInt());
			//n_sum[i]=sc.nextInt();
		for(int i=0;i<m;i++)
			m_data[i]=sc.nextInt();
			//m_sum.add(sc.nextInt());
			//m_sum[i]=sc.nextInt();
		for(int i=0;i<n-1;i++)
			sum_maker_n(i+1,n_data[i],n);
		for(int i=0;i<m-1;i++)
			sum_maker_m(i+1,m_data[i],m);
		Collections.sort(n_sum);
		Collections.sort(m_sum);
		//Arrays.sort(n_sum, 0, n_count-1);
		//Arrays.sort(m_sum, 0, m_count-1);
		int j=0;
		for(int i=0;i<n_sum.size() && j<m_sum.size();i++)
		{
			while(i<n_sum.size() && n_sum.get(i)<m_sum.get(j))
				i++;
			while(j<m_sum.size() && n_sum.get(i)>m_sum.get(j))
				j++;
			if(n_sum.get(i)==m_sum.get(j))
			{
				while(i<n_sum.size() && n_sum.get(i++)==m_sum.get(j))
					ans++;
				while(j<m_sum.size() && n_sum.get(i-1)==m_sum.get(++j))
					ans++;
			}
		}
		System.out.println(ans);
		sc.close();
	}
	
	public static int sum_maker_n(int index,int sum,int total){
		
		if(index++>=total)
			return sum;
		n_sum.add(sum_maker_n(index,sum+n_data[index-1],total));
		n_sum.add(sum_maker_n(index,sum,total));
		return 0;
	}
	
	public static int sum_maker_m(int index,int sum,int total){
		
		if(index++>=total)
			return sum;
		m_sum.add(sum_maker_m(index,sum+m_data[index-1],total));
		m_sum.add(sum_maker_m(index,sum,total));
		return 0;
	}
}
