package codeAgon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.TreeMap;
import java.util.TreeSet;

public class CA_17_q4 {

	static ArrayList<ArrayList<Integer>> list;
	static TreeSet<String> map;
	static boolean check;
	static int start;
	static long mod = (long)(1e9+7);
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		int t = sc.nextInt();
		
		while(t-->0)
		{
			list = new ArrayList<ArrayList<Integer>>();
			map = new TreeSet<String>();
			check = false;
			
			int n = sc.nextInt();
			int u,v,g;
			
			for(int i=0;i<n;i++)
				list.add(new ArrayList<Integer>());
			
			start=0;
			
			for(int i=1;i<n;i++)
			{
				u = sc.nextInt()-1;
				v = sc.nextInt()-1;
				g = sc.nextInt();
				if(g==1)
				{
					start = u;
					map.add(u+" "+v);
				}
				list.get(u).add(v);
				list.get(v).add(u);
			}
			
			dfs(start);
		}
	}
	
	public static long dfs( int index) {
		
		long ans=1,temp;
		int u=index,v;
		
		for(int i=0;i<list.get(index).size();i++)
		{
			if(u==start)
				check = false;
			v = list.get(index).get(i);
			temp = dfs(v);
			if(check)
				ans = (ans*temp)%mod;
			else
				ans = (ans*(temp+1))%mod;
			
			if(map.contains(v+" "+u) || map.contains(u+" "+v))
				check = true;
		}
		return ans;
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
