package August_17;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class GCD_on_directed_graph {

	static int[] cost;
	static boolean[] visited;
	static boolean[] path;
	static int n;
	static ArrayList<ArrayList<Integer>> list ;
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		
		n = sc.nextInt();
		int m = sc.nextInt();
		int ans = 1000000;
		
		cost = new int[n];
		visited = new boolean[n];
		path = new boolean[n];
		
		for(int i=0;i<n;i++)
		{
			cost[i] = sc.nextInt();
			ans = Math.min(ans, cost[i]);
		}
		
		list = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<n;i++)
			list.add(new ArrayList<Integer>());
		
		int u,v;
		
		for(int i=0;i<m;i++)
		{
			u = sc.nextInt()-1;
			v = sc.nextInt()-1;
			list.get(u).add(v);
		}

		for(int i=0;i<n;i++)
		{
			if(!visited[i])
				dfs( i, ans);
			ans = Math.min(ans, cost[i]);
		}
		
		System.out.println(ans);
	}
	
	public static void dfs(int index, int ans) {
		
		visited[index] = true;
		path[index] = true;
		int prev = cost[index];
		
		for(int i=0;i<list.get(index).size();i++)
		{
			if(!visited[list.get(index).get(i)])
				dfs(list.get(index).get(i) , ans);
			else if(path[list.get(index).get(i)])
				path[list.get(index).get(i)] = false;
			
			
			cost[index] = Math.min(cost[index], gcd(prev , cost[list.get(index).get(i)]));
			//cost[index] = Math.min(cost[index], gcd(cost[index] , cost[list.get(index).get(i)]));

			if(!path[index])
			{
				path[index] = true;
				prev = cost[index];
			}
		}
		ans = Math.min(ans, cost[index]);
		path[index] = false;
		
		return;
	}
	
	
	public static int gcd(int a,int b){
		
		a=Math.abs(a);
		b=Math.abs(b);
		
		int temp;
		while(b!=0)
		{
			temp = a%b;
			a = b;
			b = temp;
		}
		return a;
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
