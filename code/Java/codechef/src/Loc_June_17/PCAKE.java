package Loc_June_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class PCAKE {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		boolean[] prime = new boolean[1001];
		boolean[] good = new boolean[1001];
		long[][] bit_map = new long[1001][3];
		
		for(int i=0;i<1001;i++)
			good[i] = prime[i] = true;
		
		int count = 0;
		
		for(int i=2;i<1001;i++)
		{
			if(prime[i])
			{
				add( bit_map, i , count);
				
				for(int j=i+i;j<1001;j+=i)
				{
					add( bit_map, j , count);
					prime[j] = false;
				}
				
				for(int j=i;j*i<1001;j+=i)
					good[i*j] = false;

				count++;
			}
		}
		
//		for(int i=0;i<100;i++)
//			System.out.println(i+" "+Long.toHexString(bit_map[i][0]));
//		System.out.println(count);
		
		int t = sc.nextInt();
		int n,s_index,start;
		int[] data = new int[100001];
		long ans;
		long[] temp_bit_map = new long[3];
		boolean prev;
		
		while(t-->0)
		{
			n = sc.nextInt();
			
			for(int i=0;i<3;i++)
				temp_bit_map[i] = 0L;
			
			//mul = 1L;
			s_index = 0;
			start = 0;
			prev = false;
			ans = 0L;
			
			for(int i=0;i<n;i++)
				data[i] = sc.nextInt();
			
			for(int i=0;i<n;i++)
			{
				if(good[data[i]])
				{
					if(check(temp_bit_map, bit_map , data[i]))
					{
						for(int j=0;j<3;j++)
							temp_bit_map[j] |= bit_map[data[i]][j];
					}
					else
					{
						long n1 = i - s_index;
						ans = ans + (n1*(n1+1L))>>1;
				
						n1 = start - s_index;
						ans = ans - (n1*(n1+1L))>>1;
			
						while(s_index<i && !check(temp_bit_map, bit_map , data[i]))
						{
							for(int j=0;j<3;j++)
								temp_bit_map[j] ^= bit_map[data[s_index]][j];
							s_index++;
						}
						
						for(int j=0;j<3;j++)
							temp_bit_map[j] |= bit_map[data[i]][j];
						start = i;
					}
					prev = true;
				}
				else
				{
					if(prev)
					{
						long n1 = i - s_index;
						ans = ans + (n1*(n1+1L))>>1;
				
						n1 = start - s_index;
						ans = ans - (n1*(n1+1L))>>1;
					}
					
					s_index = i+1;
					start = i+1;
					prev = false;
					
					for(int j=0;j<3;j++)
						temp_bit_map[j] = 0L;
				}
				out.print(ans+" ");
			}
			out.println();
			if(prev)
			{
				long n1 = n - s_index;
				ans += (n1*(n1+1L))>>1;
		
				n1 = start - s_index;
				ans -= (n1*(n1+1L))>>1;
			}
			out.println(ans);
		}
		out.close();
	}
	
	public static boolean check (long[] map, long[][] temp , int index){
		
		long and = 0L; 
		
		for(int i=0;i<3;i++)
			and |= (map[i] & temp[index][i]);
		
		if(and==0L)
			return true;
		return false;
	}
	
	public static void add (long[][] bit_map , int i , int count){
		
		int slot = count/63;
		int place = 63 - (count%63);
		
		bit_map[i][slot] ^= 1L<<place;
		
		return;
	}
	
	public static long gcd(long a,long b){
		
		a=Math.abs(a);
		b=Math.abs(b);
		
		long temp;
		while(b!=0)
		{
			temp = a%b;
			a = b;
			b = temp;
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
