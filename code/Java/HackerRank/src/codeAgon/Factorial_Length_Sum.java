package codeAgon;

import java.io.IOException;
import java.util.InputMismatchException;

public class Factorial_Length_Sum {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int n=sc.nextInt(),size=1000001,temp,no_set;
		long temp_ans,ans=0;
		int[] data = new int[n];
		int[] fact_len = new int[size];
		boolean[] prime = new boolean[size];
		
		prime[0]=true;
		prime[1]=true;
		fact_len[0]=0;
		fact_len[1]=0;
				
		for(int i=2;i<size;i++)
		{
			if(!prime[i])
			{
				fact_len[i]=1;
				for(int j=i+i;j<size;j+=i)
				{
					temp=j;
					while(temp%i==0)
					{
						fact_len[j]++;
						temp/=i;
					}
					prime[j]=true;
				}
			}
			//System.out.print(fact_len[i]+" ");
		}
		
		for(int i=1;i<size;i++)
			fact_len[i]+=fact_len[i-1];
		
		no_set=1<<n;
		
		for(int i=0;i<n;i++)
			data[i]=sc.nextInt();
		
		for(int i=1;i<no_set;i++)
		{
			temp_ans=0;
			for(int j=0;j<n;j++)
			{
				if((i&(1<<j))>0)
				{
					temp_ans+=(long)fact_len[data[j]];
				}
			}
			
			if(temp_ans%2==0)
				ans+=temp_ans;
		}
		System.out.println(ans);
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
