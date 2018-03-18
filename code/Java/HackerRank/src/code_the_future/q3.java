package code_the_future;

import java.io.IOException;
import java.util.InputMismatchException;

public class q3 {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		String[] temp=sc.nextLine().split(" ");
		int n=Integer.parseInt(temp[0]),m=Integer.parseInt(temp[1]);
		boolean[][] good = new boolean[n][m];
		int[][] left = new int[n][m];
		int[][] right = new int[n][m];
		int[][] up = new int[n][m];
		int[][] down = new int[n][m];
		String data;
		
		for(int i=0;i<n;i++)
		{
			data=sc.nextLine();
			
			for(int j=0;j<m;j++)
				if(data.charAt(j)=='G')
					good[i][j]=true;
		}
		
		//To assign the value of left and up array
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if((i==0 && j==0) || !good[i][j])
				{
					left[i][j]=1;
					up[i][j]=1;
					continue;
				}
				else if(i==0)
				{
					up[i][j]=1;
					left[i][j]=1+left[i][j-1];
				}
				else if(j==0)
				{
					left[i][j]=1;
					up[i][j]=1+up[i-1][j];
				}
				else
				{
					left[i][j]=1+left[i][j-1];
					up[i][j]=1+up[i-1][j];
				}
			}
		}
		
		//To assign the value of right and down
		for(int i=n-1;i>=0;i--)
		{
			for(int j=m-1;j>=0;j--)
			{
				if((i==n-1 && j==m-1) || !good[i][j])
				{
					right[i][j]=1;
					down[i][j]=1;
					continue;
				}
				else if(i==n-1)
				{
					down[i][j]=1;
					right[i][j]=1+right[i][j+1];
				}
				else if(j==m-1)
				{
					right[i][j]=1;
					down[i][j]=1+down[i+1][j];
				}
				else
				{
					right[i][j]=1+right[i][j+1];
					down[i][j]=1+down[i+1][j];
				}
			}
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
