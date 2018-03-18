package codeAgon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class CA_17_q3 {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int count = 0;
		
		int[] data = new int[n];
		
		for(int i=0;i<n;i++)
		{
			data[i] = sc.nextInt();
			if(data[i]==1)
				count++;
		}
		
		if(count>=m)
		{
			
			long ans = Long.MAX_VALUE,temp_ans=Long.MAX_VALUE,sum = 0;
			int prev=0,index=0;
			count = 0;
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for(int i=0;i<n;i++)
			{
				if(data[i]==1)
				{
					if(count<m)
					{
						if(count==0)
							temp_ans = i-prev;
						else
							temp_ans += ((long)(i-prev))*((long)(k*count));
						count++;
					}
					else
					{
						ans = Math.min(ans, temp_ans);

						if(list.size()>index)
							sum -= list.get(index++);
						
						temp_ans -= (long)sum*(long)k ;
						temp_ans += ((long)(i-prev))*((long)(k*(m-1))) + list.get(index);
					}
					
					list.add(i-prev);
					sum += (i-prev);
					prev = i;
//					System.out.println(ans+" "+sum);
				}
			}
			
			ans = Math.min(ans, temp_ans);
			
			System.out.println(ans);
		}
		else
			System.out.println(-1);
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
