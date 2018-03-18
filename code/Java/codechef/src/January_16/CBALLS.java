package January_16;

import java.io.IOException;
import java.util.*;

public class CBALLS {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int t=sc.nextInt(),n,length,max,temp;
		int[] bucket = new int[10010];
		ArrayList<Integer> prime = new ArrayList<Integer>();
		boolean check;
		long ans,temp_ans,min;
		
		prime.add(2);
		
		for(int i=3;i<10100;i++)
		{
			check=false;
			for(int j=2;j<Math.sqrt(i);j++)
			{
				if(i%j==0)
				{
					check=true;
					break;
				}
			}
			if(!check)
				prime.add(i);
		}
		
		length=prime.size();
		
		while(t-->0)
		{
			min=Long.MAX_VALUE;
			max=0;
			ans=0;
			temp_ans=0;
			n=sc.nextInt();
			
			for(int i=0;i<n;i++)
			{
				bucket[i]=sc.nextInt();
				max=Math.max(max,bucket[i]);
				
				if(i-1>=0 && bucket[i]<bucket[i-1])
				{
					ans+=(long)(bucket[i-1]-bucket[i]);
					bucket[i]=bucket[i-1];
				}
			}
			
			//System.out.println(ans);
			for(int i=0;i<length;i++)
			{
				temp_ans=0;
				temp=prime.get(i);
				if(i>=1 && max<prime.get(i-1))
					break;
				
				for(int j=0;j<n;j++)
					if(bucket[j]%temp!=0)
						temp_ans+=(long)(temp-(bucket[j]%temp));
				
				min=Math.min(min,temp_ans);
			}
			
			System.out.println(ans+min);
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
