package June_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class CLONEME {
	
	static int size = 10001;
	static int bit_width = 63;
	static int bit_length = (size/bit_width) + 1;
	
	static long[][] bit_map_1 = new long[size][bit_length];
	static long[][] bit_map_2 = new long[size][bit_length];
	
	static long[][] bit_sum_1 = new long[size][bit_length];
	static long[][] bit_sum_2 = new long[size][bit_length];
	
	static int[] data = new int[size];
	static long[] temp_map = new long[bit_length];
	static long[] temp_sum = new long[bit_length];
	
	public static void main(String[] args) {
		
		FasterScanner sc =  new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt(),n,q,a,b,c,d;
		int max,temp_bit_length,nsqrt;
	
		while(t-->0)
		{	
			n = sc.nextInt();
			q = sc.nextInt();
			
			nsqrt = (int)Math.sqrt(n);
			max = 0;
			
			for(int i=0;i<n;i++)
			{
				data[i] = sc.nextInt();
				max = Math.max(max, data[i]);
			}
			
			temp_bit_length = max/bit_width +1;
			
			int[][] d_range = new int[2*q][5];
			
			for(int i=0;i<q;i++)
			{
				a = sc.nextInt()-1;
				b = sc.nextInt()-1;
				c = sc.nextInt()-1;
				d = sc.nextInt()-1;
				
				d_range[2*i][0] = a;
				d_range[2*i][1] = b;
				d_range[2*i][2] = a/nsqrt;
				d_range[2*i][3] = i;
				d_range[2*i][4] = 1;
				
				d_range[2*i+1][0] = c;
				d_range[2*i+1][1] = d;
				d_range[2*i+1][2] = c/nsqrt;
				d_range[2*i+1][3] = i;
				d_range[2*i+1][4] = 2;
			}
			
			java.util.Arrays.sort(d_range, new java.util.Comparator<int[]>() {
				  public int compare(int[] a,int[] b) { 
					
				    return (a[2] < b[2] ? -1 : (a[2] == b[2] ? (a[1] < b[1] ? -1 : 1) : 1));
				  }
			});
			
//			int prev_start=-1,prev_end=-1,new_start,new_end;
			int index,set;
			
			int left=0,right=-1;
			
			for(int i=0;i<2*q;i++)
			{
//				new_start = d_range[i][0];
//				new_end = d_range[i][1];
//				
//				if(prev_start==-1)
//				{
//					for(int j=new_start;j<=new_end;j++)
//						add_remove_bit(temp_map, data[j]);
//				}
//				else
//				{
//					if(new_start>prev_start)
//					{
//						while(prev_start<new_start)
//							add_remove_bit(temp_map, data[prev_start++]);
//					}
//					if(new_end>prev_end)
//					{
//						while(prev_end<new_end)
//							add_remove_bit(temp_map, data[prev_end++]);
//					}
//					else if(new_end<prev_end)
//					{
//						while(prev_end>new_end)
//							add_remove_bit(temp_map, data[prev_end--]);
//					}
//				}
//				
				index = d_range[i][3];
				set = d_range[i][4];
				
				while (left < d_range[i][0])  remove_bit(temp_map , temp_sum , data[left++]);
				while (left > d_range[i][0])  add_bit(temp_map , temp_sum , data[--left]);
				while (right < d_range[i][1]) add_bit(temp_map , temp_sum , data[++right]);
				while (right > d_range[i][1]) remove_bit(temp_map , temp_sum , data[right--]);
				
				if(set==1)
				{
					for(int j=0;j<temp_bit_length;j++)
					{
						bit_map_1[index][j] = temp_map[j];
						bit_sum_1[index][j] = temp_sum[j];
					}
				}
				else
				{
					for(int j=0;j<temp_bit_length;j++)
					{
						bit_map_2[index][j] = temp_map[j];
						bit_sum_2[index][j] = temp_sum[j];
					}
				}
//				prev_start = new_start;
//				prev_end = new_end;
			}
			
			for(int i=0;i<temp_bit_length;i++)
			{
				temp_map[i] = 0L;
				temp_sum[i] = 0L;
			}
			
			long xor,and,temp_xor,abs_diff,sum;
			int count;
			boolean[] ans = new boolean[q+1];
			boolean no, prev_xor=false;
			
			for(int i=0;i<q;i++)
			{
				xor = 0;
				and = 0;
				count = 0;
				no = false;
				
				for(int j=0;j<temp_bit_length;j++)
				{
					temp_xor = bit_map_1[i][j] ^ bit_map_2[i][j];
					and = bit_map_1[i][j] & bit_map_2[i][j];
					
					abs_diff = Math.abs(bit_sum_1[i][j] - bit_sum_2[i][j]);
					sum = bit_sum_1[i][j] + bit_sum_2[i][j];
					
					if(abs_diff==0L && temp_xor==0L)
						continue;
					else if(abs_diff!=0L && temp_xor!=0L)
					{
						String[] x = get_value (j , temp_xor , and , prev_xor).split(" ");
						
						if(x.length>1)
						{
							long value_xor = Long.parseLong(x[0]);
							long value_and = Long.parseLong(x[1]);
							prev_xor = Boolean.parseBoolean(x[2]);
							
							sum -= ( 2L*value_and + value_xor ); 
							
							if(sum!=0L)
							{
								if(!funt ( j, temp_xor , abs_diff))
								{		
									no = true;
//									out.println("stage 1");
									break;
								}
							}
						}
						else
						{
							no = true;
//							out.println("stage 2");
							break;
						}
						
						
//						if(temp_xor!=0)
//						{
//							if(and > temp_xor)
//							{
//								temp_xor = 0L;
//								count+=2;
//								check = false;
//							}
//							else
//								check = true;
//						}
//						else if(check && and != 0L)
//							count+=2;
//						
						and = temp_xor & xor;
						
						while(and!=0)
						{
							if( (and & 1L) != 0L)
								count+=2;
							and = and>>1;
						}
						xor ^= temp_xor;
					}
					else
					{
						no = true;
//						out.println("stage 3");
						break;
					}
					
					bit_map_1[i][j] = 0L;
					bit_map_2[i][j] = 0L;
					bit_sum_1[i][j] = 0L;
					bit_sum_2[i][j] = 0L;
				}
				
				if(!no)
				{
					while(xor!=0)
					{
						if( (xor & 1L)!=0)
							count++;
						xor = xor>>1;
					}
					
					if(count<=2)
						ans[i] = true;
					
//					out.println(count);
				}
			}
			
			for(int i=0;i<q;i++)
			{
				if(ans[i])
					out.println("YES");
				else
					out.println("NO");
			}
		}
		
		out.close();
	}
	
	public static boolean funt ( int index, long xor , long abs_diff){
		
		long temp = bit_width*index , mul = 1L , sum = 0;
		int count = 0, number = 0;
		
		while( xor !=0 )
		{
			if( (xor & 1L) !=0)
			{
				sum += (mul) * (temp + count);
				mul*= (-1L);
				number++;
			}
			count++;
			xor = xor>>1;
		}
		
		if(number==2 && abs_diff-Math.abs(sum)==0)
			return true;
		
		return false;
	}
	
	public static String get_value (int index , long bit_map_xor , long bit_map_and , boolean xor){
		
		long ans_xor = 0L , ans_and = 0L;
		long temp = bit_width*index;
		int count = 0;
		boolean and=false;
		
		while(bit_map_xor!=0 || bit_map_and!=0)
		{
			if(( bit_map_xor & 1L ) !=0)
			{
				ans_xor += (temp + count);
				xor = !xor;
			}
			
			if(( bit_map_and & 1L ) !=0)
			{
				ans_and += (temp + count);
				if(xor)
					and = true;
			}
			
			bit_map_xor = bit_map_xor >> 1;
			bit_map_and = bit_map_and >> 1;
			count++;
		}
		
		String ans;
		
		if(and)
			ans = "1";
		else
			ans = ans_xor +" "+ ans_and +" "+xor;
		
		return ans;
	}
	
	public static int add_bit(long[] bit_map, long[] bit_sum , int data){
		
		int index,bit;
		long xor;
		index = data/bit_width;
		bit = data%bit_width;
		xor = 1L<<bit;
		bit_map[index] = bit_map[index]^xor;
		bit_sum[index] += data;
		
		return 0;
	}
	
	public static int remove_bit(long[] bit_map, long[] bit_sum, int data){
		
		int index,bit;
		long xor;
		index = data/bit_width;
		bit = data%bit_width;
		xor = 1L<<bit;
		bit_map[index] = bit_map[index]^xor;
		bit_sum[index] -= data;
		
		return 0;
	}
	
	static class FasterScanner {

        private byte[] buf = new byte[1024];
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
