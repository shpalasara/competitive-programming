import java.io.*;
import java.util.*;

public class daiict_q4 {

	public static void main(String[] args){
		
		InputReader sc = new InputReader(System.in);
		int N = sc.nextInt();
		//int[] data = new int[N];
		ArrayList<Integer> data = new ArrayList<Integer>();
		//SortedSet<Integer> sSet = new SortedSet<Integer>();
		
		int count=0,temp;
		for(int i=0;i<N;i++)
		{
			temp=sc.nextInt();
			if(temp==2)
			{
				if(count<3)
					System.out.println("Not enough walks");
				else
				{
					System.out.println(data.get(count/3-1));
				}
			}
			else
			{
				temp=sc.nextInt();
				if(count==0)
					data.add(temp);
				else
				{
					if(temp>=data.get(0))
						data.set(0, temp);
					else
					{
						for(int j=1;j<count;j++)
						{
							if(temp>data.get(j))
							{
								/*int t=data[j];
								data[j]=temp;
								temp=t;*/
								data.add(j, temp);
							}
						}
					}
				}
				count++;
				for(int j=0;j<count;j++)
					System.out.print(data.get(j)+" ");
				//data[count++]=temp;
			}
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
