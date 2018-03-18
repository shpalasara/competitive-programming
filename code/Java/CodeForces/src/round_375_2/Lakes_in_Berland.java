package round_375_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.TreeSet;

public class Lakes_in_Berland {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		String[] str = sc.nextLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
		
		char[][] data = new char[n+2][m+2];
		
		boolean[][] check = new boolean[n+2][m+2];
		
		String[] st = new String[n];
		
		for(int i=0;i<n;i++)
			st[i] = sc.nextLine();
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				data[i][j] = st[i].charAt(j);
		
		
			
		for(int i=0;i<n;i++)
		{
			if(data[i][0]=='.')
				new_mod_dfs( i, 0, data,n,m);
			if(data[i][m-1]=='.')
				new_mod_dfs( i, m-1, data,n,m);
		}
		
		for(int j=0;j<m;j++)
		{
			if(data[0][j]=='.')
				new_mod_dfs( 0, j, data,n,m);
			if(data[n-1][j]=='.')
				new_mod_dfs( n-1, j, data,n,m);
		}
		
//		System.out.println(data.length);
//		System.out.println(data[0].length);
		
		int size;
		
		TreeSet<pair> list = new TreeSet<pair>();
		//ArrayList<pair> list = new ArrayList<pair>();
		
		for(int i=1;i<n-1;i++)
		{
			for(int j=1;j<m-1;j++)
			{
				if(data[i][j]=='.' && !check[i][j])
				{
					size = dfs( i, j, check, data,n,m);
					pair temp = new pair(i,j,size);
					list.add(temp);
				}
			}
		}
		
		//Collections.sort(list);
		
		int ans=0,length = list.size();
		
		for(int i=0;i<(length-k);i++)
		{
			pair temp = list.pollFirst();
			ans += temp.size;
			mod_dfs( temp.i, temp.j, data,n,m);
		}
		
		out.println(ans);
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(data[i][j]=='#')
					data[i][j] = '.';
				out.print(data[i][j]);
			}
			out.println();
		}
		
		out.close();
	}
	
	public static void new_mod_dfs(int i,int j,char[][] data,int n,int m){
		
		data[i][j] = '#';
		
//		int n = data.length;
//		int m = data[0].length;
		
		if(i>0 && data[i-1][j]=='.')
			new_mod_dfs( i-1, j, data,n,m);
		
		if((i+1)<n && data[i+1][j]=='.')
			new_mod_dfs( i+1, j, data,n,m);
		
		if((j+1)<m && data[i][j+1]=='.')
			new_mod_dfs( i, j+1, data,n,m);
		
		if(j>0 && data[i][j-1]=='.')
			new_mod_dfs( i, j-1, data,n,m);
	}
	
	public static void mod_dfs(int i,int j,char[][] data,int n,int m){
		
		data[i][j] = '*';
		
//		int n = data.length;
//		int m = data[0].length;
		
		if(i>0 && data[i-1][j]=='.')
			mod_dfs( i-1, j, data,n,m);
		
		if(i+1<n && data[i+1][j]=='.')
			mod_dfs( i+1, j, data,n,m);
		
		if(j+1<m && data[i][j+1]=='.')
			mod_dfs( i, j+1, data,n,m);
		
		if(j>0 && data[i][j-1]=='.')
			mod_dfs( i, j-1, data,n,m);
	}
	
	public static int dfs(int i,int j,boolean[][] check,char[][] data,int n,int m){
		
		check[i][j] = true;
		int size=1;

//		int n = data.length;
//		int m = data[0].length;
		
		if(i-1>=0 && !check[i-1][j] && data[i-1][j]=='.')
			size += dfs( i-1, j, check, data,n,m);
		
		if(i+1<n && !check[i+1][j] && data[i+1][j]=='.')
			size += dfs( i+1, j, check, data,n,m);
		
		if(j+1<m && !check[i][j+1] && data[i][j+1]=='.')
			size += dfs( i, j+1, check, data,n,m);
		
		if(j-1>=0 && !check[i][j-1] && data[i][j-1]=='.')
			size += dfs( i, j-1, check, data,n,m);
		
		return size;
	}
	
	public static class pair implements Comparable<pair>{
		
		int i,j,size;
		
		public pair(int a,int b,int c){
			
			i = a;
			j = b;
			size = c;
		}
		
		public int compareTo(pair b){
			return ((this.size < b.size) ? -1 : 1);
		}
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
