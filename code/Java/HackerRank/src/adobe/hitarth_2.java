package adobe;

import java.io.*;
import java.util.*;

public class hitarth_2 {

	static final int mod = (int)1e9 + 7;
	
	public static void main(String args[]) {
		InputReader in = new InputReader(System.in);
		PrintWriter w = new PrintWriter(System.out);
		
		int pow[] = new int[(int)2e6];
		pow[0] = 1;
		for(int i=1;i<pow.length;i++){
			pow[i] = pow[i-1] * 2;
			if(pow[i] >= mod)
				pow[i] -= mod;
		}
		
		int n = in.nextInt();
		
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i] = in.nextInt();
		
		int cnt[] = new int[n + 1];
		for(int i=0;i<n;i++)
			cnt[a[i]]++;
		
		for(int i=1;i<=n;i++)
			for(int j=i+i;j<=n;j+=i)
				cnt[i] += cnt[j];
		
		int dp[] = new int[n + 1];
		
		for(int i=n;i>=1;i--){
			long now = pow[cnt[i]] - 1;
			for(int j=i+i;j<=n;j+=i)
				now -= dp[j];
			now %= mod;
			if(now < 0)	now += mod;
			dp[i] = (int)now;
		}
		
		for(int i=0;i<n+1;i++)
			System.out.print(dp[i]+" ");
		
		System.out.println();
		
		for(int i=0;i<n;i++)
			w.print(dp[a[i]] + " " );
		w.println();
		w.close();
	}
	
	static class InputReader {

		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar;
		private int snumChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}

			int res = 0;

			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));

			return res * sgn;
		}
		
		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}

			long res = 0;

			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));

			return res * sgn;
		}
		
		public String readString() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}

