package August_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class CHEFFA {

	static long mod = (long)(1e9+7);
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		long temp_ans;
		int n,loop;
		
		long[][][] dp = new long[51][140][140];
		
		for(int i=0;i<140;i++)
			dp[0][i][0] = 1L;
		for(int j=0;j<140;j++)
			dp[0][0][j] = 1L;
		
		for(int j=1;j<140;j++)
		{
			for(int i=1;i<140;i++)
			{
				temp_ans = 1L;
				loop = Math.min(i, j);
				for(int k=1;k<=loop;k++)
					temp_ans = (temp_ans + dp[0][j-k][k])%mod;
				dp[0][i][j] = temp_ans;
			}
		}

		while(t-->0)
		{
			n = sc.nextInt();
			
			if(n==1)
			{
				sc.nextInt();
				out.println(1);
			}
			else if(n==2)
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				out.println(dp[0][x][y]);
			}
			else
			{
				int[] data = new int[n];
				int index = 1;
				
				for(int i=0;i<n;i++)
					data[i] = sc.nextInt();
				
				int d;
				
				for(int z=n-1;z>1;z--)
				{
					d = data[z];
					
					for(int y=0;y<140;y++)
					{
						for(int x=0;x<140;x++)
						{
							loop = Math.min(x, y);
							temp_ans = 0L;
							if(d+loop>140)
								break;
							for(int k=0;k<=loop;k++)
							{
								temp_ans = (temp_ans + dp[index-1][y-k][d+k])%mod;	
							}
							dp[index][x][y] = temp_ans;
						}
					}

					index++;
				}
				
				out.println(dp[index-1][data[0]][data[1]]);
			}
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
