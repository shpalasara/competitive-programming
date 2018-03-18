package August_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class CHEFMOVR {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		int n,d;
		long ans;
		
		while(t-->0)
		{
			n = sc.nextInt();
			d = sc.nextInt();
			ans = 0;
					
			long[] data = new long[n];
			long[] D = new long[d];
			int[] count = new int[d];
			long total = 0L,te,temp;
			boolean check = true;
			
			for(int i=0;i<n;i++)
			{
				data[i] = sc.nextInt();
				D[i%d] += data[i];
				count[i%d]++;
				total += data[i]; 
			}
			
			if(total%n==0)
			{
				total = total/n;
				
				for(int i=0;i<d && check;i++)
				{
					te = D[i] - (long)count[i]*total;
					if(te!=0)
						check = false;
					count[i] = 0;
					D[i] = 0;
				}
				
				if(!check)
					out.println(-1);
				else
				{
					for(int i=0;i<n-d;i++)
					{
						if(data[i]!=total)
						{
							temp = data[i] - total;
							data[i] = total;
							ans += Math.abs(temp);
							data[i+d] += temp;
						}
					}
					
					out.println(ans);
				}
			}
			else
				out.println(-1);
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
