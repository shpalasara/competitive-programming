package summer_long_1;

import java.io.IOException;
import java.util.InputMismatchException;

public class Stuck_in_a_Matrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		
		int t=sc.nextInt(),n,m,ans,t1,t2,a1;
		int[][] matrix = new int[1001][1001];
		int[][] gcd = new int[1001][1001];
		int[][] gcd_1 = new int[1001][1001];
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					matrix[i][j] = sc.nextInt();
			
//			for(int i=n-1;i>=0;i--)
//			{
//				for(int j=m-1;j>=0;j--)
//				{
//					if(i==n-1 && m==j-1)
//						gcd[i][j] = matrix[i][j];
//					else if(i==n-1)
//						gcd[i][j] = gcd(gcd[i][j+1],matrix[i][j]);
//					else if(j==m-1)
//						gcd[i][j] = gcd(gcd[i+1][j],matrix[i][j]);
//					else
//						gcd[i][j] = Math.max(gcd(gcd[i][j+1],matrix[i][j]),gcd(gcd[i+1][j],matrix[i][j]));
//				}
//			}
			
//			for(int i=0;i<n;i++)
//			{
//				for(int j=0;j<m;j++)
//					System.out.print(gcd[i][j]+" ");
//				System.out.println();
//			}
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					if(i==0 && j==0)
						gcd_1[i][j] = gcd(matrix[i][j] ,matrix[n-i-1][m-j-1]);
					else if(i==0)
						gcd_1[i][j] = gcd(gcd_1[i][j-1],matrix[i][j]);
					else if(j==0)
						gcd_1[i][j] = gcd(gcd_1[i-1][j],matrix[i][j]);
					else
						gcd_1[i][j] = Math.max(gcd(gcd_1[i][j-1],matrix[i][j]),gcd(gcd_1[i-1][j],matrix[i][j]));
				}
			}
			
//			for(int i=0;i<n;i++)
//			{
//				for(int j=0;j<m;j++)
//					System.out.print(gcd_1[i][j]+" ");
//				System.out.println();
//			}
			
//			ans = 1;
//			
//			for(int i=0;i<n;i++)
//			{
//				for(int j=0;j<m;j++)
//				{
//					if(i==0 && j==0)
//						ans = gcd[0][0];
//					else if(i==0)
//					{
//						t1 = gcd(gcd_1[i][j-1],matrix[i][j]);
//						
//						if(i+1<n)
//							ans = Math.max(ans, gcd( t1 , gcd[i+1][j]));
//						
//						if(j+1<m)
//							ans = Math.max(ans, gcd( t1 , gcd[i][j+1]));
//					}
//					else if(j==0)
//					{
//						t1 = gcd(gcd_1[i-1][j],matrix[i][j]);
//						
//						if(i+1<n)
//							ans = Math.max(ans, gcd( t1 , gcd[i+1][j]));
//						
//						if(j+1<m)
//							ans = Math.max(ans, gcd( t1 , gcd[i][j+1]));
//					}
//					else
//					{
//						t1 = gcd(gcd_1[i][j-1],matrix[i][j]);			// The previous one
//						t2 = gcd(gcd_1[i-1][j],matrix[i][j]); 			// The above one
//						
//						if(i+1<n)
//							ans = Math.max(ans, Math.max( gcd( t1 , gcd[i+1][j] ) , gcd( t2 , gcd[i+1][j] )));
//						
//						if(j+1<m)
//							ans = Math.max(ans, Math.max( gcd( t1 , gcd[i][j+1] ) , gcd( t2 , gcd[i][j+1] )));
//					}
//				}
//			}
//			
//			ans = Math.max(ans , Math.max(gcd[0][0] , gcd_1[n-1][m-1]));
//			
			if(gcd_1[n-1][m-1]==1)
				System.out.println("HOLD THE DOOR!");
			else
				System.out.println(gcd_1[n-1][m-1]);
		}
	}
	
	public static int gcd(int a,int b){
		
		a=Math.abs(a);
		b=Math.abs(b);
		
		int temp;
		while(b!=0)
		{
			temp = a%b;
			a = b;
			b = temp;
		}
		return a;
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
//1
//3 3
//14 7 1
//2 70 5
//1 4 20