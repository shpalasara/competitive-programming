import java.io.IOException;
import java.util.*;

public class AMLPALIN {

	public static int length;
	
	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int T=Integer.parseInt(sc.nextLine()),n,count_aa,count_ab,count_ba,count_bb,min_ab_ba;
		String temp,ans;
		
		while(T-->0)
		{
			ans="";
			count_aa=0;
			count_ab=0;
			count_ba=0;
			count_bb=0;
			n=Integer.parseInt(sc.nextLine());
			
			for(int i=0;i<n;i++)
			{
				temp=sc.nextLine();
				if(temp.compareTo("aa")==0)
					count_aa++;
				else if(temp.compareTo("ab")==0)
					count_ab++;
				else if(temp.compareTo("ba")==0)
					count_ba++;
				else
					count_bb++;
				//System.out.println(temp.compareTo("aa"));
			}
			
			min_ab_ba=Math.min(count_ab, count_ba);
			
			//for(int i=0;i<count_aa/2;i++)
			//	ans+="aa";
			//temp="";
			length=count_aa/2;
			ans=make_out(1,ans,"aa");
			
			//for(int i=0;i<min_ab_ba;i++)
			//	ans+="ab";
			//temp="";
			length=min_ab_ba;
			ans=make_out(1,ans,"ab");
			
			//if(count_bb<=1 && count_aa%2==1)
			//	ans+="aa";
			//else
			//{
				
				//for(int i=0;i<2*(count_bb/2);i++)
				//	ans+="bb";
				//temp="";
				if(count_aa%2==1)
				{
					length=count_bb/2;
					ans=make_out(1,ans,"bb");
					ans+="aa";
					length=count_bb/2;
					ans=make_out(1,ans,"bb");
				}
				else
				{
					length=count_bb;
					ans=make_out(1,ans,"bb");
				}
			//}
			
			//for(int i=0;i<min_ab_ba;i++)
			//	ans+="ba";
			//temp="";
			length=min_ab_ba;
			ans=make_out(1,ans,"ba");
			
			//for(int i=0;i<count_aa/2;i++)
			//	ans+="aa";
			//temp="";
			length=count_aa/2;
			ans=make_out(1,ans,"aa");
			
			System.out.println(ans);
		}
	}
	
	public static String make_out(int count,String out,String add){
		
		if(count<=length)
		{
			String temp=add+add;
			out=make_out(2*count,out,temp);
			if(count<=length)
			{
				out+=add;
				length-=count;
			}
			return out;	
		}
		else
			return out;
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
