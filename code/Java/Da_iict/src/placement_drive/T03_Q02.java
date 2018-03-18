package placement_drive;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class T03_Q02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int r,c,q,x1,y1,x2,y2,ans;
		
		r = sc.nextInt();
		c = sc.nextInt();
		int[][] data = new int[r+1][c+1];
		
		for(int i=1;i<=r;i++)
		{
			for(int j=1;j<=c;j++)
				data[i][j] = sc.nextInt();
		}
		
		for(int i=1;i<=r;i++)
		{
			for(int j=2;j<=c;j++)
				data[i][j] ^= data[i][j-1];
		}
		
		for(int j=1;j<=c;j++)
		{
			for(int i=2;i<=r;i++)
				data[i][j] ^=data[i-1][j];
		}
		
		q = sc.nextInt();
		
//		for(int i=0;i<=r;i++)
//		{
//			for(int j=0;j<=c;j++)
//				System.out.print(data[i][j]+" ");
//			System.out.println();
//		}
		
		while(q-->0)
		{
			x1 = sc.nextInt()-1;
			y1 = sc.nextInt()-1;
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			
			ans = data[x2][y2]^data[x2][y1]^data[x1][y2]^data[x1][y1];
			out.println(ans);
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
