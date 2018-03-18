import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class no_square {

	public static void main(String[] args){
		
		InputReader ir = new InputReader(System.in);
		int N=ir.nextInt(),K=ir.nextInt(),ans=0;
		ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> diagonal = new ArrayList<ArrayList<Integer>>();
		int[][] points = new int[N][2];
		for(int i=0;i<N;i++)
		{
			points[i][0]=ir.nextInt();
			points[i][1]=ir.nextInt();
			nodes.add(new ArrayList<Integer>());
			diagonal.add(new ArrayList<Integer>());
		}
		for(int i=0;i<N;i++)
		{
			for(int j=i+1;j<N;j++)
			{
				if(Math.pow(points[i][0]-points[j][0], 2)+Math.pow(points[i][1]-points[j][1], 2)==K*K)
				{
					nodes.get(i).add(j);
					//nodes.get(j).add(i);
				}
				else if(Math.pow(points[i][0]-points[j][0],2) + Math.pow(points[i][1]-points[j][1],2)==2*K*K)
				{
					diagonal.get(i).add(j);
					//diagonal.get(j).add(i);
				}
			}
		}
		int temp,count;
		//boolean check=false;
		/*for(int i=0;i<N;i++)
		{
			System.out.println("point"+i);
			for(int j=0;j<diagonal.get(i).size();j++)
				System.out.print(diagonal.get(i).get(j)+" ");
			System.out.println();
		}
		System.out.println();
		
		for(int i=0;i<N;i++)
		{
			System.out.println("ad_point"+i);
			for(int j=0;j<nodes.get(i).size();j++)
				System.out.print(nodes.get(i).get(j)+" ");
			System.out.println();
		}
		System.out.println();
		*/
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<diagonal.get(i).size();j++)
			{
				count=0;
				temp=diagonal.get(i).get(j);
				for(int k=0;k<nodes.get(i).size();k++)
					if(nodes.get(nodes.get(i).get(k)).contains(temp))
						count++;
				//System.out.println(count);
				if(count%2==0 && count!=0)
				{
					ans++;
					break;
				}
			}
		}
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
