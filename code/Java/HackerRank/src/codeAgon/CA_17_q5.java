package codeAgon;

import java.io.IOException;
import java.util.InputMismatchException;

public class CA_17_q5 {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int x,y;
		
		Disjoint_Set set = new Disjoint_Set(n);
		
		for(int i=0;i<m;i++)
		{
			x = sc.nextInt()-1;
			y = sc.nextInt()-1;
			
			set.union(x, y);
		}
		
		int parent,extra=0;
		int min1,min2;
		long ans = 0L;
		
		int[] no_vert = new int[n];
		int[] no_edge = new int[n];
		
		for(int i=0;i<n;i++)
		{
			no_edge[i] = set.find_edges(i);
			no_vert[i] = set.find_vertex(i);
			parent = set.find(i);
			
//			System.out.println(no_edge[i]+" "+no_vert[i]);
			
			ans += (long)(no_vert[i]-1);
			extra += (no_edge[i] + 1 - no_vert[i]);
			set.edges[parent] = no_vert[i]-1;
		}
		
		if(extra==0)
		{
			min1 = 10000000;
			min2 = 10000000;
			
			for(int i=0;i<n;i++)
			{
				if(no_vert[i]>1)
				{
					if(min1>=no_vert[i])
					{
						min1 = no_vert[i];
						
						if((no_vert[i]-1)>1)
							min2 = Math.min(min2, no_vert[i]-1);
					}
					else
					{
						min2 = Math.min(min2, no_vert[i]);
						if((no_vert[i]-1)>1)
							min1 = Math.min(min1, no_vert[i]-1);
					}
				}
			}
			
			ans -= (long)(2*(min1-1 + min2-1));
		}
		else if(extra==1)
		{
			min1 = 10000000;
			
			for(int i=0;i<n;i++)
			{
				if(no_vert[i]>1)
					min1 = Math.min(min1, no_vert[i]);
			}
			ans -= (long)(2*(min1-1));
		}
		
		System.out.println(ans);
	}
	
	static class Disjoint_Set{
		
	    int[] rank, parent;
	    int[] edges,vertex;
	    int n;
	    
	    public Disjoint_Set(int n)
	    {
	        rank = new int[n];
	        parent = new int[n];
	        edges = new int[n];
	        vertex = new int[n];
	        this.n = n;
	        makeSet();
	    }

	    void makeSet()
	    {
	        for (int i=0; i<n; i++)
	        {
	            parent[i] = i;
	            edges[i] = 0;
	            vertex[i] = 1;
	        }
	    }

	    int find(int x){
	    	return parent[x]==x ? x : (parent[x] = find(parent[x]));
	    }
	    
	    int find_edges(int x) {
	    	
	    	if(parent[x]==x)
	    		return edges[x];
	    	return find_edges(parent[x]);
	    }
	    
	    int find_vertex(int x) {
	    	
	    	if(parent[x]==x)
	    		return vertex[x];
	    	return find_vertex(parent[x]);
	    }
	    
	    void union(int x, int y)
	    {
	        int xRoot = find(x), yRoot = find(y);
	        
	        if (xRoot == yRoot)
	        {
	        	edges[xRoot]++;
	            return;
	        }
	        
	        if (rank[xRoot] < rank[yRoot])
	        {
	            parent[xRoot] = yRoot;
	            edges[yRoot] += edges[xRoot]+1;
	            vertex[yRoot] += vertex[xRoot];
	        }
	        else if (rank[yRoot] < rank[xRoot])
	        {
	            parent[yRoot] = xRoot;
	            edges[xRoot] += edges[yRoot]+1;
	            vertex[xRoot] += vertex[yRoot];
	        }
	        else
	        {
	            parent[yRoot] = xRoot;
	            edges[xRoot] += edges[yRoot]+1;
	            rank[xRoot] = rank[xRoot] + 1;
	            vertex[xRoot] += vertex[yRoot];
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
