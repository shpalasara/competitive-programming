package June_16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class FRJUMP {

	/**
	 * @param args
	 */
	public static long mod = 1000000007;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n,p,r;
		long q,t,f,prev,dig,c_prev=0;
		n=sc.nextInt();
		
		long[] data = new long[n];
		double[] log_10 = new double[n]; 
		long[] inv_data = new long[n];
		long[] ans = new long[n+1];
		double[] digit = new double[n+1];
		boolean[] prime = new boolean[100001];
		boolean check = false;
		prime[1] = false;
		
		for(int i=2;i<100001;i++)
		{
			if(!prime[i])
			{
				for(int j=i+i;j<100001;j+=i)
					prime[j] = true;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			data[i] = sc.nextInt();
			inv_data[i] = power(data[i],mod-2,mod);
			log_10[i] = Math.log10(data[i]);
		}
		
		for(int i=0;i<n+1;i++)
		{
			ans[i] = data[0];
			digit[i] = log_10[0];
		}
		
		for(int i=n-1;i>0;i--)
		{
			if(prime[i])
			{
				for(int j=1;j<=(int)Math.sqrt(i);j++)
				{
					if(i%j==0)
					{
						ans[j] = (ans[j]*data[i])%mod;
						digit[j] += log_10[i];
						
						int temp = i/j;
						if(temp!=j)
						{
							ans[temp] = (ans[temp]*data[i])%mod;
							digit[temp] += log_10[i];
						}
					}
				}
			}
			else
			{
				ans[1] = (ans[1]*data[i])%mod;
				digit[1] += log_10[i];
				
				if(i!=1)
				{
					ans[i] = (ans[i]*data[i])%mod;
					digit[i] += log_10[i];
				}
			}
		}
		
//		for(int i=0;i<n+1;i++)
//			System.out.print(ans[i]+" ");
//		System.out.println();
		
		q=sc.nextInt();
		
		while(q-->0)
		{
			t = sc.nextInt();
			
			if(t==1)
			{
				p = sc.nextInt();
				f = sc.nextInt();
				
				prev = data[p-1];
				data[p-1] = f;
				
				if(f!=prev)
				{
					int i = p-1;
					
					if(i==0)
					{
						if(!check)
							c_prev = prev;
						
						check = true;
//						for(int j=0;j<n+1;j++)
//						{
//							ans[j] = (((ans[j]*inv_data[i])%mod)*data[i])%mod;
//							//ans[j] = (ans[j]*data[i])%mod;
//							
//							digit[j] = digit[j] - Math.log10(prev) + Math.log10(data[i]);
//							//digit[j] += Math.log10(data[i]);
//						}
//						
//						inv_data[i] = power(data[i],mod-2,mod);
					}
					else
					{
						double prev_log = log_10[i];
						log_10[i] = Math.log10(data[i]) ;
						
						if(prime[i])
						{	
							for(int j=1;j<=(int)Math.sqrt(i);j++)
							{
								if(i%j==0)
								{
									ans[j] = (((ans[j]*inv_data[i])%mod)*data[i])%mod;
									
									digit[j] = digit[j] - prev_log + log_10[i];
									
									int temp = i/j;
									if(temp!=j)
									{
										ans[temp] = (((ans[temp]*inv_data[i])%mod)*data[i])%mod;
										
										digit[temp] = digit[temp] - prev_log + log_10[i];
									}
								}
							}
						}
						else
						{
							ans[1] = (((ans[1]*inv_data[i])%mod)*data[i])%mod;
							digit[1] = digit[1] - prev_log + log_10[i];
							
							if(i!=1)
							{
								ans[i] = (((ans[i]*inv_data[i])%mod)*data[i])%mod;
								digit[i] = digit[i] - prev_log + log_10[i];
							}
						}
						
						inv_data[i] = power(data[i],mod-2,mod);
					}
				}
			}
			else
			{
				if(check)
				{
					double prev_log = Math.log10(c_prev);
					log_10[0] = Math.log10(data[0]);
					
					for(int j=0;j<n+1;j++)
					{
						ans[j] = (((ans[j]*inv_data[0])%mod)*data[0])%mod;
						
						digit[j] = digit[j] - prev_log + log_10[0];
					}
					
					inv_data[0] = power(data[0],mod-2,mod);
					
					check = false;
				}
				
				r = sc.nextInt();
				dig = (long)Math.floor(Math.pow(10 , (digit[r]+1e-9) - Math.floor(digit[r]+1e-9)));
				
				out.println(dig+" "+ans[r]);
			}
		}
		
		out.close();
	}
	
	// finding (a^n)%mod in log(n) without recursion
	
	public static long power(long a,long n,long mod){
		
		long ans=1;

		if(a==1)
			return ans;
		
		while(n!=0)
		{
			if(n%2==1)
				ans=(ans*a)%mod;
			
			a = (a*a)%mod;
			n = n>>1;
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
