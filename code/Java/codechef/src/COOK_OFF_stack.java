import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class COOK_OFF_stack {

	public static void main(String[] args){
		
		InputReader ir = new InputReader(System.in);
		int T = ir.nextInt();
		while(T-->0)
		{
			int N =ir.nextInt(),temp,j,index;
			ArrayList<Integer> data = new ArrayList<Integer>();
			for(int i=0;i<N;i++)
			{
				temp = ir.nextInt();
				if(data.isEmpty())
					data.add(temp);
				else if(data.get(data.size()-1)<=temp)
					data.add(temp);
				else if(data.get(0)>temp)
					data.set(0, temp);
				else
				{
					index=search_index(temp,data,0,data.size()-1);
					data.set(index, temp);
					/*for(j=0;j<data.size();j++)
					{
						if(temp<data.get(j))
						{
							data.set(j, temp);
							break;
							//data.add(j, temp);
						}
					}*/
					//if(j==data.size())
						//data.add(temp);
				}
			}
			System.out.print(data.size()+" ");
			for(int i=0;i<data.size();i++)
				System.out.print(data.get(i)+" ");
			System.out.println();
		} 
	}
	
	public static int search_index(int num,ArrayList<Integer> data,int start,int end)
	{
		int middle = (start+end)/2;
		if(middle+1<data.size() && data.get(middle+1)<=num)
			return search_index(num,data,middle+1,end);
		else if(middle>0 && data.get(middle-1)>num)
			return search_index(num,data,start,middle-1);
		else if(middle>0 && data.get(middle-1)<=num && data.get(middle)>num)
			return middle;
		else
			return middle+1;
		//return 0;
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
