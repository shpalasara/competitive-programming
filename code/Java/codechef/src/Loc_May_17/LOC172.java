package Loc_May_17;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.TreeSet;

public class LOC172 {

	public static void main(String[] args){
		
		int h,w,n;
		FasterScanner sc = new FasterScanner();
		
		while(true)
		{
			h = sc.nextInt();
			w = sc.nextInt();
			
			if(h==-1 && w==-1)
				break;
			
			n = sc.nextInt();
			int[][] inp = new int[n][2];
			int x,y,r;
			
			for(int i=0;i<n;i++)
			{
				x = sc.nextInt();
				y = sc.nextInt();
				r = sc.nextInt();
				
				inp[i][0] = Math.max(y-r, 0);
				inp[i][1] = Math.min(y+r, h);
			}
		
			java.util.Arrays.sort(inp, new java.util.Comparator<int[]>() {
				
				  public int compare(int[] a,int[] b) {
			
				    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? (a[1] < b[1] ? -1 : 1) : 1));
			
				  }
			
				});
			
			int ans=1,in=0,temp_ans=1;
			TreeSet<Integer> set = new TreeSet<Integer>();
			
			for(int i=1;i<inp.length && in<inp.length;i++)
			{
				while(!set.isEmpty() && set.first()<inp[i][0])
				{
					temp_ans--;
					set.pollFirst();
				}
				if(inp[i][0]<=inp[in][1])
				{
					temp_ans ++;
					if(temp_ans>ans)
						ans = temp_ans;
					set.add(inp[i][1]);
				}
				else
				{
					in++;
					i = in;
					temp_ans = 1;
					set.clear();
				}
			}
			
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
