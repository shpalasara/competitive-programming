package hack_101_May_16;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Yet_Another_Minimax_Problem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FasterScanner sc = new FasterScanner();
		int n=sc.nextInt(),max_bit=0,temp,t,t1;
		int[] data = new int[n];
		int[] mbit = new int[n];
		int[] count = new int[33];
		
		for(int i=0;i<n;i++)
		{
			data[i]=sc.nextInt();
			temp = data[i];
			
			while(temp!=0)
			{
				temp = temp>>1;
				mbit[i]++;
			}
			
			max_bit = Math.max(max_bit, mbit[i]);
			count[mbit[i]]++;
		}
		
		t = max_bit;
		for(int i=t;i>=0;i--)
		{
			if(count[i]==n)
			{
				
				t1 = 1<<(i-1);
				//System.out.println("YES "+t1);
				
				for(int j=0;j<n;j++)
					data[j] = data[j]^t1;
				
				count[i]=0;
				
				for(int j=0;j<n && i-2>0;j++)
				{
					mbit[j]=0;
					t1 = 1<<(i-2);
					
					if((data[j]&t1)>=t1)
					{
						mbit[j]=i-1;
						count[mbit[j]]++;
					}
				}
				max_bit--;
			}
			else if(count[i]==0)
			{
				//System.out.println("Yep");
				for(int j=0;j<n && i-2>0;j++)
				{
					mbit[j]=0;
					t1 = 1<<(i-2);
					
					if((data[j]&t1)>=t1)
					{
						mbit[j]=i-1;
						count[mbit[j]]++;
					}
				}
				max_bit--;
				continue;
			}
			else
				break;
		}
		
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		
		
		if(max_bit>0)
		{
			max_bit--;
			t=1<<max_bit;
			//System.out.println(t);
			
			for(int i=0;i<n;i++)
			{
				if((data[i]&t)>=t)
				{
					a1.add(data[i]);
					//System.out.println(data[i]+" 1");
				}
				else
				{
					a2.add(data[i]);
					//System.out.println(data[i]+" 2");
				}
			}
			
			int ans = Integer.MAX_VALUE;
			
			for(int i=0;i<a1.size();i++)
			{
				for(int j=0;j<a2.size();j++)
					ans = Math.min(ans, a1.get(i)^a2.get(j));
			}
			
			if(ans!=Integer.MAX_VALUE)
				System.out.println(ans);
			else
				System.out.println(0);
		}
		else	
			System.out.println(0);
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
