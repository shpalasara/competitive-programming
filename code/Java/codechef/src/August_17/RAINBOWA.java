package August_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class RAINBOWA {

	public static void main(String[] args) {
	
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		int n;
		int[] data = new int[101];
		int[] count = new int[8];
		
		while(t-->0)
		{
			n = sc.nextInt();
			boolean check = true,ou=true;
			
			for(int i=0;i<n;i++)
				data[i] = sc.nextInt();

			if(data[0]!=1 || data[n-1]!=1)
				ou = false;
			
			for(int i=1;i<n && ou;i++)
			{
				if(i==0 && data[i]!=1)
					ou = false;
				
				if(check)
				{
					if(data[i]!=data[i-1] && data[i]!=data[i-1]+1)
						ou = false;
				}
				else
				{
					if(data[i]!=data[i-1] && data[i]!=data[i-1]-1)
						ou = false;
				}

				if(data[i]==7)
					check = false;
			}
			
			if(ou)
			{
				//out.println("here");
				if(ou)
				{
					check = true;
					for(int i=0;i<n;i++)
					{
						if(data[i]==7)
							check = false;
						
						if(check)
							count[data[i]]++;
						else
							count[data[i]]--;
					}
					
					for(int i=1;i<7;i++)
						if(count[i]!=0)
							ou = false;
				}
			}

			for(int i=0;i<8;i++)
				count[i] = 0;
			
			if(ou)
				out.println("yes");
			else
				out.println("no");
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
