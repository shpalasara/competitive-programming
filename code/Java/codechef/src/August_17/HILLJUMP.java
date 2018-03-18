package August_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class HILLJUMP {

	static long[] data;
	static long[] m_data;
	static int[][] stack_index;
	static int[] size;
	static int nsqrt, n, k,block;
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		n = sc.nextInt();
		int q = sc.nextInt();
		
		nsqrt = Math.max(100 , (int)Math.ceil(Math.sqrt(n)));
		
		block = (int)Math.ceil((double)n/nsqrt);
		//System.out.println(block);
		data = new long[n+1];
		m_data = new long[block+1];				// Stores the value added/subtracted in that interval
		
		stack_index = new int[block+1][nsqrt+1];		// Stores the continues increasing sequence
		size = new int[block+1];							// Stores the size of that increasing subsequence
		
		for(int i=0;i<n;i++)
			data[i] = (long)sc.nextInt();
		
		for(int i=0;i<block;i++)
			generateSequence( i );
		
		int type,index,L,R;
		long X;
		
		for(int i=0;i<q;i++)
		{
			type = sc.nextInt();
			
			if(type==1)
			{
				index = sc.nextInt()-1;
				k = sc.nextInt();
				out.println(query_1( index )+1);
			}
			else
			{
				L = sc.nextInt()-1;
				R = sc.nextInt()-1;
				X = (long)sc.nextInt();
				query_2(L, R, X);
			}
		}
		
		out.close();
	}
	
	// ( Starting index , Number of jumps he can make )
	public static int query_1( int index) {
		
		int s_seg = index/nsqrt +1;
		
		int start = index+1;
		int end = Math.min(n, s_seg*nsqrt);
		
		for(int i=start;i<end;i++)
		{
			if((i-index)>100 || k==0)
				return index;
			if(data[index]<data[i])
			{
				k--;
				index = i;
			}
		}
		
		return BinarySearch( index , s_seg );
	}
	
	public static int BinarySearch( int pre_index , int seg ) {
		
		if(seg>=block || k==0)
			return pre_index;
		
		long prev_data;
		int index;
		
		for(int i=seg; i<block; i++)
		{
			prev_data = data[pre_index] + m_data[pre_index/nsqrt];
			index = BinarySearch_Seg( prev_data , i );
			if(index==-1 || (stack_index[i][index] - pre_index) >100)
				return pre_index;
			else
			{
				if(k > (size[i]-index))
				{
					k -= (size[i]-index);
					pre_index = stack_index[i][size[i]-1];
				}
				else
					return stack_index[i][index+k-1];
			}
		}
		return pre_index;
	}
	
	public static int BinarySearch_Seg( long value , int seg ) {
		
		int l = 0;
		int r = size[seg]-1;
		int mid = (l+r)>>1;
		
		if((data[stack_index[seg][l]] + m_data[seg]) > value)
			return l;
		if((data[stack_index[seg][r]] + m_data[seg]) <= value)
			return -1;
		
		while(l<r)
		{
			if((mid-1)>=0 &&  (data[stack_index[seg][mid]] + m_data[seg]) > value && (data[stack_index[seg][mid-1]] + m_data[seg]) <= value)
				return mid;
			if((mid+1)<size[seg] &&  (data[stack_index[seg][mid+1]] + m_data[seg]) > value && (data[stack_index[seg][mid]] + m_data[seg]) <= value)
				return mid+1;
			
			if((data[stack_index[seg][mid]] + m_data[seg]) > value )
				r = mid-1;
			else
				l = mid+1;
			mid = (l+r)>>1;
		}
		
		return -1;
	}
	
	public static void query_2( int L , int R , long X ) {
		
		int s_seg = L/nsqrt;
		int e_seg = R/nsqrt;
		
		if(s_seg==e_seg)
		{
			for(int i=L;i<=R;i++)
				data[i] += X;
			generateSequence( s_seg );
			return;
		}
		
		int start = L;							// Modifies the starting segment
		int end = Math.min( n , (s_seg+1)*nsqrt);
		for(int i=start;i<end;i++)				
			data[i] += X;
		generateSequence( s_seg );
		
		
		for(int i = s_seg+1;i<e_seg;i++)		// Modifies the middle segments
			m_data[i] += X;
		
		
		start = e_seg*nsqrt;					// Modifies the ending segment
		end = R+1;
		for(int i=start;i<end;i++)
			data[i] += X;
		generateSequence( e_seg );
		
		return;
	}
	
	// ( Segement Number , size of the array)
	public static void generateSequence(int seg){
		
		int index = 0;
		int start = seg*nsqrt;
		int end = Math.min((seg+1)*nsqrt, n);
		
		stack_index[seg][index++] = start;
		
		for(int i=start+1;i<end;i++)
		{
			if((i-stack_index[seg][index-1])>100)
				break;
			
			if(data[i]>data[stack_index[seg][index-1]])
				stack_index[seg][index++] = i;
		}
		size[seg] = index;
		
		return;
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

//103 10
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 3 4
//1 1 1