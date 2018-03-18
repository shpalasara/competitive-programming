package SnackDown_16;

// Accepted

import java.io.IOException;
import java.util.InputMismatchException;

public class MMSUM_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		int t=sc.nextInt(),n;
		long data[];
		long temp_ans,temp_min,long_ans,long_min,ans,max;
		
		while(t-->0)
		{
			n=sc.nextInt();
			data = new long[n];
			
			for(int i=0;i<n;i++)
				data[i] = sc.nextInt();
			
			ans = max = Integer.MIN_VALUE;
			temp_ans = long_ans = 0;
			temp_min = long_min = 0;
			
			for(int i=0;i<n;i++)
			{
				temp_ans+=data[i];
				long_ans+=data[i];
				long_min = Math.min(data[i], long_min);
				
				if(temp_ans<=data[i])
				{
					temp_ans = data[i];
					temp_min = 0;
				}
				
				temp_min = Math.min(temp_min, data[i]);
				
				if(long_ans-long_min<temp_ans-temp_min)
				{
					long_ans = temp_ans;
					long_min = temp_min;
				}
				
				ans = Math.max(ans, Math.max(temp_ans-temp_min, long_ans-long_min));
				max = Math.max(max, data[i]);
			}
			
			if(max<0)
				System.out.println(max);
			else
				System.out.println(ans);
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
