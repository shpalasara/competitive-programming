package SnackDown_16;

// Wrong Answer

import java.io.IOException;
import java.util.InputMismatchException;

public class MMSUM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		int t=sc.nextInt(),n;
		long[] array;
		long temp_ans,ans,prev_ans,prev_min,min,ss_min;
		boolean check;
		
		while(t-->0)
		{
			check=true;
			n=sc.nextInt();
			array = new long[n];
			
			for(int i=0;i<n;i++)
				array[i]=sc.nextInt();
			
			prev_ans=Long.MIN_VALUE;
			prev_min=Long.MIN_VALUE;
			temp_ans=ans=array[0];
			ss_min = 0;
			min=Math.min(0, array[0]);
			
			for(int i=1;i<n;i++)
			{
				temp_ans+=array[i];
				
				if(temp_ans<=array[i])
				{
					System.out.println("start");
					if(prev_ans == Long.MIN_VALUE)
					{
						prev_ans = temp_ans-array[i];
						prev_min = min;
					}
					else
					{
						//if(prev_ans-prev_min<=0)
						//{
							prev_ans=temp_ans-array[i];
							prev_min=min;
							//check=true;
						//}
						if(prev_ans-prev_min>0)
						{
							if(temp_ans-array[i]+prev_ans-prev_min>ss_min)
								ss_min = temp_ans-array[i]+prev_ans-prev_min;
							else
								ss_min += temp_ans-array[i];
						}
						else
							ss_min = 0;
					}
					temp_ans=array[i];
					ans = Math.max(ans, Math.max(temp_ans, Math.max(temp_ans+ss_min , temp_ans+prev_ans-prev_min)));
					min=Math.min(0, array[i]);
				}
				else
				{
					min=Math.min(min, array[i]);
					ans = Math.max(ans, Math.max(temp_ans, Math.max(temp_ans-min, Math.max(temp_ans+prev_ans+ss_min , temp_ans+prev_ans-prev_min)))); 
				}
				
//				if(array[i]<min)
//					min=array[i];
//				System.out.println("$ "+i);
//				System.out.println(temp_ans+" "+ans);
//				System.out.println(prev_ans+" "+prev_min);
			}
			System.out.println(ans);
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
