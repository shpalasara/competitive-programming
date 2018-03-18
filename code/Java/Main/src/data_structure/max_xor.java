package data_structure;

import java.io.IOException;
import java.util.InputMismatchException;

public class max_xor {

	/**
	 * @param args
	 */
	public static int hight = 40;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		
		int n = sc.nextInt();
		long[] data = new long[n];
		
		for(int i=0;i<n;i++)
		{
			data[i] = sc.nextLong();
		}
		
		trie data1 = new trie();				// Stores the xor values starting from the right side of the array.
		//trie data2 = new trie();				// Stores the xor values starting from the left side of the array.
		
		long xor = data[n-1];
		insert_data( data1 , xor);
		
		for(int i=n-2;i>=0;i--)
		{
			xor = xor ^ data[i];
			insert_data(data1 , xor);
		}
		
		long ans = get_max( 0L , data1),new_xor = 0L;
		
		for(int i=0;i<n;i++)
		{
			new_xor = new_xor ^ data[i];
			delete_data(data1, xor);
			ans = Math.max(ans, get_max(new_xor , data1));
			xor = xor ^ data[i];
		}
		
		System.out.println(ans);
	}
	
	public static long get_max( long value, trie data){
		
		trie temp = data;
		long t,ans=0;
		
		for(int i=hight;i>=0;i--)
		{
			t = value & 1L<<i;
				
			if(temp==null)
				return value;
				
			if(i==0)
			{
				if(temp.count>0)
					ans = temp.value ^ value;
			}
			else
			{
				if(t!=0)
				{
					if(temp.left!=null && temp.left.count>0)
						temp = temp.left;
					else
						temp = temp.right;
				}
				else
				{
					if(temp.right!=null && temp.right.count>0)
						temp = temp.right;
					else
						temp = temp.left;
				}
			}
		}
		
		return ans;
	}
	
	public static void insert_data(trie data , long value){
		
		trie temp = data;
		
		for(int i=hight;i>=0;i--)
		{
			temp.count++;
			
			if(i==0)
			{
				temp.value = value;
			}
			else
			{
				if((value & 1L<<i)==0)
				{
					if(temp.left==null)
						temp.left = new trie();
					temp = temp.left;
				}
				else
				{
					if(temp.right==null)
						temp.right = new trie();
					temp = temp.right;
				}
			}
		}
	}
	
	public static void delete_data(trie data, long value){

		trie temp = data;
		
		for(int i=hight;i>=0;i--)
		{			
			temp.count--;
			
			if((value & 1L<<i)==0)
			{
//				if(temp.left==null)
//					temp.left = new trie();
				temp = temp.left;
			}
			else
			{
//				if(temp.right==null)
//					temp.right = new trie();
				temp = temp.right;
			}
			
//			if(temp==null)
//			{
//				System.out.println("Error");
//				break;
//			}
		}
	}

	public static class trie {
		
		int count;
		trie left;
		trie right;
		long value;
		
		public trie(){
			
			left = null;
			right = null;
			count = 0;
			value = 0;
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
