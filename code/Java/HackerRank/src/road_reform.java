import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class road_reform {

	public static void main(String[] args){
		
		InputReader ir = new InputReader(System.in);
		int N = ir.nextInt(),M = ir.nextInt();
		int x,y,cost;
		long[] f_cost = new long[N];
		int[] prev = new int[N];
		long ans=0;
		f_cost[0]=0;
		for(int i=1;i<N;i++)
			f_cost[i]=1000000001;
		
		storage data,data1;
		ArrayList<ArrayList<storage>> graph = new ArrayList<ArrayList<storage>>();
		ArrayList<Integer> nodes=new ArrayList<Integer>();
		
		for(int i=0;i<N;i++)
			graph.add(new ArrayList<storage>());
		
		for(int i=0;i<M;i++)
		{
			data=new storage();
			data1=new storage();
			x=ir.nextInt();
			y=ir.nextInt();
			cost=ir.nextInt();
			data.cost=cost;
			data1.cost=cost;
			data.node=y;
			graph.get(x-1).add(data);
			data1.node=x;
			graph.get(y-1).add(data1);
		}
		//for(int i=0;i<N;i++)
		//{
		int i=0;
		nodes.add(0);
		while(!nodes.isEmpty())
		{
			i=nodes.remove(0);
			while(!graph.get(i).isEmpty())
			{
				data=graph.get(i).remove(0);
				graph.get(data.node-1).remove(data);
				if(data.cost+f_cost[i]<f_cost[data.node-1])
				{
					f_cost[data.node-1]=data.cost+f_cost[i];
					prev[data.node-1]=i;
					if(!nodes.contains(data.node-1))
						nodes.add(data.node-1);
				}
			}
		}
		//}
		//long temp_y;
		for(i=1;i<N;i++)
		{
			//ans+=f_cost[i]-1;
			x=i;
			//temp_y=f_cost[x];
			while(x!=0)
			{
				ans+=/*y*/f_cost[i]-f_cost[prev[x]]-1;
				x=prev[x];
				//temp_y+=f_cost[x];
				//System.out.println("value i "+i+" now "+x+" ans "+ans);
			}
			//System.out.println(prev[i]+" ");
		}
		//System.out.println();
			//System.out.print(f_cost[i]+" ");
		System.out.println(ans);
	}
	
	static public class InputReader {
		 
		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar;
		private int snumChars;
		private SpaceCharFilter filter;
 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
 
		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
 
			int res = 0;
 
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
 
			return res * sgn;
		}
 
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}
/*
5 6
1 3 2
3 2 1
2 3 2
3 4 4
2 4 2
4 5 3


5 7
1 2 6
1 3 3
1 4 6
2 3 5
2 5 1
3 4 2
4 5 4



4 5
1 3 2
1 2 1
2 3 1
3 4 4
2 4 5
*/