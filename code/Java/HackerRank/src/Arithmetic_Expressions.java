import java.io.IOException;
import java.util.InputMismatchException;

public class Arithmetic_Expressions {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		int n = sc.nextInt();
		int[] data = new int[n];
		
		boolean[][] dp = new boolean[n][101];
		int[][] operator = new int[n][101];
		int[][] prev = new int[n][101];
		
		for(int i=0;i<n;i++)
			data[i] = sc.nextInt();
		
		dp[0][data[0]] = true;
		
		int x;
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<101;j++)
			{
				if(dp[i-1][j])
				{
					x = (j + data[i])%101;
					prev[i][x] = j;
					operator[i][x] = 1;
					dp[i][x] = true;
					
					x = (j*data[i])%101;
					prev[i][x] = j;
					operator[i][x] = 2;
					dp[i][x] = true;
					
					x = (j-data[i]+101)%101;
					prev[i][x] = j;
					operator[i][x] = 3;
					dp[i][x] = true;
				}
			}
		}
		
		StringBuilder str = new StringBuilder("");
		
		x = 0;
		
		for(int i=n-1;i>0;i--)
		{
			str.insert(0, data[i]);
			if(operator[i][x]==1)
				str.insert(0, '+');
			else if(operator[i][x]==2)
				str.insert(0, '*');
			else if(operator[i][x]==3)
				str.insert(0, '-');
			else
				str.insert(0, ' ');
			x = prev[i][x];
		}
		str.insert(0, data[0]);
		
		System.out.println(str.toString());
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
