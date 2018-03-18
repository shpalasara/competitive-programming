package June_16;

import java.io.IOException;
import java.util.InputMismatchException;

public class BINOP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		int t=Integer.parseInt(sc.nextLine()),length,ans;
		String a,b;
		boolean check;
		int count_zero,count_one,zero,one;
		
		while(t-->0)
		{
			count_zero = 0;
			count_one = 0;
			zero=0;
			one=0;
			
			ans=0;
			check = true;
			a=sc.nextLine();
			b=sc.nextLine();
			length = a.length();
			
			for(int i=0;i<length && check;i++)
			{
				if(a.charAt(i)!=b.charAt(i))
				{
					if(a.charAt(i)=='0')
						count_zero++;
					else
						count_one++;
				}
				else
				{
					if(a.charAt(i)=='0')
						zero++;
					else
						one++;
				}
			}
			
			zero += Math.min(count_zero, count_one);
			one += Math.min(count_zero, count_one);
			ans+= Math.min(count_zero, count_one);
			
			if(count_zero!=count_one)
			{
				if(count_zero>count_one)
				{
					if(one>0)
						ans+=count_zero-count_one;
					else
						check = false;
				}
				else
				{
					if(zero>0)
						ans+=count_one-count_zero;
					else
						check = false;
				}
			}
			
			if(check)
			{
				System.out.println("Lucky Chef\n"+ans);
			}
			else
				System.out.println("Unlucky Chef");
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
