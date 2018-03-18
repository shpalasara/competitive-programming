package SnackDown_17;

import java.io.IOException;
import java.util.InputMismatchException;

public class SNSOCIAL_1 {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int t = sc.nextInt(),n,m;
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			int[][] data = new int[n][m];
			int[][] d_data = new int[n][m];
			
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					data[i][j] = sc.nextInt();
			
			int change,max,count=0;
			boolean tp = false;
			
			while(true)
			{
				change = 0;
				
				for(int i=0;i<n;i++)
				{
					for(int j=0;j<m;j++)
					{
						max = 0;
						if(tp)
						{
							if(i>0)
								max = Math.max(max, d_data[i-1][j]);
							if(j>0)
								max = Math.max(max, d_data[i][j-1]);
							if(i>0 && j>0)
								max = Math.max(max, d_data[i-1][j-1]);
							if(i+1<n)
								max = Math.max(max, d_data[i+1][j]);
							if(j+1<m)
								max = Math.max(max, d_data[i][j+1]);
							if(i+1<n && j+1<m)
								max = Math.max(max, d_data[i+1][j+1]);
							if(i+1<n && j>0)
								max = Math.max(max, d_data[i+1][j-1]);
							if(i>0 && j+1<m)
								max = Math.max(max, d_data[i-1][j+1]);
							
							data[i][j] = Math.max(max, d_data[i][j]);
						}
						else
						{
							if(i>0)
								max = Math.max(max, data[i-1][j]);
							if(j>0)
								max = Math.max(max, data[i][j-1]);
							if(i>0 && j>0)
								max = Math.max(max, data[i-1][j-1]);
							if(i+1<n)
								max = Math.max(max, data[i+1][j]);
							if(j+1<m)
								max = Math.max(max, data[i][j+1]);
							if(i+1<n && j+1<m)
								max = Math.max(max, data[i+1][j+1]);
							if(i+1<n && j>0)
								max = Math.max(max, data[i+1][j-1]);
							if(i>0 && j+1<m)
								max = Math.max(max, data[i-1][j+1]);
							
							d_data[i][j] = Math.max(max, data[i][j]);
						}

						if(data[i][j]!=d_data[i][j])
							change++;
					}
				}
				if(change==0)
					break;
				count++;
				tp = !tp;
			}
			
			System.out.println(count);
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
