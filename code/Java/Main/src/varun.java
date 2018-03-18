import java.io.*;
import java.math.*;
import java.util.*;
 
public class varun {
	static long mod = (int) (1e9 + 7);
 
	public static int[] generatePrimes(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, 2, n + 1, true);
		for (int i = 2; i * i <= n; i++)
			if (prime[i])
				for (int j = i * i; j <= n; j += i)
					prime[j] = false;
		int[] primes = new int[n + 1];
		int cnt = 0;
		for (int i = 0; i < prime.length; i++)
			if (prime[i])
				primes[cnt++] = i;
 
		return Arrays.copyOf(primes, cnt);
	}
 
	public static int[] generatePrimesLinear(int n) {
		int[] lp = new int[n + 1];
		int[] primes = new int[n + 1];
		int cnt = 0;
		for (int i = 2; i <= n; ++i) {
			if (lp[i] == 0) {
				lp[i] = i;
				primes[cnt++] = i;
			}
			for (int j = 0; j < cnt && primes[j] <= lp[i] && i * primes[j] <= n; ++j)
				lp[i * primes[j]] = primes[j];
		}
		return Arrays.copyOf(primes, cnt);
	}
 
	public static boolean isPrime(long n) {
		if (n <= 1)
			return false;
		for (long i = 2; i * i <= n; i++)
			if (n % i == 0)
				return false;
		return true;
	}
 
	public static int[] numberOfPrimeDivisors(int n) {
		int[] divisors = new int[n + 1];
		Arrays.fill(divisors, 2, n + 1, 1);
		for (int i = 2; i * i <= n; ++i)
			if (divisors[i] == 1)
				for (int j = i; j * i <= n; j++)
					divisors[j * i] = divisors[j] + 1;
		return divisors;
	}
 
	public static int[] generateDivisorTable(int n) {
		int[] divisor = new int[n + 1];
		for (int i = 1; i <= n; i++)
			divisor[i] = i;
		for (int i = 2; i * i <= n; i++)
			if (divisor[i] == i)
				for (int j = i * i; j <= n; j += i)
					divisor[j] = i;
		return divisor;
	}
 
	public static int phi(int n) {
		int res = n;
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0) {
				while (n % i == 0)
					n /= i;
				res -= res / i;
			}
		if (n > 1)
			res -= res / n;
		return res;
	}
 
	static long ordinaryFibo(long n, long m) {
		long F[][] = { { 1, 1 }, { 1, 0 } };
		if (n == 0)
			return 0;
		power1(F, n - 1, m);
		return F[0][0] % m;
	}
 
	static void power1(long F[][], long n, long m) {
		if (n == 0 || n == 1)
			return;
		long M[][] = { { 1, 1 }, { 1, 0 } };
 
		power1(F, n >> 1, m);
		multiply(F, F, m);
 
		if ((n & 1) != 0)
			multiply(F, M, m);
	}
 
	static void multiply(long F[][], long M[][], long m) {
		long x = ((F[0][0] * M[0][0]) + (F[0][1] * M[1][0]));
		long y = ((F[0][0] * M[0][1]) + (F[0][1] * M[1][1]));
		long z = ((F[1][0] * M[0][0]) + (F[1][1] * M[1][0]));
		long w = ((F[1][0] * M[0][1]) + (F[1][1] * M[1][1]));
		x %= m;
		y %= m;
		z %= m;
		w %= m;
		F[0][0] = x;
		F[0][1] = y;
		F[1][0] = z;
		F[1][1] = w;
	}
 
	public static int[] generatePhi(int n) {
		int[] res = new int[n + 1];
		for (int i = 1; i <= n; i++)
			res[i] = i;
		for (int i = 1; i <= n; i++)
			for (int j = i + i; j <= n; j += i)
				res[j] -= res[i];
		return res;
	}
 
	static long gcd(long m, long n) {
		long x;
		long y;
		while (m % n != 0) {
			x = n;
			y = m % n;
			m = x;
			n = y;
		}
		return n;
	}
 
	static long lcm(long a, long b) {
		if (a == 0 && b == 0) {
			return 0;
		}
 
		long result = a;
		long gcd = gcd(a, b);
		result /= gcd;
		result *= b;
		result = Math.abs(result);
		return result;
	}
 
	static long modPow(long a, long b, long mod) {
		long res = 1, pow = a;
		while (b > 0) {
			if ((b & 1) == 1) {
				res = (pow * res) % mod;
			}
			pow = (pow * pow) % mod;
			b = b / 2;
		}
		return res;
	}
 
	public static long modInverse(long a, long p) {
		// (assuming p is prime).
		return modPow(a, p - 2, p);
	}
 
	public static long nCk(long y, long z) {
		if (y < z) {
			return 0;
		}
		if (y == z || z == 0) {
			return 1;
		}
 
		if (z == 1) {
			return y % mod;
		}
 
		// Left to right associativity between * and %
		return (((factorials[(int) y] * invFact[(int) z]) % mod) * invFact[(int) (y - z)])
				% mod;
	}
 
	static BigInteger b(long a) {
		return BigInteger.valueOf(a);
	}
 
	static long[] factorials, invFact;
 
	static void computeFactorials(int N) {
		factorials = new long[N];
		invFact = new long[N];
		factorials[0] = 1;
		for (int i = 1; i < factorials.length; i++) {
			factorials[i] = (factorials[i - 1] * i) % mod;
		}
 
		for (int i = 0; i < invFact.length; i++)
			invFact[i] = modPow(factorials[i], mod - 2, mod);
	}
 
	static long[][] generateNCR(int n, long mod) {
		long ncr[][] = new long[n + 1][n + 1];
		ncr[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			ncr[i][0] = 1;
			ncr[0][i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				ncr[i][j] = (ncr[i - 1][j] + ncr[i - 1][j - 1]) % mod;
			}
		}
		return ncr;
	}
 
	static long lucas(long n, long k, long[][] ncr) {
		long ans = 1;
		while (n > 0) {
			int N = (int) (n % mod);
			int K = (int) (k % mod);
			if (K > N)
				return 0;
			ans *= (ncr[N][K]);
			n /= mod;
			k /= mod;
		}
		return ans % mod;
	}
 
	static BigInteger Bigpow(BigInteger n, BigInteger a) {
		BigInteger res = b(1), pow = n;
		while (a.compareTo(b(0)) > 0) {
			if ((a.and(b(1))).compareTo(b(1)) == 0) {
				res = pow.multiply(res);
			}
			pow = pow.multiply(pow);
			a = a.divide(b(2));
		}
		return res;
	}
 
	static void sortint(int[] arr) {
		int len = arr.length;
		if (len == 1)
			return;
		int j, k;
		int tem;
		Random random = new Random();
		for (int i = 0; i < 3 * len; i++) {
			j = random.nextInt(len - 1);
			k = random.nextInt(len - j) + j + 1;
			tem = arr[j];
			arr[j] = arr[k];
			arr[k] = tem;
		}
		Arrays.sort(arr);
	}
 
	static void sortlong(long[] arr) {
		int len = arr.length;
		if (len == 1)
			return;
		int j, k;
		long tem;
		Random random = new Random();
		for (int i = 0; i < 3 * len; i++) {
			j = random.nextInt(len - 1);
			k = random.nextInt(len - j) + j + 1;
			tem = arr[j];
			arr[j] = arr[k];
			arr[k] = tem;
		}
		Arrays.sort(arr);
	}
 
