package codeAgon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.TreeMap;
import java.util.TreeSet;

public class Rust_his_Transfer {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		HashMap<String , String> map ;
		int n,m,x,y,r,texi,S,D;
		
		int[][] ans = new int[3002][2];
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			
			for(int i=0;i<n+1;i++)
			{
				list.add(new ArrayList<Integer>());
				ans[i][0] = 0;
				ans[i][1] = 0;
			}
			
			map = new HashMap<String , String>();
			
			for(int i=0;i<m;i++)
			{
				x = sc.nextInt();
				y = sc.nextInt();
				r = sc.nextInt();
				texi = sc.nextInt();
				
				if(x!=y)
				{
					map.put(x+" "+y, r+" "+texi);
					list.get(x).add(y);
					list.get(y).add(x);
				}
			}
			
			S = sc.nextInt();
			D = sc.nextInt();
			
			if(S==D)
				out.println(0);
			else
			{
				
			}
		}
		
		out.close();
	}
	
	static class _Node implements Comparable<_Node>{
		
		int station,r_cost,t_cost;

		public _Node(int s ,int r , int t) {
			
			station = s;
			r_cost = r;
			t_cost = t;
		}
		
		@Override
		public int compareTo(_Node x) {
			
			return this.r_cost - x.r_cost ;
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
