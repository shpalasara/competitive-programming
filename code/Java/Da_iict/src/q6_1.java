import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class q6_1 {

	public static void main(String[] args){
		
		InputReader ir = new InputReader(System.in);
		int T,n,pos;
		int[] output = new int[100001];
		ArrayList<Integer> list = new ArrayList<Integer>();
		T=ir.nextInt();
		while(T-->0)
		{
			pos=1;
			n=ir.nextInt();
			for(int i=0;i<n;i++)
				list.add(i, i);
			if(n==1)
			{
				output[0]=1;
				list.remove(0);
			}
			else
			{
				output[1]=1;
				list.remove(1);
			}
			for(int i=1;i<n;i++)
			{
				pos=(pos+i+1)%list.size();
				//System.out.println("pos"+pos+" data "+list.get(pos)+" size"+list.size());
				output[list.remove(pos)]=i+1;
			}
			//System.out.println();
			//System.out.println("pos"+pos+" size"+list.size());
			for(int i=0;i<n;i++)
				System.out.print("X"+output[i]+" ");
			System.out.println();
		}
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
