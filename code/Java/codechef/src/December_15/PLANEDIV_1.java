package December_15;

import java.io.IOException;
import java.util.*;
 
public class PLANEDIV_1 {
 
	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		//Scanner sc = new Scanner(System.in);
		long t=sc.nextLong(),n,ans,temp_ans;
	
		while(t-->0)
		{
			ans=0;
			temp_ans=0;
			n=sc.nextInt();
			double[][] data =new double[(int)n][3];
			
			for(int i=0;i<(int)n;i++)
			{
				data[i][0]=(double)sc.nextInt();
				data[i][1]=(double)sc.nextInt();
				data[i][2]=(double)sc.nextInt();
				
				if(data[i][0]!=0)
				{
					if(data[i][1]!=0)
						data[i][1]/=data[i][0];
					if(data[i][2]!=0)
						data[i][2]/=data[i][0];
					data[i][0]=1.0;
				}
				else if(data[i][1]!=0)
				{
					if(data[i][0]!=0)
						data[i][0]/=data[i][1];
					if(data[i][2]!=0)
						data[i][2]/=data[i][1];
					data[i][1]=1.0;
				}
			}
			java.util.Arrays.sort(data, new java.util.Comparator<double[]>() {
 
				  public int compare(double[] a,double[] b) {
 
				    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? (a[1]<b[1] ? -1 : (a[1]==b[1] ? (a[2]<b[2] ? -1 : 1) : 1)) : 1));
 
				  }
 
				});
			
			for(int i=0;i<(int)n-1;i++)
			{
				if(data[i][0]==data[i+1][0] && data[i][1]==data[i+1][1] && data[i][2]!=data[i+1][2])
					temp_ans++;
				else if(data[i][0]!=data[i+1][0] || data[i][1]!=data[i+1][1])
					temp_ans=0;
				
 
				if(temp_ans+1>ans)
					ans=temp_ans+1;
				//System.out.println(temp_ans);
				//System.out.println(data[i][0]+" "+data[i][1]+" "+data[i][2]);
			}
			if(temp_ans+1>ans)
				ans=temp_ans+1;
			//System.out.println(data[n-1][0]+" "+data[n-1][1]+" "+data[n-1][2]);
			
			System.out.println(ans);
		}
		//sc.close();
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
/*
1 5
0 1 0
0 3 2
1 0 0
5 0 8
0 8 100
*/