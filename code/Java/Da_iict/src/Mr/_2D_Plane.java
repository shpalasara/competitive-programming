package Mr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.TreeSet;

public class _2D_Plane {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int q = sc.nextInt();
		
		TreeSet<Long> x = new TreeSet<Long>();
		TreeSet<Long> y = new TreeSet<Long>();
		
		HashMap<Integer,Integer> x1 = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> y1 = new HashMap<Integer,Integer>();
		HashMap<String,Integer> te = new HashMap<String,Integer>();
		
//		long min = Integer.MIN_VALUE,max = Integer.MAX_VALUE; 
	
		int t,xt,yt;
		
		while(q-->0)
		{
			t = sc.nextInt();	
			
			if(t==1)
			{
				xt = sc.nextInt();
				yt = sc.nextInt();
				
				if(te.containsKey(xt+" "+yt))
				{
					int temp = te.remove(xt+" "+yt)+1;
					te.put(xt+" "+yt, temp);
				}
				else
					te.put(xt+" "+yt, 1);
				
				if(!x.isEmpty() && x.contains((long)xt))
				{
					int temp = x1.get(xt);
					x1.remove(xt);
					x1.put(xt, temp+1);
				}
				else
				{
					x.add((long)xt);
					x1.put(xt, 1);
				}
				
				if(!y.isEmpty() && y.contains((long)yt))
				{
					int temp = y1.get(yt);
					y1.remove(yt);
					y1.put(yt, temp+1);
				}
				else
				{
					y.add((long)yt);
					y1.put(yt, 1);
				}
			}
			else if(t==2)
			{
				xt = sc.nextInt();
				yt = sc.nextInt();
				
//				System.out.println("Hii");
				
				if(te.containsKey(xt+" "+yt))
				{
					
					if(x1.get(xt)==1)
					{
						x1.remove(xt);
						x.remove((long)xt);
					}
					else
					{
						int temp = x1.get(xt);
						x1.remove(xt);
						x1.put(xt, temp-1);
					}
					
					if(y1.get(yt)==1)
					{
						y1.remove(yt);
						y.remove((long)yt);
					}
					else
					{
						int temp = y1.get(yt);
						y1.remove(yt);
						y1.put(yt, temp-1);
					}
				}
			}
			else
			{
				if(x.size()<2 && y.size()<2)
					out.println(0);
				else
				{
					long ans1,ans2;
					
					//if()
					
					out.println(Math.max(Math.abs(x.last()-x.first()), Math.abs(y.last()- y.first()) ));
				}
			}
		}
		
		x.clear();
		y.clear();
		
		x1.clear();
		y1.clear();
		te.clear();
		
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
