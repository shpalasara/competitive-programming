package Week_Of_Code_33;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Transform_to_Palindrome {

	public static void main(String[] args) {
		
		FasterScanner sc =  new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n,k,m,x,y;
		n = sc.nextInt();
		k = sc.nextInt();
		m = sc.nextInt();
		
		Disjoint_Set set = new Disjoint_Set(n+1);
		
		for(int i=0;i<k;i++)
		{
			x = sc.nextInt();
			y = sc.nextInt();
			set.union(x, y);
		}
		
		int[] data = new int[m];
		
		for(int i=0;i<m;i++)
			data[i] = set.find(sc.nextInt());
		
//		for(int i=0;i<m;i++)
//			out.print(data[i]+" ");
//		out.println();
//		out.println();
		
		int[][] dp = new int[m+1][m+1];
		
		for(int i=0;i<m+1;i++)
			dp[i][i] = 1;
		
		int j,ans=1;
		for(int size=1; size<m; size++)
		{
			for(int i = 1; i<=m-size; i++)
			{
				j = i+size;
				if(data[i-1]==data[j-1])
					dp[i][j] = 2 + dp[i+1][j-1];
				else
					dp[i][j] = Math.max( dp[i+1][j], dp[i][j-1]);
				ans = Math.max(ans, dp[i][j]);
			}
		}
		
//		for(int i=0;i<m+1;i++)
//		{
//			for(j=0;j<m+1;j++)
//				out.print(dp[i][j]+" ");
//			out.println();
//		}
		out.println(ans);
		out.close();
	}
	
	static class Disjoint_Set{
	    int[] rank, parent;
	    int n;
	    
	    public Disjoint_Set(int n)
	    {
	        rank = new int[n];
	        parent = new int[n];
	        this.n = n;
	        makeSet();
	    }

	    void makeSet()
	    {
	        for (int i=0; i<n; i++)
	            parent[i] = i;
	    }

	    int find(int x){
	    	return parent[x]==x ? x : (parent[x] = find(parent[x]));
	    }
	    
	    void union(int x, int y)
	    {
	        int xRoot = find(x), yRoot = find(y);
	        
	        if (xRoot == yRoot)
	            return;
	        
	        if (rank[xRoot] < rank[yRoot])
	            parent[xRoot] = yRoot;

	        else if (rank[yRoot] < rank[xRoot])
	            parent[yRoot] = xRoot;
	 
	        else
	        {
	            parent[yRoot] = xRoot;
	            rank[xRoot] = rank[xRoot] + 1;
	        }
	    }
	}

	
	static class FasterScanner {

        private byte[] buf = new byte[1024];
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
