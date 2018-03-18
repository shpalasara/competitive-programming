package August_16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.TreeSet;

public class CHEFRRUN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt(),n,count,index,ans,inc;
		TreeSet<Integer> set = new TreeSet<Integer>();
		//HashMap<Integer,Integer> set = new HashMap<Integer,Integer>();
		
		boolean check;
		
		while(t-->0)
		{
			count=1;
			inc=1;
			index=0;
			ans=0;
			check = true;
			
			n = sc.nextInt();
			int[] data = new int[n];
			int[] temp = new int[n];
			int[] t1 = new int[n];
			
			for(int i=0;i<n;i++)
			{
				set.add(i);
				//set.put(i, 1);
				data[i] = sc.nextInt();
			}
			
			while(!set.isEmpty() || check)
			{
				if(set.isEmpty())
					check = false;
				
				if(temp[index]==0)
				{
					temp[index] = count;
					t1[index] = inc;
					set.remove(index);
					index = (index+data[index]+1)%n;
				}
				else
				{
					if(t1[index]==inc)
						ans += count-temp[index];
					
					if(!set.isEmpty())
						index = set.first();
						//index = set.entrySet().iterator().next().getKey();
					
					inc++;
				}
				count++;
			}
			
			out.println(ans);
			set.clear();
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
