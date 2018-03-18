package August_16;

// Accepted

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class CHEFCRUN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out); 
		
		int t = sc.nextInt(),n,start,end;
		long ans;
		
		while(t-->0)
		{
			n = sc.nextInt();
			int[] data = new int[n];
			ans = Long.MAX_VALUE;
			
			for(int i=0;i<n;i++)
				data[i] = sc.nextInt();
			
			start = sc.nextInt();
			end = sc.nextInt();
			
			
			long[] forward = new long[n+1];
			long[] backword = new long[n+1];
			
			long[] forw_min = new long[n+1];
			long[] back_min = new long[n+1];
			
			//long forw_min=0,back_min=0;
			
			int i = start-1;
			boolean check = false;
			
			
			while(i!=(start-1) || !check)
			{
				forward[(i+1)%n] = forward[i] + (long)data[i];
				
				//if(((i+1)%n)>=start && ((i+1)%n)<end)
				forw_min[(i+1)%n] = Math.min(forw_min[i], forward[(i+1)%n]);
				
				i = (i+1)%n;
				check = true;
			}
			
			i = start-1;
			check = false;
			
			while(i!=(start-1) || !check)
			{	
				backword[i] = backword[(i+1)%n] + (long)data[(i-1+n)%n];
				
				//if(i<start || i>=end)
				back_min[i] = Math.min(back_min[(i+1)%n], backword[i]);
				
				i = (i-1+n)%n;
				check = true;
			}
			
			ans = Math.min(forward[(end-1+n)%n], backword[(end)%n]);
			
			//out.println(ans);
			
//			for(i=0;i<n;i++)
//				out.print(forward[i]+" ");
//			out.println();
//			
//			for(i=0;i<n;i++)
//				out.print(backword[i]+" ");
//			out.println();
//			
//			for(i=0;i<n;i++)
//				out.print(forw_min[i]+" ");
//			out.println();
//			
//			for(i=0;i<n;i++)
//				out.print(back_min[i]+" ");
//			out.println();
			
			int temp = 0;
			
			for(i=end-1;i>=start;i--)
			{
				ans = Math.min(ans, backword[end%n]+2*forw_min[i]+2*temp);
				temp+=data[(i-1+n)%n];
				//out.println("f "+ans+" "+i);
			}
			
			temp = 0;
			for(i=end%n;i!=start;i=(i+1)%n)
			{
				ans = Math.min(ans, forward[end-1]+2*back_min[i]+2*temp);
				temp+=data[(i-1+n)%n];
				//out.println("b "+ans+" "+i);
			}
			
			out.println(ans);
			
			
//
//			i = start;
//			check = false;
			
//			while(i!=(start-1+n)%n || !check)
//			{
//				if(i<end)
//				{
//					ans = Math.min(2L*forward[(i-1+n)%n]+backword[(end)%n], ans);
//					ans = Math.min(2L*backword[(i)%n]-backword[(end)%n], ans);
//				}
//				else if(i>end)
//				{
//					ans = Math.min(2L*forward[(i-1+n)%n]-forward[end-1], ans);
//					ans = Math.min(2L*backword[(i)%n]+forward[end-1], ans);
//				}
//				else
//				{
//					ans = Math.min(2L*forward[i]+backword[(end)%n], ans);
//					ans = Math.min(2L*backword[(i)%n]+forward[end], ans);
//				}
//				
//				out.println("? "+i+" "+end+" "+ans);
//				
//				if(i>=end)
//					ans = Math.min(2L*backword[(n+1+i)%n]-backword[(n+1+end)%n], ans);
//				else
//					ans = Math.min(2L*backword[(n+1+i)%n]+forward[end], ans);
				
//				out.println("! "+i+" "+end+" "+ans);
//				
//				i = (i+1)%n;
//				check = true;
//			}
			
//			out.println(ans);
		}
		
		out.close();
	}
	
	public static long function(int[] data,int start,int end,int n){
		
		long ans = Long.MAX_VALUE;
	
		long[] forward = new long[n+1];
		long[] backword = new long[n+1];
		
		long forw_min=0,back_min=0;
		
		int i = start-1;
		boolean check = false;
		
		//System.out.println("hi");
		
		while(i!=(start-1) || !check)
		{
			forward[(i+1)%n] = forward[i] + (long)data[i];
			
			if(start<end)
			{
				if(((i+1)%n)>=start && ((i+1)%n)<end)
					forw_min = Math.min(forw_min, forward[(i+1)%n]);
			}
			else
			{
				if(((i+1)%n)<end || ((i+1)%n)>=start)
					forw_min = Math.min(forw_min, forward[(i+1)%n]);
			}
		
			//System.out.println(i);
			i = (i+1)%n;
			check = true;
		}
		
		//System.out.println("forw_min "+forw_min);
		
		//System.out.println("hi1");
		
		i = start-1;
		check = false;
		
		while(i!=(start-1) || !check)
		{	
			backword[i] = backword[(i+1)%n] + (long)data[(i-1+n)%n];
			
			if(start<end)
			{
				if(i<start || i>=end)
					back_min = Math.min(back_min, backword[i]);
			}
			else
			{
				if(i>=end && i<start)
					back_min = Math.min(back_min, backword[i]);
			}
			
			i = (i-1+n)%n;
			check = true;
		}
		
//		System.out.println("back_min "+back_min);
//		
//		for(i=0;i<n;i++)
//			System.out.print(forward[i]+" ");
//		System.out.println();
//		
//		for(i=0;i<n;i++)
//			System.out.print(backword[i]+" ");
//		System.out.println();
		
		//System.out.println("hi2");
		
		ans = Math.min(forward[(end-1+n)%n], backword[(end)%n]);
		
		if(back_min!=Long.MAX_VALUE)
			ans = Math.min(ans, forward[(end-1+n)%n]+2*back_min);
		
		if(forw_min!=Long.MAX_VALUE)
			ans = Math.min(ans, backword[end%n]+2*forw_min);
		
		//System.out.println(ans);
		
		return ans;
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
