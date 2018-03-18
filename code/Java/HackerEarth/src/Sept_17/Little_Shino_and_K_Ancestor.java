package Sept_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.TreeMap;

public class Little_Shino_and_K_Ancestor {

	static int[] val;
	static int[] ans; 
	static ArrayList<ArrayList<Integer>> list;
	static HashMap<Integer, TreeMap<Integer,Integer>> set;
	static int k;
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		k = sc.nextInt();
		
		val = new int[n];
		ans = new int[n];
		
		for(int i=0;i<n;i++)
		{
			ans[i] = -1;
			val[i] = sc.nextInt();
		}
		
		list = new ArrayList<ArrayList<Integer>>();
		set = new HashMap<Integer, TreeMap<Integer,Integer>>();
		
		for(int i=0;i<n;i++)
			list.add(new ArrayList<Integer>());
		
		int u,v;
		
		for(int i=0;i<n-1;i++)
		{
			u = sc.nextInt()-1;
			v = sc.nextInt()-1;
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		DFS ( 0, -1, 0);
//		dfs(list, 0);
		
		for(int i=0;i<n;i++)
			out.print(ans[i]+" ");
			
		out.close();
	}
	
	public static void DFS ( int index, int parent, int height) {
		
		int size,s;
		
		if(height>=k)
		{
			if(set.containsKey(val[index]) && set.get(val[index]).size()>=k)
			{
				s = set.get(val[index]).size();
				ans[index] = set.get(val[index]).get(s-k+1)+1;
			}
		}
		
		if(!set.containsKey(val[index]))
			set.put(val[index], new TreeMap<Integer,Integer>());
		
		s = set.get(val[index]).size()+1;
		set.get(val[index]).put(s, index);
		
		size = list.get(index).size();
		
		for(int i=0;i<size;i++)
		{
			if(list.get(index).get(i)!=parent)
				DFS ( list.get(index).get(i), index, height+1);
		}
		
		set.get(val[index]).remove(s);
		return;
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> graph, int root) {
		
		int n = graph.size();
		int[] curEdge = new int[n];
		int[] stack = new int[n];
		stack[0] = root;
		
		for (int top = 0; top >= 0; ) 
		{
			int u = stack[top];
			
			if (curEdge[u] == 0) 
			{
				if(set.containsKey(val[u]) && set.get(val[u]).size()>=k)
				{
					int s = set.get(val[u]).size();
					ans[u] = set.get(val[u]).get(s-k+1)+1;
				}
				if(!set.containsKey(val[u]))
					set.put(val[u], new TreeMap<Integer,Integer>());
				
				int s = set.get(val[u]).size()+1;
				set.get(val[u]).put(s, u);
//				System.out.println(u);
			}
			
			if (curEdge[u] < graph.get(u).size()) {
				int v = graph.get(u).get(curEdge[u]++);
				if (curEdge[v] == 0) {
					stack[++top] = v;
				}
			} else {
				set.get(val[u]).remove(set.size());
				--top;
			}
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
