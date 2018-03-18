package February_17;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class INTERVAL {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t,n,m;
		t = sc.nextInt();
	
		doubly_queue Qi = new doubly_queue();
//		ArrayList<Long> list = new ArrayList<Long>();
		long[] list = new long[300001];
		int count;
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			long[] data = new long[n+1];						// Sequence A
			long[] pre_sum = new long[n+1];
			pre_sum[0] = 0;
			
			for(int i=0;i<n;i++)
			{
				data[i] = sc.nextInt();
				pre_sum[i+1] = pre_sum[i] + data[i];
			}
			
			int[] interval_length = new int[m+1];				// Sequence B
			
			for(int i=0;i<m;i++)
				interval_length[i] = sc.nextInt();
			
			long[] dp = new long[n+1];
			
			int length = interval_length[m-1];
			
			if(m%2==0)
				for(int i=0;i<(n-length+1);i++)
					dp[i] = -(pre_sum[i+length] - pre_sum[i]);
			else
				for(int i=0;i<(n-length+1);i++)
					dp[i] = pre_sum[i+length] - pre_sum[i];
			
			long[] temp = new long[n+1];
			
			for(int i=m-1;i>0;i--)
			{
				int k_i_ = interval_length[i];
				int k_i = interval_length[i-1];
				
				// Apply for the current player (Score he should choose)
				for(int j=0;j<(n-k_i+1);j++)
					temp[j] = pre_sum[j+k_i] - pre_sum[j];
				
//				list.clear();
				count = 0;
				Qi.reset();
				int k = k_i-1-k_i_,j;
				
				if((i+1)%2==0)
				{
					// Need to minimize the sum (chefu's term)
					for (j = 0; j < k; j++)
				    {
				        while ( (!Qi.isEmpty()) && dp[j] <= dp[Qi.get_back()])
				            Qi.pop_back(); 
				        Qi.push_back(j);
				    }
				    for ( ; j < (n-k_i_+1); j++)
				    {
//				    	list.add(dp[Qi.get_front()]);
				    	list[count++] = dp[Qi.get_front()];
				        while ( (!Qi.isEmpty()) && Qi.get_front() <= j - k)
				            Qi.pop_front();  
				        while ( (!Qi.isEmpty()) && dp[j] <= dp[Qi.get_back()])
				            Qi.pop_back();
				        Qi.push_back(j);
				    }
//					list.add(dp[Qi.get_front()]);
					list[count++] = dp[Qi.get_front()];
					
					for(j=0;j<(n-k_i+1);j++)
					{
						dp[j] = temp[j] + list[j+1];		//list.get(j+1);
						temp[j] = 0;
					}
				}
				else
				{
					for (j = 0; j < k; j++)
				    {
				        while ( (!Qi.isEmpty()) && dp[j] >= dp[Qi.get_back()])
				            Qi.pop_back();  
				        Qi.push_back(j);
				    }
				    for ( ; j < (n-k_i_+1); j++)
				    {
//				    	list.add(dp[Qi.get_front()]);
				    	list[count++] = dp[Qi.get_front()];
				        while ( (!Qi.isEmpty()) && Qi.get_front() <= j - k)
				            Qi.pop_front();  
				        while ( (!Qi.isEmpty()) && dp[j] >= dp[Qi.get_back()])
				            Qi.pop_back();
				        Qi.push_back(j);
				    }
//					list.add(dp[Qi.get_front()]);
				    list[count++] = dp[Qi.get_front()];
					
					for(j=0;j<(n-k_i+1);j++)
					{
						dp[j] = -temp[j] + list[j+1];		//list.get(j+1) ;
						temp[j] = 0;
//						list[j] = 0;
					}
				}
				for(;j<n;j++)
				{
					dp[j] = 0;
					temp[j] = 0;
//					list[j] = 0;
				}
			}
			
			long output = dp[0];
			
			for(int i=1;i<n;i++)
				output = Math.max(output, dp[i]);
			
			out.println(output);
		}
		
		out.close();
	}

	static class doubly_queue {

		public int s_i,e_i,size;
		public static int Def_size = 300001;
		private int[] data = new int[Def_size];

		public void reset(){
			
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
			e_i = e_i%Def_size;
		}
		
		public int pop_back(){
			
			e_i--;
			if(e_i<0)
				e_i+=Def_size;
			size--;
			if(size==0)
				s_i = e_i;
			return data[e_i];
		}
		
		public int get_back(){
			
			return data[e_i-1];
		}
		
		public int pop_front(){
			
			int index = s_i;
			s_i = (s_i+1)%Def_size;
			size--;
			if(size == 0)
				e_i = s_i;
			return data[index];
		}
		
		public int get_front(){
			
			return data[s_i];
		}
		
//		private List<Integer> deque = new ArrayList<Integer>();
//
//		private void reset(){
//			
//			deque.clear();
//		}
//		
//		private boolean isEmpty(){
//			
//			return deque.isEmpty();
//		}
//		
//		private void puch_front(int element){
//			
//			deque.add(0,element);
//		}
//		
//		private void push_back(int element){
//			
//			deque.add(element);
//		}
//		
//		private int pop_back(){
//			
//			return deque.remove(deque.size()-1);
//		}
//		
//		public int get_back(){
//			
//			return deque.get(deque.size()-1);
//		}
//		
//		public int pop_front(){
//			
//			return deque.remove(0);
//		}
//		
//		public int get_front(){
//			
//			return deque.get(0);
//		}
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
