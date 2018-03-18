package August_16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class SHAIKHGN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt(),m;
		
		boolean[][] check = new boolean[n][n];
		//ArrayList<ArrayList<pair>> graph = new ArrayList<ArrayList<pair>>();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<n;i++)
		{
			//ArrayList<pair> temp = new ArrayList<pair>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			
			for(int j=0;j<n;j++)
			{
				if(sc.nextInt()==1)
				{
					check[i][j] = true;
					
					//pair p = new pair();
					//p.index = j;
					//temp.add(p);
					temp.add(j);
				}
			}
			graph.add(temp);
		}
		
		if(n==1)
		{
			m = sc.nextInt();
			int time,start;
			
			while(m-->0)
			{
				time = sc.nextInt();
				start = sc.nextInt()-1;
				
				if(check[0][0] || time==0)
					out.println(1+"\n"+1);
				else
					out.println(0+"\n"+(-1));
			}
		}
		else
		{
			ArrayList<pair> node = new ArrayList<pair>();
		
			for(int i=0;i<n;i++)
			{
				pair temp = new pair();
				temp.index = i;
				node.add(temp);
			}
			
			//build_dfs(graph, node);
			
			m = sc.nextInt();
			int time,start,count;
			
			while(m-->0)
			{
				time = sc.nextInt();
				start = sc.nextInt()-1;
				
				if(time>0)
				{	
					build_dfs_extd ( start, graph, node, 1 , time);
					
					count=0;
					StringBuilder str = new StringBuilder("");
					
					for(int i=0;i<n;i++)
					{
						if(node.get(i).taken)
						{
							count++;
							str.append((i+1)+" ");
						}
						node.get(i).initialize(i);
					}
					
					out.println(count);
					
					if(count==0)
						out.println(-1);
					else
						out.println(str.toString());
				}
				else
					out.println("1\n"+(start+1));
			}
		}
		out.close();
	}
	
//	public static void build_dfs (ArrayList<ArrayList<Integer>> graph, ArrayList<pair> node){
//		
//		int count = 0;
//		
//		for(int i=0;i<node.size();i++)
//		{
//			if(node.get(i).count==-1)
//				count = build_dfs_extd ( i, graph, node, count+1);
//		}
//	}
//	
	
	public static void build_dfs_extd (int index, ArrayList<ArrayList<Integer>> graph, ArrayList<pair> node, int count ,int k){
		
		if(k==0)
			node.get(index).taken = true;
		else if(node.get(index).count!=-1)
		{
			//if(node.get(index).cycle==-1)
			//	node.get(index).cycle = count - node.get(index).count;
			//else
			//	node.get(index).cycle = Math.min(node.get(index).cycle, count - node.get(index).count);
			
			int cycle = k%(count-node.get(index).count);
			
			travelled (graph , node , index, cycle);
			
			//return count;
		}
		else
		{
			node.get(index).count = count;
			
			for(int i=0;i<graph.get(index).size();i++)
			{
				build_dfs_extd (graph.get(index).get(i), graph, node, count+1 ,k-1);
			}
			
			//return count;
		}
	}
	
	public static void travelled(ArrayList<ArrayList<Integer>> graph ,ArrayList<pair> node , int index, int k){
		
		if(k==0)
			node.get(index).taken = true;
		else
		{
			for(int i=0;i<graph.get(index).size();i++)
				travelled (graph , node , graph.get(index).get(i), k-1);
		}
	}
	
	static class pair{
		
		int index,cycle,count;
		boolean taken;
		
		public pair(){
			
			taken = false;
			count = -1;
			cycle = -1;
		}
		
		public void initialize(int i){
			
			taken = false;
			count = -1;
			cycle = -1;
			index = i;
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
/*

0 1 0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 0 0 0 0
0 0 0 0 1 0 0 0 0 0 0
0 1 0 0 0 1 0 0 0 0 0 
0 0 0 0 0 0 1 0 0 0 0
0 0 0 0 0 0 0 1 1 0 0
1 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 1 0 0 0 0 0
5
3 11
11 11
1 5
2 5
7 7

ans : 

2
8 9 
3
4 8 9 
2
2 6 
2
3 7 
2
2 6 

*/