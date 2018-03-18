package Sept_17;

import java.io.IOException;
import java.util.InputMismatchException;

public class Little_Shino_and_Number_of_Divisors {

	static long mod = (long)(1e9+7);
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		
		int x = sc.nextInt();
		long[] count = new long[x];
		
		for(int i=0;i<x;i++)
			count[i] = sc.nextInt();
		
		long[] pre_mul = new long[x];
		long[] post_mul = new long[x];
		
		pre_mul[0] = (count[0]+1L);
		for(int i=1;i<x;i++)
			pre_mul[i] = (pre_mul[i-1] * (count[i]+1L))%mod;

//		for(int i=0;i<x;i++)
//			System.out.print(pre_mul[i]+" ");
//		System.out.println();
		
		post_mul[x-1] = (count[x-1]+1L);
		for(int i=x-2;i>=0;i--)
			post_mul[i] = (post_mul[i+1]* (count[i]+1L))%mod;
		
//		for(int i=0;i<x;i++)
//			System.out.print(post_mul[i]+" ");
//		System.out.println();
		
		for(int i=0;i<x;i++)
			count[i] = ((count[i]*(count[i]+1L))>>1)%mod;
		
//		for(int i=0;i<x;i++)
//			System.out.print(count[i]+" ");
//		System.out.println();
		
		for(int i=1;i<x-1;i++)
			count[i] = (count[i]*((pre_mul[i-1]*post_mul[i+1])%mod))%mod;
		if(x>1)
		{
			count[0] = (count[0]*post_mul[1])%mod;
			count[x-1] = (count[x-1]*pre_mul[x-2])%mod;
		}
		
//		for(int i=0;i<x;i++)
//			System.out.print(count[i]+" ");
//		System.out.println();
		
		long ans=1;
		
		for(int i=0;i<x;i++)
			ans = (ans * (count[i]+1L))%mod;
		
		System.out.println(ans);
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
