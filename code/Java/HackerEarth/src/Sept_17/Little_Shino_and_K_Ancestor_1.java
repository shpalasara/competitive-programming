package Sept_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Little_Shino_and_K_Ancestor_1 {

	static int size = 1000001,k;
	static ArrayList<Integer>[] list;
//	static ArrayList<int[]> index = new ArrayList<int[]>();
	static int[] index = new int[4*size];
	static int[] i_pointer = new int[size];
	static int[] index_size = new int[size];
	static int[] val,ans;
	static int[] count = new int[size];
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		k = sc.nextInt();
		
		val = new int[n];
		ans = new int[n];
		list = (ArrayList<Integer>[])new ArrayList[n];
		
		for(int i=0;i<n;i++)
		{
			val[i] = sc.nextInt();
			ans[i] = -1;
			count[val[i]]++;
			list[i] = new ArrayList<Integer>();
		}
		
		int pointer=0;
		
		for(int i=0;i<size;i++)
		{
			if(count[i]>=k)
			{
				i_pointer[i] = pointer;
				pointer += count[i];
			}
			else
				i_pointer[i] = -1;
		}
		
		int u,v;
		
		for(int i=1;i<n;i++)
		{
			u = sc.nextInt()-1;
			v = sc.nextInt()-1;
			list[u].add(v);
			list[v].add(u);
		}
		
		dfs(list, 0);
		
		for(int i=0;i<n;i++)
			out.print(ans[i]+" ");
		
		out.close();
	}
	
	public static void dfs(List<Integer>[] graph, int root) {
		
		int n = graph.length;
		int[] curEdge = new int[n];
		int[] stack = new int[n];
		stack[0] = root;
		int u,v,size,pointer;
		
		for (int top = 0; top >= 0; ) {
			u = stack[top];
			if (curEdge[u] == 0) {
				if(count[val[u]]>=k)
				{
					size = index_size[val[u]];
					pointer = i_pointer[val[u]];
					if(size>=k)
						ans[u] = index[pointer-k] +1;
					index[pointer] = u;
					index_size[val[u]]++;
					i_pointer[val[u]]++;
//					System.out.println(u);
				}
			}
			if (curEdge[u] < graph[u].size()) {
				v = graph[u].get(curEdge[u]++);
				if (curEdge[v] == 0) {
					stack[++top] = v;
				}
			} else {
				if(count[val[u]]>=k)
				{
					index_size[val[u]]--;
					i_pointer[val[u]]--;
				}
				--top;
			}
		}
		
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
