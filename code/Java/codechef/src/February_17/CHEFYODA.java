package February_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class CHEFYODA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		double[] fact = new double[1000001];
		
		fact[0] = Math.log(1);
		for(int i=1;i<1000001;i++)
			fact[i] = fact[i-1]+Math.log(i);
		
//		for(int i=0;i<10;i++)
//			out.println(fact[i]);
		
		int t,n,m,p,k;
		double ans;
		t = sc.nextInt();
		boolean st,cr;
		
		while(t-->0)
		{
			ans = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			p = sc.nextInt();
			k = sc.nextInt();
			
			if(p==0)
				ans = 1;
			else
			{
				if(n%2==1 || m%2==1)
					cr = false;
				else
					cr = true;
				
				if(n%2==1 && m%2==1)
					st = false;
				else
					st = true;
				
				if(st && cr)
					ans = 1;
				else if((!st && !cr))
					ans = 0;
				else
				{
					double temp = ((double)k)*Math.log(2),temp_1;
					
//					out.println(temp);
					
					for(int i=p;i<k+1;i++)
					{
						temp_1 = (fact[k]-fact[k-i]-fact[i]-temp);
//						out.println(temp_1);
						ans += Math.exp(temp_1);
					}
				}
			}
			out.printf("%f\n",ans);
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
