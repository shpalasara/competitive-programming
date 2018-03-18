package June_17;

// Accepted
// Involves Persistence Segment Tree and Hashing

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;

public class CLONEME_1 {

	static int MAXN = 131072;
	static long x,y;
	static long[] rand;
	
	public static void main(String[] args) {
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		Random rd = new Random();
		
		rand = new long[131072];
		
		for(int i=0;i<rand.length;i++)
			rand[i] = (long)rd.nextInt();
		
		int t = sc.nextInt();
		
		while(t-->0)
		{
			int n = sc.nextInt();
			int q = sc.nextInt();
			
			int[] data = new int[n+1];
			Node[] root = new Node[n+1];
			
			for(int i=0;i<n+1;i++)
				root[i] = new Node();
			
			BuildSegTree( 0, MAXN , root[0]);
			
			for(int i=1;i<n+1;i++)
			{
				data[i] = sc.nextInt();
				Add_SegTee(root[i-1], root[i], 0, MAXN, data[i]);
			}
			
			Node a, b, c, d;
			long c_diff, s_diff, ss_diff;
			long x_diff,diff,_diff,r_diff;
			
			for(int i=0;i<q;i++)
			{
				a = root[sc.nextInt()-1];
				b = root[sc.nextInt()];
				c = root[sc.nextInt()-1];
				d = root[sc.nextInt()];
				
				c_diff = (b.count-a.count) - (d.count-c.count);
				s_diff = (b.sum-a.sum) - (d.sum-c.sum);
				ss_diff = (b.sum_square-a.sum_square) - (d.sum_square-c.sum_square);
				x_diff = (b.xor^a.xor) ^ (d.xor^c.xor);
				r_diff = (b.rand_mul-a.rand_mul) - (d.rand_mul-c.rand_mul);
				
				if(c_diff==0 && s_diff==0 && ss_diff==0 && x_diff==0 && r_diff==0)
					out.println("YES");
				else if((b.count-a.count)==1 && c_diff==0)
					out.println("YES");
				else
				{
					long first = last_match(0, MAXN, a, b, c, d);
					long last = last_match_rev(0, MAXN, a, b, c, d);
				
//					System.out.println(first+" "+last);
					diff = (b.count-a.count) - (first+last);
					_diff = Math.abs(ss_diff) - (x+y)*Math.abs(s_diff);
					
					if(diff<=1L && _diff==0)
						out.println("YES");
					else
						out.println("NO");
				}
			}
		}
		
		out.close();
	}
	
	public static long last_match(int ss, int se, Node a, Node b, Node c, Node d) {
		
		long c_diff, s_diff, ss_diff;
		long x_diff,r_diff;
		
		int mid = (ss+se)>>1;
		
		if(ss==se)
		{
			x = se;
			return Math.min((b.count-a.count), (d.count-c.count));
		}
		
		c_diff = (b.left.count-a.left.count) - (d.left.count-c.left.count);
		s_diff = (b.left.sum-a.left.sum) - (d.left.sum-c.left.sum);
		ss_diff = (b.left.sum_square-a.left.sum_square) - (d.left.sum_square-c.left.sum_square);
		x_diff = (b.left.xor^a.left.xor) ^ (d.left.xor^c.left.xor);
		r_diff = (b.left.rand_mul-a.left.rand_mul) - (d.left.rand_mul-c.left.rand_mul);;
		
		if(c_diff==0L && s_diff==0L && ss_diff==0L && x_diff==0 && r_diff==0)
			return (b.left.count-a.left.count) + last_match(mid+1, se, a.right, b.right, c.right, d.right);
		else
			return last_match(ss, mid, a.left, b.left, c.left, d.left);
	}
	
	public static long last_match_rev(int ss, int se, Node a, Node b, Node c, Node d) {
		
		long c_diff, s_diff, ss_diff;
		long x_diff,r_diff;
		
		int mid = (ss+se)>>1;
		
		if(ss==se)
		{
			y = se;
			return Math.min((b.count-a.count), (d.count-c.count));
		}
		
		c_diff = (b.right.count-a.right.count) - (d.right.count-c.right.count);
		s_diff = (b.right.sum-a.right.sum) - (d.right.sum-c.right.sum);
		ss_diff = (b.right.sum_square-a.right.sum_square) - (d.right.sum_square-c.right.sum_square);
		x_diff = (b.right.xor^a.right.xor) ^ (d.right.xor^c.right.xor);
		r_diff = (b.right.rand_mul-a.right.rand_mul) - (d.right.rand_mul-c.right.rand_mul);
		
		if(c_diff==0 && s_diff==0 && ss_diff==0 && x_diff==0 && r_diff==0)
			return (b.right.count-a.right.count) + last_match_rev( ss, mid, a.left, b.left, c.left, d.left);
		else
			return last_match_rev(mid+1, se, a.right, b.right, c.right, d.right);
	}
	
	public static void Add_SegTee (Node prev_node , Node new_node , int ss , int se , long index ) {
		
		int mid = (ss + se)>>1;
		
		if(index==ss && index==se)
		{
			new_node.count = prev_node.count + 1;
			new_node.sum = prev_node.sum + index;
			new_node.sum_square = prev_node.sum_square + index*index;
			new_node.xor = prev_node.xor ^ index;
			new_node.rand_mul = prev_node.rand_mul + index*rand[(int)index];
			return;
		}
			
		if(index>mid)
		{
			new_node.left = prev_node.left;
			new_node.right = new Node();
			Add_SegTee(prev_node.right, new_node.right, mid+1, se, index);
		}
		else
		{
			new_node.right = prev_node.right;
			new_node.left = new Node();
			Add_SegTee(prev_node.left, new_node.left, ss, mid, index);
		}
		
		new_node.count = new_node.left.count + new_node.right.count;
		new_node.sum = new_node.left.sum + new_node.right.sum;
		new_node.sum_square = new_node.left.sum_square + new_node.right.sum_square;
		new_node.xor = new_node.left.xor ^ new_node.right.xor;
		new_node.rand_mul = new_node.left.rand_mul + new_node.right.rand_mul;
		return;
	}
	
	public static void BuildSegTree (int ss, int se , Node parent) {
		
		int mid = (ss + se)>>1;
		
		if(ss==se)
			return;

		parent.left = new Node();
		parent.right = new Node();
		
		BuildSegTree( ss, mid, parent.left);
		BuildSegTree( mid+1, se , parent.right);
	}
	
	public static class Node{
		
		Node left;
		Node right;
		long count,sum,sum_square;
		long xor;
		long rand_mul;
		
		public Node() {
			
			count = 0;
			sum = 0;
			sum_square = 0;
			xor = 0;
			left = null;
			right = null;
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
