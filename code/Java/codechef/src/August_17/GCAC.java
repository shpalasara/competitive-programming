package August_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

public class GCAC {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		int n,m,temp;
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			int[] salary = new int[n];
			
			for(int i=0;i<n;i++)
				salary[i] = sc.nextInt();
			
			int[][] company = new int[m][3];
			
			for(int i=0;i<m;i++)
			{
				company[i][0] = sc.nextInt();
				company[i][1] = sc.nextInt();
				company[i][2] = i;
			}
			
			Arrays.sort(company, new Comparator<int[]>() {
				
				public int compare(int[] a, int[] b) {
					return a[0]>b[0] ? 1 : -1;
				}
			});
			
			int[] new_index = new int[m];
			
			for(int i=0;i<m;i++)
				new_index[company[i][2]] = i;
			
			boolean[] check = new boolean[m];
				
//			int[] prev_max_offers = new int[m];
//			
//			for(int i=0;i<m;i++)
//				prev_max_offers[i] = company[i][1];
			
			int[][] qual = new int[n][m];
			
		//	sc.nextLine();
			for(int i=0;i<n;i++)
			{
				String str = sc.nextLine();
				for(int j=0;j<m;j++)
					qual[i][new_index[j]] = str.charAt(j)-'0';
			}
			int acc_offers = 0;
			long total_salary = 0L;
			int not_taken = m;
			
			for(int i=0;i<n;i++)
			{
				for(int j=m-1;j>=0;j--)
				{
					if(company[j][0]<salary[i])
						break;
					if(qual[i][j]==1 && company[j][1]>0)
					{
						acc_offers++;
						total_salary += (long)company[j][0];
						company[j][1]--;
						if(!check[j])
						{
							not_taken--;
							check[j] = true;
						}
						break;
					}
				}
			}
			
			out.println(acc_offers+" "+total_salary+" "+not_taken);
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
