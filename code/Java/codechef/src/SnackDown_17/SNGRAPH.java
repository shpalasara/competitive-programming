package SnackDown_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class SNGRAPH {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt(),n,m,u,v;
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			int[][] degree = new int[n][2];
			ArrayList<Integer>[] list = new ArrayList[n];
			int[] unsorted = new int[n];
			
			for(int i=0;i<n;i++)
			{
				list[i] = new ArrayList<Integer>();
				degree[i][1] = i;
			}
			
			while(m-->0)
			{
				u = sc.nextInt()-1;
				v = sc.nextInt()-1;
				degree[v][0]++;
				degree[u][0]++;
				list[v].add(u);
				list[u].add(v);
			}

			for(int i=0;i<n;i++)
				unsorted[i] = degree[i][0];
			
			java.util.Arrays.sort(degree, new java.util.Comparator<int[]>() {
			
				  public int compare(int[] a,int[] b) {
				    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));
				  }
			});
			
//			for(int i=0;i<n;i++)
//				out.print(degree[i]+" ");
//			out.println();
			
			int[] ans = new int[n+1];
			int temp_ans=0,index=0,vertex;
			
			for(int i=0;i<n;i++)
			{
				while(index<n && degree[index][0]==i)
				{
					vertex = degree[index][1];
					
					for(int j=0;j<list[vertex].size();j++)
					{
						unsorted[list[vertex].get(j)]--;
						if(unsorted[list[vertex].get(j)]==0)
						{
							unsorted[list[vertex].get(j)] = -1;
							temp_ans++;
						}
					}
					if(unsorted[vertex]>=0)
						temp_ans++;
					unsorted[vertex] = -1;
					index++;
				}
				ans[i] = temp_ans;
			}
			
			for(int i=0;i<n;i++)
			{
//				ans[i] += ans[i-1];
				if(ans[i]>(n-1))
					ans[i] = n-1;
			}
			
			for(int i=0;i<n;i++)
				out.print(ans[i]+" ");
			out.println();
		}
		out.close();
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
