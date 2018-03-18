package round_341;

import java.io.IOException;
import java.util.InputMismatchException;

public class Wet_Shark_and_Bishops {

	public static void main(String[] args){
	
		FasterScanner sc = new FasterScanner();
		boolean[][] bishop = new boolean[1001][1001];
		int n=sc.nextInt(),row,col,i,max=1000;
		long ans=0,count;
		
		//System.out.println("hello");
		
		for(i=0;i<n;i++)
		{
			row=sc.nextInt()-1;
			col=sc.nextInt()-1;
			
			bishop[row][col]=true;
		}
		
		for(int loop=1;loop<max;loop++)
		{
			count=0;
			i=loop;
			for(int j=0;j<=loop && i>=0;j++)
			{
				if(bishop[i][j])
					count++;
				i--;
			}
			if(count!=0)
				ans+=((count)*(count-1))>>1;
		
			//System.out.println("loop "+loop);
		}
		//System.out.println("1 "+ans);
		
		for(int loop=1;loop<max;loop++)
		{
			count=0;
			i=loop;
			int j=max-1;
			
			while(j>=loop && i<max)
			{
				if(bishop[i][j])
					count++;
				j--;
				i++;
			}
			if(count!=0)
				ans+=((count)*(count-1))>>1;
		}
		//System.out.println("2 "+ans);
		
		for(int loop=0;loop<max;loop++)
		{
			i=loop;
			count=0;
			for(int j=0;j<max && i<max;j++)
			{
				if(bishop[i][j])
					count++;
				i++;
			}
			if(count!=0)
				ans+=((count)*(count-1))>>1;
		}
		//System.out.println("3 "+ans);
		
		for(int loop=1;loop<max;loop++)
		{
			int j=loop;
			count=0;
			for(i=0;i<max && j<max;i++)
			{
				if(bishop[i][j])
					count++;
				j++;
			}
			if(count!=0)
				ans+=((count)*(count-1))>>1;
		}
		
		System.out.println(ans);
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
