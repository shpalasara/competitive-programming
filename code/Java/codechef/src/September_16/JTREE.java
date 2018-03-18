package September_16;

// Accepted (Use array of ArrayList in place of ArrayList of ArrayList)

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.InputMismatchException;

public class JTREE {

	/**
	 * @param args
	 */
	
	static long max_val = Long.MAX_VALUE/10; 
	static long[] ans;
	static long[] segtree;
	static ArrayList<data>[] cost;
	static ArrayList<Integer>[] list;
	
	JTREE() {
		solve();
	}
 
	public static void main(String args[]) {
		new Thread(null, new Runnable() {
			public void run(){
				new JTREE();
			}
		}, "1", 1 << 24).start();
	}
	
	public static void solve() {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n,m;
		n = sc.nextInt();
		m = sc.nextInt();
		
		cost = new ArrayList[n+1];
		list = new ArrayList[n+1];
		
		
		for(int i=0;i<n+1;i++)
			list[i] = new ArrayList<Integer>();
		
		int a,b;
		
		for(int i=0;i<n-1;i++)
		{
			a = sc.nextInt()-1;
			b = sc.nextInt()-1;
			
			list[b].add(a);
			//list.get(b).add(a);
		}
		
		for(int i=0;i<n+1;i++)
			cost[i] = new ArrayList<data>();
		
		int v,k;
		long w;
		
		while(m-->0)
		{
			v = sc.nextInt()-1;
			k = sc.nextInt();
			w = sc.nextInt();
			
			data temp = new data(w,k);
//			cost.get(v).add(temp);
			cost[v].add(temp);
		}
		
		ans = new long[n];
		
		for(int i=0;i<n;i++)
			ans[i] = max_val;
		ans[0] = 0;
		
//		int x = (int)Math.ceil(Math.log(n)/Math.log(2));
//		int length = (1<<(x+1)) - 1;
		
		int length = 4*n;
		
		segtree = new long[length];
		constructST( 0, n-1, 0);
		
		dfs(0, 0);
		
		int q = sc.nextInt(),h;
		
		while(q-->0)
		{
			h = sc.nextInt()-1;
			out.println(ans[h]);
		}
		
		out.close();
	}
	
	public static void dfs(int length, int index){
		
		if(length!=0)
		{	
			for(int i=0;i<cost[index].size();i++)
				ans[index] = Math.min(ans[index], (long)(cost[index].get(i).cost) + (long)getAns(Math.max(0, length-cost[index].get(i).duration),length-1,0,ans.length-1,0));
		}
		else
			ans[index] = 0L;	
		
		getUpdate(length, length, 0, ans.length-1, 0, ans[index]);
		
		for(int i=0;i<list[index].size();i++)
		{
			//if(list.get(index).get(i)!=0)
				dfs(length+1, list[index].get(i));
		}
		
		//getUpdate(length, length, 0, ans.length-1, 0, max_val);
		return;
	}
	
//	public static void iterative_dfs(ArrayList<ArrayList<Integer>> list, ArrayList<ArrayList<data>> cost, long[] segtree, long[] ans, int length, int index){
//		
//		Deque<Integer> stack = new ArrayDeque<Integer>();
//		
//		stack.push(index);
//		int s;
//		
//		while(!stack.isEmpty()){
//			
//			s = stack.pollLast();
//			
//			for(int i=0;i<list.get(s).size();i++)
//			{
//				stack.push(list.get(s).get(i));
//			}
//		}
//	}
	
	static class data {
		
		long cost;
		int duration;
		
		public data(long w,int k){
			cost = w;
			duration = k;
		}
	}
	
	public static void getUpdate(int ql,int qr,int sl,int sr,int index,long update){
		
		if(sl>qr || sr<ql)
			return;
		
		if(sl==sr)
		{
			segtree[index] = update;
			return;
		}
		
		int mid=getMid(sl,sr);
		getUpdate(ql,qr,sl,mid,2*index+1,update);
		getUpdate(ql,qr,mid+1,sr,2*index+2,update);
	
		segtree[index] = Math.min( segtree[2*index+1], segtree[2*index+2]);
		return;
	}
	
	public static long getAns(int ql,int qr,int sl,int sr,int index){
		
		if(sl>qr || sr<ql)
			return max_val;
		
		if(ql<=sl && sr<=qr)
			return segtree[index];
		
		int mid=getMid(sl,sr);
		
		return( Math.min( getAns(ql,qr,sl,mid,2*index+1) , getAns(ql,qr,mid+1,sr,2*index+2)));
	}
	
	public static long constructST(int st, int end, int index){
		
		if(st==end)
		{
			segtree[index] = max_val;
			return segtree[index];
		}
		
		int mid=getMid(st,end);
		segtree[index] = Math.min( constructST(st,mid,2*index+1), constructST(mid+1,end,2*index+2));
		return segtree[index];
	}
	
	public static int getMid(int start,int end){
		return (start+end)>>1 ;
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
