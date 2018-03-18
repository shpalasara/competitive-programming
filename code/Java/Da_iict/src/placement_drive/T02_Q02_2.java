package placement_drive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class T02_Q02_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		int t=sc.nextInt(),n,m,groups,max;
		
		ArrayList<Integer> list = new ArrayList<Integer>();

		
		while(t-->0)
		{
			n=sc.nextInt();
			m=sc.nextInt();
			groups=0;
			max=0;
			boolean[][] check = new boolean[n][m];
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					if(sc.nextInt()==1)
						check[i][j] = true;
					else
						check[i][j] = false;
				}
			}
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					if(check[i][j])
					{
						groups++;
						max= Math.max(max, recurse(i,j,n,m,check));
					}
				}
			}
			
			System.out.println(groups+" "+max);
		}
	}

	public static int recurse(int i,int j,int n,int m,boolean[][] check)
	{
		int ans=1;
		check[i][j] = false;
		
		if(i-1>=0 && j-1>=0 && check[i-1][j-1])
			ans+=recurse(i-1,j-1,n,m,check);
		
		if(i-1>=0 && check[i-1][j])
			ans+=recurse(i-1,j,n,m,check);
		
		if(j-1>=0 && check[i][j-1])
			ans+=recurse(i,j-1,n,m,check);
		
		if(i+1<n && j-1>=0 && check[i+1][j-1])
			ans+=recurse(i+1,j-1,n,m,check);
		
		if(i-1>=0 && j+1<m && check[i-1][j+1])
			ans+=recurse(i-1,j+1,n,m,check);
		
		if(j+1<m && check[i][j+1])
			ans+=recurse(i,j+1,n,m,check);
		
		if(i+1<n && check[i+1][j])
			ans+=recurse(i+1,j,n,m,check);
		
		if(i+1<n && j+1<m && check[i+1][j+1])
			ans+=recurse(i+1,j+1,n,m,check);
		
		return ans;
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
