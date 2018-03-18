package August_17;

// Accepted

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class Straightest_path {

	static int[][] ans;
	static boolean[][] visited,left_right;
	static PriorityQueue<node> queue; 
	static int n,m;
	static String[] data; 
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		
		String[] str = sc.nextLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		data = new String[n];
		
		for(int i=0;i<n;i++)
			data[i] = sc.nextLine();
		
		ans = new int[n][m];
		visited = new boolean[n][m];
		left_right = new boolean[n][m];
		queue =new PriorityQueue<node>();
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				ans[i][j] = 10000001;
		
		int s_x=-1,s_y=-1;
		int e_x=-1,e_y=-1;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(data[i].charAt(j)=='V')
				{
					s_x = i;
					s_y = j;
				}
				else if(data[i].charAt(j)=='H')
				{
					e_x = i;
					e_y = j;
				}
			}
		}
		
		for(int i=s_x+1;i<n;i++)
		{
			if(data[i].charAt(s_y)=='*')
				break;
			
			ans[i][s_y] = 0;
			visited[i][s_y] = true;
			left_right[i][s_y] = false;
			queue.add(new node(i,s_y,0,true));
		}
		
		for(int i=s_x-1;i>=0;i--)
		{
			if(data[i].charAt(s_y)=='*')
				break;
			
			ans[i][s_y] = 0;
			visited[i][s_y] = true;
			left_right[i][s_y] = false;
			queue.add(new node(i,s_y,0,true));
		}
		
		for(int j=s_y+1;j<m;j++)
		{
			if(data[s_x].charAt(j)=='*')
				break;
			
			ans[s_x][j] = 0;
			visited[s_x][j] = true;
			left_right[s_x][j] = true;
			queue.add(new node(s_x,j,0,false));
		}
		
		for(int j=s_y-1;j>=0;j--)
		{
			if(data[s_x].charAt(j)=='*')
				break;
			
			ans[s_x][j] = 0;
			visited[s_x][j] = true;
			left_right[s_x][j] = true;
			queue.add(new node(s_x,j,0,false));
		}
		
		travel();
		
		if(ans[e_x][e_y]==10000001)
			System.out.println(-1);
		else
			System.out.println(ans[e_x][e_y]);
	}
	
	public static void travel() {
		
		node next;
		int x,y,val;
		boolean lr;
		
		while(!queue.isEmpty())
		{
			next = queue.remove();
			x = next.x;
			y = next.y;
			val = next.ans;
			lr = next.lr;
			
			if(lr)
			{
				for(int i=y+1;i<m;i++)
				{
					if(data[x].charAt(i)=='*' || left_right[x][i])
						break;
					
					if(!visited[x][i])
					{
						ans[x][i] = val+1;
						visited[x][i] = true;
						left_right[x][i] = true;
						queue.add(new node(x,i,val+1,false));
					}
				}
				
				for(int i=y-1;i>=0;i--)
				{
					if(data[x].charAt(i)=='*' || left_right[x][i])
						break;
					
					if(!visited[x][i])
					{
						ans[x][i] = val+1;
						visited[x][i] = true;
						left_right[x][i] = true;
						queue.add(new node(x,i,val+1,false));
					}
				}
			}
			else
			{
				for(int i=x+1;i<n;i++)
				{
					if(data[i].charAt(y)=='*' || (visited[i][y] && !left_right[i][y]))
						break;
					
					if(!visited[i][y])
					{
						ans[i][y] = val+1;
						visited[i][y] = true;
						left_right[i][y] = false;
						queue.add(new node(i,y,val+1,true));
					}
				}
				
				for(int i=x-1;i>=0;i--)
				{
					if(data[i].charAt(y)=='*' || (visited[i][y] && !left_right[i][y]))
						break;
					
					if(!visited[i][y])
					{
						ans[i][y] = val+1;
						visited[i][y] = true;
						left_right[i][y] = false;
						queue.add(new node(i,y,val+1,true));
					}
				}
			}
		}
	}
	
//	public static void BFS() {
//
//		node data;
//		int x,y,an;
//		boolean lr,ud;
//		
//		while(!queue.isEmpty())
//		{
//			data = queue.remove();
//			x = data.x;
//			y = data.y;
//			an = data.ans;
//			lr = data.lr;
//			ud = data.ud;
//			
//			if((x-1)>=0 && !visited[x-1][y] && )
//			{
//				visited[x-1][y] = true;
//				if(ud)
//					ans[x-1][y] = an;
//				else
//					ans[x-1][y] = an + 1;
//				
//				queue.add( new node(x-1,y,ans[x-1][y],false,true));
//			}
//			if((x+1)<n && !visited[x+1][y])
//			{
//				visited[x+1][y] = true;
//				if(ud)
//					ans[x+1][y] = an;
//				else
//					ans[x+1][y] = an + 1;
//				
//				queue.add( new node(x+1,y,ans[x+1][y],false,true));
//			}
//		}
//	}
	
	public static class node implements Comparable<node>{
		
		int ans;
		int x,y;
		boolean lr;				// Moving left or right
//		boolean ud;				// Moving up or down
		
		public node(int i, int j, int val, boolean lr/*, boolean ud*/) {
			x = i;
			y = j;
			ans = val;
			this.lr = lr;
//			this.ud = ud;
		}
		
		public int compareTo(node x) {
			
			return (this.ans - x.ans);
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
