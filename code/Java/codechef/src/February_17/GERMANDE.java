package February_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class GERMANDE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		int o1,o2,n;
				
		while(t-->0)
		{
			o1 = sc.nextInt();
			o2 = sc.nextInt();
			n = o1*o2;
			
			int[] data = new int[n];
			int[] count = new int[n];
			int max = (o2+1)>>1;
			int max_1 = (o1+1)>>1;
			
			for(int i=0;i<n;i++)
			{
				data[i] = sc.nextInt();
				if(i==0)
					count[i] = data[i];
				else
					count[i] = count[i-1] + data[i];
			}
			
			if(count[n-1]>=(max*max_1))
			{
				int[] state_elec = new int[n];
				int end,ones;
				
				for(int i=0;i<n;i++)
				{
					end = i+o2-1;
					if(end<n)
					{
						if(i==0)
							ones = count[end];
						else
							ones = count[end] - count[i-1];
					}
					else
					{
						end = end%n;
						if(i==0)
							ones = count[n-1] + count[end];
						else
							ones = (count[n-1]-count[i-1]) + count[end];
					}
					
					if(ones>=max)
						state_elec[i] = 1;
					else
						state_elec[i] = 0;
				}
				
				boolean check = false;
				
				for(int i=0;i<o2 && !check;i++)
				{
					ones = 0;
					for(int j=0;j<o1;j++)
					{
						ones += state_elec[(i+j*o2)%n];
					}
					
					if(ones>=max_1)
						check = true;
				}
				
				if(check)
					out.println(1);
				else
					out.println(0);
			}
			else
				out.println(0);
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
