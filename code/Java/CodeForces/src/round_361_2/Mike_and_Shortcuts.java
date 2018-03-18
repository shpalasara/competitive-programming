package round_361_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Mike_and_Shortcuts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n=sc.nextInt();
		int[] next = new int[n];
		int[] ans = new int[n];
		
		for(int i=0;i<n;i++)
		{
			next[i] = sc.nextInt();
			ans[i] = Integer.MAX_VALUE;
		}
		
		ans[0]=0;
		
		if(next[0]-1!=0)
			ans[next[0]-1] = 1;
		
		for(int i=1;i<n;i++)
		{
			if(ans[i]<ans[i-1]+1)
			{
				int j=i-1;
				while(j>0 && ans[j]>ans[i]+i-j)
				{
					ans[j] = ans[i]+i-j;
					
					if(next[j]-1!=j)
						ans[next[j]-1] = Math.min(ans[next[j]-1], ans[j]+1);
					
					j--;
				}
			}
			else
				ans[i] = ans[i-1]+1;
			
			if(next[i]-1!=i)
				ans[next[i]-1] = Math.min(ans[next[i]-1], ans[i]+1);
		}
		
		//int min = ans[n-1];
		
		//for(int i=n-2;i>0;i--)
		//	ans[i] = Math.min(ans[i], ans[i+1]+1);
		
		for(int i=0;i<n;i++)
			out.print(ans[i]+" ");
		
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
