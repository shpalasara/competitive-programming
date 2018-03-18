package educ_round_1;

import java.io.IOException;
import java.util.InputMismatchException;

public class round_8_q3 {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		String[] str=sc.nextLine().split(" ");
		int n=Integer.parseInt(str[0]),k=Integer.parseInt(str[1]);
		char t;
		
		str[0]=sc.nextLine();
		str[1]="";
		
		//for(int i=0;i<n;i++)
		//	max+=Math.max(str[0].charAt(i)-'a', 'z'-str[0].charAt(i));
		
		if(k<n*25)
		{	
			for(int i=0;i<n;i++)
			{
				if(k>0)
				{
					if((str[0].charAt(i)-'a')>('z'-str[0].charAt(i)))
					{
						if(k>(str[0].charAt(i)-'a'))
						{
							str[1]+="a";
							k-=(str[0].charAt(i)-'a');
						}
						else
						{
							t=(char)((str[0].charAt(i))-k);
							str[1]+=""+t;
							k=0;
						}
					}
					else
					{
						if(k>('z'-str[0].charAt(i)))
						{
							str[1]+="z";
							k-=('z'-str[0].charAt(i));
						}
						else
						{
							t=(char)(((int)str[0].charAt(i))+k);
							str[1]+=""+t;
							k=0;
						}
					}
				}
				else
				{
					str[1]+=str[0].substring(i);
					break;
				}
			}
			//System.out.println(str[1]);
		//}
		
			if(k>0)	
				System.out.println("-1");
			else
				System.out.println(str[1]);
		}
		else
			System.out.println("-1");
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
