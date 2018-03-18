package December_15;
import java.io.IOException;
import java.util.*;

public class PLANEDIV {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		//Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(),n,ans,temp_ans,gcd;
	
		while(t-->0)
		{
			ans=0;
			temp_ans=0;
			n=sc.nextInt();
			int[][] data =new int[n][3];
			
			for(int i=0;i<n;i++)
			{
				data[i][0]=sc.nextInt();
				data[i][1]=sc.nextInt();
				data[i][2]=sc.nextInt();
				
				if(data[i][0]!=0 && data[i][1]!=0)
					gcd=GCD(data[i][0],data[i][1]);
				else if(data[i][0]!=0)
					gcd=data[i][0];
				else
					gcd=data[i][1];
				
				data[i][0]/=gcd;
				data[i][1]/=gcd;
				data[i][2]/=gcd;
			}
			java.util.Arrays.sort(data, new java.util.Comparator<int[]>() {

				  public int compare(int[] a,int[] b) {

				    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? (a[1]<b[1] ? -1 : (a[1]==b[1] ? (a[2]<b[2] ? -1 : 1) : 1)) : 1));

				  }

				});
			
			for(int i=0;i<n-1;i++)
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
	
	public static int GCD(int a, int b)
	{
		int temp;
		if(a<b)
		{
			temp=b;
			b=a;
			a=temp;
		}
		while(b!=0)
		{
			temp=b;
			b=a%b;
			a=temp;
		}
		return a;
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
