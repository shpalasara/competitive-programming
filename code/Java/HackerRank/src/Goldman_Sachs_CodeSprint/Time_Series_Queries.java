package Goldman_Sachs_CodeSprint;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.TreeSet;

public class Time_Series_Queries {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
	
		int n = sc.nextInt();
		int q = sc.nextInt(),v;
		int max_val=0,min_val=(int)(1e9+1);
		int max_time,min_time;
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();	
		TreeSet<Integer> time = new TreeSet<Integer>();
		TreeSet<node> val = new TreeSet<node>();
		node data;
		
		int[][] stock = new int[n][4];
		
		for(int i=0;i<n;i++)
		{
			stock[i][0] = sc.nextInt();
			map.put(stock[i][0], i);
			time.add(stock[i][0]);
		}
		
		min_time = stock[0][0];
		max_time = stock[n-1][0];
		
		for(int i=0;i<n;i++)
		{
			stock[i][1] = sc.nextInt();
			stock[i][2] = stock[i][1];
			stock[i][3] = stock[i][1];
			max_val = Math.max(max_val, stock[i][1]);
			min_val = Math.min(min_val, stock[i][1]);
		}
		
		for(int i=n-2;i>=0;i--)
			stock[i][2] = Math.max(stock[i][2], stock[i+1][2]);
		
		val.add(new node(stock[0][1],0));
		
		for(int i=1;i<n;i++)
		{
			if(stock[i][3]>stock[i-1][3])
				val.add(new node(stock[i][3],i));
			else
				stock[i][3] = stock[i-1][3];
		}
		
		while(q-->0)
		{
			if(sc.nextInt()==1)
			{
				v = sc.nextInt();
				if(v<=max_val)
				{
					data = new node(v,0);
					out.println(stock[val.ceiling(data).index][0]);
				}
				else
					out.println(-1);
			}
			else
			{
				v = sc.nextInt();
				if(v<=max_time)
				{
					v = time.ceiling(v);
					v = map.get(v);
					out.println(stock[v][2]);
				}
				else
					out.println(-1);
			}
		}
		
		out.close();
	}
	
	static class node implements Comparable<node>{
		
		int value,index;
		
		public node(int x,int y) {
			value = x;
			index = y;
		}
		
		@Override
		public int compareTo(node x) {
			
			return ( this.value > x.value ? 1 : (this.value==x.value ? (this.index-x.index) : -1)); 
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
