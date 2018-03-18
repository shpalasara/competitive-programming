package June_17;

// Accepted

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class UNIONSET {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		int size = 2501;
		int map_size = (int)Math.ceil((double)2501/64);
		
		long[][] bit_map = new long[size][map_size];
		
		int n,k,len,data;
		long all_set = -1L;
		int temp_map_size;
		
		while(t-->0)
		{
			n = sc.nextInt();
			k = sc.nextInt();
			temp_map_size = (int)Math.ceil((double)k/64);
			
			for(int i=0;i<n;i++)
			{
				len = sc.nextInt();
				for(int j=0;j<len;j++)
				{
					data = sc.nextInt()-1;
					add_remove_bit(bit_map[i], data);
				}
			}
			
			boolean check;
			int ans=0;
			
			long temp,x;
			
			if(k%64==0)
				temp = all_set;
			else
				temp = bit_setter(k%64);
			
			for(int i=0;i<n;i++)
			{
				for(int j=i+1;j<n;j++)
				{
					check = true;
					for(int l=0;l<temp_map_size-1 && check;l++)
					{
						x = bit_map[i][l] | bit_map[j][l];
						if(( x ^ all_set ) != 0L )
							check = false;
					}
					if(check)
					{
						x = (bit_map[i][temp_map_size-1] | bit_map[j][temp_map_size-1]);
						if(( x ^ temp ) == 0L )
							ans++;
					}
				}
				
				for(int l=0;l<temp_map_size;l++)
					bit_map[i][l] = 0L;
			}
			out.println(ans);
		}
		
		out.close();
	}
	
	public static long bit_setter (int k){
		
		long temp=0;
		
		for(int i=0;i<k;i++)
			temp |=1L<<i;
		
//		for(int i=63;i>=63-(k-1);i--)
//			temp |= 1L<<i; 
	
		return temp;
	}
	
	public static int add_remove_bit(long[] bit_map, int data){
		
		int index,bit;
		long xor;
		index = data/64;
		bit = data%64;
		xor = 1L<<bit;
		bit_map[index] = bit_map[index]^xor;
		
		return 0;
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
