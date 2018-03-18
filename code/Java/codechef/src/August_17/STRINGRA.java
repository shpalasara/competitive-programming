package August_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.TreeSet;
import java.util.Arrays;

public class STRINGRA {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		int n,m;
		int[] ans = new int[100010];
		int[] count = new int[100010];
		boolean check;
		TreeSet<Integer> set1 = new TreeSet<Integer>();
		TreeSet<Integer> set2 = new TreeSet<Integer>();
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			check = true;
			set1.clear();
			set2.clear();
			
			for(int i=0;i<n+1;i++)
			{
				ans[i] = 0;
				count[i] = 0;
			}
			
			int[][] edges = new int[m][2];
			
			for(int i=0;i<m;i++)
			{
				edges[i][0] = sc.nextInt();
				edges[i][1] = sc.nextInt();
				
				if(edges[i][0]>=edges[i][1])
					check = false;
				count[edges[i][0]]++;
			}
			
			for(int i=0;i<n && check;i++)
				if(count[i]==0)
					check = false;
			
			
			Arrays.sort(edges, new Comparator<int[]>() {
				
				public int compare(int[] a , int[] b) {
					
					return ( a[0]>b[0] ? 1 : ( (a[0]<b[0]) ? -1 : (a[1]>b[1] ? 1 : -1))); 
				}
			});
			
			for(int i=1;i<m && check;i++)
				if(edges[i][0]==edges[i-1][0] && edges[i][1]==edges[i-1][1])
					check = false;
			
			set1.add(1);
			
			int i=0;
			
			while(i<m && check)
			{
				if(!set1.isEmpty() && set1.contains(edges[i][0]))
					set1.remove(edges[i][0]);
				do
				{
					if(!set1.isEmpty() && set1.contains(edges[i][1]))
						set1.remove(edges[i][1]);
					set2.add(edges[i][1]);
					i++;
				}
				while(i<m && edges[i][0]==edges[i-1][0]);
				
				if(set1.isEmpty())
				{
					if(i<m)
						set2.add(edges[i][0]+1);
					set1.addAll(set2);
					set2.clear();
				}
				else
					check = false;
			}
			
			int index;
			
			if(check)
			{
				//out.println("here");
				set1.clear();
				set2.clear();
				for(i=1;i<=count[0];i++)
					set1.add(i);
		
				i=0;
				while(i<m && check)
				{
					index = i;
					do {
						if(ans[edges[index][1]]!=0)
						{
							if(!set1.contains(ans[edges[index][1]]))
								check = false;
							else
							{
								set1.remove(ans[edges[index][1]]);
								set2.add(ans[edges[index][1]]);
							}
						}
						index++;
					}
					while(check && index<m && edges[index][0]==edges[index-1][0]);
					
					do {
						if(ans[edges[i][1]]==0)
						{
							if(set1.isEmpty())
								check = false;
							else
							{
								ans[edges[i][1]] = set1.pollFirst();
								set2.add(ans[edges[i][1]]);
							}
						}
						i++;
					}
					while(check && i<m && edges[i][0]==edges[i-1][0]);
					
					set1.clear();
					set1.addAll(set2);
					set2.clear();
				}
			}
						
			for(i=1;i<=n && check;i++)
			{
				if(ans[i]==0 || ans[i]>count[0])
					check = false;
			}
			
			if(check)
			{
				for(i=1;i<=n;i++)
					out.print(ans[i]+" ");
				out.println();
			}
			else
				out.println(-1);
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
