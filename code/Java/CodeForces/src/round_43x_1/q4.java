package round_43x_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class q4 {

	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int size = 1<<19;
		boolean[] check = new boolean[size];
		Node trie = new Node();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int data;
		
		for(int i=0;i<n;i++)
		{
			data = sc.nextInt();
			check[data] = true;
//			insert_node(trie,data);
		}
		
		for(int i=0;i<check.length;i++)
		{
			if(!check[i])
				insert_node(trie, i);
		}
		
		int xor=0;
		
		while(m-->0)
		{
			xor ^= sc.nextInt();
			out.println(find_nearest(trie, xor)^xor);
		}
		
		out.close();
	}
	
	public static int find_nearest (Node trie , int val) {
		
		Node temp = trie;
		int ans=0;
		
		for(int i=20;i>=0;i--)
		{
			if((val&(1<<i))==0)
			{
				if(temp.left==null)
				{
					ans ^= (1<<i);
					temp = temp.right;
				}
				else
					temp = temp.left;
			}
			else
			{
				if(temp.right==null)
				{
//					ans ^= (1<<i);
					temp = temp.left;
				}
				else
				{
					ans ^= (1<<i); 
					temp = temp.right;
				}
			}
		}
		return ans;
	}
	
	public static void insert_node(Node trie, int val) {
		
		Node temp = trie;
		
		for(int i=20;i>=0;i--)
		{
			if((val&(1<<i))==0)
			{
				if(temp.left==null)
					temp.left = new Node();
				temp = temp.left;
			}
			else
			{
				if(temp.right==null)
					temp.right = new Node();
				temp = temp.right;
			}
		}
		
		return;
	}
	
	static class Node{
	
		Node left;
		Node right;
		
		public Node(){
			
			left = null;
			right = null;
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
