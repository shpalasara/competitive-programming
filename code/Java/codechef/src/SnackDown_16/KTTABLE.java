package SnackDown_16;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

public class KTTABLE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FasterScanner sc = new FasterScanner();
		int t=sc.nextInt(),n,i_a,i_b,ans,temp,temp1;
		int[] A,B;
		
		while(t-->0)
		{
			ans = 0;
			n=sc.nextInt();
			A = new int[n];
			B = new int[n];
			
			temp1 = 0;
			
			for(int i=0;i<n;i++)
			{
				temp = sc.nextInt();
				A[i] = temp-temp1;
				temp1 = temp;
			}
				
			//Arrays.sort(A);
			
			for(int i=0;i<n;i++)
				B[i]=sc.nextInt();
			
			//Arrays.sort(B);
			
			for(int i=0;i<n;i++)
				if(A[i]>=B[i])
					ans++;
			
			System.out.println(ans);
			
//			i_a=n-1;
//			i_b=n-1;
//			
//			for(int i=0;i<n;i++)
//				System.out.print(A[i]+" ");
//			
//			System.out.println();
//			
//			for(int i=0;i<n;i++)
//				System.out.print(B[i]+" ");
//			
//			System.out.println();
//			
//			while(i_a>=0 && i_b>=0)
//			{
//				if(A[i_a]>=B[i_b])
//				{
//					ans++;
//					i_a--;
//				}
//				i_b--;
//			}
//			
//			System.out.println(ans);
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
