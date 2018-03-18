package daiict;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Deepu_and_Market {

	public static void main(String[] args) {
	
		FasterScanner sc =  new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int n,m;
		n = sc.nextInt();
		int nsqrt = (int)Math.sqrt(n);
		int[] data = new int[n];
		int[][] temp = new int[n][2];
		
		for(int i=0;i<n;i++)
		{
			data[i] = sc.nextInt();
			temp[i][0] = data[i];
			temp[i][1] = i;
		}
		
		java.util.Arrays.sort(temp, new java.util.Comparator<int[]>() {
			  public int compare(int[] a,int[] b) {
			    return (a[0] < b[0] ? -1 : 1);
			  }
		});
		
		int[] index = new int[n];
		
		for(int i=0;i<n;i++)
			index[temp[i][1]] = i;
		
		m = sc.nextInt();
		long X;
		int L,R,count;
		
		int length = 1 << ((int)(Math.log(n+1)/Math.log(2)) + 2);
		
		long[][] seg_tree = new long[length][3];
		
		long[][] query = new long[m][4];
		
		for(int i=0;i<m;i++)
		{
			query[i][0] = sc.nextInt();
			query[i][1] = sc.nextInt();
			query[i][2] = query[i][0]/nsqrt;
			query[i][3] = sc.nextLong();
		}
		
		java.util.Arrays.sort(query, new java.util.Comparator<long[]>() {
			  public int compare(long[] a,long[] b) {
			    return (a[2] < b[2] ? -1 : (a[0] == b[0] ? (a[1] < b[1] ? -1 : 1) : 1));
			  }
		});
		
		int left=0,right=-1;
		for(int i=0;i<m;i++)
		{
			while (left < query[i][0]){
				getUpdate(seg_tree, index[left], index[left],0,n-1,0,-data[left]);
				left++;
			}
			while (left > query[i][0]){
				left--;
				getUpdate(seg_tree, index[left], index[left],0,n-1,0,data[left]);
				
			}
			while (right < query[i][1]){
				right++;
				getUpdate(seg_tree, index[right], index[right],0,n-1,0,data[right]);
			}
			while (right > query[i][1]) {
				getUpdate(seg_tree, index[right], index[right],0,n-1,0,-data[right]);
				right--;
			}
			
		}
		
		out.close();
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
