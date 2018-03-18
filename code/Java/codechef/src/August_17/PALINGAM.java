package August_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class PALINGAM {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = Integer.parseInt(sc.nextLine());
		
		int[] countA = new int[26];
		int[] countB = new int[26];
		
		while(t-->0)
		{
			String sA = sc.nextLine();
			String sB = sc.nextLine();
			
			for(int i=0;i<26;i++)
				countA[i]=countB[i]=0;
			
			for(int i=0;i<sA.length();i++)
				countA[sA.charAt(i)-'a']++;

			for(int i=0;i<sB.length();i++)
				countB[sB.charAt(i)-'a']++;
			
			boolean dg_2 = false;						// Difference greater than 2
			boolean b_a = true;
			boolean a_b = true;
			
			for(int i=0;i<26;i++)
			{
				if(countB[i]==0 && countA[i]>1)
					dg_2 = true;
				if(countA[i]>0 && countB[i]==0)
					b_a = false;
				if(countB[i]>0 && countA[i]==0)
					a_b = false;
			}
			
			if(dg_2)
				out.println("A");
			else if(b_a)
				out.println("B");
			else if(a_b)
				out.println("A");
			else
				out.println("B");
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
