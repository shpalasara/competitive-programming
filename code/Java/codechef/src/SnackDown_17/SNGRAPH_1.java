package SnackDown_17;

// Accepted

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

class SNGRAPH_1 {
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt(),n,m,u,v;;
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();

			pair[] edges = new pair[m];
			final int[] degree = new int[n];
			
			
			for(int i=0;i<m;i++)
			{
				u = sc.nextInt()-1;
				v = sc.nextInt()-1;
				degree[v]++;
				degree[u]++;
				edges[i] = new pair(u,v);
			}
			
			Arrays.sort(edges,  new Comparator<pair>() {
                public int compare(pair a, pair b) {
                    return (-1*Integer.compare(Math.min(degree[a.u], degree[a.v]), Math.min(degree[b.u], degree[b.v])));
                }
            });
			
//			for(int i=0;i<m;i++)
//				out.println(edges[i].u+" "+edges[i].v);
//			out.println();
			
			Disjoint_Set set = new Disjoint_Set(n);
			int j=0;
			int[] ans = new int[n];
			
			for(int i=n-1;i>=0 && j<m;i--)
			{
				while(j<m && Math.min(degree[edges[j].u], degree[edges[j].v])>i)
				{
					set.union(edges[j].u, edges[j].v);
					j++;
				}
				ans[i] = set.getResult();
			}
			
			for(int i=0;i<n;i++)
				out.print(ans[i]+" ");
			out.println();
		}
		
		out.close();
	}
	
	public static class pair{

		int u,v;
		public pair(int x,int y){
			u = x;
			v = y;
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
	
	static class Disjoint_Set{
	    int[] rank, parent;
	    int n,result;
	    
	    public Disjoint_Set(int n)
	    {
	        rank = new int[n+1];
	        parent = new int[n+1];
	        this.n = n;
	        result = n-1;
	        makeSet();
	    }

	    public int makeSet()
	    {
	        for (int i=0; i<n; i++)
	            parent[i] = i;
	        return 0;
	    }
	    
	    public int getResult(){
	    	return result;
	    }

	    public int find(int x){
	    	return (parent[x]==x ? x : (parent[x] = find(parent[x])));
	    }
	    
	    public int union(int x, int y)
	    {
	        int xRoot = find(x), yRoot = find(y);
	        
	        if (xRoot == yRoot)
	            return 0;
	        result--;
	        if (rank[xRoot] < rank[yRoot])
	        {
	            parent[xRoot] = yRoot;
	            return 1;
	        }
	        else if (rank[yRoot] < rank[xRoot])
	        {
	            parent[yRoot] = xRoot;
	            return -1;
	        }
	        else
	        {
	            parent[yRoot] = xRoot;
	            rank[xRoot]++;
	        }
	        return 1;
	    }
	}
}
