package adobe;

import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Subset_GCD_1 {

	static final int mod = (int)1e9 + 7;
	public static long power;
	
	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int n=sc.nextInt(),count,freq,temp,max;
		int[] check = new int[n+1];
		int[][] data = new int[n][2];
		long[] temp_ans = new long[n+1];
		long[] ans = new long[n];
		
		int pow[] = new int[(int)2e6];
		pow[0] = 1;
		for(int i=1;i<pow.length;i++){
			pow[i] = pow[i-1] * 2;
			if(pow[i] >= mod)
				pow[i] -= mod;
		}
		
		long minus;
		HashMap<Integer,Integer> dict = new HashMap<Integer,Integer>();

		for(int i=0;i<n;i++)
		{
			data[i][0]=sc.nextInt();
			data[i][1]=i;
			check[data[i][0]]++;
		}
		
		java.util.Arrays.sort(data, new java.util.Comparator<int[]>() {

			  public int compare(int[] a,int[] b) {

			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));

			  }

			});
		
		max=data[n-1][0];
		
		for(int i=0;i<n;i++)
		{
			dict.put(data[i][0],i);
			
			while(i+1<n && data[i][0]==data[i+1][0])
			{
				i++;
			}
		}
		
		//This takes O(n) complexity
		for(int i=n-1;i>=0;i--)
		{
			count=0;
			freq=0;
			minus=0;
			
			while(i>0 && data[i-1][0]==data[i][0])
			{
				count++;
				i--;
			}
			temp=2;
			//This one below take O(log (n)) complexity
			for(int j=temp*data[i][0];j<=n;j=(++temp)*data[i][0])
			{
				if(dict.containsKey(j))
				{
					freq+=check[j];
					minus=(minus+(long)temp_ans[dict.get(j)])%1000000007;
				}
			}
			
			freq+=count+1;
			minus++;
			temp_ans[i]=(pow[freq]-minus)%1000000007;
			
			while(temp_ans[i]<0)
				temp_ans[i]+=(long)1000000007;
		}
		
		for(int i=0;i<n;i++)
		{
			if(i+1<n && temp_ans[i+1]==0)
				temp_ans[i+1]=temp_ans[i];
			
			ans[data[i][1]]=temp_ans[i];
		}
		
		for(int i=0;i<n;i++)
			System.out.print(ans[i]+" ");
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
//1073741824
//2^30    73741817
//My ans  73739725
//Ori ans 73737737
//999997915
//30
//13 17 23 1 27 24 15 12 13 3 18 7 11 9 14 7 29 22 9 6 12 20 23 29 13 7 18 25 26 10
//My   14 1 3 73739725 1 1 1 6 14 1955 3 14 2 27 1 14 3 1 27 53 6 1 3 3 14 14 3 1 1 2 
//Orig 14 1 3 73737737 1 1 1 6 14 1955 3 14 2 27 1 14 3 1 27 53 6 1 3 3 14 14 3 1 1 2