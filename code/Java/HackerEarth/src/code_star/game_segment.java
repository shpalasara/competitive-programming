package code_star;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class game_segment {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int n=Integer.parseInt(sc.nextLine()),ans,length;
		String data;
		int[] presum = new int[55];
		int[][] dp = new int[55][55];
		int[][] dp1 = new int[55][55];
		ArrayList<Integer>[] temp = null;
		
		while(n-->0)
		{
			for(int i=0;i<55;i++)
				temp[i]=new ArrayList<Integer>();
			
			ans=1;
			data=sc.nextLine();
			length=data.length();
			presum[0]=data.charAt(0)-'0';
			
			for(int i=1;i<length;i++)
				presum[i]=presum[i-1]+data.charAt(i)-'0';
			
			for(int i=0;i<length;i++)
			{
				for(int j=i;j<length;j++)
				{
					if(i==0)
					{
						if(2*presum[j]<presum[length-1])
						{
							if(j==0)
								dp[i][j]=1;
							else
								dp[i][j]=dp[i][j-1]+1;
						}
						else
						{
							if(j==0)
								dp[i][j]=0;
							else
								dp[i][j]=dp[i][j-1];
						}
					}
					else
					{
						if(2*presum[j]<presum[length-1] && 2*presum[i-1]<presum[j])
						{
							if(j==0)
								dp[i][j]=1;
							else
								dp[i][j]=dp[i][j-1]+1;
						}
						else
						{
							if(j==0)
								dp[i][j]=0;
							else
								dp[i][j]=dp[i][j-1];
						}
						
						dp1[i][j]=dp[i][j]*dp[0][i-1];
					}
				}
			}
		}
	}
	
	// s_i - starting index of the segment
	// e_i - ending index of the segment 
	public static int get_segment(int s_i,int e_i,int[] presum){
		
		return 0;
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
