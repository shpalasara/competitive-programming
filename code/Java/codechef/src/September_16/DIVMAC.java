package September_16;

//Rejected 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class DIVMAC {

	/**
	 * @param args
	 */
	
	static node[] segtree;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt(),n,m;
		
		int[] next = new int[1000001];
		int[] LPD = new int[1000001];
		next[1] = 1;
		LPD[1] = 1;
		
		for(int i=2;i<1000001;i++)
		{
			if(next[i]==0)
			{
				for(int j=i+i;j<1000001;j+=i)
				{
					if(next[j]==0)
					{
						next[j] = j/i;
						LPD[j] = i;
					}
				}
				
				next[i] = 1;
				LPD[i] = i;
			}
		}
		
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();

			int x = (int)Math.ceil(Math.log(n)/Math.log(2));
			int length = (1<<(x+1)) - 1;
			
			int[] data = new int[n];
			
			for(int i=0;i<n;i++)
				data[i] = sc.nextInt();
			
			segtree = new node[length];
			
			constructST(data,LPD,0,n-1,0);
			
			int type,L,R;
			
			while(m-->0)
			{
				type = sc.nextInt();
				L = sc.nextInt()-1;
				R = sc.nextInt()-1;
				
				if(type==0)
					getUpdate(LPD,next,L,R,0,n-1,0,1);
				else
					out.print(getAns(L,R,0,n-1,0)+" ");
			}
			out.println();
		}
		
		out.close();
	}
	
	public static void getUpdate( int[] LPD, int[] next,int ql,int qr,int sl,int sr,int index,int update){
			
		if(segtree[index].lazy!=0)
		{
			if(sl==sr)
			{
				for(int i=0;i<segtree[index].lazy;i++)
				{
					if(segtree[index].a==1)
						break;
					else
						segtree[index].a = next[segtree[index].a];
				}
				
				segtree[index].ans = LPD[segtree[index].a];
				segtree[index].fine = true;
			}
			else
			{
				segtree[2*index+1].lazy += segtree[index].lazy;
				segtree[2*index+2].lazy += segtree[index].lazy;	
				segtree[index].fine = false;			
			}
			
			segtree[index].lazy = 0;
		}
		
		if(sr<ql || sl>qr)
			return;
		
		if(sl==sr)
		{
			segtree[index].a = next[segtree[index].a];
			segtree[index].ans = LPD[segtree[index].a];
			segtree[index].fine = true;
			segtree[index].lazy = 0;
			return;
		}
		
		if(sl>=ql && sr<=qr)
		{
			segtree[2*index+1].lazy += segtree[index].lazy;
			segtree[2*index+1].lazy += segtree[index].lazy;

		}
		
		
		int mid=getMid(sl,sr);
		getUpdate(LPD,next,ql,qr,sl,mid,2*index+1,update);
		getUpdate(LPD,next,ql,qr,mid+1,sr,2*index+2,update);
		
		segtree[index].ans = Math.max(  segtree[2*index+1].ans, segtree[2*index+2].ans);
		
		return;
		//array[index][0]=array[2*index+1][0]+array[2*index+2][0];
//		
//		return segtree[index].ans;
	}
	
	public static int getAns(int ql,int qr,int sl,int sr,int index){
		
		if(sl>qr || sr<ql)
			return 1;
		
		if(ql<=sl && sr<=qr)
			return segtree[index].ans;
		
		int mid=getMid(sl,sr);
		
		return( Math.max( getAns(ql,qr,sl,mid,2*index+1) , getAns(ql,qr,mid+1,sr,2*index+2)));
	}
	
	public static void constructST(int[] data,int[] LPD, int st, int end, int index){
		
		segtree[index] = new node();
		
		if(st==end)
		{
			segtree[index].a = data[st];
			segtree[index].ans = LPD[data[st]];
			return;
		}
		
		int mid=getMid(st,end);
		constructST(data,LPD,st,mid,2*index+1);
		constructST(data,LPD,mid+1,end,2*index+2);
		
		segtree[index].ans = Math.max(segtree[2*index+1].ans, segtree[2*index+2].ans); 
		return;
	}
	
	public static int getMid(int start,int end){
		return start + (end-start)/2 ;
	}

	public static class node{
		
		int a;
		int ans;
		int lazy;
		boolean fine;
		
		public node(){
			a = 0;
			ans = 0;
			lazy = 0;
			fine = true;
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
