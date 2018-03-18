package company;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class amazon_1 {

	static long mod = (long)(1e9+7);
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		int x,k;
		long pre_sum = 0;
		
		long[] pre_dp = new long[101];
		
		for(int i=1;i<101;i++)
			pre_dp[i] = 1;
		
		for(int i=1;i<101;i++)
		{
			pre_dp[i] = (pre_dp[i]+pre_sum)%mod;
			pre_sum = (pre_sum + pre_dp[i])%mod;
		}
		
		for(int i=0;i<20;i++)
			System.out.println(pre_dp[i]);
		
		while(t-->0)
		{
			x = sc.nextInt();
			k = sc.nextInt();
			pre_sum = 0;
			
			if(x<=k)
			{
				out.println(pre_dp[x]);
			}
			else
			{
				long[] dp = new long[x+1];
				
				for(int i=1;i<=k;i++)
				{
					dp[i] = pre_dp[i];
					pre_sum = (pre_sum + dp[i])%mod;
				}
				
				for(int i=k+1;i<=x;i++)
				{
					pre_sum = (pre_sum - dp[i-k-1] + mod)%mod;
					
					dp[i] = (dp[i] + pre_sum)%mod;
					pre_sum = (pre_sum + dp[i])%mod;
				}
				
				out.println(dp[x]);
			}
		}
		
		out.close();
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
