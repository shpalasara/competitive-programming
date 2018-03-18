package code_star;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Arya_Stark {

	public static Node[] graph;
	
	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt(),q,t,x,y,dist_x,dist_y;
		graph = new Node[n];
		
		for(int i=0;i<n;i++)
			graph[i]=new Node();
		
		for(int i=0;i<n-1;i++)
		{
			x=sc.nextInt()-1;
			y=sc.nextInt()-1;
			
			graph[x].child.add(y);
			graph[y].child.add(x);
		}
		
		graph[0].parent_id=-1;

		graph[0].in=0;
		graph[0].out=set_parent(0,1,1);
		
		//System.out.println("0 out "+graph[0].out);
		//System.out.println(graph[1].in+" <in : out> "+graph[1].out);
		q=sc.nextInt();
		
		for(int i=0;i<q;i++)
		{
			t=sc.nextInt();
			
			if(t==0)
			{
				y=sc.nextInt()-1;
				x=sc.nextInt()-1;
			}
			else
			{
				x=sc.nextInt()-1;
				y=sc.nextInt()-1;
			}
			
			dist_x=graph[x].dist;
			dist_y=graph[y].dist;
			
			if(x==y)
				pw.println("YES 1");
			
			if(dist_x>dist_y && graph[y].in<graph[x].in && graph[y].out>graph[x].out)
				pw.println("YES "+(dist_x-dist_y+1));
			else
				pw.println("NO");
		}
		pw.close();
	}
	
	public static int set_parent(int node_id,int dist,int count){
		
		int size=graph[node_id].child.size(),parent_id=graph[node_id].parent_id,child_id;
		
		for(int i=0;i<size;i++)
		{
			child_id=graph[node_id].child.get(i);
			
			if(child_id!=parent_id)
			{	
				graph[child_id].dist=dist;
				graph[child_id].parent_id=node_id;
				graph[child_id].in=count;
				
				//System.out.println("id "+child_id+" in "+count);
				count=set_parent(child_id,dist+1,++count);
				graph[child_id].out=count;
				//System.out.println("id "+child_id+" out "+count);
				count++;
			}
		}
		return count;
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

class Node {

	int id;
	int dist;
	int in,out;
	int parent_id;
	ArrayList<Integer> child = new ArrayList<Integer>();
}
