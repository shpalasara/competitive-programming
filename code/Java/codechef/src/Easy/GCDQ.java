package Easy;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class GCDQ {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int T=sc.nextInt(),n,q,l,r;
		
		while(T-->0)
		{
			n=sc.nextInt();
			q=sc.nextInt();
			int[] data = new int[n];
			int height=(int)Math.ceil(Math.log(n)/Math.log(2));
			int size=(int)(Math.pow(2, height+1))-1;
			int[] array = new int[size];
			
			for(int i=0;i<n;i++)
				data[i]=sc.nextInt();
			
			constructST(array,data,0,n-1,0);
			
			for(int i=0;i<q;i++)
			{
				l=sc.nextInt();
				r=sc.nextInt();
				pw.print(gcd(getAns(array,0,l-2,0,n-1,0),getAns(array,r,n-1,0,n-1,0))+"\n");
			}
		}
		pw.close();
	}
	//ql -- query left(low) side
	//qr -- query rigth(high) side
	//sl -- segment left(low) side
	//sr -- segment right(high) side
	
	public static int getAns(int[] array,int ql,int qr,int sl,int sr,int index){
		
		if(ql<=sl && sr<=qr)
			return array[index];
		
		if(sl>qr || sr<ql)
			return 0;
		
		int mid=getMid(sl,sr);
		
		return(gcd(getAns(array,ql,qr,sl,mid,2*index+1),getAns(array,ql,qr,mid+1,sr,2*index+2)));
	}
	
	public static int constructST(int[] array,int[] data,int st,int end,int index){
		
		if(st==end)
		{
			array[index]=data[st];
			return data[st];
		}
		else
		{
			int mid=getMid(st,end);
			array[index]=gcd(constructST(array,data,st,mid,2*index+1),constructST(array,data,mid+1,end,2*index+2));
			return array[index];
		}
	}
	
	public static int getMid(int start,int end){
		return (start+(end-start)/2);
	}
	
	public static int gcd(int a,int b)
	{
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
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
