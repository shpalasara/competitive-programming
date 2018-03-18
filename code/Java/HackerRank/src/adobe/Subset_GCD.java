package adobe;

import java.io.IOException;
import java.util.*;

public class Subset_GCD {

	public static long power;
	
	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int n=sc.nextInt(),same,end,prev_index,p_p_index;
		int[][] data = new int[n][2];
		long[] temp_out = new long[n];
		long[] out = new long[n];
		int height=(int)Math.ceil(Math.log(n)/Math.log(2));
		int size=(int)(Math.pow(2, height+1))-1;
		int[] array = new int[size];
		
		for(int i=0;i<n;i++)
		{
			data[i][0]=sc.nextInt();
			data[i][1]=i;
		}
		
		java.util.Arrays.sort(data, new java.util.Comparator<int[]>() {

			  public int compare(int[] a,int[] b) {

			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));

			  }

			});
		
		constructST(array,data,0,n-1,0);
		
		prev_index=-1;
		p_p_index=-1;
		
		for(int i=n-1;i>=0;i--)
		{
			end=n-1;
			same=0;
			
			while(i>0 && data[i-1][0]==data[i][0])
			{
				i--;
				same++;
			}
			
			while(getAns(array,i,end,0,n-1,0)!=data[i][0])
			{
				end--;
			}
			if(prev_index==-1)
			{
				power=end-i+1;
				temp_out[i]=power_mod(power,1,2)-1;
				prev_index=i;
			}
			else
			{
				if(p_p_index==-1)
				{
					//power=
					p_p_index=prev_index;
					//prev_index=
				}
			}
		}
	}

	public static long power_mod(long b,long temp,long a){
		
		if(temp<=b)
		{
			long ans=power_mod(b,temp<<1,(a*a)%1000000007);
			
			if(power>=temp)
			{
				ans=(ans*a)%1000000007;
				power-=temp;
			}
			
			return ans;
		}
		else
			return 1;
	}
	
	public static int getAns(int[] array,int ql,int qr,int sl,int sr,int index){
		
		if(ql<=sl && sr<=qr)
			return array[index];
		
		if(sl>qr || sr<ql)
			return 0;
		
		int mid=getMid(sl,sr);
		
		return(gcd(getAns(array,ql,qr,sl,mid,2*index+1),getAns(array,ql,qr,mid+1,sr,2*index+2)));
	}
	
	public static int constructST(int[] array,int[][] data,int st,int end,int index){
		
		if(st==end)
		{
			array[index]=data[st][0];
			return data[st][0];
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
