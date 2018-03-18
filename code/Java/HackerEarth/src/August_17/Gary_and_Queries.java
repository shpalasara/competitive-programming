package August_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Gary_and_Queries {

	static int size = 500010;
	static int nsqrt = (int)Math.sqrt(size);
	static long[] BIT = new long[size+100];
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		int[] data = new int[n];
		long[] tans = new long[nsqrt+1];
		long sum=0;
		
		for(int i=0;i<n;i++)
		{
			data[i] = sc.nextInt();
			
			for(int j=2;j<nsqrt && j<=data[i];j++)
				tans[j] += (long)(data[i]/j); 
		
			sum += (long)data[i];
			update(data[i] , 1);
		}
		
		int x,y,prev,next,count;
		long pr,ne,ans;
		
		while(q-->0)
		{
			if(sc.nextInt()==1)
			{
				x = sc.nextInt()-1;
				y = sc.nextInt();
				
				prev = data[x];
				data[x] = y;
				next = y;
				
				sum += (long)(next-prev);
				
				update(prev , -1);
				update(next , 1);
				
				for(int i=2;i<nsqrt && i<=prev;i++)
					tans[i] -= (long)(prev/i);
				
				for(int i=2;i<nsqrt && i<=next;i++)
					tans[i] += (long)(next/i);
			}
			else
			{
				x = sc.nextInt();
				
				if(x==1)
					out.println(sum);
				else if(x<nsqrt)
					out.println(tans[x]);
				else
				{
					pr = query(x-1);
					count = 1;
					ans = 0;
					
					for(int i=2*x-1;i<size;i+=x)
					{
						ne = query(i);
						ans += ((long)(ne-pr)*(long)count);
						count++;
						pr = ne;
					}
					
					out.println(ans);
				}
			}
		}
		
		out.close();
	}
	
	public static void update(int x, int delta)
	{
	      for(; x <= size; x += x&-x)
	        BIT[x] += (long)delta;
	}
	
	public static long query(int x)
	{
	     long sum = 0;
	     for(; x > 0; x -= x&-x)
	        sum += BIT[x];
	     return sum;
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
