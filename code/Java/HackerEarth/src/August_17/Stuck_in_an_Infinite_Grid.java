package August_17;

import java.io.IOException;
import java.util.InputMismatchException;

public class Stuck_in_an_Infinite_Grid {

	static int size = 200001;
	static long mod = (long)(1e9+7);
	static long[] fact = new long[size];
	static long[] inv_fact = new long[size];
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		
		fact[0] = 1;
		for(int i=1;i<size;i++)
			fact[i] = (i*fact[i-1])%mod;
		
		inv_fact[0] = 1;
		inv_fact[1] = 1;
		for(int i=2;i<size;i++)
			inv_fact[i] = power(fact[i],mod-2,mod);
		
		int t = sc.nextInt();
		int xs,ys,xt,yt,k,K;
		long ans,temp;
		int x_diff,y_diff;
		int headx,tailx,heady,taily;
		
		while(t-->0)
		{
			xs = sc.nextInt();
			ys = sc.nextInt();
			xt = sc.nextInt();
			yt = sc.nextInt();
			K = sc.nextInt();
			
			ans = 0;
			
			x_diff = Math.abs(xs-xt);
			y_diff = Math.abs(ys-yt);
			
			int diff = x_diff + y_diff;
			
			if(diff>K)
				System.out.println(0);
			else
			{
				for(int i=x_diff;i<=K-y_diff;i+=2)
				{
					k = K;
					tailx = (i-x_diff)>>1;
					headx = i - tailx;
					
					taily = (k-i-y_diff);
					if(taily%2==0)
					{
						taily = taily>>1;
						heady = (k-i) - taily;
						
						temp = nCr (k , tailx);
						k -= tailx;
						temp = (temp * nCr (k , headx))%mod;
						k -= headx;
						temp = (temp * nCr (k , taily))%mod;
						k -= taily;
						temp = (temp * nCr (k , heady))%mod;
						k -= heady;
						
						ans = (ans + temp)%mod;
//						System.out.println(ans);
					}	
				}

				System.out.println(ans);
			}
		}
	}
	
	public static long nCr (int n, int r) {
		
		if(n==r || r==0)
			return 1L;
		else if(n>r)
		{
			long ans = (fact[n] * inv_fact[r])%mod;
			ans = (ans * inv_fact[n-r])%mod;
			return ans;
		}
		return 0;
	}
	
	// finding (a^n)%mod in log(n) without recursion
	
	public static long power(long a,long n,long mod){
		
		long ans=1;
		
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
