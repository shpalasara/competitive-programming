package Algo;

import java.io.IOException;
import java.util.InputMismatchException;

public class Lazy_propagation {

	public static void main(String[] args){
		
		
	}
	
	public static void getUpdate(long[][] array,int ql,int qr,int sl,int sr,int index,int update){
		
		if(array[index][1]!=0)
		{
			array[index][0]+=(long)(sr-sl+1)*array[index][1];
			
			if(sr!=sl)
			{
				array[2*index+1][1]+=array[index][1];
				array[2*index+2][1]+=array[index][1];
			}
			array[index][1]=0;
		}
		
		if(sr<ql || sl>qr)
			return;
		
		if(sl>=ql && sr<=qr)
		{
			array[index][0]+=(long)(sr-sl+1)*(long)update;
			
			if(sl!=sr)
			{
				array[2*index+1][1]+=update;
				array[2*index+2][1]+=update;
			}
			return;
		}
		int mid=getMid(sl,sr);
		
		getUpdate(array,ql,qr,sl,mid,2*index+1,update);
		getUpdate(array,ql,qr,mid+1,sr,2*index+2,update);
		
		array[index][0]=array[2*index+1][0]+array[2*index+2][0];
		
		return;
	}
	
	public static long getAns(long[][] array,int ql,int qr,int sl,int sr,int index){
		
		if(array[index][1]!=0)
		{
			array[index][0]+=(long)(sr-sl+1)*array[index][1];
			
			if(sr!=sl)
			{
				array[2*index+1][1]+=array[index][1];
				array[2*index+2][1]+=array[index][1];
			}
			array[index][1]=0;
		}
		if(sl>qr || sr<ql)
			return 0;
		
		if(ql<=sl && sr<=qr)
			return array[index][0];
		
		int mid=getMid(sl,sr);
		
		return(getAns(array,ql,qr,sl,mid,2*index+1)+getAns(array,ql,qr,mid+1,sr,2*index+2));
	}
	
	public static long constructST(long[] array,long[] data,int st,int end,int index){
		
		if(st==end)
		{
			array[index]=data[st];
			return data[st];
		}
		else
		{
			int mid=getMid(st,end);
			array[index]=constructST(array,data,st,mid,2*index+1)+constructST(array,data,mid+1,end,2*index+2);
			return array[index];
		}
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
