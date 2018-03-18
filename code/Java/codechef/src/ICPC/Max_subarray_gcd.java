package ICPC;
import java.io.IOException;
import java.util.*;

public class Max_subarray_gcd {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int N=sc.nextInt(),k=sc.nextInt(),max=0,_gcd,ans,prev_gcd=0;
		int[] array = new int[N];
		
		for(int i=0;i<N;i++)
		{
			array[i]=sc.nextInt();
			if(max<array[i])
				max=array[i];
		}
		
		if(k>max)
			System.out.println("0");
		else
		{
			int count;
			ans=1;
			for(int i=0;i<N;i++)
			{
				count=1;
				if(array[i]>=k)
				{
					_gcd=array[i];
					for(int j=i+1;j<N;j++)
					{
						//prev_gcd=_gcd;
						_gcd=gcd(_gcd,array[j]);
						if(_gcd<k)
							break;
						count++;
					}
					//if(prev_gcd>=k) 
					//{
						if(count>ans)
							ans=count;
					//}
					//else
						//start++;
				}
				if(ans==N-i)
					break;
			}
			System.out.println(ans);
		}
	}
	
	public static int gcd(int a, int b)
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
