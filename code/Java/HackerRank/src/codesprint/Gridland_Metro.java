package codesprint;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Gridland_Metro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		long n,m,k;
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		pair[] data = new pair[(int)k];
		
		for(int i=0;i<k;i++)
			data[i] = new pair(sc.nextInt(),sc.nextInt(),sc.nextInt());
		
//		java.util.Arrays.sort(data, new java.util.Comparator<pair[]>() {
//		
//			  public int compare(pair a,pair b) {
//		
//			    return (a.r < b.r ? -1 : (a.r == b.r ? (a.c1 < b.c1 ? -1 : (a.c1==b.c1 ? (a.c2<b.c2 ? -1:1) :1)) : 1));
//		
//			  }
//		
//			});
		
		Arrays.sort(data);
		
		long ans = 0,taken=n;
		long r=1,c=-1,temp,i=0;
		
		while(i<k && r<=n)
		{
			c = 0;
			temp = m;
			
			while(i<k && r<=n && data[(int)i].r!=r)
			{
				//System.out.println(i+" h "+r+" "+data[i].r);
				//ans = ans+(long)m;
				r++;
			}
			
			while(i<k && r<=n && data[(int)i].r==r)
			{
				if(c<=data[(int)i].c1)
				{
					temp -= data[(int)i].c2-data[(int)i].c1+1;
					c = data[(int)i].c2+1;
				}
				else
				{
					if(c<=data[(int)i].c2)
					{
						temp -= data[(int)i].c2-c+1;
						c = data[(int)i].c2+1;
					}
				}
				i++;
			}
			
			if(temp>0 && temp!=m && r<=n)
			{
				ans= ans+(long)temp;
			}

			r++;
			taken--;
			//System.out.println(i+" "+r+" "+ans);
		}
		
		ans += taken*m;
		
		System.out.println(ans);
	}
	
	public static class pair implements Comparable<pair>{
		
		long r,c1,c2;
		
		public pair(long r,long c1,long c2){
			this.r = r;
			this.c1 = c1;
			this.c2 = c2;
		}
		
		public int compareTo(pair b){
			return (this.r < b.r ? -1 : (this.r == b.r ? (this.c1 < b.c1 ? -1 : (this.c1==b.c1 ? (this.c2<b.c2 ? -1:1) :1)) : 1));
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
