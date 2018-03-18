package daiict;

import java.io.IOException;
import java.util.*;
import java.util.InputMismatchException;

public class Coyote_and_roads {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int n=sc.nextInt(),count=0;
		int[][] data = new int[n][3];
		int[][] ans= new int[2*(n-1)][3];
		boolean[] check = new boolean[n];
		//int[] connect = new int[];
		
		long out=0;
		
		for(int i=0;i<n;i++)
		{
			data[i][0]=sc.nextInt();
			data[i][1]=sc.nextInt();
			data[i][2]=i;
			//ans[i]=Integer.MAX_VALUE;
		}
		
		 Arrays.sort(data, new Comparator<int[]>() {
	            public int compare(int[] a, int[] b) {
	                
	            	return (a[0]<b[0] ? -1: (a[0] == b[0] ? 0 : 1));
	            }
	        });
		 
		 // at 0 weight
		 // at 1 vertices from
		 // at 2 vertices to
		 
		 for(int i=1;i<n;i++)
		 {
			 ans[count][0] = Math.abs(data[i-1][0]-data[i][0]);
			 ans[count][1] = data[i-1][2];
			 ans[count++][2] = data[i][2];
		 }
		 
		 Arrays.sort(data, new Comparator<int[]>() {
	            public int compare(int[] a, int[] b) {
	                
	            	return (a[1]<b[1] ? -1: (a[1] == b[1] ? 0 : 1));
	            }
	        });
		 
		 for(int i=1;i<n;i++)
		 {
			 ans[count][0] = Math.abs(data[i-1][1]-data[i][1]);
			 ans[count][1] = data[i-1][2];
			 ans[count++][2] = data[i][2];
		 }
		 
		 System.out.println(count);
		 
		 Arrays.sort(ans, new Comparator<int[]>() {
	            public int compare(int[] a, int[] b) {
	                
	            	return (a[0]<b[0] ? -1: (a[0] == b[0] ? 0 : 1));
	            }
	        });
		 
		 count=0;
		 
		 for(int i=0;i<2*(n-1);i++)
		 {
			 if(!check[ans[i][1]] || !check[ans[i][2]])
			 {
				 check[ans[i][1]]=true;
				 check[ans[i][2]]=true;
				 out+=(long)ans[i][0];
				 count++;
			 }
		 }
		 
		 System.out.println(count);
		 //for(int i=0;i<n;i++)
		//	 out+=(long)ans[i];
		 
		 System.out.println(out);
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
