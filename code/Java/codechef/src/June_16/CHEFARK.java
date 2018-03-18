package June_16;

import java.io.IOException;
import java.util.InputMismatchException;

public class CHEFARK {

	/**
	 * @param args
	 */
	public static long mod = 1000000007;
	public static long[] fact = new long[100001];
	public static long[] inv_fact = new long[100001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		
		fact[0]=1;
		inv_fact[0]=1;
		
		for(int i=1;i<100001;i++)
			fact[i] = ((long)i*fact[i-1])%mod;
		
		for(int i=1;i<100001;i++)
			inv_fact[i] = power(fact[i],mod-2,mod);
		
		int t=sc.nextInt(),n,k,zeros;
		long ans;
		
		while(t-->0)
		{
			n=sc.nextInt();
			k=sc.nextInt();
			zeros=0;
			ans=0;
			
			for(int i=0;i<n;i++)
			{
				if(sc.nextInt()==0)
					zeros++;
			}
			
			if(zeros>0)
			{
				if(n<=k)
					ans = power(2,n-zeros,mod);
				else
				{
					n = n-zeros;
					
					for(int i=0;i<=k;i++)
						ans = (ans + nCr(n,i))%mod;
				}
			}
			else
			{
				if(k%2==1)
				{
					for(int i=1;i<=k;i+=2)
						ans = (ans + nCr(n,i))%mod;
				}
				else
				{
					for(int i=0;i<=k;i+=2)
						ans = (ans + nCr(n,i))%mod;
				}
			}
			
			System.out.println(ans);
		}
		
	}
	
	public static long nCr(int n,int r)
	{
		if(n>=r)
		{
			long ans;
			ans = (((fact[n]*inv_fact[n-r])%mod)*inv_fact[r])%mod;
			return ans;
		}
		else
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
