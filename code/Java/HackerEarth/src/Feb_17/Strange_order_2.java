package Feb_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Strange_order_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc =  new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		boolean[] prime = new boolean[n+1];
		
		for(int i=2;i<n+1;i++)
		{
			if(!prime[i])
			{
				for(int j=i+i;j<n+1;j+=i)
					prime[j] = true;
			}
		}
		
		int[][] data = new int[n][2];
		int count=n,temp_count,end,start;
		boolean check = true;
		
		for(int i=0;i<n;i++)
			data[i][0] = n-i;
		
		while(count!=1)
		{
			temp_count = 0;
			start = 0;
			if(check)
			{
				end = data[start][0];
				while(!prime[end] && start<count)
				{
					out.print(end+" ");
					if(start+1<count)
						end = data[++start][0];
					else
						break;
				}
				
				for(int i=start;i<count;i++)
				{
					if(gcd(data[i][0],end)==1)
						data[temp_count++][1] = data[i][0];
					else
						out.print(data[i][0]+" ");
				}
				count = temp_count;
				check = false;
			}
			else
			{
				end = data[start][1];
				while(!prime[end] && start<count)
				{
					out.print(end+" ");
					if(start+1<count)
						end = data[++start][1];
					else
						break;
				}
				
				for(int i=start;i<count;i++)
				{
					if(gcd(data[i][1],end)==1)
						data[temp_count++][0] = data[i][1];
					else
						out.print(data[i][1]+" ");
				}
				count = temp_count;
				check = true;
			}
			//System.out.println(count);
		}
		out.println();
		out.close();
	}
	
	public static int gcd(int a,int b){
		
		a=Math.abs(a);
		b=Math.abs(b);
		
		int temp;
		while(b!=0)
		{
			temp = a%b;
			a = b;
			b = temp;
		}
		return a;
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
