package LT_16_July;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class CHEFCLOS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t =sc.nextInt(),n,k,l,left;
		
		while(t-->0)
		{
			n = sc.nextInt();
			k = sc.nextInt();
			l = sc.nextInt();
			left = k;
			
			int[] data = new int[n];
			
			boolean[] check = new boolean[28];
			
			for(int i=0;i<n;i++)
			{
				data[i] = sc.nextInt();
				check[data[i]] = true;
			}
			
			for(int i=2;i<28;i++)
			{
				if(check[i])
				{
					for(int j=i+1;j<28;j++)
					{
						if(check[j])
						{
							int gcd = gcd(i,j);
							if(!check[gcd])
							{	
								check[gcd]=true;
								left--;
							}
						}
					}
				}
			}
			
			if(left<=0)
				System.out.println(0);
			else
			{
				int[] ans = new int[left+1];
				
				ArrayList<Integer> left_no = new ArrayList<Integer>();
				ArrayList<Integer> set = new ArrayList<Integer>();
				
				ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
				
				for(int i=1;i<28;i++)
				{
					if(!check[i] && i<=l)
						left_no.add(i);
					if(check[i])
						set.add(i);
				}
				
				for(int i=0;i<=left;i++)
					list.add(new ArrayList<Integer>());
	
				int num=0;
				int length = set.size();
				
				for(int i=0;i<28;i++)
				{
					if(check[i])
						num = num|(1<<i);
				}
				list.get(0).add(num);
				
				for(int x=0;x<left;x++)
				{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					
					for(int j=0;j<list.get(x).size();j++)
						temp.add(list.get(x).get(j));
					
					for(int i=0;i<left_no.size()-1;i++)
					{
						
						for(int j=0;j<temp.size();j++)
						{
							int val=temp.get(j),len=length;
							
							for(int m=27;m>=0;m--)
							{
								if((val&(1<<m))>0)
								{
									int gcd = gcd(left_no.get(i),m)-1;
									
									if((val&(1<<gcd))==0 && gcd+1!=left_no.get(i))
									{
										val = val|(1<<gcd);
										len++;
									}
								}
								if(m==left_no.get(i))
								{
									val = val|(1<<(left_no.get(i)-1));
									len++;
								}
							}
							
							if(len-length!=0 || len-length<=left)
							{
								int index = len-length;
								boolean ch = true;
								
								for(int m=0;m<list.get(index).size();m++)
								{
									if((val^list.get(index).get(m))==0)
										ch=false;
								}
								if(ch)
									list.get(index).add(val);
							}
						}
						
					}
				}
			}
		}
		
		out.close();
	}
	
	public static int gcd(int a,int b){
		
		a=Math.abs(a);
		b=Math.abs(b);
		
		int temp;
		while(b!=0)
		{
			temp = a%b;
			a = b;
			b = temp;
		}
		return a;
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
