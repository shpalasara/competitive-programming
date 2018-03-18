package summer_long_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class Lucky_Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		Comparator<Integer> comparator = new newComparator();
		
//		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(1000001,comparator);
		
		HashMap<String,PriorityQueue<Integer>> hm = new HashMap<String,PriorityQueue<Integer>>();
		HashMap<String,Integer> hm1 = new HashMap<String,Integer>();
		boolean[] chcek = new boolean[1000000001];
		
		int q=Integer.parseInt(sc.nextLine()),index=1;
		
		String[] str = new String[2];
		
		while(q-->0)
		{
			str = sc.nextLine().split(" ");
			
			if(!hm1.containsKey(str[0]))
			{
//				HashSet<Integer> inner = new HashSet<Integer>();
				PriorityQueue<Integer> queue = new PriorityQueue<Integer>(1000001,comparator);
				
				if(Integer.parseInt(str[1])==1)
				{
					hm1.put(str[0], 2);
					queue.add(2);
				}
				else
				{
//					inner.add(Integer.parseInt(str[1]));
					queue.add(Integer.parseInt(str[1]));
					queue.add(1);
					hm1.put(str[0], 1);
				}
				
//				hm.put(str[0], inner);
				hm.put(str[0], queue);
				
				out.println(str[1]);
			}
			else if(!hm.get(str[0]).contains(Integer.parseInt(str[1])))
			{
				int value = hm.get(str[0]).element();
				
				if(Integer.parseInt(str[1])==value)
				{
					while(hm.get(str[0]).poll()==value)
					{
						hm.
						value++;
					}
				}
				else
					hm.get(str[0]).add(Integer.parseInt(str[1]));
				
				out.println(str[1]);
			}
			else
			{
				index = hm1.get(str[0]);
				
				while(hm.get(str[0]).contains(index))
				{
					hm.get(str[0]).remove(index);
					index++;
				}
	
				out.println(index);			
				hm1.put(str[0], ++index);
			}
		}
		
		out.close();
	}

	public static class newComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer x, Integer y) {
			// TODO Auto-generated method stub
			if (x < y)
	            return -1;
	        if (x > y)
	            return 1;
			return 0;
		}
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
