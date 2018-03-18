package code_star;

import java.io.IOException;
import java.util.InputMismatchException;

public class random_stuff {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int t=sc.nextInt(),n;
		long mod=1000000007,temp,t1=0;
		long[] power = new long[1001];
		long[] pre_power = new long[1001];
		long[] ans = new long[1001];
		
		for(int i=0;i<1001;i++)
		{
			power[i]=1;
			pre_power[i]=1;
		}
		
		for(int i=0;i<10;i++)
		{
			t1=0;
			temp=0;
			for(int j=0;j<=i;j++)
			{
				if(j==1)
				{
					if(i!=1)
						pre_power[j]=(pre_power[j]+power[j])%mod;		
					
					power[j]=(power[j]*(long)(j+1))%mod;
					//System.out.println("i "+i+" p "+pre_power[j]);
				}
				else if(j>1)
				{
					pre_power[j]=power[j];
					power[j]=(1+(power[j]*(long)(j+1))%mod)%mod;
				}
				
				if(j!=0)
				{
					temp=(temp+power[j]-pre_power[j-1])%mod;
					
					if(temp<0)
						temp+=mod;
				}
				else
					temp=1;
				
				//if(i==2)
				//	System.out.println("t : "+temp+" ");
			}
			ans[i]=temp;
		}
		
		while(t-->0)
		{
			n=sc.nextInt();
			System.out.println(ans[n-1]);
		}
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
