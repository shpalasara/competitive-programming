package SnackDown_17;

import java.io.IOException;
import java.util.InputMismatchException;

public class ISSNAKE {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int t = Integer.parseInt(sc.nextLine()),n;
		
		while(t-->0)
		{
			n = Integer.parseInt(sc.nextLine());
			char[][] ch = new char[2][n+1];
			ch[0] = sc.nextLine().toCharArray();
			ch[1] = sc.nextLine().toCharArray();
			
			int[][] nb = new int[2][n+1];				// Neighbours of that point
			int t1=0,i1=-1,j1=-1,count=0;
			int[] edge_count = new int[5];
			boolean check=false;
			
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<n;j++)
				{
					t1 = 0;
					if(ch[i][j]=='#')
					{
						if(i1==-1)
						{
							i1 = i;
							j1 = j;
						}
						count++;
						if(i==0)
						{
							if(ch[i+1][j]=='#')
								t1++;
						}
						else
						{
							if(ch[i-1][j]=='#')
								t1++;
						}
						if(j>0 && ch[i][j-1]=='#')
							t1++;
						if(j<n-1 && ch[i][j+1]=='#')
							t1++;
						
						nb[i][j] = t1;
						edge_count[t1]++;
						if(t1==1)
						{
							i1 = i;
							j1 = j;
							check = true;
						}
					}
				}
			}
			
			if(count==0)
				System.out.println("no");
			else if(count==1)
				System.out.println("yes");
			else if(edge_count[0]>0)
				System.out.println("no");
			else if(edge_count[1]>2)
				System.out.println("no");
			else
			{
				boolean result;
				if(check)
					result = travel(i1,j1,n,ch,count);
				else
					result = travel(i1,j1,n,ch,count) | travel(i1+1,j1,n,ch,count);
				
				if(result)
					System.out.println("yes");
				else
					System.out.println("no");
			}
		}
	}

	public static boolean travel(int i,int j,int n,char[][] ch,int count){
		
		boolean[][] visited = new boolean[2][n+1]; 
		int temp,t_count=0;
		
		while(t_count<count)
		{
			t_count++;
			visited[i][j] = true;
			
			if(t_count==count)
				break;
			
			if(i==0)
			{
				if(!visited[i+1][j] && ch[i+1][j]=='#')
				{
					i++;
					continue;
				}
			}
			else
			{
				if(!visited[i-1][j] && ch[i-1][j]=='#')
				{
					i--;
					continue;
				}
			}
			
			temp = 0;
			
			if(j>0 && ch[i][j-1]=='#' && !visited[i][j-1])
				temp = 1;
			if(j<(n-1) && ch[i][j+1]=='#' && !visited[i][j+1])
				temp +=2;
			
			if(temp>2 || temp<=0)
				return false;
			else if(temp==1)
				j--;
			else
				j++;
		}
		
		return true;
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
