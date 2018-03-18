package codeAgon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Remaining_Factors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		
		boolean[] check = new boolean[1000001];
        ArrayList<Long> prime = new ArrayList<Long>();
        
        for(int i=2;i<1000001;i++)
        {
            if(!check[i])
            {
                prime.add((long)i);
                
                for(int j=i+i;j<1000001;j+=i)
                    check[i] = true;
            }
        }
	
        int[] count = new int[prime.size()];
        int extra=0;
        
        long n = sc.nextLong();
        
        for(int i=0;i<prime.size();i++)
        {
        	while((n%prime.get(i))==0)
        	{
        		n/=prime.get(i);
        		count[i]++;
        	}
        }
        
        if(n!=1)
        	extra++;
        
        //System.out.println(extra);
        
        long ans1=1L,ans2=1L;
        
        for(int i=0;i<count.length;i++)
        {
        	ans1 = ans1*((long)count[i]+1L);
        	ans2 = ans2*((long)count[i]*2L+1L);
        }
        
        if(extra!=0)
        {
        	ans1 = ans1*2L;
        	ans2 = ans2*3L;
        	ans2 -= (ans2>>1);
        }
        else
        	ans2 -= ans2>>1;
        
        System.out.println(ans2-ans1);
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
