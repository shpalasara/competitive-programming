package company;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class amazon_2 {

	public static void main(String[] args) {
	
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		long a,b,gcd,min,max,lcm,l,r;
		long n;
		
		while(t-->0)
		{
			a = sc.nextInt();
			b = sc.nextInt();
			n = sc.nextInt();
			
			gcd = GCD(a,b);
			lcm = a*(b/gcd);
			
			min = Math.min(a, b);
			max = Math.max(a, b);
			
			l = 1;
			r = (n+1L)*min;
			
			long ans = BinarySearch( l, r, n, a, b, lcm);
			
			if(ans%a==0 || ans%b==0)
				out.println(ans);
			else
			{
				min = (ans/a)*a;
				max = (ans/b)*b;
				out.println(Math.max(min, max));
			}
		}
		
		out.close();
	}
	
	public static long BinarySearch(long l, long r, long n, long a, long b, long c) {
		
		long mid,count;
		
		mid = (l+r)>>1;
		
		while(l<r)
		{
			mid = (l+r)>>1;
			count = mid/a + mid/b - mid/c;
			
			if(count==n)
				return mid;
			if(count<n)
				l = mid+1;
			else
				r = mid;
		}
		
		return mid;
	}
	
	public static long GCD(long a,long b){
		
		a=Math.abs(a);
		b=Math.abs(b);
		
		long temp;
		while(b!=0)
		{
			temp = a%b;
			a = b;
			b = temp;
		}
		return a;
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