//	static class MyArrayListL implements List<Long> {
// 
//		private long[] myStore;
//		private int actSize = 0;
// 
//		public MyArrayListL() {
//			myStore = new long[2];
//		}
// 
//		public Long get(int index) {
//			return myStore[index];
//		}
// 
//		public void add(long obj) {
//			if (myStore.length - actSize <= 1)
//				increaseListSize();
//			myStore[actSize++] = obj;
//		}
// 
//		public int size() {
//			return actSize;
//		}
// 
//		public void clear() {
//			actSize = 0;
//		}
// 
//		private void increaseListSize() {
//			myStore = Arrays.copyOf(myStore, myStore.length * 2);
//		}
// 
//		@Override
//		public boolean add(Long arg0) {
//			// TODO Auto-generated method stub
//			return false;
//		}
// 
//		@Override
//		public void add(int arg0, Long arg1) {
//			// TODO Auto-generated method stub
// 
//		}
// 
//		@Override
//		public boolean addAll(Collection<? extends Long> arg0) {
//			// TODO Auto-generated method stub
//			return false;
//		}
// 
//		@Override
//		public boolean addAll(int arg0, Collection<? extends Long> arg1) {
//			// TODO Auto-generated method stub
//			return false;
//		}
// 
//		@Override
//		public boolean contains(Object arg0) {
//			// TODO Auto-generated method stub
//			return false;
//		}
// 
//		@Override
//		public boolean containsAll(Collection<?> arg0) {
//			// TODO Auto-generated method stub
//			return false;
//		}
// 
//		@Override
//		public int indexOf(Object arg0) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
// 
//		@Override
//		public boolean isEmpty() {
//			// TODO Auto-generated method stub
//			return false;
//		}
// 
//		@Override
//		public Iterator<Long> iterator() {
//			// TODO Auto-generated method stub
//			return null;
//		}
// 
//		@Override
//		public int lastIndexOf(Object arg0) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
// 
//		@Override
//		public ListIterator<Long> listIterator() {
//			// TODO Auto-generated method stub
//			return null;
//		}
// 
//		@Override
//		public ListIterator<Long> listIterator(int arg0) {
//			// TODO Auto-generated method stub
//			return null;
//		}
// 
//		@Override
//		public boolean remove(Object arg0) {
//			// TODO Auto-generated method stub
//			return false;
//		}
// 
//		@Override
//		public Long remove(int arg0) {
//			// TODO Auto-generated method stub
//			return null;
//		}
// 
//		@Override
//		public boolean removeAll(Collection<?> arg0) {
//			// TODO Auto-generated method stub
//			return false;
//		}
// 
//		@Override
//		public boolean retainAll(Collection<?> arg0) {
//			// TODO Auto-generated method stub
//			return false;
//		}
// 
//		@Override
//		public Long set(int arg0, Long arg1) {
//			// TODO Auto-generated method stub
//			return null;
//		}
// 
//		@Override
//		public List<Long> subList(int arg0, int arg1) {
//			// TODO Auto-generated method stub
//			return null;
//		}
// 
//		@Override
//		public Object[] toArray() {
//			// TODO Auto-generated method stub
//			return null;
//		}
// 
//		@Override
//		public <T> T[] toArray(T[] arg0) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//	}
//	
	static void solve1(){
		int T;
		long n;
		
		T=i();
		while(T-->0){
			n=l();
			//System.out.println(n);
			if(n==1 || n==2){
				System.out.println("0");
			}else
			{
				//System.out.println((long)Math.pow(2, (int)log2(n)));
				//System.out.println((long)Math.pow(2, (int)log2(n)+1));
				long k = (long)Math.min(n-(long)Math.pow(2, (int)log2(n)), (long)Math.pow(2, (int)log2(n)+1)-n);
				System.out.println(k);
			}
		}
	}
	public static void main(String args[]) {
		new Thread(null, new Runnable() {
			public void run() {
				solve1();
			}
		}, "1", 1 << 26).start();
	}
	
	public static long logb( double a, double b ){
		return (long)(Math.log(a) / Math.log(b));
	}

	public static double log2( double a ){
		return logb(a,2);
	}
	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);
 
	static int i() {
		return in.readInt();
	}
 
	static long l() {
		return in.readLong();
	}
 
	static double d() {
		return in.readDouble();
	}
 
	static String s() {
		return in.readString();
	}
 
	static int[] Iarr(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = i();
		}
		return array;
	}
 
	static long[] Larr(int size) {
		long[] array = new long[size];
		for (int i = 0; i < size; i++) {
			array[i] = l();
		}
		return array;
	}
 
	static double[] Darr(int size) {
		double[] array = new double[size];
		for (int i = 0; i < size; i++) {
			array[i] = d();
		}
		return array;
	}
 
	static String[] Sarr(int size) {
		String[] array = new String[size];
		for (int i = 0; i < size; i++) {
			array[i] = s();
		}
		return array;
	}
 
	static char[] stoc(String ss) {
		return ss.toCharArray();
	}
 
	private static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
 
		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public int readInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		public double readDouble() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, readInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, readInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
 
		public long readLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		public String next() {
			return readString();
		}
 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
 
	private static class OutputWriter {
		private final PrintWriter writer;
 
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					outputStream)));
		}
 
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
 
		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}
 
		public void println(Object... objects) {
			print(objects);
			writer.println();
		}
 
		public void close() {
			writer.close();
		}
 
		public void flush() {
			writer.flush();
		}
	}
}