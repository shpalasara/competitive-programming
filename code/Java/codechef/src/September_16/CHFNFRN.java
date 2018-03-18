package September_16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class CHFNFRN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt(),n,m,a,b;
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			boolean[][] graph = new boolean[n][n];
			int[] degree = new int[n];
			
			for(int i=0;i<m;i++)
			{
				a = sc.nextInt()-1;
				b = sc.nextInt()-1;
				
				if(!graph[a][b])
				{
					degree[a]++;
					degree[b]++;
				}
				
				graph[a][b] = true;
				graph[b][a] = true;
			}
			
			boolean[] check = new boolean[n];
			boolean[] g1 = new boolean[n];
			boolean[] g2 = new boolean[n];
			
			int min = degree[0],index=0;
			
			for(int i=1;i<n;i++)
			{
				if(degree[i]<min)
				{
					min = degree[i];
					index = i;
				}
			}
			
			recurse_1( check, g1, g2, graph, index, n);
			
			boolean ans = true,g11,g22;
			
			for(int i=0;i<n;i++)
			{
				if(!check[i])
				{
					g11 = true;
					g22 = true;
					
					for(int j=0;j<n;j++)
					{
						if(g1[j] && !graph[i][j])
							g11 = false;
						
						if(g2[j] && !graph[i][j])
							g22 = false;
					}
					
					if(g11)
					{
//						check[i] = true;
//						g1[i] = true;
						recurse_1( check, g1, g2, graph, i, n);
					}
					else if(g22)
					{
//						check[i] = true;
//						g2[i] = true;
						recurse_2( check, g1, g2, graph, i, n);
					}
					else
						ans = false;
				}
			}
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for(int i=0;i<n && ans;i++)
			{
				if(g1[i])
				{
					for(int j=0;j<list.size();j++)
					{
						if(!graph[i][list.get(j)])
							ans = false;
					}
					list.add(i);
					
				}
			}
			
			list.clear();
			
			for(int i=0;i<n && ans;i++)
			{
				if(g2[i])
				{
					for(int j=0;j<list.size();j++)
					{
						if(!graph[i][list.get(j)])
							ans = false;
					}
					list.add(i);
				}
			}
			
			list.clear();
			
//			out.println("g1:");
//			for(int i=0;i<n;i++)
//			{
//				if(g1[i])
//					out.print(i+" ");
//			}
//			out.println();
//			
//			out.println("g2:");
//			for(int i=0;i<n;i++)
//			{
//				if(g2[i])
//					out.print(i+" ");
//			}
//			out.println();
			
			if(ans)
				out.println("YES");
			else
				out.println("NO");
		}
		
		out.close();
	}
	
	public static void recurse_1(boolean[] check, boolean[] g1, boolean[] g2, boolean[][] graph, int index, int n){
		
		check[index] = true;
		g1[index] = true;
		
		for(int i=0;i<n;i++)
		{
			if(!check[i] && !graph[index][i])
				recurse_2( check, g1, g2, graph, i, n);
		}
	}
	
	public static void recurse_2(boolean[] check, boolean[] g1, boolean[] g2, boolean[][] graph, int index, int n){
		
		check[index] = true;
		g2[index] = true;
		
		for(int i=0;i<n;i++)
		{
			if(!check[i] && !graph[index][i])
			{
				recurse_1( check, g1, g2, graph, i, n);
			}
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
