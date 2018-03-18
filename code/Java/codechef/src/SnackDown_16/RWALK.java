package SnackDown_16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class RWALK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt(),n,length1,length2,size,sum1,sum2,i1,i2;
		boolean temp;
		
		while(t-->0)
		{
			sum1=0;						// For vertical
			sum2=0;						// For Horizontal
			temp = true;
			i1=0;i2=0;
			
			n=sc.nextInt();
			
			length1 = (n/2)+1;
			length2 = (n+1)/2;
			
			int[] vert = new int[length1];
			int[] hori = new int[length2];
			int[] s_vert = new int[length1];
			int[] s_hori = new int[length2];
			
			//size = str.length;
			size = 2*n+1;
			
			for(int i=0;i<size;i++)
			{
				String s = sc.nextString();
				
				if(!(s.equals("L") || s.equals("R")))
				{
					if(temp)
					{
						vert[i1] = Integer.parseInt(s);
						sum1+=vert[i1];
						s_vert[i1++] = sum1;
					}
					else
					{
						hori[i2] = Integer.parseInt(s);
						sum2+=hori[i2];
						s_hori[i2++] = sum2;
					}
					temp=!temp;
				}
			}

			if(n==1 || n==2)
				out.println("NO");
			else
				out.println(solve(vert,s_vert,sum1,length1)+solve(hori,s_hori,sum2,length2));
		}
		
		out.close();
	}
	
	public static int solve(int[] data,int[] pre_sum,int sum,int length)
	{
		boolean[][] dp = new boolean[sum+1][2];
		int diff = sum;
		
		dp[0][0] = true;
        
		for (int i=0; i<length; i++)
	    {		
			for(int j=0;j<=pre_sum[i] && j<=sum/2;j++)
				dp[j][1] = false;
			
	        for (int j=0; j<=pre_sum[i] && j<=sum/2; j++)
	        {
	            dp[j][1] |= dp[j][0];
	 
	            if (dp[j][0])
	                dp[j+data[i]][1] = true;
	        }
	        
	        for(int j=0;j<=pre_sum[i] && j<=sum/2;j++)
	        	dp[j][0] = dp[j][1];
	    }
		
		for (int j=sum/2; j>=0; j--)
	    {
	        if (dp[j][0])
	        {
	            diff = sum-2*j;
	            break;
	        }
	    }
		
		return diff;
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
/*
for(int i=1;i<=sum1;i++)
					dp1[i][0] = false;
				dp1[0][0] = true;
			        
				for (int i=0; i<length1; i++)
			    {		
					for(int j=0;j<=s_vert[i] && j<=sum1/2;j++)
						dp1[j][1] = false;
					
			        for (int j=0; j<=s_vert[i] && j<=sum1/2; j++)
			        {
			            dp1[j][1] |= dp1[j][0];
			 
			            if (dp1[j][0])
			                dp1[j+vert[i]][1] = true;
			        }
			        
			        for(int j=0;j<=s_vert[i] && j<=sum1/2;j++)
			        	dp1[j][0] = dp1[j][1];
			    }
				
//				for(int i=0;i<=sum1;i++)
//					System.out.print(dp1[i][0]+" ");
//				System.out.println();
				
				diff1 = sum1;
				
				for (int j=sum1/2; j>=0; j--)
			    {
			        if (dp1[j][0])
			        {
			            diff1 = sum1-2*j;
			            break;
			        }
			    }
				
				
				// For horizontal
				
				for(int i=1;i<=sum2;i++)
					dp1[i][0] = false;
				dp1[0][0] = true;
			        
				for (int i=0; i<length2; i++)
			    {	
					for(int j=0;j<=s_vert[i] && j<=sum2/2;j++)
						dp1[j][1] = false;
					
			        for (int j=0; j<=s_hori[i] && j<=sum2/2; j++)
			        {
			            dp1[j][1] |= dp1[j][0];
			 
			            if (dp1[j][0])
			                dp1[j+hori[i]][1] = true;
			        }
			        
			        for(int j=0;j<=s_hori[i] && j<=sum2/2;j++)
			        	dp1[j][0] = dp1[j][1];
			    }
				
				diff2 = sum2;
				
				for (int j=sum2/2; j>=0; j--)
			    {
			        if (dp1[j][0])
			        {
			            diff2 = sum2-2*j;
			            break;
			        }
			    }
*/
