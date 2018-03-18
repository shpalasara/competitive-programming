package snapdeal;
import java.io.IOException;
import java.util.*;

public class q2 {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int n=sc.nextInt(),m=sc.nextInt();
		int[][] hotel = new int[n][m];
		long[] row = new long[n];
		long[] col = new long[m];
		long[][] diag = new long[n][m];
		long ans=0;
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				hotel[i][j]=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(i==0 && j==0)
					col[j]=row[i]=diag[i][j]=hotel[i][j];
				else if(i==0)
				{
					ans=((long)hotel[i][j]*row[i])%1000000007;
					row[i]=(ans+row[i])%1000000007;
					col[j]=ans;
					diag[i][j]=ans;
				}
				else if(j==0)
				{
					ans=((long)hotel[i][j]*col[j])%1000000007;
					col[j]=(ans+col[j])%1000000007;
					row[i]=(row[i]+ans)%1000000007;
					diag[i][j]=ans;
				}
				else
				{
					ans=((long)hotel[i][j]*(diag[i-1][j-1]+row[i]+col[j]))%1000000007;
					diag[i][j]=(diag[i-1][j-1]+ans)%1000000007;
					row[i]=(ans+row[i])%1000000007;
					col[j]=(ans+col[j])%1000000007;
				}	
			}
		}
		System.out.println(ans);
		//sc.close();
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