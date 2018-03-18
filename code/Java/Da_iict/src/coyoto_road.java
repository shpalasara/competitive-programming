import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class coyoto_road {

	public static void main(String[] args){
		
		InputReader ir = new InputReader(System.in);
		int N = ir.nextInt();
		int[][] x = new int[N][2];
		int[][] y = new int[N][2];
		long[] min = new long[N];
		long ans=0,temp=0;
		int a=0,b=0;
		for(int i=0;i<N;i++)
		{
			x[i][0]=ir.nextInt();
			x[i][1]=i;
			y[i][0]=ir.nextInt();
			y[i][1]=i;
		}
		java.util.Arrays.sort(x, new java.util.Comparator<int[]>() {

			  public int compare(int[] a, int[] b) {

			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));

			  }

			});
		java.util.Arrays.sort(y, new java.util.Comparator<int[]>() {

			  public int compare(int[] a, int[] b) {

			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));

			  }

			});
		
		for(int i=0;i<N-1;i++)
			min[x[i][1]]=Math.abs(x[i][0]-x[i+1][0]);
		min[x[N-1][1]]=1000000001;
		a=x[N-1][1];
		
		for(int i=0;i<N-1;i++)
		{
			if(y[i][1]==a)
			{
				//System.out.println("value of i "+i);
				b=Math.abs(y[i][0]-y[i+1][0]);
			}
			else if(min[y[i][1]]>Math.abs(y[i][0]-y[i+1][0]))
				min[y[i][1]]=Math.abs(y[i][0]-y[i+1][0]);
			if(i!=0 && min[y[i][1]]>Math.abs(y[i][0]-y[i-1][0]))
				min[y[i][1]]=Math.abs(y[i][0]-y[i-1][0]);
		}
		if(min[y[N-1][1]]>b)
		{
			//System.out.println("good "+b);
			min[y[N-1][1]]=0;
			min[a]=b;
		}
		else
			min[a]=0;
		//System.out.println("0 to n");
		for(int i=0;i<N;i++)
		{
			//System.out.print(min[i]+" ");
			ans+=min[i];
			min[i]=0;
		}
		//System.out.println();
		//from upper to lower
		for(int i=N-1;i>0;i--)
			min[x[i][1]]=Math.abs(x[i][0]-x[i-1][0]);
		min[x[0][1]]=1000000001;
		a=x[0][1];
		
		//for(int i=0;i<N;i++)
			//System.out.print(min[i]+" ");
		//System.out.println();
		//System.out.println("value of a "+a);
		b=1000;
		for(int i=N-1;i>0;i--)
		{
			if(y[i][1]==a)
				b=Math.abs(y[i][0]-y[i-1][0]);
			else if(min[y[i][1]]>Math.abs(y[i][0]-y[i-1][0]))
				min[y[i][1]]=Math.abs(y[i][0]-y[i-1][0]);
			if(i!=N-1 && min[y[i][1]]>Math.abs(y[i][0]-y[i+1][0]))
				min[y[i][1]]=Math.abs(y[i][0]-y[i+1][0]);	
		}
		//System.out.println(y[0][1]+" value of b"+b);
		if(min[y[0][1]]>b)
		{
			//System.out.println("here");
			min[y[0][1]]=0;
			min[a]=b;
		}
		else
			min[a]=0;
		
		
		for(int i=0;i<N;i++)
		{
			//System.out.print(min[i]+" ");
			temp+=min[i];
		}
		//System.out.println();
		//if(ans>temp)
			System.out.println(temp);
		//else
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
