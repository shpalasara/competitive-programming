import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class QuantumLand {

	public static void main(String[] args){
		
		InputReader ir = new InputReader(System.in);
		int n = ir.nextInt(),start=-1,next,checker=0,loop=0;
		int[] w = new int[n];
		int[] count = new int[n];
		boolean[] ok = new boolean[n];
		double[] p = new double[n];
		double ans=0,temp_ans=0;
		
		for(int i=0;i<n;i++)
		{
			w[i]=ir.nextInt()-1;
			p[i]=(double)ir.nextInt()/(double)100;
			count[i]++;
			count[w[i]]++;
			if(count[i]>1)
				start=i;
			else if(count[w[i]]>1)
				start=w[i];
			if(i==w[i])
				count[i]=-100001;
				//ans=-11;
		}
		//System.out.println(start);
		//temp=n;
		//if(ans==-11)
			//System.out.println("hello"+0.00);
		/*else */if(start==-1)
			System.out.println("Something wrong");
		else
		{		
			for(int i=0;i<n;i++)
				ok[i]=false;
				
			for(int i=0;i<=n;i++)
			{
				loop=0;
				temp_ans=0;
				if(i==0)
				{
					temp_ans=p[start];
					next=w[start];
					ok[start]=true;
					while(start!=next && loop<n)
					{
						ok[next]=true;
						temp_ans*=p[next];
						if(next==w[next])
						{
							checker=1;
							break;
						}
						next=w[next];
						loop++;
					}
					if(checker==0)
						ans+=temp_ans;
					checker=0;
				}
				else if(ok[i-1]==false)
				{
					if(count[i-1]>1)
					{
						start=i-1;
						temp_ans=p[start];
						next=w[start];
						ok[start]=true;
						while(start!=next && loop<n)
						{
							ok[next]=true;
							temp_ans*=p[next];
							if(next==w[next])
							{
								checker=1;
								break;
							}
							next=w[next];
							loop++;
						}
						if(checker==0)
							ans+=temp_ans;
						checker=0;
					}
					
				}
				else
					ok[i-1]=true;
				//for(int j=0;j<n;j++)
					//System.out.print(ok[j]+" ");
				//System.out.println();
				//System.out.println(i+" "+temp_ans);
			}
			System.out.printf("%.2f\n",ans);
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
/*
15
3 100
1 100
3 10
5 60
9 100
9 30
4 40
10 20
7 100
7 10
12 100
14 100
11 100
13 100
3 100
*/
