import java.util.*;

public class Counting_Triangles {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),temp=0;
		long a,b,_c,acute=0,right=0,obtuse=0;
		double c;
		boolean[] length = new boolean[10010];
		int[] count = new int[10010];
		int[] data = new int[n];
		
		for(int i=0;i<n;i++)
		{
			data[i]=sc.nextInt();
			length[data[i]]=true;
		}
		
		for(int i=0;i<10010;i++)
		{
			if(length[i])
				temp++;
			count[i]=temp;
		}
		
		for(int i=0;i<n-2;i++)
		{
			a=data[i];
			for(int j=i+1;j<n-1;j++)
			{
				b=data[j];
				//Math.f
				
					c=Math.sqrt(a*a+b*b);
					_c=(long)Math.floor(c);
					if(c==_c && length[(int)_c])
					{
						//System.out.println("C "+c+" "+Math.floor(c));
						//System.out.println("Hii "+a+" "+b+" "+_c);
						right++;
						//if((int)(a+b)<data[n-1])
							acute+=(long)((count[(int)_c]-1)-count[(int)b]);
							
						obtuse+=(long)(count[Math.min((int)a+(int)b-1, data[n-1])]-count[(int)_c]);
					}
					else
					{
						//System.out.println("Hii "+a+" "+b+" "+_c);
						//if((int)(a+b)<data[n-1])
							acute+=(long)(count[(int)_c]-count[(int)b]);
							
						obtuse+=(long)(count[Math.min((int)a+(int)b-1, data[n-1])]-count[(int)_c]);
					}
				
			}
		}
		System.out.println(acute+" "+right+" "+obtuse);
		sc.close();
	}
}
