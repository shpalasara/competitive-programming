package round_404_2;

import java.io.IOException;
import java.util.InputMismatchException;

public class Anton_and_Classes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		int n = sc.nextInt();
		int[][] chess = new int[n][2];
		
		int chess_end_min=0,chess_start_max=0;
		
		for(int i=0;i<n;i++)
		{
			chess[i][0] = sc.nextInt();
			chess[i][1] = sc.nextInt();
			
			if(i==0)
			{
				chess_end_min = chess[i][1];
				chess_start_max = chess[i][0];
			}
			else
			{
				chess_end_min = Math.min(chess_end_min, chess[i][1]);
				chess_start_max = Math.max(chess_start_max, chess[i][0]);
			}
		}
		
		int m = sc.nextInt();
		int[][] prog = new int[m][2];
		int prog_end_min=0,prog_start_max=0;
		
		for(int i=0;i<m;i++)
		{
			prog[i][0] = sc.nextInt();
			prog[i][1] = sc.nextInt();
			
			if(i==0)
			{
				prog_end_min = prog[i][1];
				prog_start_max = prog[i][0];
			}
			else
			{
				prog_end_min = Math.min(prog_end_min, prog[i][1]);
				prog_start_max = Math.max(prog_start_max, prog[i][0]);
			}
		}
		
		int ans = Math.max(prog_start_max-chess_end_min, 0);
		ans = Math.max(ans, chess_start_max-prog_end_min);
		
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
