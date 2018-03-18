package May_16;

//Hitarth code

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;

class CHEFMATH_1 {
	
	static long[][] dp;
	static int count;
	static ArrayList<Long> list;
	static ArrayList<Long> solution;
	static HashMap<Pair, Long> h;
	static long mod = (long)1e9+7;
	
	public static void main(String[] args) {
		FasterScanner in = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		list = new ArrayList<>();
		long a = 1;
		long b = 2;
		h = new HashMap<>();
		list.add(a);
		list.add(b);
		long MAX = (long) 1e9;
		while (b <= MAX) {
			long temp = a + b;
			a = b;
			list.add(temp);
			b = temp;

		}
		//System.out.println(list);
		int q = in.nextInt();
		for(int i = 0;i<list.size();i++){
			h.put(new Pair(0, 0, i), 1l);
		}
		h.put(new Pair(0, 0, -1), 1l);
		while (q-- > 0) {
			long x = in.nextLong();
			int k = in.nextInt();
			count = 0;
			solution = new ArrayList<>();
			long ans = f(list.size()-1, k, x);
			//System.out.println(h);
			System.out.println(ans);
		}
		out.close();
	}

	static long f(int index, int maxFrequency, long val) {
		Pair p = new Pair(val,maxFrequency,index);
		//System.out.println("Function called for "+p);
		if(h.containsKey(p)){
			return h.get(p);
		}
		if(val==0){
			return 0;
		}
		if (maxFrequency == 0) {
			return 0;
		}
		if (index == -1) {
			return 0;
		}
		int i = 0;
		long ans = 0;
//		f(index - 1, maxFrequency, val);
		for (i = 0; i <= maxFrequency; i++) {
			// System.out.println(list.get(index)+" "+i);
			if (val - i * list.get(index) >= 0) {
				//solution.add(list.get(index));
				if(index>0){
					if((maxFrequency-i)*list.get(index-1)<val - i*list.get(index)){
						continue;
					}
				}
				ans += f(index - 1, maxFrequency - i, val - i * list.get(index));
				ans %=mod;
			} else {
				break;
			}
		}
//		for (int j = 1; j <= maxFrequency && j < i; j++) {
//			solution.remove(solution.size() - 1);
//		}
		h.put(p, ans);
		return ans;
	}
	
	static class Pair{
		long x;
		int k;
		int index;
		public Pair(long x,int k,int index){
			this.x = x;
			this.k = k;
			this.index = index;
		}
		@Override
		public boolean equals(Object o){
			Pair p;
			if(o instanceof Pair){
				p = (Pair)o;
				return p.x==x  && p.k==k && p.index==index;
			}
			return false;
		}
		@Override
		public int hashCode(){
			return (int)(x+k+index);
		}
		public String toString(){
			return "["+x+" "+k+" "+index+"]";
		}
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