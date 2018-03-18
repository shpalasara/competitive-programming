package May_16;

import java.io.IOException;
import java.util.InputMismatchException;
import java.math.BigInteger;

public class FORESTGA {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int n =sc.nextInt();
		long w=sc.nextLong(),l=sc.nextLong(),months,temp,ans,prev=0,min_rate=Long.MAX_VALUE;
		long[][] height = new long[n][2];
		
		for(int i=0;i<n;i++)
		{
			height[i][0]=sc.nextLong();
			height[i][1]=sc.nextLong();
			
			if(min_rate>height[i][1])
				min_rate=height[i][1];
		}
		
		long st=0,lt=w/min_rate,mid;
		mid=(st+lt)>>1;
		int i,count=0,comp;
		BigInteger bi1,bi2,bi3;
		bi1 = BigInteger.valueOf(0);
		bi2 = BigInteger.valueOf(0);
		
		//System.out.println("hii");
		while(st<lt /*&& mid!=st && mid!=lt*/)
		{
			temp=0;
			bi1 = BigInteger.valueOf(0);
			bi2 = BigInteger.valueOf(0);
			count=0;
			
			//System.out.println("mid "+mid+" st "+st+" lt "+lt);
			for(i=0;i<n;i++)
			{
				//temp+=Math.abs(height[i][0]+lt*height[i][1]);
				bi1 = BigInteger.valueOf(height[i][0]);
				bi1 = bi1.add(BigInteger.valueOf(mid).multiply(BigInteger.valueOf(height[i][1])));
				
				if(bi1.compareTo(BigInteger.valueOf(l))>=0)
				{
					bi2 = bi2.add(bi1);
					
					comp = bi2.compareTo(BigInteger.valueOf(w));
					
					if(comp>=0)
						count++;
				}
				
				if(count>=2)
					break;
			}
			
			if(st==mid)
				break;
			
			//System.out.println(count);
			
			if(count!=0)
				lt=mid;
			else
				st=mid;

			mid=(st+lt)>>1;
		}
		
		count=0;
		bi1 = BigInteger.valueOf(0);
		bi2 = BigInteger.valueOf(0);
		
		for(i=0;i<n;i++)
		{
			//temp+=Math.abs(height[i][0]+lt*height[i][1]);
			bi1 = BigInteger.valueOf(height[i][0]);
			bi1 = bi1.add(BigInteger.valueOf(st).multiply(BigInteger.valueOf(height[i][1])));
			
			if(bi1.compareTo(BigInteger.valueOf(l))>=0)
			{
				bi2 = bi2.add(bi1);
				
				comp = bi2.compareTo(BigInteger.valueOf(w));
				
				if(comp>=0)
					count++;
			}
			
			if(count>=2)
				break;
		}
		
		if(count!=0)
			System.out.println(st);
		else
			System.out.println(lt);
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
