package Feb_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.TreeSet;

public class Strange_order {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc =  new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt(),temp;
//		int[][] max = new int[n+1][2];
		boolean[] prime = new boolean[n+1];
		
		int[][] list = new int[n+1][25];
		int[] count = new int[n+1];
		
		TreeSet<Integer> set = new TreeSet<Integer>();
//		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
//		for(int i=0;i<n+1;i++)
//			list.add(new ArrayList<Integer>());
		
		for(int i=2;i<n+1;i++)
		{
			if(!prime[i])
			{
				for(int j=i;j<n+1;j+=i)
				{
					prime[j] = true;
					list[j][count[j]++] = i;
//					list.get(j).add(i);
				}
			}
		}
		
		for(int i=0;i<n+1;i++)
		{
//			max[i][0] = i;
//			max[i][1] = i;
			prime[i] = true;
		}
		
		for(int i=n;i>0;i--)
		{
			if(prime[i])
			{
				for(int j=0;j<count[i];j++)
				{
//					temp = list.get(i).get(j);
					temp = list[i][j];
					
					if(prime[temp])
					{
						for(int k=temp;k<n+1;k+=temp)
						{
							if(prime[k])
							{
								set.add(k);
								prime[k] = false;
							}
						}
//							max[k][1] = Math.max(max[k][1], i);
					}
				}
				while(!set.isEmpty())
				{
					out.print(set.pollLast()+" ");
				}
			}
		}
		
		out.print(1);
		
//		for(int i=n;i>0;i--)
//		{
//			for(int j=0;j<list.get(i).size();j++)
//			{
//				max[i][1] = Math.max(max[i][1], max[list.get(i).get(j)][1]);
//				max[list.get(i).get(j)][1] = Math.max(max[list.get(i).get(j)][1], max[i][1]);
//			}
//		}
		
//		int[] min_prime = new int[n+1];
//		
//		for(int i=0;i<n+1;i++)
//			min_prime[i] = i;
//		
//		for(int i=2;i<n+1;i++)
//		{
//			for(int j=i+i;j<n+1;j+=i)
//				min_prime[j] = Math.min(min_prime[j], i);
//		}
		
//		for(int i=n;i>0;i--)
//		{
//			if(max[i][1]==0)
//			{
//				temp = min_prime[i];
//				for(int j=temp;j<n+1;j+=temp)
//					max[j][1] = Math.max(max[j][1], i);
//			}
//		}
		
//		java.util.Arrays.sort(max, new java.util.Comparator<int[]>() {
//			
//			  public int compare(int[] a,int[] b) {
//		
//			    return (a[1] < b[1] ? -1 : (a[1] == b[1] ? (a[0] < b[0] ? -1 : 1) : 1));
//		
//			  }
//		
//			});
//		
//		for(int i=n;i>0;i--)
//			out.print(max[i][1]+" ");
//		out.println();
//		for(int i=n;i>0;i--)
//			out.print(max[i][0]+" ");
		
//		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
//		
//		for(int i=0;i<n+1;i++)
//			list.add(new ArrayList<Integer>());
//		
//		for(int i=2;i<n+1;i++)
//		{
//			for(int j=i+i;j<n+1;j+=i)
//				list.get(j).add(i);
//		}
//		
//		boolean[] check = new boolean[n+1];
//		
//		for(int i=n;i>0;i--)
//		{
//			if(!check[i])
//			{
//				check[i] = true;
//				out.print(i+" ");
//				for(int j=list.get(i).size()-1;j>=0;j--)
//				{
//					if(!check[list.get(i).get(j)])
//					{
//						out.print(list.get(i).get(j)+" ");
//						check[list.get(i).get(j)] = true;
//					}
//				}
//			}
//		}
		out.println();
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
