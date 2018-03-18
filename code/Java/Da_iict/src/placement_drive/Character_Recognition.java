package placement_drive;

import java.io.IOException;
import java.util.InputMismatchException;

public class Character_Recognition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FasterScanner sc = new FasterScanner();
		String[] str = sc.nextLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
		
		boolean[] check = new boolean[1<<k];
		boolean[][] data = new boolean[k][n*m];
		
		for(int i=0;i<k;i++)
		{	
			for(int j=0;j<n;j++)
			{
				String temp = sc.nextLine();
				for(int l=0;l<m;l++)
				{
					if(temp.charAt(l)=='1')
						data[i][j*m+l] = true;
				}
			}
		}
		
		int val;
		
		for(int i=0;i<n*m;i++)
		{
			val = 0;
			
			for(int j=0;j<k;j++)
			{
				if(data[j][i])
					val = val | (1<<j);
			}
			check[val] = true;
		}
		
//		for(int i=0;i<check.length;i++)
//		{
//			if(check[i])
//				System.out.print(1+" ");
//			else
//				System.out.print(0+" ");
//		}
//		System.out.println();
		
		int[] out = new int[k];
		
		System.out.println(recursion(0, k-1, out, check , k , n));
	}
	
	public static int recursion(int index, int count, int[] out, boolean[] check , int k , int n){
		
		int ans = 100,temp,in,size;
		boolean ch = true;
		size = check.length;
		
		for(int i=0;i<k && ch;i++)
		{
			for(int j=i+1;j<k && ch;j++)
			{	
				if(out[i]==out[j])
					ch = false;
			}
		}
		
		if(ch)
		{
			//System.out.println("here");
			return k-1-count; 
		}
		
		if(count==0)
		{
			//System.out.println("h1");
			return ans;
		}
		
		for(int i=index;i<size;i++)
		{
			if(check[i])
			{
				//System.out.println(i+" "+count);
				int[] new_out = new int[k];
				
				for(int j=0;j<k;j++)
					new_out[j] = out[j];
				
				temp = i;
				in = 0;
				
				while(temp!=0)
				{
					if(temp%2==0)
						new_out[in] += 1<<count;
					in++;
					temp = temp>>1;
				}
				
				ans = Math.min(ans, recursion(i+1, count-1, new_out, check , k , n));
			}
			
			if(ans==(k-1-count))
				break;
		}
		
		return ans;
	}

	public static class info {
		
		boolean check;
		int index;
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
