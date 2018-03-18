package January_16;

import java.io.IOException;
import java.util.InputMismatchException;

public class DEVPERF {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int t=Integer.parseInt(sc.nextLine()),n,m,x_max,y_max,x_min,y_min,dist,ans,temp_ans,x_d,y_d;
		String[] input = new String[1001];
		String[] temp = new String[2];
		boolean check;
		
		while(t-->0)
		{
			check=false;
			ans=Integer.MAX_VALUE;
			temp_ans=1;
			x_max=-1;
			y_max=-1;
			x_min=Integer.MAX_VALUE;
			y_min=Integer.MAX_VALUE;
			
			temp = sc.nextLine().split(" ");
			n=Integer.parseInt(temp[0]);
			m=Integer.parseInt(temp[1]);
			
			for(int i=0;i<n;i++)
				input[i]=sc.nextLine();
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					if(input[i].charAt(j)=='*')
					{
						check=true;
						x_max=Math.max(x_max, j);
						x_min=Math.min(x_min, j);
						y_max=Math.max(y_max, i);
						y_min=Math.min(y_min, i);
					}
				}
			}
			
			if(check)
			{
				for(int i=0;i<n;i++)
				{
					for(int j=0;j<m;j++)
					{
						x_d=Math.max(Math.abs(x_min-j),Math.abs(x_max-j));
						y_d=Math.max(Math.abs(y_min-i),Math.abs(y_max-i));
						temp_ans=Math.max(x_d, y_d);
						ans=Math.min(temp_ans, ans);
					}
				}
				ans++;
			}
			else
				ans=0;
			
			System.out.println(ans);
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
