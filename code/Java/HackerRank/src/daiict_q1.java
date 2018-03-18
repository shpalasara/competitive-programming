import java.util.*;
import java.io.*;

public class daiict_q1 {

	public static void main(String[] args){
		
		InputReader sc = new InputReader(System.in);
		//PrintWriter w = new PrintWriter(System.out);
		int N= sc.nextInt(),p,q,ans=0,temp;
		HashMap<Integer,Integer> set = new HashMap<Integer,Integer>();
		
		for(int i=0;i<N;i++)
		{
			p=sc.nextInt();
			q=sc.nextInt();
			if(p!=q)
			{
				if(set.containsKey(q) && (temp=set.get(q))>0)
				{
					if(temp>1)
						set.put(q, temp-1);
					else
						set.put(q,0);
				}
				else
					ans++;
				
				if(set.containsKey(p) && (temp=set.get(p))>0)
					set.put(p, temp+1);
				else
					set.put(p, 1);
			}
		}
		System.out.println(ans);
		//w.println(ans);
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
