package SnackDown_16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class VCAKE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int inp=sc.nextInt();
		boolean check;
		
		for(int i=0;i<inp;i++)
		{
			check = false;
			
			long r=sc.nextInt(),c=sc.nextInt(),r1,c1;
			long m=sc.nextLong(),j=sc.nextLong(),k=sc.nextLong();
			
			if((m+j+k)==(r*c))
			{
				if(m%r==0)
				{
					long temp=m/r;
					c1=c-temp;
					
					if((j%c1==0 && k%c1==0)||(j%r ==0 && k%r==0))
						check = true;
				}
				
				if(!check && m%c==0)
				{
					long temp=m/c;
					r1=r-temp;
					
					if((j%c==0 && k%c==0)||(j%r1==0 && k%r1==0))
						check = true;
				}
			
			
				if(!check && j%r==0)
				{
					long temp=j/r;
					c1=c-temp;
					
					if((m%c1==0 && k%c1==0) || (m%r==0 && k%r==0))
						check = true;
				}
				
				if(!check && j%c==0)
				{
					long temp=j/c;
					r1=r-temp;
					
					if((m%c==0 && k%c==0)||(m%r1==0 && k%r1==0))
						check = true;
				}
			
			
				if(!check && k%r==0)
				{
					long temp=k/r;
					c1=c-temp;
					
					if((m%c1==0 && j%c1==0)||(m%r==0&&j%r==0))
						check = true;
				}
				
				if(!check && k%c==0)
				{
					long temp=k/c;
					r1=r-temp;
 
					if((m%c==0 && j%c==0)||(m%r1==0 && j%r1==0))
						check = true;
				}
				
					
				if(check==true)
					out.println("Yes");
				else
					out.println("No");
			}
			else
				out.println("No");
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
