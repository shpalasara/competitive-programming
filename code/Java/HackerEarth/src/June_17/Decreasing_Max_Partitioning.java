package June_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Decreasing_Max_Partitioning {

	static long mod = (long)(1e9 + 7);
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t,n;
		t = sc.nextInt();
		int[] data = new int[100001];
		int[] l_max = new int[100001];
		int[] r_max = new int[100001];
		long prev,ans;
		
		while(t-->0)
		{
			n = sc.nextInt();
			ans = 1;
			
			for(int i=0;i<n;i++)
				data[i] = sc.nextInt();
			
			l_max[0] = data[0];
			for(int i=1;i<n;i++)
				l_max[i] = Math.max(l_max[i-1], data[i]);
			
			r_max[n-1] = data[n-1];
			for(int i=n-2;i>=0;i--)
				r_max[i] = Math.max(r_max[i+1], data[i]);
			
			prev=n-1;
			for(int i=n-2;i>=0;i--)
			{
				if(data[i]>=r_max[i+1])
				{
					ans = (ans*(long)(prev-i+1))%mod;
					prev = i;
				}
			}
			
			out.println(ans);
		}
		
		out.close();
	}
	
	// finding (a^n)%mod in log(n) Iteratively
	public static long power(long a,long n){
		
		long ans=1L;
		
		while(n!=0)
		{
			if((n&1L)==1L)
				ans=(ans*a)%mod;
			
			a = (a*a)%mod;
			n=n>>1;
		}
		return ans;
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
