package SnackDown_17;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.TreeSet;

public class CONSESNK {

//	static TreeSet<Long> set1 = new TreeSet<Long>();
//	static TreeSet<Long> set2 = new TreeSet<Long>();
	
	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int t = sc.nextInt(),n;
		long l,a,b;
		
		while(t-->0)
		{
			n = sc.nextInt();
			l = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			
			int[] data = new int[n];
			
			for(int i=0;i<n;i++)
				data[i] = sc.nextInt();
			
			Arrays.sort(data);
			
			System.out.println(binary_search( n, data, a, b, l));
		}
	}
	
	public static long binary_search(int n, int[] data, long a, long b, long l){
		
		long L = a, R = b-((long)n)*l,mid;				// Range of the search
//		long ans_l,ans_r;
		long ans_m,ans_m1;
		
//		ans_l = funt(n,data,L,l);
//		ans_r = funt(n,data,R,l);
		
		while(L<R)
		{
			mid = (R+L)/2;
			ans_m = funt(n,data,mid,l);
			ans_m1 = funt(n,data,mid+1,l);
			
			if(ans_m>ans_m1){
				L = mid+1;
//				ans_r = ans_m;
			}
			else{
				R = mid;
//				ans_l = ans_m;
			}
		}
		
		return funt(n,data,L,l);
	}
	
	public static long funt(int n,int[] data,long a,long l){
		
//		for(int i=0;i<n;i++)
//			set1.add((long)data[i]);
//		
//		set2.addAll(set1);
		
		long ans=0, ta, pos = a;
		for(int i=0;i<n;i++)
		{
//			if(set1.floor(a)!=null)
//				ta = set1.floor(a);
//			else
//				ta = set1.ceiling(a);
			ta = data[i];
			ans += Math.abs(pos-ta);
//			set1.remove(ta);
			pos +=l;
		}
		
//		set1.addAll(set2);
//		set2.clear();
		return ans;
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
