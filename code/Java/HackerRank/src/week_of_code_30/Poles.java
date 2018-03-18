package week_of_code_30;

import java.io.IOException;
import java.util.InputMismatchException;

public class Poles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		int n,k;
		n = sc.nextInt();
		k = sc.nextInt();
		int[][] data = new int[n][2];
		
		for(int i=0;i<n;i++)
		{
			data[i][0] = sc.nextInt();					// Altitude of the pole
			data[i][1] = sc.nextInt();					// Weight of the pole
		}
		
		int[][] dp = new int[n+1][k+1];
		int[][] weight = new int[n+1][k+1];
		int[][] score = new int[n+1][n+1];
		
		int we;
		
		for(int i=0;i<n-1;i++)
		{
			we = data[i][1];
			for(int j=i+1;j<n;j++)
			{
				if(j==i+1)
					score[i][j] = we*(data[j][0]-data[j-1][0]);
				else
					score[i][j] = score[i][j-1] + we*(data[j][0]-data[j-1][0]);
				we += data[j][1];
			}
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<k;j++)
			{
//				dp[i][j] = dp[i-1][j-1] + score[][]
//				if(j<=i)
//				{
//					if(i==0)
//					{
//						weight[i][j] = data[i-1][1];
//						dp[i][j] = weight[i][j]*(data[i][0]-data[i-1][0]);
//					}
//					else
//					{
//						weight[i][j] += data[i-1][1];
//					}
//				}
			}
		}
	}
	
	public int max(){
		return 1;
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
