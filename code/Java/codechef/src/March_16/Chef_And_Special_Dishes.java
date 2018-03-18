package March_16;

import java.io.IOException;
import java.util.InputMismatchException;

public class Chef_And_Special_Dishes {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int d=Integer.parseInt(sc.nextLine()),length,loop;
		String str;
		boolean ans,temp;
		
		while(d-->0)
		{
			ans=temp=true;
			str=sc.nextLine();
			length=str.length();
			
			if(length%2==0)
			{
				loop=length>>1;
				for(int i=0;i<loop && ans;i++)
				{
					if(str.charAt(i)!=str.charAt(loop+i))
						ans=false;
				}
			}
			else
			{
				loop=length>>1;
				
				int count1=0,count2=loop;
				boolean a1=true,a2=true,te=false;
				
				while(a1 && count1<loop && count2<length)
				{
					if(str.charAt(count1)!=str.charAt(count2))
					{
						if(te)
						{
							a1=false;
							break;
						}
						te=true;
						count2++;
					}
					else
					{
						count1++;
						count2++;
					}
				}
				
				count1=0;
				count2=loop+1;
				te=false;
				
				while(a2 && count1<loop+1 && count2<length)
				{
					if(str.charAt(count1)!=str.charAt(count2))
					{
						if(te)
						{
							a2=false;
							break;
						}
						te=true;
						count1++;
					}
					else
					{
						count1++;
						count2++;
					}
				}
				if(a1 || a2)
					ans=true;
				else
					ans=false;
			}
			
			if(ans)
				System.out.println("YES");
			else
				System.out.println("NO");
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
