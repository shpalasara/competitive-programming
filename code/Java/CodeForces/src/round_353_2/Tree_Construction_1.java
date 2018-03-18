package round_353_2;

import java.util.*;
import java.io.*;


public class Tree_Construction_1 
{
	public static void main(String[] args)
	{
		new Tree_Construction_1().solve();
	}

	FasterScanner in=new FasterScanner();
	PrintWriter out=new PrintWriter(System.out);

	public void solve()
	{
		//		int tt=in.nextInt();
		//		for(int ii=0;ii<tt;ii++)
		{
			TreeSet<s> tree=new TreeSet<>();
			int n=in.nextInt();
			int x=in.nextInt();
			tree.add(new s(1,x));
			
			for(int i=2;i<=n;i++)
			{
				x=in.nextInt();
				s node=new s(i,x);
				s c=tree.ceiling(node);
				s f=tree.floor(node);
				
				if(c==null)
				{
					f.right=true;
					out.print(f.val+" ");
				}
				else if(f==null)
				{
					c.left=true;
					out.print(c.val+" ");
				}
				else if(c.left && f.right)
				{
					System.out.println("error");
				}
				else if(!c.left)
				{
					c.left=true;
					out.print(c.val+" ");
				}
				else
				{
					f.right=true;
					out.print(f.val+" ");
				}
				tree.add(node);
			}
			
			out.close();
		} 
	}

	class s implements Comparable<s>
	{
		int idx;
		int val;
		boolean left;
		boolean right;
		
		public s(int idx,int val)
		{
			this.idx=idx;
			this.val=val;
		}

		public String toString()
		{
			return " { "+this.idx+" "+this.val+" "+"} ";
		}

		@Override
		public int compareTo(s o) {
			// TODO Auto-generated method stub
			if(this.val!=o.val)
				return Integer.compare(this.val, o.val);
			else 
				return Integer.compare(o.idx, this.idx);
		}
	}

		public static class FasterScanner {
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = System.in.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}
		private boolean isEndOfLine(int c) {
			return c=='\n' || c=='\r' || c==-1;
		}
		public String nextString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
		private boolean isSpaceChar(int c) {
			return c=='\n' || c=='\r' || c==-1 || c==' ' || c=='\t';
		}
		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}

			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		public double nextDouble()
		{
			return Double.parseDouble(nextString());
		}
		public int[] nextIntArray(int n)
		{
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=nextInt();
			}
			return arr;
		}
		public long[] nextLongArray(int n)
		{
			long[] arr=new long[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=nextLong();
			}
			return arr;
		}
		public int[] nextIntArray10(int n)
		{
			int[] arr=new int[n+1];
			for(int i=1;i<=n;i++)
			{
				arr[i]=nextInt();
			}
			return arr;
		}
		public long[] nextLongArray10(int n)
		{
			long[] arr=new long[n+1];
			for(int i=1;i<=n;i++)
			{
				arr[i]=nextLong();
			}
			return arr;
		}
		public int[] nextIntArray11(int n)
		{
			int[] arr=new int[n+2];
			for(int i=1;i<=n;i++)
			{
				arr[i]=nextInt();
			}
			return arr;
		}
		public long[] nextLongArray11(int n)
		{
			long[] arr=new long[n+2];
			for(int i=1;i<=n;i++)
			{
				arr[i]=nextLong();
			}
			return arr;
		}
	}

}
