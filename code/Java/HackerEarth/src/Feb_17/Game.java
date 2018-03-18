package Feb_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		int n,q,ans;
		
		while(t-->0)
		{
			n = sc.nextInt();
			q = sc.nextInt();
			ans = n;
			
			int[][] block = new int[q][2];
			
			for(int i=0;i<q;i++)
			{
				block[i][0] = sc.nextInt();
				block[i][1] = sc.nextInt();
			}
			
			java.util.Arrays.sort(block, new java.util.Comparator<int[]>() {
			
				  public int compare(int[] a,int[] b) {
			
				    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? (a[1] < b[1] ? -1 : 1) : 1));
			
				  }
			
				});
			
			int prev = 0,col=0,prev_v=0;
			
			for(int i=0;i<q;i++)
			{
				if(i+2<q && block[i][0]==block[i+2][0])
				{	
					ans = block[i][0]-1;
					break;
				}
				
				if(i+1<q)
				{
					if(block[i][0]==block[i+1][0])
					{
						if(prev_v+1==block[i][0] && (block[i][1]==2 || block[i+1][1]==2))
						{
//							if(block[i-1][1]==2)
//							{
//								if(block[i-2][1]!=block[i][1] && block[i-2][1]!=block[i+1][1])
//								{
//									ans = block[i-2][0];
//									break;
//								}
//							}
//							else if(block[i-2][1]==2)
//							{
//								if(block[i-1][1]!=block[i][1] && block[i-1][1]!=block[i+1][1])
//								{
//									ans = block[i-2][0];
//									break;
//								}
//							}
							if(col!=0 && block[i][1]!=col && block[i+1][1]!=col)
							{
								ans = block[i][0]-1;
								break;
							}
						}
							
						prev_v = block[i][0];
						
						if(block[i][1]==2)
							col = block[i+1][1];
						else if(block[i+1][1]==2)
							col = block[i][1];
						else
							col = 0;
						i++;
					}
					else
					{
						if(block[i][1]!=2)
							col = 0;
						else if(col!=0 && prev_v+1 == block[i][0])
							prev_v = block[i][0];
					}
				}	
			}
			
			out.println(ans);
		}
		
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
