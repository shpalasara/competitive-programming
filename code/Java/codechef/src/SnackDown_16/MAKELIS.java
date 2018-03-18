package SnackDown_16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class MAKELIS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int[][] data = new int[100001][101];
		int[][] length = new int[100001][2];
		
		ArrayList<Integer> prime = new ArrayList<Integer>();
		boolean[] check = new boolean[100001];
		
		for(int i=2;i<100001;i++)
		{
			if(!check[i])
			{
				prime.add(i);

				for(int j=i+i;j<100001 && !check[i];j+=i)
					check[j]=true;
			}
		}
//		
//		System.out.println(prime);
		
		data[1][0] = 1;
		length[1][0] = 1;			// Indicates length of the answer
		length[1][1] = 1;			// Indicates the longest increasing sub-sequence length
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		//System.out.println("Hii");
		
		for(int i=2;i<100001;i++)
		{
			temp.clear();
			int index=0,te=i,sum=0;
			//boolean checker=false;
			//System.out.println(i);
			
			while(te!=1 && sum<=100)
			{
				if(te%prime.get(index)==0)
				{
					//if(checker)
					//	temp.set(temp.size()-1, temp.get(temp.size()-1)+prime.get(index));
					//else
						temp.add(prime.get(index));
					
					te = te/prime.get(index);
					sum+=prime.get(index);
					//checker=true;
				}
				else
				{
					//checker = false;
					index++;
				}
			}
			
			//System.out.println(i+" "+sum);
			
			if(sum<=100)
			{
				te=0;index=0;
				
				for(int j=0;j<temp.size();j++)
				{
					te += temp.get(j); 
					for(int k=index;k<temp.get(j)+index;k++)
					{
						data[i][k] = te-k+index;
					}
					index +=temp.get(j);
				}
				
				length[i][0] = sum;
				length[i][1] = temp.size();
			}
			else
			{
				int count=1;
				
				while(true && i>count)
				{
					int p,q=length[count][0];
					
					if(count==1 && length[i-count][0]+length[i-count][1]<=100)
					{
						for(p=0;p<length[i-count][1];p++)
							data[i][p] = p+length[i-count][0]+1;
						
						for(;p<length[i-count][0]+length[i-count][1];p++)
							data[i][p] = data[i-count][p-length[i-count][1]];
						
//						if(i<=101)
//						{
//							System.out.println(i);
//							
//						}
						
						length[i][0] = length[i-count][0]+length[i-count][1];
						length[i][1] = length[i-count][1];
						
						break;
					}
					else if(length[i-count][1]==length[count][1] && length[i-count][0]+length[count][0]<=100)
					{
						
						for(p=0;p<length[i-count][0];p++)
						{
							data[i][p] = data[i-count][p]+q;
						}
						
						for(;p<length[i-count][0]+length[count][0];p++)
						{
							data[i][p] = data[count][p-length[i-count][0]];
						}
						
						length[i][0] = length[i-count][0]+length[count][0];
						length[i][1] = length[i-count][1];
						
						break;
					}
					else
						count++;
				}
			}
		}
		
		int t=sc.nextInt(),n;
		//System.out.println("Hii");
		
		while(t-->0)
		{
			n=sc.nextInt();
			
			out.println(length[n][0]);
			
			for(int i=0;i<length[n][0];i++)
				out.print(data[n][i]+" ");
			
			out.println();
		}
		
		out.close();
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
