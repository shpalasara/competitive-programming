package round_372_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Complete_the_Word {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		char[] str = sc.nextLine().toCharArray();
		
		int[] index = new int[26];
		int start=0;
		
		for(int i=0;i<26;i++)
			index[i] = -1;
		
		if(str.length<26)
			out.println("-1");
		else
		{
			boolean check = false;
			
			for(int i=0;i<26;i++)
			{
				if(str[i]!='?')
				{
					if(index[str[i]-'A']!=-1)
					{
						start = index[str[i]-'A'];
						
						for(int j=0;j<26;j++)
						{
							if(index[j]<=start)
								index[j] = -1;
						}
						start++;
					}
					index[str[i]-'A'] = i;
				}
			}
			
			if(start==0)
			{
				int ind = 0;
				
				for(int j=0;j<26;j++)
				{
					while(ind<26 && index[ind]!=-1)
						ind++;
					
					if(str[j]=='?')
					{
						str[j] = (char)((int)'A'+ind);
						ind++;
					}
				}
				check = true;
			}
			
			for(int i=26;i<str.length && !check;i++)
			{
				///System.out.println("here");
				
				if(str[i]!='?')
				{
					if(index[str[i]-'A']!=-1)
					{
						start = index[str[i]-'A'];
						
						for(int j=0;j<26;j++)
						{
							if(index[j]!=-1 && index[j]<=start)
								index[j] = -1;
						}
						start++;
					}
					index[str[i]-'A'] = i;
				}
				
				if((i+1)-start==26)
				{
					int ind = 0;
					
					for(int j=i-25;j<=i;j++)
					{
						while(ind<26 && index[ind]!=-1)
							ind++;
						
						if(str[j]=='?')
						{
							str[j] = (char)((int)'A'+ind);
							//index[ind]=1;
							ind++;
						}
					}
					check = true;
					break;
				}
			}
			
			if(check)
			{
				for(int i=0;i<str.length;i++)
				{
					if(str[i]=='?')
						out.print('A');
					else
						out.print(str[i]);
				}
			}
			else
				out.print("-1");
		}
			
		out.println();
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
