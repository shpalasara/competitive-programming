import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class code_war_4 {

	public static void main(String[] args){
		
		//InputReader ir = new InputReader(System.in);
		Scanner ir = new Scanner(System.in);
		int T,N,t,k,c;
		T=ir.nextInt();
		while(T-->0)
		{
			N=ir.nextInt();
			long[][] data = new long[N][2];
			long[][] check = new long[N][2];
			for(int i=0;i<N;i++)
			{
				data[i][0]=ir.nextLong();
				data[i][1]=ir.nextLong();
			}
			c=ir.nextInt();
			while(c-->0)
			{
				t=ir.nextInt();
				k=ir.nextInt();
				for(int i=0;i<N;i++)
				{
					check[i][1]=i;
					check[i][0]=-(data[i][1]+data[i][0]*t);
					//System.out.print(+check[i][1]+" ");
				}
				//System.out.println();
				java.util.Arrays.sort(check, new java.util.Comparator<long[]>() {

					  public int compare(long[] a,long[] b) {

					    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));

					  }

					});
				
				long min=1001,count=1;
				for(int i=1;i<N && count<=k;i++)
				{
					//if(check[i][0]!=check[i-1][0])
					//{
						if(count==k)
							min=check[i-1][1];
					//}
					//if(count==k)
					//{
						while(count==k && i<N)
						{
							if(check[i][0]!=check[i-1][0])
								count++;
							else if(min>check[i][1])
								min=check[i][1];
							i++;
						}

						count++;
								//}
				}
				System.out.println(min+1);
			}
		}
		ir.close();
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
