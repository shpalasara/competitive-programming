package September_16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
 
public class JTREE_1 {
 
	/**
	 * @param args
	 */
	static long[] ans;
	static long[] segtree;
	static ArrayList<ArrayList<data>> cost = new ArrayList<ArrayList<data>>();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args){
		new JTREE_1().solve();
	}
	
	public static void solve() {
		// TODO Auto-generated method stub
 
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n,m;
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0;i<n;i++)
			list.add(new ArrayList<Integer>());
		
		int a,b;
		
		for(int i=0;i<n-1;i++)
		{
			a = sc.nextInt()-1;
			b = sc.nextInt()-1;
			
			list.get(b).add(a);
		}
		
		for(int i=0;i<n;i++)
			cost.add(new ArrayList<data>());
		
		int v,k,w;
		
		while(m-->0)
		{
			v = sc.nextInt()-1;
			k = sc.nextInt();
			w = sc.nextInt();
			
			data temp = new data(w,k);
			cost.get(v).add(temp);
		}
		
		ans = new long[n+1];
		
		for(int i=0;i<n+1;i++)
			ans[i] = Long.MAX_VALUE/10;
		
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
			long min = Long.MAX_VALUE/10;
			
			for(int i=0;i<cost.get(index).size();i++)
			{
				min = Math.min(min, cost.get(index).get(i).cost + getAns(Math.max(0, length-cost.get(index).get(i).duration),length-1,0,ans.length-1,0));
			}
			
			ans[index] = min;
		}
		else
			ans[index] = 0;	
		
		getUpdate( length, length, 0, ans.length-1, 0, ans[index]);
		
		for(int i=0;i<list.get(index).size();i++)
		{
			dfs( length+1, list.get(index).get(i));
		}
		
		getUpdate(length, length, 0, ans.length-1, 0, Long.MAX_VALUE/10);
		return;
	}
	
	static class data {
		
		long cost;
		int duration;
		
		public data(int w,int k){
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
			return Long.MAX_VALUE/10;
		
		if(ql<=sl && sr<=qr)
			return segtree[index];
		
		int mid=getMid(sl,sr);
		
		return(Math.min( getAns(ql,qr,sl,mid,2*index+1) , getAns(ql,qr,mid+1,sr,2*index+2)));
	}
	
	public static long constructST(int st, int end, int index){
		
		if(st==end)
		{
			segtree[index] = Long.MAX_VALUE/10;
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
