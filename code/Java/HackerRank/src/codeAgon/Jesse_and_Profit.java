package codeAgon;

import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Jesse_and_Profit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		
		int n =sc.nextInt();
		int d = sc.nextInt();
		
		int[] data = new int[n];
		
		for(int i=0;i<n;i++)
			data[i] = sc.nextInt();
		
		int amount;
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int start,end;
		
		while(d-->0)
		{
			amount = sc.nextInt();
			start = -1;
			end = -1;
			
			for(int i=n-1;i>=0;i--)
			{
				if(hm.isEmpty())
					hm.put(data[i], i);
				else
				{
					if(hm.containsKey(data[i]+amount))
					{
						if(start==-1 && end==-1)
						{
							start = i;
							end = hm.get(data[i]+amount);
						}
						else if((end-start)>=(hm.get(data[i]+amount)-i))
						{
							start = i;
							end = hm.get(data[i]+amount);
						}
					}
					
					hm.put(data[i], i);
				}
			}

			start++;
			end++;
			
			if(start==0 && end==0)
				System.out.println(-1);
			else
				System.out.println(start+" "+end);
			hm.clear();
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
