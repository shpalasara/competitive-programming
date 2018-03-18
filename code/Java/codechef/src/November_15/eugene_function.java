package November_15;
import java.io.IOException;
import java.util.*;

public class eugene_function {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		//Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		long a1,d,l,r,f_a1,f_d,ans,sum,count;
		long[] temp = new long[15];
		
		while(t-->0)
		{
			ans=0;
			a1=sc.nextLong();
			d=sc.nextLong();
			l=sc.nextLong();
			r=sc.nextLong();
			
			f_a1=funt(a1);
			f_d=funt(d);
			sum=0;
			
			if(d==0)
			{
				ans=(r+1-l)*f_a1;
			}
			else
			{
				for(int i=1;i<10;i++)
				{
					temp[i]=funt(f_a1+i*f_d);
					sum+=temp[i];
				}
				temp[0]=temp[9];
				
				if(l==1 && l<=r)
				{
					ans=f_a1;
					l++;
				}
				while((l-1)%9!=1 && l<=r)
				{
					ans+=temp[(int)((l-1)%9)];
					l++;
				}
				count=(r+1-l)/9;
				ans+=count*sum;
				l+=count*9;
				
				while(l<=r)
				{
					ans+=temp[(int)((l-1)%9)];
					l++;
				}
			}
			
			
			//for(int i=0;i<=count;i++)
			//	ans+=temp[i];
			
			System.out.println(ans);
		}
		//sc.close();
	}
	
	public static long funt(long x)
	{
		long ans;
		while(x>9)
		{
			ans=0;
			while(x!=0)
			{
				ans+=x%10;
				x/=10;
			}
			x=ans;
		}
		return x;
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
