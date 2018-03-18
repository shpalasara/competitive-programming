package CodeZilla;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class CZAP {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		int nsqrt = (int)Math.sqrt(n);
		int[] data = new int[n];
		
		long[][] sum = new long[n][nsqrt];
		
		for(int i=0;i<n;i++)
			data[i] = sc.nextInt();
		
		int q = sc.nextInt();
		int l,r,d,diff;
		int s_seg,e_seg;
		
		for(int i=n-1;i>=0;i--)
		{
			s_seg = (i/nsqrt)*nsqrt;
			e_seg = s_seg + nsqrt;
			
			for(int j=0;j<nsqrt;j++)
				sum[i][j] = data[i];
			
			for(int j=i+1;j<Math.min(n, e_seg);j++)
			{
				diff = (j-i);
				sum[i][diff] += sum[j][diff];
			}
		}
		
//		System.out.println(nsqrt);
//		
//		for(int i=0;i<n;i++)
//		{
//			for(int j=0;j<nsqrt;j++)
//				System.out.print(sum[i][j]+" ");
//			System.out.println();
//		}
		
		while(q-->0)
		{
			l = sc.nextInt();
			r = sc.nextInt();
			d = sc.nextInt();
			
			long ans = 0L;
			
			if(d>=nsqrt)
			{
				for(int i=l;i<=r;i+=d)
					ans += (long)data[i];
			}
			else
			{	
				s_seg = (l/nsqrt)*nsqrt;
				e_seg = s_seg + nsqrt;
				
				for(int i=l;i<Math.min(r+1, e_seg);i+=d)
					ans += (long)data[i];
				
				s_seg = e_seg;
				e_seg = (r/nsqrt)*nsqrt;
				
				int temp,index;
				
				for(int i=s_seg;i<e_seg;i+=nsqrt)
				{
					temp = i-l;
					
					if(temp%d==0)
						index = temp/d;
					else
						index = (temp/d) + 1;
					
					index = index*d + l;
					ans += sum[index][d];
				}
				
				if(s_seg<=e_seg)
				{
					index = e_seg - l;
					
					if(index%d==0)
						index = index/d;
					else
						index = index/d + 1;
					
					index = index*d+l;
					
					for(int i=index;i<=r;i+=d)
						ans += (long)data[i];
				}
			}
			
			out.println(ans);
		}
		
		out.close();
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
