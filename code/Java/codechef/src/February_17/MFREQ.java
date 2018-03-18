package February_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;

public class MFREQ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n,m;
		n = sc.nextInt();
		m = sc.nextInt();
		int[] data = new int[n];
		int[] left_index = new int[n];
		int[] right_index = new int[n];
		
		for(int i=0;i<n;i++)
			data[i] = sc.nextInt();
		
		left_index[0] = 0;
		for(int i=1;i<n;i++)
		{
			if(data[i]==data[i-1])
				left_index[i] = left_index[i-1];
			else
				left_index[i] = i;
		}
		
		right_index[n-1] = n-1;
		for(int i=n-2;i>=0;i--)
		{
			if(data[i]==data[i+1])
				right_index[i] = right_index[i+1];
			else
				right_index[i] = i;
		}
		
//		HashMap<Integer,ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>();
//		
//		for(int i=0;i<n;i++)
//		{
//			data[i] = sc.nextInt();
//			if(hm.containsKey(data[i]))
//				hm.get(data[i]).add(i+1);
//			else
//			{
//				ArrayList<Integer> temp = new ArrayList<Integer>();
//				temp.add(i+1);
//				hm.put(data[i], temp);
//			}
//		}
		
		int L,R,k,mid,l,r;
		
		while(m-->0)
		{
			L = sc.nextInt()-1;
			R = sc.nextInt()-1;
			k = sc.nextInt();
			
			mid = (L+R)>>1;
			l = left_index[mid];
			r = right_index[mid];
			
			l = Math.max(l, L);
			r = Math.min(r, R);
			
			if((r-l+1)>=k)
				out.println(data[mid]);
			else
				out.println("-1");
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
