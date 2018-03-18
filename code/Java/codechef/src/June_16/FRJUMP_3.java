package June_16;

// Accepted

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class FRJUMP_3 {

	/**
	 * @param args
	 */
	public static long mod = 1000000007;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n,p,r,q,f,t,dig;
		n=sc.nextInt();
		
		int[] data = new int[n];
		double[] log_10 = new double[n];
		long[] inv_data = new long[n];
		long[] ans = new long[n];
		double[] digit = new double[n];
		
		for(int i=0;i<n;i++)
		{
			data[i] = sc.nextInt();
			
			log_10[i] = Math.log10(data[i]);
			inv_data[i] = power(data[i],mod-2,mod);
		}
		
		for(int i=0;i<Math.sqrt(n);i++)
		{
			ans[i] = data[0];
			digit[i] = log_10[0];
		}
		
		for(int i=1;i<Math.sqrt(n);i++)
		{
			for(int j=i;j<n;j++)
			{
				if(j%i==0)
				{
					ans[i] = (ans[i]*data[j])%mod;
					digit[i] += log_10[j];
				}
			}
		}
		
		q=sc.nextInt();
		
		while(q-->0)
		{
			if(sc.nextInt()==1)
			{
				p=sc.nextInt();
				f=sc.nextInt();
				
				int i=p-1;
				data[i] = f;
				double new_log = Math.log10(f);
				
				if(i==0)
				{
					for(int j=1;j<Math.sqrt(n);j++)
					{
						ans[j] = (((ans[j]*data[i])%mod)*inv_data[i])%mod;
						digit[j] = digit[j] + new_log - log_10[i];
					}
				}
				else
				{
					for(int j=1;j<=i && j<Math.sqrt(n);j++)
					{
						if(i%j==0)
						{
							ans[j] = (((ans[j]*data[i])%mod)*inv_data[i])%mod;
							digit[j] = digit[j] + new_log - log_10[i];
						}
					}
				}
				
				inv_data[i] = power(data[i],mod-2,mod);
				log_10[i] = new_log;
			}
			else
			{
				r=sc.nextInt();
				
				if(r<((int)Math.sqrt(n)))
				{
					dig = (int)Math.floor(Math.pow(10 , digit[r]+1e-9 - Math.floor(digit[r]+1e-9)));
					out.println(dig+" "+ans[r]);
				}
				else
				{
					double temp=0;
					long f_ans=1;
					
					for(int i=0;i<n;i+=r)
					{
						temp += log_10[i];
						f_ans = (f_ans*data[i])%mod;
					}
					
					dig = (int)Math.floor(Math.pow(10 , temp+1e-9 - Math.floor(temp+1e-9)));
					out.println(dig+" "+f_ans);
				}
			}
		}
		
		out.close();
	}

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
