package August_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class CHEFFA_1 {

	static long mod = (long)(1e9+7);
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		long temp_ans;
		int n,loop;
		
		long[][] dp = new long[129][129];
		
		long[][][] ndp = new long[129][129][129];
		long[][][] odp = new long[129][129][129];
		long[][][] tdp = new long[129][129][129];
		
		for(int i=0;i<129;i++)
			dp[i][0] = 1L;
		for(int j=0;j<129;j++)
			dp[0][j] = 1L;
		
		for(int j=1;j<129;j++)
		{
			for(int i=1;i<129;i++)
			{
				temp_ans = 1L;
				loop = Math.min(i, j);
				for(int k=1;k<=loop;k++)
					temp_ans = (temp_ans + dp[j-k][k])%mod;
				dp[i][j] = temp_ans;
			}
		}
		
		for(int i=0;i<129;i++)
			ndp[0][i][0] = 1L;
		for(int j=0;j<129;j++)
			ndp[0][0][j] = 1L;
		
		for(int i=0;i<129;i++)
		{
			for(int j=0;j<129;j++)
			{
				for(int k=0;k<129;k++)
				{
					if((i<76 || j<76) && (j<76 || k<76))
					{
						if(j==0 || (i==0 && k==0))
							ndp[i][j][k] = 1L;
						else if(i==0 || k==128)
							ndp[i][j][k] = dp[j][k];
//						else if(k==125)
//							ndp[i][j][k] = 1L;
						else
							ndp[i][j][k] = (ndp[0][j][k] + ndp[i-1][j-1][k+1])%mod;
				
					}
				}
			}
		}
		
//		for(int i=0;i<101;i++)
//		{
//			for(int j=0;j<101;j++)
//				System.out.print(dp[i][j]+"  ");
//			System.out.println();
//		}
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
				out.println(dp[x][y]);
			}
			else if(n==3)
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				int z = sc.nextInt();
				out.println(ndp[x][y][z]);
			}
			else
			{
				int[] data = new int[n];
				
				for(int i=0;i<n;i++)
					data[i] = sc.nextInt();
				
				for(int i=0;i<129;i++)
				{
					for(int j=0;j<129;j++)
					{
						for(int k=0;k<129;k++)
							odp[i][j][k] = ndp[i][j][k];
					}
				}
				
				int d;
				
				for(int z=n-1;z>2;z--)
				{
					d = data[z];
					
					for(int i=0;i<129;i++)
					{
						for(int j=0;j<129;j++)
						{
							for(int k=0;k<129;k++)
							{
								if((i<76 || j<76) && (j<76 || k<76))
								{
									if(i==0 || j==0)
										tdp[i][j][k] = odp[j][k][d];
									else if(k==128)
										tdp[i][j][k] = odp[j][k][d] ;
									else
										tdp[i][j][k] = (odp[j][k][d] + tdp[i-1][j-1][k+1])%mod;
								}
							}
						}
					}
					for(int i=0;i<129;i++)
						for(int j=0;j<129;j++)
							for(int k=0;k<129;k++)
								odp[i][j][k] = tdp[i][j][k];
					
				}
				
				out.println(odp[data[0]][data[1]][data[2]]);
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
