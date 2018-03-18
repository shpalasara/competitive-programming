package hack_101_June_16;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Sorted_Subsegments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		int n=sc.nextInt(),q=sc.nextInt(),k=sc.nextInt(),s_index=0,e_index=0;
		
		int[] data = new int[n];
		int[][] query = new int[q][2];
		ArrayList<node> fquery = new ArrayList<node>();
		boolean inside = false,insert = false;
		
		for(int i=0;i<n;i++)
			data[i] = sc.nextInt();
		
		for(int i=0;i<q;i++)
		{
			query[i][0] = sc.nextInt();
			query[i][1] = sc.nextInt();
		}
		
		java.util.Arrays.sort(query, new java.util.Comparator<int[]>() {
			
		  public int compare(int[] a,int[] b) {
	
		    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? ( a[1]>b[1] ? -1 : 1) : 1));
	
		  }
	
		});
			
		node end = new node();
		end.s = query[0][0];
		end.e = query[0][1];
		
		//fquery.add(temp);
		
		for(int i=1;i<q;i++)
		{
			insert = false;
			
			while(i<q && query[i][0]==query[i-1][0])
				i++;
			
			if(i<q)
			{
				if(query[i][0]<=end.e)
				{
					end.e = query[i][1];
				}
				else
				{
					fquery.add(end);
					end = new node();
					
					end.s = query[i][0];
					end.e = query[i][1];
					insert = true;
				}
			}
		}
		
		if(!insert)
			fquery.add(end);
		
		
		for(int i=0;i<fquery.size() && !inside;i++)
		{
			if(k>=fquery.get(i).s && k<=fquery.get(i).e)
			{
				s_index = fquery.get(i).s;
				e_index = fquery.get(i).e;
				inside = true;
			}
		}
		
		if(inside)
		{
			int[] new_data = new int[e_index-s_index+1];
			k-=s_index;
			
			for(int i=0;i<e_index-s_index+1;i++)
				new_data[i] = data[s_index+i];
			
			Arrays.sort(new_data);
			
			System.out.println("new_data");
			for(int i=0;i<e_index-s_index+1;i++)
				System.out.print(new_data[i]+" ");
			System.out.println();
			
			
			System.out.println(new_data[k]);
		}
		else
		{
			System.out.println(data[k]);
		}
	}

	static class node{
		
		int s,e;
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
