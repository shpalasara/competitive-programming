package Sept_17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Journey {

	static long[] L,C,P,pre_sum,dp,segTree;
	static int n,m;
	static long max,MAX = (long)(1e12);
	static TreeMap<Long,Integer> map;
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		L = new long[n-1];
		pre_sum = new long[n-1];
		C = new long[n-1];
		P = new long[n-1];
		dp = new long[n];
		map = new TreeMap<Long,Integer>();
		
		for(int i=0;i<n-1;i++)
			L[i] = sc.nextInt();
		
		pre_sum[0] = L[0];
		map.put(pre_sum[0], 0);
		
		for(int i=1;i<n-1;i++)
		{
			pre_sum[i] = pre_sum[i-1] + L[i];
			map.put(pre_sum[i], i);
		}
		max = pre_sum[n-2];
		
		for(int i=0;i<n-1;i++)
			C[i] = sc.nextInt();
		
		for(int i=0;i<n-1;i++)
			P[i] = sc.nextInt();
			
		solve();
		
		long c,ans;
		Entry<Long, Integer> temp;
		int ql,qr;
		
		while(m-->0)
		{
			c = sc.nextLong();
			
			if((c-max)>=0L)
				out.println(0);
			else
			{
				ql = 0;
				temp = map.floorEntry(c);
				if(temp==null)
					qr = ql;
				else
					qr = temp.getValue()+1;
				
				ans = getAns(segTree, ql, qr, 0, n-1, 0);
				
				if((ans-MAX)==0L)
					out.println((-1));
				else
					out.println(ans);
			}
		}
		
		out.close();
	}
	
	public static void solve() {
		
		dp[n-1] = 0;
		
		for(int i=0;i<n-1;i++)
			dp[i] = MAX;
		
		int size = (1<<(int)((Math.log(n)/Math.log(2)) + 2)) - 1;
		segTree = new long[size];
		constructST( segTree, dp, 0, n-1,0);
		
		int ql,qr;
		Entry<Long, Integer> temp;
		
		for(int i=n-2;i>=0;i--)
		{
//			System.out.println(i);
			if(C[i]<L[i])
				dp[i] = MAX;
			else
			{
				ql = i+1;
				
				if(C[i]>=(max-pre_sum[i]+L[i]))
					dp[i] = P[i];
				else
				{
					temp = map.floorEntry(C[i]+pre_sum[i]-L[i]);
					qr = temp.getValue()+1;
					
					long t = getAns(segTree, ql, qr, 0, n-1, 0);
//					System.out.println(ql+" "+qr+" ans "+t);
					dp[i] = P[i] + t;
				}
				getUpdate( segTree, i, 0, n-1, 0, dp[i]);
			}
		}
//		System.out.println();
//		for(int i=0;i<n;i++)
//			System.out.print(dp[i]+" ");
//		System.out.println();
		
		
	}
	
	public static void getUpdate(long[] array,int ind,int sl,int sr,int index,long update){
		
		if(sr<ind || sl>ind)
			return;
		
		if(sl==sr)
		{
			if(sl==ind)
				array[index] = update;
			else
				System.out.println("error");
//			System.out.println("count "+update);
			return;
		}
		int mid=getMid(sl,sr);
		
		if(ind<=mid)
			getUpdate(array,ind,sl,mid,2*index+1,update);
		else
			getUpdate(array,ind,mid+1,sr,2*index+2,update);
		
		array[index] = Math.min( array[2*index+1], array[2*index+2]);
		
		return;
	}
	
	public static long getAns(long[] array,int ql,int qr,int sl,int sr,int index){
		
		if(sl>qr || sr<ql)
			return MAX;
		
		if(ql<=sl && sr<=qr)
			return array[index];
		
		int mid=getMid(sl,sr);
		
		return(Math.min( getAns(array,ql,qr,sl,mid,2*index+1), getAns(array,ql,qr,mid+1,sr,2*index+2)));
	}
	
	public static long constructST(long[] array,long[] data,int st,int end,int index){
		
		if(st==end)
		{
			array[index]=data[st];
			return data[st];
		}
		int mid=getMid(st,end);
		array[index]=Math.min( constructST(array,data,st,mid,2*index+1), constructST(array,data,mid+1,end,2*index+2));
		return array[index];
		
	}
	
	public static int getMid(int start,int end){
		return ((start+end)/2);
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
