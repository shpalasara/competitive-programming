package September_16;

// Accepted

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class DIVMAC_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt(),n,m;
		
		n = 1000001;
		
		int[] LPD = new int[n + 1];
		
		for (int i = 1; i <= n; i++)
			LPD[i] = i;
		
		for (int i = 2; i * i <= n; i++)
		{
			if (LPD[i] == i)
			{
				for (int j = i * i; j <= n; j += i)
					if(LPD[j] == j)
						LPD[j] = i;
			}
		}
		
//		for(int i=0;i<n;i++)
//			System.out.println(i+" "+LPD[i]);
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
 
			int x = (int)Math.ceil(Math.log(n)/Math.log(2));
			int length = (1<<(x+1)) - 1;
			
			int[] data = new int[n];
			
			for(int i=0;i<n;i++)
				data[i] = sc.nextInt();
			
			node[] segtree = new node[length];
			
			constructST(segtree,data,LPD,0,n-1,0);
			
			int type,L,R;
			
			while(m-->0)
			{
				type = sc.nextInt();
				L = sc.nextInt()-1;
				R = sc.nextInt()-1;
				
				if(type==0)
				{
//					out.println("tree");
//					
//					for(int j=0;j<length;j++)
//					{
//						if(segtree[j]!=null)
//							out.print(j+" "+segtree[j].ans+" e ");
//					}
//					out.println();
					
					getUpdate(segtree,LPD,L,R,0,n-1,0);
				}
				else
				{
					out.print(getAns(segtree,L,R,0,n-1,0)+" ");
				}
			}
			out.println();
		}
		out.close();
	}
	
	public static void getUpdate(node[] segtree, int[] LPD,int ql,int qr,int sl,int sr,int index){
			
		if(sl>qr || sr<ql)
			return;
	
		if(segtree[index].ans==1)
			return;
		
		if(sl==sr)
		{
			segtree[index].a = segtree[index].a/segtree[index].ans;
			segtree[index].ans = LPD[segtree[index].a];
			return;
		}
		
		int mid=getMid(sl,sr);
		getUpdate( segtree,LPD,ql,qr,sl,mid,2*index+1);
		getUpdate(segtree,LPD,ql,qr,mid+1,sr,2*index+2);
		
		segtree[index].ans = Math.max( segtree[2*index+1].ans, segtree[2*index+2].ans);
		return;
	}
	
	public static int getAns(node[] segtree,int ql,int qr,int sl,int sr,int index){
		
		if(sl>qr || sr<ql)
			return 1;

		if(segtree[index].ans==1)
			return 1;
		
		if(ql<=sl && sr<=qr)
			return segtree[index].ans;
		
		int mid=getMid(sl,sr);
		
		return(Math.max( getAns(segtree,ql,qr,sl,mid,2*index+1) , getAns(segtree,ql,qr,mid+1,sr,2*index+2)));
	}
	
	public static int constructST( node[] segtree, int[] data,int[] LPD, int st, int end, int index){
		
		segtree[index] = new node();
		
		if(st==end)
		{
			segtree[index].a = data[st];
			segtree[index].ans = LPD[data[st]];
			return segtree[index].ans;
		}
		
		int mid=getMid(st,end);
		segtree[index].ans = Math.max( constructST(segtree,data,LPD,st,mid,2*index+1), constructST(segtree,data,LPD,mid+1,end,2*index+2));
		return segtree[index].ans;
	}
	
	public static int getMid(int start,int end){
		return (start+end)>>1 ;
	}
 
	public static class node{
		
		int a;
		int ans;
		
		public node(){
			a = 0;
			ans = 1;
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
