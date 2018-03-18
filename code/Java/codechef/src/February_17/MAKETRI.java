package February_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class MAKETRI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		long l = sc.nextLong(),r = sc.nextLong();
		long[] data = new long[n];
		
		for(int i=0;i<n;i++)
			data[i] = sc.nextLong();
		
		Arrays.sort(data);
		long[][] interval = new long[n-1][2];
		
		for(int i=1;i<n;i++)
		{
			interval[i-1][0] = data[i]-data[i-1]+1L;
			interval[i-1][1] = data[i-1]+data[i]-1L;
		}
		
		java.util.Arrays.sort(interval, new java.util.Comparator<long[]>() {
		
			  public int compare(long[] a,long[] b) {
		
			    return ((a[0]-b[0]) < 0 ? -1 : ((a[0]-b[0]) == 0 ? ((a[1]-b[1]) < 0 ? -1 : 1) : 1));
		
			  }
		
			});
		
		long x=interval[0][0];
		long y=interval[0][1];
		long ans = 0;
		
		for(int i=1;i<n-1;i++)
		{
			if((long)(y-interval[i][0])>=0L)
				y = Math.max(y, interval[i][1]);
			else
			{
				x = Math.max(x, l);
				y = Math.min(y, r);
				if((long)(y-x)>=0L)
					ans += y-x+1L;
				x = interval[i][0];
				y = interval[i][1];
			}
		}
		
		x = Math.max(x, l);
		y = Math.min(y, r);
		if((long)(y-x)>=0L)
			ans += y-x+1L;
		
		out.println(ans);
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
