package June_16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
 
public class FRJUMP_2 {
 
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
		int[] new_data = new int[n];
		double[] log_10 = new double[n];
		long[] inv_data = new long[n];
		long[] ans = new long[n+1];
		double[] digit = new double[n+1];
		boolean[] checker = new boolean[n];
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> modified = new ArrayList<Integer>();
		ArrayList<Integer> te ;
		
		HashMap<Integer,Long> hm = new HashMap<Integer,Long>();
		HashMap<Integer,Double> hm1 = new HashMap<Integer,Double>();
		
		for(int i=0;i<n;i++)
		{
			data[i] = sc.nextInt();
			
			if(!hm1.containsKey(data[i]))
			{
				log_10[i] = Math.log10(data[i]);
				hm1.put(data[i], log_10[i]);
			}
			else
				log_10[i] = hm1.get(data[i]);
			
			if(!hm.containsKey(data[i]))
			{
				inv_data[i] = power(data[i],mod-2,mod);
				hm.put(data[i], inv_data[i]);
			}
			else
				inv_data[i] = hm.get(data[i]);
			
			te = new ArrayList<Integer>();
			list.add(te);
		}
		
		for(int i=0;i<n+1;i++)
		{
			ans[i] = data[0];
			digit[i] = log_10[0];
		}
		
		for(int i=n-1;i>0;i--)
		{
			for(int j=1;j<=(int)Math.sqrt(i);j++)
			{
				if(i%j==0)
				{
					list.get(i).add(j);
					ans[j] = (ans[j]*((long)data[i]))%mod;
					digit[j] += log_10[i];
					
					int temp = i/j;
					if(temp!=j)
					{
						list.get(i).add(temp);
						ans[temp] = (ans[temp]*((long)data[i]))%mod;
						digit[temp] += log_10[i];
					}
				}
			}
		}
		
		for(int i=0;i<n+1;i++)
			list.get(0).add(i);
		
		q=sc.nextInt();
		
		while(q-->0)
		{
			t = sc.nextInt();
			
			if(t==1)
			{
				p = sc.nextInt();
				f = sc.nextInt();
				
				new_data[p-1] = f;
				
				if(!checker[p-1])
				{
					modified.add(p-1);
					checker[p-1] = true;
				}
			}
			else
			{
				for(int i=0;i<modified.size();i++)
				{
					int index = modified.get(i),in;
					double new_log;
					
					if(!hm1.containsKey(new_data[index]))
					{
						new_log = Math.log10(new_data[index]);
						hm1.put(new_data[index], new_log);
					}
					else
						new_log = hm1.get(new_data[index]);
					
					
					for(int j=0;j<list.get(index).size();j++)
					{
						in = list.get(index).get(j);
						
						ans[in] = (((ans[in]*inv_data[index])%mod)*((long)new_data[index]))%mod;
						digit[in] = digit[in] - log_10[index] + new_log;
					}
						
					log_10[index] = new_log;
					data[index] = new_data[index];
					
					if(!hm.containsKey(data[index]))
					{
						inv_data[index] = power(data[index],mod-2,mod);
						hm.put(data[index], inv_data[index]);
					}
					else
						inv_data[index] = hm.get(data[index]);
					
					checker[index] = false;
				}
				
				modified.clear();
				
				r = sc.nextInt();
				dig = (int)Math.floor(Math.pow(10 , digit[r]+1e-9 - Math.floor(digit[r]+1e-9)));
				
				out.println(dig+" "+ans[r]);
			}
		}
		hm.clear();
		list.clear();
		out.close();
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