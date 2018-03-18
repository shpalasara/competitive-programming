package SnackDown_17;

import java.io.IOException;
import java.util.InputMismatchException;

public class SNTEMPLE {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int t = sc.nextInt(),n;
		long ans;
		
		while(t-->0)
		{
			ans = 0;
			n = sc.nextInt();
			long[] data = new long[n+1];
			long[] min_prev = new long[n+1];
			long sum=0,final_ans;
			
			for(int i=0;i<n;i++)
			{
				data[i] = sc.nextInt();
				sum += data[i];
			}
			
			final_ans = sum;
			
			if(data[0]>1)
			{
				ans += data[0]-1L;
				data[0] = 1;
			}
			
			for(int i=1;i<n;i++)
			{
				if(data[i]>(data[i-1]+1))
				{
					ans += data[i]-(data[i-1]+1);
					data[i] = data[i-1]+1;
				}
			}
			
			if(data[n-1]>1)
			{
				ans += data[n-1]-1L;
				data[n-1] = 1;
			}
			sum = 1;
			
			for(int i=n-2;i>=0;i--)
			{
				if(data[i]>(data[i+1]+1))
				{
					ans += data[i] - (data[i+1]+1L);
					data[i] = data[i+1]+1;
				}
				sum += data[i];
			}
			
			long ap;
			
			for(int i=1;i<n-1;i++)
			{
				if(data[i]>=data[i-1] && data[i]>=data[i+1])
				{
					ap = data[i]*data[i];				// Sum of the serious
					final_ans = Math.min(final_ans, ans + (sum-ap));
				}
			}
			
			System.out.println(final_ans);
		}
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
