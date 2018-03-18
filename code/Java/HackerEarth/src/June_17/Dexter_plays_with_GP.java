package June_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Dexter_plays_with_GP {
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		long r,S,p,x,a,r_m;
		int nsqrt;
		
		HashMap<Long,Integer> map = new HashMap<Long,Integer>();
		long[] r_i = new long[50000];
	
		r_i[0] = 1;
		map.put(r_i[0], 0);
		
		while(t-->0)
		{
			x = -1;
			r = sc.nextInt();
			S = sc.nextInt();
			p = sc.nextInt();
			
			if(S==1L)
				x = 1;
			else if(r!=1L)
			{
//				if(p<1000)
//					nsqrt = (int)p-1;
//				else 
					nsqrt = (int)Math.ceil(Math.sqrt(p-1));
				
				a = (S*(r-1) + 1)%p;
				
				for(int i=1;i<nsqrt;i++)
				{
					r_i[i] = (r_i[i-1]*r)%p;
					map.put(r_i[i], i);
				}
				r_m = power( r, nsqrt*(p-2), p);
				
				for(int i=0;i<nsqrt;i++)
				{
					if(map.containsKey(a))
					{
						x = i*nsqrt + map.get(a);
						break;
					}
					a = (a*r_m)%p;
				}
				
				for(int i=1;i<nsqrt;i++)
					map.remove(r_i[i]);
			}
			
			out.println(x);
		}
		
		out.close();
	}
	
	// finding (a^n)%mod in log(n) without recursion
	
	public static long power(long a,long n,long mod){
		
		long ans=1;
		// if mod is prime
		n = n%(mod-1);
		
		while(n!=0)
		{
			if(n%2==1)
				ans=(ans*a)%mod;
			
			a = (a*a)%mod;
			n=n>>1;
		}
		return ans;
	}
	
	static class FasterScanner {

        private byte[] buf = new byte[1024];
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
