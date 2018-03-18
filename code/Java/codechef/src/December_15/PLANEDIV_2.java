package December_15;
//Final answer
import java.io.IOException;
import java.util.*;

public class PLANEDIV_2 {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		
		HashMap <String,Integer> data = new HashMap<String,Integer>();
		HashMap <Double,Integer> slope = new HashMap <Double,Integer>();
		
		long t,n,a,b,c,gcd,zero1,zero2,temp_ans,ans;
		t=sc.nextLong();
		double m;
		
		while(t-->0)
		{
			data.clear();
			slope.clear();
			temp_ans=0;
			ans=0;
			zero1=0;
			zero2=0;
			n=sc.nextLong();
			
			while(n-->0)
			{
				a=sc.nextLong();
				b=sc.nextLong();
				c=sc.nextLong();
				
				gcd=gcd(a,gcd(b,c));
				
				a/=gcd;
				b/=gcd;
				c/=gcd;
				
				if(data.containsKey(a+" "+b+" "+c))
					continue;
				
				data.put(a+" "+b+" "+c, 1);
				
				if(a==0)
					zero1++;
				else if(b==0)
					zero2++;
				else
				{
					m=a/(double)b;
					
					if(slope.containsKey(m))
					{
						slope.put(m, slope.get(m)+1);
						temp_ans=slope.get(m);
					}
					else
					{
						slope.put(m,1);
						temp_ans=1;
					}
					
					ans=Math.max(ans, temp_ans);
				}
			}
			
			ans=Math.max(ans, Math.max(zero1, zero2));
			System.out.println(ans);
		}
		
	}
	
	public static long gcd(long a,long b)
	{
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
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
