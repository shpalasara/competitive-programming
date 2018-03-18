package round_353_2;

import java.io.IOException;
import java.util.InputMismatchException;

public class Tree_Construction {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int n=sc.nextInt(),data;
		String str = "";
		Node root = new Node();
		Node node = new Node();
		root.value = sc.nextInt();
		n--;
		
		while(n-->0)
		{
			data = sc.nextInt();
			node = root;
			
			while(true)
			{
				
			}
		}
		System.out.println(str);
	}
	
	public static int insertion(Node node, int data){
		
		int ans;
		if(node.value<data)
		{
			if(node.right_child!=null)
			{
				ans = insertion(node.right_child, data);
				node.height = Math.max(node.height, node.right_child.height+1);
				
				if(node.left_child!=null && (node.right_child.height-node.left_child.height)>=1)
				{
					
				}
				else if(node.height>=2)
				{
					
				}
				return ans;
			}
			else
			{
				node.right_child = new Node();
				node.right_child.value = data;
				node.right_child.parent = node;
				node.right_child.height = 0;
				node.height = Math.max(node.height, 1);
				return node.value;
				//str += node.value+" ";
				//break;
			}
		}
		else
		{
			if(node.left_child!=null)
			{
				ans = insertion(node.left_child, data);
				node.height = Math.max(node.left_child.height+1, node.height);
				return ans;
			}
			else
			{
				node.left_child = new Node();
				node.left_child.value = data;
				node.left_child.parent = node;
				node.left_child.height = 0;
				node.height = Math.max(node.height, 1);
				return node.value;
				//str += node.value+" ";
				//break;
			}
		}
	}
	
	static class Node {
		
		public Node left_child;
		public Node right_child;
		public Node parent;
		public int height;
		public int value;
		
		public void Node(){
			
			parent = null;
			left_child = null;
			right_child = null;
			height = 0;
		}
	}
	
	static class FasterScanner {
		 
        private byte[] buf = new byte[8192];
        private int curChar;
        private int numChars;
 
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = System.in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
 
        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }
 
        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
 
        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
 
        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}


/*Anand's Solution

import java.util.*;
import java.io.*;
public class D 
{
	public static void main(String[] args)
	{
		new D().solve();
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

	class segTree
	{
		int n;
		SSSS[] val;

		public segTree(SSSS[] arr)
		{
			n=arr.length;
			val=new SSSS[3*n];
			for(int i=0;i<arr.length;i++)
			{
				val[i+n]=arr[i];
			}
			build();
		}

		void build() 
		{  
			for (int i = n - 1; i > 0; --i)
			{
				//t[i] = t[i<<1] + t[i<<1|1];
				//merge(i,i<<1,i<<1|1);
				val[i]=merge(val[i<<1],val[i<<1|1]);
			}
		}

		void modify(int p, SSSS s)
		{  
			val[p+n]=s;
			for (p=p+n; (p >>= 1)!=0; )
			{
				val[p]=merge(val[p<<1],val[p<<1|1]);
			}
		}

		SSSS query(int l, int r) 
		{  
			SSSS resl = null,resr=null;
			for (l += n, r += n; l < r; l >>= 1, r >>= 1)
			{
				if ((l&1)!=0)
				{
					resl=merge(resl,val[l]);
					l++;
				}
				if ((r&1)!=0)
				{
					--r;
					resr=merge(val[r],resr);
				}
			}
			return merge(resl,resr);
		}

		//Write merge method As per requienment
		public SSSS merge(SSSS a1,SSSS a2)
		{
			if(a1==null && a2==null)
				return null;
			if(a1==null && a2!=null)
				return a2;
			if(a1!=null && a2==null)
				return a1;

			SSSS a=new SSSS();
			a.d=Math.max(a1.d,a2.d);

			return a;
		}


	}

	class SSSS
	{

		double d=0.0;
		public SSSS(){};
		public SSSS(double d)
		{
			this.d=d;
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

*/