package August_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.TreeMap;
import java.util.TreeSet;

public class WALKBT {

	public static long ans;
	static boolean check,zeros;
	static PrintWriter out;
	static int n;
	static TreeMap<Integer , _Node> map;
	
	public static void main(String[] args) {
	
		FasterScanner sc = new FasterScanner();
		out = new PrintWriter(System.out);
		
		int t = Integer.parseInt(sc.nextLine());
		TreeSet<Integer> seq = new TreeSet<Integer>();
		TreeSet<Integer> temp = new TreeSet<Integer>();
		
		int q,c,te;

		map = new TreeMap<Integer , _Node>();
		
		while(t-->0)
		{
			check = true;
			zeros = false;
			
			map.clear();
			seq.clear();
			temp.clear();
			
			_Node node = new _Node(-1);
			
			String[] str = sc.nextLine().split(" ");
			
			n = Integer.parseInt(str[0]);
			q = Integer.parseInt(str[1]);
			ans = 1L;
			
			while(q-->0)
			{
				String[] st = sc.nextLine().split(" ");
			
				if(st[0].compareTo("!")==0)
				{
					c = Integer.parseInt(st[1]);
					c = add(seq, c, n);
					temp.clear();
					
					if(c==-1 || seq.ceiling(c+1)==null)
					{
						temp.addAll(seq);
						find_nearest ( temp , node);
					}
					else
					{
						te = seq.ceiling(c+1);
						temp.addAll(seq.headSet(te, false));
						find_nearest(temp, map.get(te));
					}
				}
				else
					out.println(ans);
			}
		}
		
		out.close();
	}
	
	public static void find_nearest (TreeSet<Integer> seq , _Node node ) {
		
		if(seq.isEmpty())
		{
			if(!node.data.isEmpty())
			{
				ans += (long)(node.data.first() + 1);
				node.data.add(-1);
			}
			return;
		}
		
		if(node.data.isEmpty())
		{
			if(check)
			{
				ans += (long)(n);
				check = false;
			}
			else
				ans += (long)(seq.last()+1);
			
			
			add_seq ( seq , node );
			return;
		}
		else
		{
			int max = seq.last();
		
			if(node.data.contains(max))
			{
				seq.pollLast();
				if(max==0)
					return;
				map.put(max, node.map.get(max));
				find_nearest ( seq , node.map.get(max));
			}
			else
			{	
				if(node.data.floor(max)!=null)
					ans += (long)(max + 1);
				else
					ans += (long)(node.data.ceiling(max)+1);
				
				add_seq ( seq , node);
			}
		}
	}
	
	public static void add_seq (TreeSet<Integer> seq , _Node node ) {
		
		_Node t;
		_Node x = node;
		int max;
		
		while(true){
			
			if(seq.isEmpty())
			{
				x.data.add(-1);
				break;
			}
			
			max = seq.pollLast();
			
			t = new _Node(max);
			x.data.add(max);
			x.map.put(max, t);
			x = t;
			map.put(max, t);
			
			if(max==0)
				break;
		}
		return;
	}
	
	public static int add(TreeSet<Integer> seq , int c , int n) {
		
		if(seq.isEmpty())
		{
			seq.add(c);
			return c;
		}
		
		while(c<n && seq.contains(c)) {
			seq.remove(c);
			map.remove(c);
			c++;
		}
		
		if(c>=n)
			return -1;
		
		seq.add(c);
		return c;
	}
	
	static class _Node /*implements Comparable<_Node>*/{
		
		int c;
		TreeMap<Integer, _Node> map;
//		HashMap<Integer, _Node> map;
		TreeSet<Integer> data;

		public _Node(int c) {
			
			this.c = c;
			map = new TreeMap<Integer , _Node>();
			data = new TreeSet<Integer>();
		}
		
//		@Override
//		public int compareTo(_Node x) {
//			
//			return this.c - x.c ;
//		}
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
