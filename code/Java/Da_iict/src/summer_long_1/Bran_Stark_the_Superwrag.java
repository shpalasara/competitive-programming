package summer_long_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Bran_Stark_the_Superwrag {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc= new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n=sc.nextInt(),m=sc.nextInt();
		int[][] data = new int[n*m][3];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				data[i*m+j][0]=sc.nextInt();
				data[i*m+j][1]=i;
				data[i*m+j][2]=j;
			}
		}
		

		java.util.Arrays.sort(data, new java.util.Comparator<int[]>() {
		
			  public int compare(int[] a,int[] b) {
		
			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));
		
			  }
		
			});
		
//		for(int i=0;i<n*m;i++)
//			System.out.print(data[i][0]+" ");
//		System.out.println();
		
		int q = sc.nextInt(),x,index;
		
		while(q-->0)
		{
			x=sc.nextInt();
			index = binarySearch(data,x,0,n*m-1);
			
			if(index==-1)
				out.println("Not Reachable.Bran Needs Another Plan.");
			else
				out.println((data[index][1]+1)+" "+(data[index][2]+1));
		}
		out.close();
	}
	
	public static int binarySearch(int[][] data,int x,int low,int high)
	{
		int mid = (high+low)/2;	
		
		if(data[mid][0]==x)
			return mid;
		
		if(data[low][0]==x)
			return low;
		
		if(data[high][0]==x)
			return high;
		
		if(low>=high)
			return -1;
		
		if(data[mid][0]>x)
			return binarySearch(data,x,low+1,mid-1);
		else
			return binarySearch(data,x,mid+1,high-1);
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
