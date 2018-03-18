package June_16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class CHSQARR {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n=sc.nextInt(),m=sc.nextInt(),q,a,b;
		int[][] data = new int[n+1][m+1];
		int ans,t1,i,j,elements;
		
		// Scanning the matrix
		
		for(i=0;i<n;i++)
			for(j=0;j<m;j++)
				data[i][j]=sc.nextInt();
		
		int[][] temp;
		int[][] final_sum;
		int[][] max;
		
		//ArrayList<Integer> list = new ArrayList<Integer>(); 
		doubly_queue list = new doubly_queue();
		
		q=sc.nextInt();
		
		while(q-->0)
		{
			a=sc.nextInt();
			b=sc.nextInt();
			
			if(a==1 && b==1)
				ans=0;
			else
			{
				ans = Integer.MAX_VALUE;
				
				temp = new int[n+1][m+1];
				final_sum = new int[n+1][m+1];
				max = new int[n+1][m+1];
				
				// Making an array which stores the sum value of the row having length b
				
				for(i=0;i<n;i++)
				{
					t1 = 0;
					for(j=0;j<b;j++)
						t1 += data[i][j];
					
					temp[i][b-1] = t1; 
				}
				
				for(i=0;i<n;i++)
				{
					for(j=b;j<m;j++)
						temp[i][j] = data[i][j]+temp[i][j-1]-data[i][j-b];
				}
				
//				for(i=0;i<n;i++)
//				{
//					for(j=0;j<m;j++)
//						System.out.print(temp[i][j]+" ");
//					System.out.println();
//				}
				
				// Over
				
				
				
				// Making an array which stores the total sum of the sub-matrix
				
				for(j=b-1;j<m;j++)
				{
					t1=0;
					for(i=0;i<a;i++)
						t1 +=temp[i][j];
					
					final_sum[a-1][j] = t1;
				}
				
				for(i=a;i<n;i++)
				{
					for(j=b-1;j<m;j++)
						final_sum[i][j] = temp[i][j]+final_sum[i-1][j]-temp[i-a][j];
				}
				
//				for(i=0;i<n;i++)
//				{
//					for(j=0;j<m;j++)
//						System.out.print(final_sum[i][j]+" ");
//					System.out.println();
//				}
				
				// Over
				
				temp = new int[n][m];
				
				// Finding the max from every row having length b
				
				for(i=0;i<n;i++)
				{
					//list.clear();
					list.reset();
					
					for(j=0;j<b;j++)
					{
//						while((!list.isEmpty()) && data[i][j]>= data[i][list.get(list.size()-1)])
//							list.remove(list.size()-1);
//						
//						list.add(j);
						
						while((!list.isEmpty()) && data[i][j]>= data[i][list.get_back()])
							list.pop_back();
						
						list.push_back(j);
					}
					
					for(;j<m;j++)
					{
//						temp[i][j-1] = data[i][list.get(0)];
//						
//						while((!list.isEmpty()) && list.get(0)<=j-b)
//							list.remove(0);
//						
//						while((!list.isEmpty()) && data[i][j]>= data[i][list.get(list.size()-1)])
//							list.remove(list.size()-1);
//						
//						list.add(j);
						
						temp[i][j-1] = data[i][list.get_front()];
						
						while((!list.isEmpty()) && list.get_front()<=j-b)
							list.pop_front();
						
						while((!list.isEmpty()) && data[i][j]>= data[i][list.get_back()])
							list.pop_back();
						
						list.push_back(j);
					}
					
					//temp[i][m-1] = data[i][list.get(0)];
					
					temp[i][m-1] = data[i][list.get_front()];
				}
				
//				for(i=0;i<n;i++)
//				{
//					for(j=0;j<m;j++)
//						System.out.print(temp[i][j]+" ");
//					System.out.println();
//				}
				
				
				for(j=b-1;j<m;j++)
				{
					//list.clear();
					list.reset();
					
					for(i=0;i<a;i++)
					{
//						while((!list.isEmpty()) && temp[i][j]>= temp[list.get(list.size()-1)][j])
//							list.remove(list.size()-1);
//						
//						list.add(i);
						
						while((!list.isEmpty()) && temp[i][j]>= temp[list.get_back()][j])
							list.pop_back();
						
						list.push_back(i);
					}
					
					for(;i<n;i++)
					{
//						max[i-1][j] = temp[list.get(0)][j];
//						
//						while((!list.isEmpty()) && list.get(0)<=i-a)
//							list.remove(0);
//						
//						while((!list.isEmpty()) && temp[i][j]>= temp[list.get(list.size()-1)][j])
//							list.remove(list.size()-1);
//						
//						list.add(i);
						
						max[i-1][j] = temp[list.get_front()][j];
						
						while((!list.isEmpty()) && list.get_front()<=i-a)
							list.pop_front();
						
						while((!list.isEmpty()) && temp[i][j]>= temp[list.get_back()][j])
							list.pop_back();
						
						list.push_back(i);
					}
					
					//max[n-1][j] = temp[list.get(0)][j];
					max[n-1][j] = temp[list.get_front()][j];
					
				}
				
//				for(i=0;i<n;i++)
//				{
//					for(j=0;j<m;j++)
//						System.out.print(max[i][j]+" ");
//					System.out.println();
//				}
				
				// Over 
				
				elements = a*b;
				
				for(i=a-1;i<n;i++)
				{
					for(j=b-1;j<m;j++)
						ans = Math.min(ans, (max[i][j]*elements)-final_sum[i][j]);
				}
			}
			out.println(ans);
		}
		
		out.close();
	}
	
	public static class doubly_queue {
		
		public int[] data;
		public int s_i,e_i,size;

		public void reset(){
			
			data = new int[1001];
			s_i=0;
			e_i=0;
			size=0;
		}
		
		public boolean isEmpty(){
			
			if(size<=0)
				return true;
			return false;
		}
		
		public void push_back(int element){
			
			data[e_i++]=element;
			size++;
			e_i = e_i%1001;
		}
		
		public int pop_back(){
			
			e_i--;
			if(e_i<0)
				e_i+=1001;
			size--;
			
			return data[e_i];
		}
		
		public int get_back(){
			
			return data[e_i-1];
		}
		
		public int pop_front(){
			
			int index = s_i;
			s_i = (s_i+1)%1001;
			size--;
			
			return data[index];
		}
		
		public int get_front(){
			
			return data[s_i];
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
