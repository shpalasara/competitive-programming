package round_1;

import java.io.IOException;
import java.util.InputMismatchException;

public class MasterMind {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int n=sc.nextInt(),t,index=0,k;
		int[][] id = new int[n][2];
		int[] count = new int[n];
		
		for(int i=0;i<n;i++)
		{
			id[i][1]=sc.nextInt();
			id[i][0] = sc.nextInt();
		}
		
		java.util.Arrays.sort(id, new java.util.Comparator<int[]>() {
			 
			  public int compare(int[] a,int[] b) {

			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? (a[1]<b[1] ? -1 : 1) : 1));

			  }

			});
		
		for(int i=0;i<n;i++)
		{
			if(id[i][0]!=0)
			{
				for(int j=0;j<n;j++)
				{
					if(id[i][0]>=id[j][1])
					{
						t=id[i][0]-id[j][1];
						index=-1;
						
						if(t==0)
						{
							count[j]++;
							id[j][1]=0;
							break;
						}
						else
						{
							for(k=0;k<n;k++)
							{
								if(k!=i && k!=j && id[k][1]==t)
								{
									index=k;
									count[j]++;
									count[index]++;
								}
							}
						}
					}
				}
			}
		}
		
		for(int i=0;i<n;i++)
		{
			if(count[i]==0)
			{
				index=id[i][1];
				break;
			}
		}
		System.out.println(index);
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
