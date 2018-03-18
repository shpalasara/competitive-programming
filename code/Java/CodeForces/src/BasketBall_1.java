import java.util.*;

public class BasketBall_1 {

    public static int n_count,m_count,n,m;
    public static int[] n_sum,m_sum;
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();m=sc.nextInt();
        n_sum = new int[1<<(n+1)];
        m_sum = new int[1<<(m+1)];
        n_count=n;m_count=m;
        int ans=0;
        
        for(int i=0;i<n;i++)
            n_sum[i]=sc.nextInt();
        for(int i=0;i<m;i++)
            m_sum[i]=sc.nextInt();
        
        for(int i=0;i<n-1;i++)
        {
            sum_maker_n(i+1,n_sum[i],n);
            sum_maker_n(i+1,0,n);
        }
        for(int i=0;i<m-1;i++)
        {
            sum_maker_m(i+1,m_sum[i],m);
            sum_maker_m(i+1,0,m);
        }
        Arrays.sort(n_sum, 0, n_count-1);
        Arrays.sort(m_sum, 0, m_count-1);
        int j=0;
        for(int i=0;i<n_count && j<m_count;i++)
        {
            while(i<n_count && n_sum[i]<m_sum[j])
                i++;
            while(j<m_count && n_sum[i]>m_sum[j])
                j++;
            if(n_sum[i]==m_sum[j])
            {
                while(i<n_count && n_sum[i++]==m_sum[j])
                    ans++;
                while(j<m_count && n_sum[i-1]==m_sum[++j])
                    ans++;
            }
        }
        System.out.println(ans);
        sc.close();
    }
    
    public static int sum_maker_n(int index,int sum,int total){
        
        if(index>=total)
            return 0;
        n_sum[n_count++]=sum+n_sum[index];
        index++;
        sum_maker_n(index,sum+n_sum[index],total);
        sum_maker_n(index,sum,total);
        return 0;
    }
    
    public static int sum_maker_m(int index,int sum,int total){
        
        if(index>=total)
            return sum;
        m_sum[m_count++]=sum+m_sum[index];
        index++;
        sum_maker_m(index,sum+m_sum[index],total);
        sum_maker_m(index,sum,total);
        return 0;
    }
}