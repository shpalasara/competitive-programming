package Good_Bye_2015;

import java.io.IOException;
import java.util.InputMismatchException;

public class New_Year_and_Domino {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		String[] temp = sc.nextLine().split(" ");
		int row = Integer.parseInt(temp[0]),col= Integer.parseInt(temp[1]),length,q,r1,c1,r2,c2,out;
		boolean[][] data = new boolean[row][col];
		int[][] ans = new int[row][col];
		
		for(int i=0;i<row;i++)
		{
			temp[0]=sc.nextLine();
			length=temp[0].length();
			
			for(int j=0;j<length;j++)
			{
				if(temp[0].charAt(j)=='.')
					data[i][j]=true;
				else
					data[i][j]=false;
			}
		}
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(i==0 && j==0)
					ans[i][j]=0;
				else if(i==0)
				{
					if(data[i][j] && data[i][j-1])
						ans[i][j]=ans[i][j-1]+1;
					else
						ans[i][j]=ans[i][j-1];
				}
				else if(j==0)
				{
					if(data[i][j] && data[i-1][j])
						ans[i][j]=ans[i-1][j]+1;
					else
						ans[i][j]=ans[i-1][j];
				}
				else
				{
					ans[i][j]=ans[i][j-1]+ans[i-1][j]-ans[i-1][j-1];
					if(i-1>=0 && (data[i][j] && data[i-1][j]))
						ans[i][j]++;
					if(j-1>=0 && (data[i][j] && data[i][j-1]))
						ans[i][j]++;
				}
				//System.out.print(ans[i][j]+" ");
			}
			//System.out.println();
		}
		
		q=sc.nextInt();
		while(q-->0)
		{
			r1=sc.nextInt()-1;
			c1=sc.nextInt()-1;
			r2=sc.nextInt()-1;
			c2=sc.nextInt()-1;
			
			if(r1==0 & c1==0)
				out=ans[r2][c2];
			else
			{
				out=ans[r2][c2];
				//System.out.println(out);
				
				if(c1-1>=0)
					out-=ans[r2][c1-1];
				//System.out.println(out);
				
				if(r1-1>=0)
					out-=ans[r1-1][c2];
				//System.out.println(out);
				
				if(c1-1>=0 && r1-1>=0)
					out+=ans[r1-1][c1-1];
				//System.out.println(out);
				
				if(r1!=0)
				{
					for(int i=c1;i<=c2;i++)
					{
						//if(data[r1][i] && data[r1][i-1])
						//	out--;
						if(data[r1][i] && data[r1-1][i])
							out--;
					}
				}
			
				if(c1!=0)
				{
					for(int j=r1;j<=r2;j++)
					{
						//if(j-1>=r1 && (data[j][c1] && data[j-1][c1]))
						//	out--;
						if(data[j][c1] && data[j][c1-1])
							out--;
					}
				}
			}
			
			System.out.println(out);
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
/*
				if(i-1>=0 && (data[i][j] && data[i-1][j]))
					ans[i][j]++;
				if(j-1>=0 && (data[i][j] && data[i][j-1]))
					ans[i][j]++;
*/