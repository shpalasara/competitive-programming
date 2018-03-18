import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class q6 {

	public static void main(String[] args){
		
		InputReader ir = new InputReader(System.in);
        PrintWriter pr = new PrintWriter(System.out);
		int[] output = new int[100001];
		int T,n,index,count,prev;
		T=ir.nextInt();
		while(T-->0)
		{
			n=ir.nextInt();
			index=1;
			output[index]=index;
			count=1;
			prev=1;
			if(n==1)
				output[0]=1;
			else
			{
				while(count<n)
				{
					index=(count+1)%(n-count);
					while(index>=0)
					{
						if(output[prev]==0)
							index--;
						if(index<0 && output[prev%n]==0)
							prev--;
						//if(output[(prev+1)%n]==0)
						prev++;
						prev%=n;
						//System.out.println("check1");
					}
					index=prev++;
					prev%=n;
					output[index]=++count;
					//System.out.println("check");
				}
			}
			for(int i=0;i<n;i++)
			{
				//pr.print('X');
				pr.print("X"+output[i]+" ");
				output[i]=0;
				//pr.print();
			}
			pr.print('\n');
		}
		pr.close();
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
