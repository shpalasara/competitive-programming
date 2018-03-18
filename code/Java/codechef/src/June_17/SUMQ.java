package June_17;

// Accepted

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class SUMQ {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		int p,q,r;
		int mod = (int)(1e9 + 7);
		
		while(t-->0)
		{
			p = sc.nextInt();
			q = sc.nextInt();
			r = sc.nextInt();
			
			long[] A = new long[p];
			long[] B = new long[q];
			long[] C = new long[r];
			
			for(int i=0;i<p;i++)
				A[i] = sc.nextLong();
			for(int i=0;i<q;i++)
				B[i] = sc.nextLong();
			for(int i=0;i<r;i++)
				C[i] = sc.nextLong();
			
			Arrays.sort(A);
			Arrays.sort(B);
			Arrays.sort(C);
			
			int length_A = 0 , length_C = 0;
			long sum_A = 0 , sum_C = 0;
			long y_sqr = 0;
			long ans = 0 , temp;
			
			for(int i=0;i<q;i++)
			{
				while(length_A<p && A[length_A]<=B[i])
					sum_A = (sum_A + A[length_A++] )%mod;
				while(length_C<r && C[length_C]<=B[i])
					sum_C = (sum_C + C[length_C++] )%mod;
				
				if(length_A!=0 && length_C!=0)
				{
					y_sqr = (B[i] * B[i])%mod;
					temp = (B[i] * ( ((long)length_C * sum_A ) % mod + ((long)length_A * sum_C ) % mod )) %mod;
					ans = (ans + (sum_A * sum_C )%mod + temp%mod + ( ( ((long)length_A*(long)length_C )%mod ) * y_sqr )%mod )%mod;
				}
			}
			
			out.println(ans);
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
