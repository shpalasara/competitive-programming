package Loc_July_16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class NUMHOLMS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt(),n,sum,temp;
		int[] freq = new int[10];
		
		while(t-->0)
		{
			n = sc.nextInt();
			sum = 0;
			
			for(int i=0;i<10;i++)
				freq[i]=0;
			
			while(n-->0)
			{
				temp = sc.nextInt();
				freq[temp]++;
				sum+=temp;
			}
			
			StringBuilder str = new StringBuilder("");
			
			if(freq[0]==0)
				out.println(-1);
			else
			{
				boolean check = false;
				
				if(sum%3==0)
				{
					check = true;
				}
				else if(sum%3==1)
				{
					for(int i=1;i<10;i+=3)
					{
						if(freq[i]>0)
						{
							check = true;
							freq[i]--;
							break;
						}
					}
					
					if(!check)
					{
						int dec = 2;
						
						for(int i=2;i<10;i+=3)
						{
							if(dec==2)
							{
								if(freq[i]>=2)
								{
									check = true;
									freq[i]-=dec;
									break;
								}
								else if(freq[i]==1)
								{
									freq[i]--;
									dec--;
								}
							}
							else if(dec==1 && freq[i]>=1)
							{
								freq[i]--;
								check = true;
								break;
							}
						}
					}
				}
				else
				{
					for(int i=2;i<10;i+=3)
					{
						if(freq[i]>0)
						{
							check = true;
							freq[i]--;
							break;
						}
					}
					
					if(!check)
					{
						int dec = 2;
						
						for(int i=1;i<10;i+=3)
						{
							if(dec==2)
							{
								if(freq[i]>=2)
								{
									check = true;
									freq[i]-=dec;
									break;
								}
								else if(freq[i]==1)
								{
									freq[i]--;
									dec--;
								}
							}
							else if(dec==1 && freq[i]>=1)
							{
								freq[i]--;
								check = true;
								break;
							}
						}
					}
				}
				
				if(check)
				{
					int te=0;
					
					for(int i=9;i>=0;i--)
					{
						if(i!=0)
							te +=freq[i];
						else
						{
							if(te==0)
								freq[0]=1;
						}
						for(int j=0;j<freq[i];j++)
							str.append(i);
					}
					
					out.println(str.toString());
				}
				else
					out.println(-1);
			}
		}
		
		out.close();
	}
	
	static class FasterScanner {

        private byte[] buf = new byte[1024];
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
