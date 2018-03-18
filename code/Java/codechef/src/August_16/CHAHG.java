package August_16;

// Accepted

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class CHAHG {

	/**
	 * @param args
	 */
	public static long max = (long)(1e9+1);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt(),n,count;
		
		while(t-->0)
		{
			n = sc.nextInt();
			int[][] data = new int[n][2];
			
			for(int i=0;i<n;i++)
			{
				data[i][0] = sc.nextInt();
				data[i][1] = sc.nextInt();
			}
			
			if(n==1)
			{
				out.println("1");
				out.println("0 Inf");
			}
			else
			{
				pair ans1 = new pair();
				pair ans2 = new pair();
				pair ans = new pair();
				
				for(int i=0;i<n-1;i++)
				{
					if((i%2)==0)
					{
						if((ans1.start+2L)!=0 || (ans1.end+2L)!=0)
							greater( data, i, i+1, ans1);
						
						if((ans2.start+2L)!=0 || (ans2.end+2L)!=0)
							greater( data, i+1, i,ans2);
					}
					else
					{
						if((ans1.start+2L)!=0 || (ans1.end+2L)!=0)
							greater( data, i+1, i, ans1);
						
						if((ans2.start+2L)!=0 || (ans2.end+2L)!=0)
							greater( data, i, i+1, ans2);
					}
				}
				
				count = 0;
				
				if((ans1.start+2L)!=0 && (ans1.end+2L)!=0)
					count++;
				if((ans2.start+2L)!=0 && (ans2.end+2L)!=0)
					count++;
				
				
				if(count==0)
					out.println(count);
				else if(count==1)
				{
					out.println(count);
					
					if((ans1.start+2L)!=0 && (ans1.end+2L)!=0)
					{
						if((ans1.end-max)==0)
							out.println(ans1.start+" "+"Inf");
						else
							out.println(ans1.start+" "+ans1.end);
					}
					
					if((ans2.start+2L)!=0 && (ans2.end+2L)!=0)
					{
						if((ans2.end-max)==0)
							out.println(ans2.start+" "+"Inf");
						else
							out.println(ans2.start+" "+ans2.end);
					}
				}
				else
				{
					if(ans1.start>ans2.start)
					{
						long t1,t2;
						t1 = ans1.start;
						t2 = ans1.end;
						ans1.start = ans2.start;
						ans1.end = ans2.end;
						ans2.start = t1;
						ans2.end = t2;
					}
					
					if((ans2.start-ans1.end)>1L)
					{
						out.println(count);
						
						if((ans1.end-max)==0)
							out.println(ans1.start+" "+"Inf");
						else
							out.println(ans1.start+" "+ans1.end);
						
						if((ans2.end-max)==0)
							out.println(ans2.start+" "+"Inf");
						else
							out.println(ans2.start+" "+ans2.end);
					}
					else
					{
						//out.println("here");
						
						out.println(1);
						
						ans.start = Math.min(ans1.start, ans2.start);
						ans.end = Math.max(ans1.end, ans2.end);
						
						if((ans.end-max)==0)
							out.println(ans.start+" "+"Inf");
						else
							out.println(ans.start+" "+ans.end);
					}
				}
			}
		}
		
		out.close();
	}
	
	public static void greater(int[][] data, int index1 , int index2 , pair temp){
		
		long start=-1,end=-1;
		int diff,rate;
		
		if(index2<data.length && index1<data.length)
		{
			if(data[index1][0]>data[index2][0])
			{
				if(data[index1][1]>=data[index2][1])
				{
					start = 0L;
					end = max;
				}
				else
				{
					diff = data[index1][0]-data[index2][0];
					rate = data[index2][1]-data[index1][1];
					
					start = 0L;
					end = (long)Math.ceil((double)diff/(double)rate) - 1L;
				}
			}
			else
			{
				if(data[index1][1]>data[index2][1])
				{
					diff = data[index2][0]-data[index1][0];
					rate = data[index1][1]-data[index2][1];
					
					start = (long)Math.ceil((double)diff/(double)rate);
					
					if((diff%rate)==0)
						start++;
					end = max;
				}
			}
		}
		
		if((start+1L)!=0 && (end+1L)!=0)
		{
			if((temp.start+1L)==0 || (temp.end+1L)==0)
			{
				temp.start = start;
				temp.end = end;
			}
			else
			{
				if((temp.end-start)<0L || (end-temp.start)<0L)
				{
					temp.start = -2L;
					temp.end = -2L;
				}
				else
				{
					temp.start = Math.max(temp.start, start);
					temp.end = Math.min(temp.end, end);
				}
			}
		}
		else
		{
			temp.start = -2L;
			temp.end = -2L;
		}
		
	}
	
	static class pair {
		
		long start;
		long end;
		
		public pair(){
			start = -1;
			end = -1;
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
