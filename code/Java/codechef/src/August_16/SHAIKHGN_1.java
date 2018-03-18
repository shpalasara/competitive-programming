package August_16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class SHAIKHGN_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		int size = (int)Math.ceil((double)n/(double)64);
		
		graph data = new graph(n,size);
		int i1,i2;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(sc.nextInt()==1)
				{
					i1 = j/64;
					i2 = 63 - j%64;
					data.row[i][i1] = data.row[i][i1] | (1L<<i2);
					
					i1 = i/64;
					i2 = 63 - i%64;
					data.col[i1][j] = data.col[i1][j] | (1L<<i2);
				}
			}
		}
		
		ArrayList<graph> list = new ArrayList<graph>();
		list.add(data);
		
		int temp = 0;
		
		// Complexity of this code is O(n^3/64 *32)
		while(temp<32)
		{
			graph te = do_mutiply(list.get(temp), list.get(temp));
			list.add(te);
			temp++;
		}
	
//		for(int i=0;i<n;i++)
//			for(int j=0;j<size;j++)
//				System.out.printf("%x\n",list.get(1).row[i][j]);
		
//		for(int i=0;i<size;i++)
//			for(int j=0;j<n;j++)
//				System.out.printf("%x\n",data.col[i][j]);
	
		int m = sc.nextInt(),k,x,count;
		
		while(m-->0)
		{
			k = sc.nextInt();
			x = sc.nextInt()-1;
			count = 0;
			
			if(k==0)
			{
				out.println("1\n"+(x+1));
			}
			else
			{
				//graph ans = new graph(n,size);
				long[] ans = new long[size];
				
				if(k==1)
				{
					copy_row( x, data, ans);
					//copy_data(ans,list.get(0));
				}
				else
				{
					boolean check = true;
					
					// Complexity of this code is O(n^3/64 *32)
					while(k!=0)
					{
						if((k%2)==1)
						{
							if(check)
							{
								copy_row( x, list.get(count), ans);
								//copy_data(ans,list.get(count));
								check = false;
							}
							else
							{
								muliply_row(ans, list.get(count));
								//ans = do_mutiply(ans, list.get(count));
							}
						}
						
						k = k>>1;
						count++;
					}
				}
				
				count=0;
				StringBuilder str = new StringBuilder("");
				
//				for(int i=0;i<n;i++)
//				{
//					for(int j=0;j<size;j++)
//						System.out.printf("%x\n",ans.row[i][j]);
//				}
//				
//				System.out.println();
//				
//				for(int i=0;i<size;i++)
//				{
//					for(int j=0;j<n;j++)
//						System.out.printf("%x\n",ans.col[i][j]);
//				}
				
//				for(int j=0;j<size;j++)
//				{
//					for(int i=63;i>=0;i--)
//					{
//						if( (ans.row[x][j] & (1L<<i)) !=0)
//						{
//							count++;
//							str.append((j*64+63-i+1)+" ");
//						}
//					}
//				}
	
				for(int j=0;j<size;j++)
				{
					for(int i=63;i>=0;i--)
					{
						if( (ans[j] & (1L<<i)) !=0)
						{
							count++;
							str.append((j*64+63-i+1)+" ");
						}
					}
				}
					
				out.println(count);
				
				if(count==0)
					out.println(-1);
				else
					out.println(str.toString());
			}
		}
		
		out.close();
	}
	
	public static void muliply_row(long[] ans, graph data){
		
		long[] ans1 = new long[data.size];
		int n = data.n,size = data.size;
		int i1,i2;
		long temp;
		
		for(int i=0;i<n;i++)
		{
			i1 = i/64;
			i2 = 63 - i%64;
			temp = ans[0] & data.col[0][i];
			
			for(int j=1;j<size && temp==0;j++)
			{
				temp = ans[j] & data.col[j][i];
			}
			
			if(temp!=0)
			{
				ans1[i1] = ans1[i1] | (1L<<i2);
			}
		}
		
		for(int i=0;i<size;i++)
			ans[i] = ans1[i];
	}
	
	public static void copy_row(int x, graph data, long[] ans){
		
		for(int i=0;i<data.size;i++)
			ans[i] = data.row[x][i];
		
	}
	
	public static void copy_data(graph push, graph pop){
		
		int n = pop.n;
		int size = pop.size;
		
		push.n = n;
		push.size = size;
		
		for(int i=0;i<n;i++)
		{	
			for(int j=0;j<size;j++)
				push.row[i][j] = pop.row[i][j];
		}
		
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<n;j++)
				push.col[i][j] = pop.col[i][j];
		}
	}
	
	// Complexity of this code is O(n^3/64)
	public static graph do_mutiply(graph g1, graph g2){
		
		graph result = new graph(g1.n,g1.size);
		int n = g1.n,size = g1.size,i1,i2;
		long temp;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				temp = g1.row[i][0] & g2.col[0][j];
				
				for(int k=1;k<size && temp==0;k++)
				{
					temp = temp | (g1.row[i][k] & g2.col[k][j]);
				}
				
				if(temp!=0)
				{
					i1 = j/64;
					i2 = 63 - j%64;
					result.row[i][i1] = result.row[i][i1] | (1L<<i2);
					
					i1 = i/64;
					i2 = 63 - i%64;
					result.col[i1][j] = result.col[i1][j] | (1L<<i2);
				}
			}
		}
		
		return result;
	}
	
	static class graph{
		
		int n,size;
		long[][] row;
		long[][] col;
		
		public graph(int n, int size){
			
			this.n = n;
			this.size = size;
			row = new long[n][size];
			col = new long[size][n];
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
