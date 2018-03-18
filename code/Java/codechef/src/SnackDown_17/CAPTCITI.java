package SnackDown_17;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class CAPTCITI {

//	static queue list = new queue();
	static Queue<pair> list = new LinkedList<>();
	
	public static void main(String[] args){
	
		FasterScanner sc = new FasterScanner();
		int t = sc.nextInt(),n,m,index;
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			int[][] data = new int[n*m][3];
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					index = i*m + j;
					data[index][0] = sc.nextInt();
					data[index][1] = i;
					data[index][2] = j;
				}
			}
			
			java.util.Arrays.sort(data, new java.util.Comparator<int[]>() {
			
				  public int compare(int[] a,int[] b) {
				    return (a[0] < b[0] ? -1 : 1);
				  }
			});
			
			if(data[0][0]==data[n*m - 1][0])
				System.out.println("0");
			else
			{
//				list.reset();
				list.clear();
				index = n*m - 1;
				pair t1 = new pair();
				boolean[][] check = new boolean[n+1][m+1];
				
				t1.x = data[index][1];
				t1.y = data[index][2];
				t1.count = 0;
				check[t1.x][t1.y] = true;
				list.add(t1);
				
				while(index>0 && data[index-1][0]==data[index][0]){
					
					index--;
					t1 = new pair();
					t1.x = data[index][1];
					t1.y = data[index][2];
					t1.count = 0;
					check[t1.x][t1.y] = true;
					list.add(t1);
				}
				
				System.out.println(BFS(n,m,check));
				
			}
		}
	}
	
	public static int BFS(int n,int m, boolean[][] check){
		
		int i,j,ans=0;
		pair t1,t2;
		
		while(!list.isEmpty())
		{
			t1 = list.poll();
			i = t1.x;
			j = t1.y;
			ans = t1.count;
//			System.out.println(i+" "+j);
			
			if(i>0 && !check[i-1][j])
			{
				t2 = new pair();
				t2.x = i-1;
				t2.y = j;
				t2.count = ans+1;
				check[t2.x][t2.y] = true;
				list.add(t2);
			}
			if(j>0 && !check[i][j-1])
			{
				t2 = new pair();
				t2.x = i;
				t2.y = j-1;
				t2.count = ans+1;
				check[t2.x][t2.y] = true;
				list.add(t2);
			}
			if(i>0 && j>0 && !check[i-1][j-1])
			{
				t2 = new pair();
				t2.x = i-1;
				t2.y = j-1;
				t2.count = ans+1;
				check[t2.x][t2.y] = true;
				list.add(t2);
			}
			if((i+1)<n && !check[i+1][j])
			{
				t2 = new pair();
				t2.x = i+1;
				t2.y = j;
				t2.count = ans+1;
				check[t2.x][t2.y] = true;
				list.add(t2);
			}
			if((j+1)<m && !check[i][j+1])
			{
				t2 = new pair();
				t2.x = i;
				t2.y = j+1;
				t2.count = ans+1;
				check[t2.x][t2.y] = true;
				list.add(t2);
			}
			if((i+1)<n && (j+1)<m && !check[i+1][j+1])
			{
				t2 = new pair();
				t2.x = i+1;
				t2.y = j+1;
				t2.count = ans+1;
				check[t2.x][t2.y] = true;
				list.add(t2);
			}
			if((i+1)<n && j>0 && !check[i+1][j-1])
			{
				t2 = new pair();
				t2.x = i+1;
				t2.y = j-1;
				t2.count = ans+1;
				check[t2.x][t2.y] = true;
				list.add(t2);
			}
			if(i>0 && (j+1)<m && !check[i-1][j+1])
			{
				t2 = new pair();
				t2.x = i-1;
				t2.y = j+1;
				t2.count = ans+1;
				check[t2.x][t2.y] = true;
				list.add(t2);
			}
		}
		
		return ans;
	}
	
//	static class queue {
//		
//		public pair[] data;
//		public int s_i,e_i,size;
//		public static int Def_size = 250001;
//		
//		public queue(){
//
//			data = new pair[Def_size];
//			for(int i=0;i<Def_size;i++)
//				data[i] = new pair();
//		}
//		
//		public void reset(){
//			
//			s_i=0;
//			e_i=0;
//			size=0;
//		}
//		
//		public boolean isEmpty(){
//			
//			if(size<=0)
//				return true;
//			return false;
//		}
//		
//		public void add(pair element){
//			
//			data[e_i++]= element;
//			size++;
//			e_i = e_i%Def_size;
//		}
//		
//		public pair pop_back(){
//			
//			e_i--;
//			if(e_i<0)
//				e_i+=Def_size;
//			size--;
//			return data[e_i];
//		}
//		
//		public pair get_back(){
//			
//			return data[e_i-1];
//		}
//		
//		public pair poll(){
//			
//			int index = s_i;
//			s_i = (s_i+1)%Def_size;
//			size--;
//			if(size == 0)
//				e_i = s_i;
//			return data[index];
//		}
//		
//		public pair get_front(){
//			
//			return data[s_i];
//		}
//	}
//	
	static class pair{
		
		int x,y,count;
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
