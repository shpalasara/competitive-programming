package placement_drive;

// wrong Approch

import java.io.IOException;
import java.util.InputMismatchException;

public class T02_Q02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		int t =sc.nextInt(),n,m,group,max;
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			max=0;
			group = 0;
			
			int[] data = new int[m];
			int[][] ans = new int[m+1][2];
			
			ans[0][0] = sc.nextInt();
			
			if(ans[0][0]==1)
				group++;
			
			for(int i=1;i<m;i++)
			{
				if(sc.nextInt()==1)
				{
					ans[i][0] = ans[i-1][0]+1;
					if(ans[i][0]==1)
						group++;
				}
				else
					ans[i][0]=0;
			}
			
			for(int j=m-2;j>=0;j--)
			{
				if(ans[j+1][0]!=0 && ans[j][0]!=0)
					ans[j][0] = ans[j+1][0];
			}
			
			for(int i=0;i<m;i++)
				System.out.print(ans[i][0]+" ");
			System.out.println();
			
			for(int i=1;i<n;i++)
			{
				for(int j=0;j<m;j++)
					data[j] = sc.nextInt();
	
				if(data[0]==1)
				{
					if(ans[0][0]!=0)
					{
						ans[0][1] = ans[0][0]+1;
					}
					else
					{
						ans[0][1] = 1;
						group++;
					}
				}
				else
				{
					ans[0][1]=0;
				}
				
				for(int j=1;j<m;j++)
				{	
					if(data[j]==1)
					{
						if(ans[j-1][1]!=0)
						{
							ans[j][1] = ans[j][0]+ans[j-1][1]+1;
						}
						else
						{
							ans[j][1] = ans[j][0]+ans[j-1][0]+1;
						
							if(ans[j][1]==1)
								group++;
						}
						//System.out.println("he1 "+j);
					}
					else
					{
						ans[j][1]=0;
						//System.out.println("he "+j);

					}
					
//					for(int k=0;k<m;k++)
//						System.out.print(ans[k][1]+" ");
//					
//					System.out.println();
				}
				
				for(int j=m-2;j>=0;j--)
				{
					if(ans[j+1][1]!=0 && ans[j][1]!=0)
						ans[j][1] = ans[j+1][1];
				}
				
				for(int j=0;j<m;j++)
				{
					ans[j][0] = ans[j][1];
					max = Math.max(max, ans[j][0]);
					ans[j][1] = 0;
				}
				
				for(int j=0;j<m;j++)
					System.out.print(ans[j][0]+" ");
				System.out.println();
			}
			
			
			for(int i=0;i<m;i++)
				max = Math.max(max, ans[i][0]);
			
			System.out.println(group+" "+max);
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
