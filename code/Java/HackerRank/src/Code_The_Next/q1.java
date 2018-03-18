package Code_The_Next;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Stack;

public class q1 {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> r_list = new ArrayList<ArrayList<Integer>>();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		int t = sc.nextInt(),n,m,u,v;
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			for(int i=0;i<n;i++)
			{
				list.add(new ArrayList<Integer>());
				r_list.add(new ArrayList<Integer>());
			}
			
			int[][] edges = new int[m+1][2];
			
			for(int i=0;i<m;i++)
			{
				u = sc.nextInt()-1;
				v = sc.nextInt()-1;
				edges[i][0] = u;
				edges[i][1] = v;
				if(map.containsKey(u+" "+v))
					map.put(u+" "+v, map.get(u+" "+v)+1);
				else
				{
					map.put(u+" "+v, 1);
					list.get(u).add(v);
					r_list.get(v).add(u);
				}
			}
			

			boolean[] cycled = dfs_begine(list, n);
			BFS_m ( r_list , cycled , n);
			
			int ans = 0;
			
			for(int i=0;i<m;i++)
			{
				if(cycled[edges[i][1]])
					ans++;
				map.remove(edges[i][0]+" "+edges[i][1]);
			}
			
			out.println(ans);
			
			list.clear();
			r_list.clear();
		}
		out.close();
	}
	
	public static void BFS_m (ArrayList<ArrayList<Integer>> r_list , boolean[] cycled ,int n){
	
		boolean[] visited = new boolean[n];
		Stack<Integer> st = new Stack<Integer>();
		int temp,t;
		
		for(int i=0;i<n;i++)
		{
			if(cycled[i] && !visited[i])
			{
				st.add(i);
				visited[i] = true;
				
				while(!st.isEmpty())
				{
					t = st.pop();
					for(int j=0;j<r_list.get(t).size();j++)
					{
						temp = r_list.get(t).get(j);
						
						
						if(!visited[temp] && !cycled[temp])
						{
							st.add(temp);
							visited[temp] = true;
							cycled[temp] = true;
						}
					}
				}
			}
		}
	}
	
	public static boolean[] dfs_begine(ArrayList<ArrayList<Integer>> list , int n){
		
		boolean[] in = new boolean[n];
		boolean[] visited = new boolean[n];
		boolean[] cycle = new boolean[n]; 
		
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
				dfs (list , in , n, i , visited , cycle);
		}
		
		return in;
	}
	
	public static void dfs (ArrayList<ArrayList<Integer>> list , boolean[] in ,int n, int x , boolean[] visited , boolean[] cycle){
		
		visited[x] = true;
		cycle[x] = true;
		int temp;
		
		for(int i=0;i<list.get(x).size();i++)
		{
			temp = list.get(x).get(i);
			if(!visited[temp])
				dfs ( list , in , n, temp , visited , cycle);
			else if(cycle[temp])
			{
				in[temp] = true;
				in[x] = true;
			}
		}
		cycle[x] = false;
		return;
	}
	
	public static void DFS(HashMap< String, Integer> map , ArrayList<ArrayList<Integer>> list , boolean[] in ,int n){
		
		Stack<Integer> st = new Stack<Integer>();
		boolean[] visited = new boolean[n];
		boolean[] cycled = new boolean[n]; 
		int[] size = new int[n];
		int node;
		
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				visited[i] = true;
				st.add(i);
				
				while(!st.isEmpty())
				{
					node = st.peek();
					cycled[node] = true;
					visited[node] = true;
					
					if(size[node]<list.get(node).size())
					{
						int temp = list.get(node).get(size[node]++);
						if(cycled[temp])
							in[temp] = true;
						else if(!visited[temp])
							st.add(temp);
					}
					else
					{
						int temp = st.pop();
						cycled[temp] = false;
						size[temp] = 0;
					}
				}
			}
		}
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
