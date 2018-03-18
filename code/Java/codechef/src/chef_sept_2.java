import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class chef_sept_2 {

	public static void main(String[] args){
		
		InputReader ir = new InputReader(System.in);
		int T=ir.nextInt(),N,M,ans,group;
		while(T-->0)
		{
			ans=0;
			N=ir.nextInt();
			M=ir.nextInt();
			int[] data=new int[M];
			for(int i=0;i<M;i++)
				data[i]=ir.nextInt();
			Arrays.sort(data);
			group=M;
			for(int i=0;i<M && group>1;i++)
			{
				if(data[i]+1<group)
				{
					ans+=data[i];
					group-=data[i]+1;
				}
				else
				{
					ans+=group-1;
					group=0;
				}
			}
			System.out.println(ans);
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
