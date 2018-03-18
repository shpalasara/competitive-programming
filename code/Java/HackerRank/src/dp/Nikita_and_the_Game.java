package dp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Nikita_and_the_Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		int t = sc.nextInt(),n;
		ArrayList<Integer> list;
		ArrayList<Long> sum;
		int temp;
		
		while(t-->0)
		{
			list = new ArrayList<Integer>();
			sum = new ArrayList<Long>();
			n = sc.nextInt();
			
			for(int i=0;i<n;i++)
			{
				temp = sc.nextInt();
				
				if(temp!=0)
					list.add(temp);
			}
			
			if(list.size()==1)
				System.out.println(0);
			else if(list.size()==0)
				System.out.println(n-1);
			else
			{
				sum.add((long)list.get(0));
				
				for(int i=1;i<list.size();i++)
					sum.add(sum.get(i-1)+(long)list.get(i));
				
				System.out.println(recurse( sum, 0, list.size()-1, 0L));
			}
		}
	}
	
	public static int recurse(ArrayList<Long> sum, int start, int end,long sv){
		
		for(int i=start;i<end;i++)
		{
			if((sum.get(i)-sv)==(sum.get(end)-sum.get(i)))
				return 1+Math.max(recurse( sum, start,i , sv), recurse( sum, i+1, end, sum.get(i)));
		}
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
