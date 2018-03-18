package December_17;

import java.io.IOException;
import java.util.InputMismatchException;

public class CHEFHAM {

	static int size = 100001;
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		
		int t = sc.nextInt();
		
		while(t-->0) {
			
			int n = sc.nextInt();
			int[] data = sc.nextIntArray(n);
			
			int[] ans = new int[n];
			int ham_dist = 0;
			
			int[] index1 = new int[size];
			int[] index2 = new int[size];
			int[] next = new int[size];
			
			for(int i=0;i<n;i++){
				
				if(index1[data[i]]==0)
					index1[data[i]] = i+1;
				else
					index2[data[i]] = i+1;
			}
			
			int pair=0,single=0,i_pair=-1,i_single=-1;
			
			for(int i=size-1;i>0;i--)
			{
				if(index1[i]!=0 && index2[i]!=0) {
					pair++;
					next[i] = i_pair;
					i_pair = i;
				}
				else if(index1[i]!=0) {
					single++;
					next[i] = i_single;
					i_single = i;
				}
			}
			
			if(pair<=1 && single<=1) {
				
			}else if(pair==1 || single==1) {
				
			}
			else {
			
				for(int i=0;i<size;i++) {
					
					if(index1[i]!=0) {
						
						if(index2[i]!=0) {
							
							if(next[i]==-1) {
								
							}else {
								
								ans[index1[i]-1] = next[i];
								ans[index2[i]-1] = next[i];
							}
								
						}else {
							
						}
					}
				}
			}
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
