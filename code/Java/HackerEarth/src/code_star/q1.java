package code_star;

import java.io.IOException;
import java.util.InputMismatchException;

public class q1 {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int t=sc.nextInt();
		long n,k,mod;
		
		while(t-->0)
		{
			n=sc.nextLong();
			k=sc.nextLong();
			mod=1<<k;
			
			if(k==0)
				System.out.println("0");
			else
			{
				
				System.out.println(fib(n+(long)1,mod));
			}
		}
	}
	
	public static long fib(long n,long mod)
	{
	  long[][] F = new long[2][2];
	  
	  F[0][0]=F[0][1]=F[1][0]=1;
	  F[1][1]=0;
	  
	  if (n == 0)
	    return 0;
	  
	  power(F, n-1,mod);
	  return F[0][0];
	}
	 
	/* Optimized version of power() in method 4 */
	public static void power(long[][] F, long n,long mod)
	{
	  if( n == 0 || n == 1)
	      return;
	  
	  long[][] M = new long[2][2];
	  
	  M[0][0]=M[0][1]=M[1][0]=1;
	  F[1][1]=0;
	 
	  power(F, n/2,mod);
	  multiply(F, F,mod);
	 
	  if (n%2 != 0)
	     multiply(F, M,mod);
	}
	 
	public static void multiply(long F[][], long M[][],long mod)
	{
	  long x =  ((F[0][0]*M[0][0])%mod + (F[0][1]*M[1][0])%mod)%mod;
	  long y =  ((F[0][0]*M[0][1])%mod + (F[0][1]*M[1][1])%mod)%mod;
	  long z =  ((F[1][0]*M[0][0])%mod + (F[1][1]*M[1][0])%mod)%mod;
	  long w =  ((F[1][0]*M[0][1])%mod + (F[1][1]*M[1][1])%mod);
	 
	  F[0][0] = x;
	  F[0][1] = y;
	  F[1][0] = z;
	  F[1][1] = w;
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
