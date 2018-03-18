package summer_long_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Samarth_and_Sticks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		int n =sc.nextInt(),m=sc.nextInt(),temp,ans=0;
		
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			temp = sc.nextInt();
			
			if(!hm.containsKey(temp))
			{
				hm.put(temp, "1 0");
				list.add(temp);
			}
			else
			{
				String[] str = hm.get(temp).split(" ");
				hm.put(temp, (Integer.parseInt(str[0])+1)+" "+str[1]);
			}
		}
		
		Collections.sort(list);
		
		if(m!=1)
		{
			for(int i=list.size()-1;i>=0;i--)
			{
				if(list.get(i)%m==0 && hm.containsKey(list.get(i)/m))
				{
					String[] str1 = hm.remove(list.get(i)).split(" ");
					String[] str2 = hm.get(list.get(i)/m).split(" ");
					
					int a1,a2;
					a1 = Integer.parseInt(str1[0])+Integer.parseInt(str2[1]);
					a2 = Integer.parseInt(str1[1])+Integer.parseInt(str2[0]);
					
					hm.put(list.get(i)/m, a2+" "+a1);
					//System.out.println(list.get(i)/m+" "+a1+" "+a2);
				}
				else
				{
					String[] str = hm.remove(list.get(i)).split(" ");
					ans += Math.max(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
					//System.out.println(ans+" "+list.get(i));
				}
			}
		}
		else
			ans = list.size();
		
		System.out.println(ans);
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
