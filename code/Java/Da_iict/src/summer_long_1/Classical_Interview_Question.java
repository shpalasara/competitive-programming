package summer_long_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Classical_Interview_Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t=Integer.parseInt(sc.nextLine()),n,k,ans,i;
		String[] str = new String[2];
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> tm;
		
		for(i=0;i<26;i++)
		{
			tm = new ArrayList<String>();
			list.add(tm);
		}
		
		while(t-->0)
		{
			for(i=0;i<26;i++)
				list.get(i).clear();
			
			ans = 0;
			str = sc.nextLine().split(" ");
			n = Integer.parseInt(str[0]);
			k = Integer.parseInt(str[1]);
			
			str[0] = sc.nextLine();
			
			i=0;
			while(i<n)
			{
				String temp = i+" ";
				while(i+1<n && str[0].charAt(i)==str[0].charAt(i+1))
					i++;
				
				temp +=(++i);
				list.get(str[0].charAt(i-1)-'a').add(temp);
			}
			
			String[] temp = new String[2];

			int s_i=0,e_i=0,temp_k=0,temp_ans=0;
			
			for(i=0;i<26;i++)
			{
				s_i=0;
				e_i=0;
				temp_k=0;
				temp_ans=0;
				
				while(e_i<list.get(i).size())
				{
					temp = list.get(i).get(e_i).split(" ");
					
					if(s_i==e_i)
					{
						temp_ans = Integer.parseInt(temp[1]) - Integer.parseInt(temp[0]);
					}
					else
					{
						String[] t2 = list.get(i).get(s_i).split(" ");
						temp_ans = Integer.parseInt(temp[1]) - Integer.parseInt(t2[0]);
						
						t2 = list.get(i).get(e_i-1).split(" ");
						temp_k += Integer.parseInt(temp[0]) - Integer.parseInt(t2[1]);
					}
					
					while(temp_k>k && s_i<=e_i)
					{
						String[] t1 = list.get(i).get(s_i).split(" ");
						s_i++;
						
						String[] t2 = list.get(i).get(s_i).split(" ");
						temp_k -= Integer.parseInt(t2[0]) - Integer.parseInt(t1[1]);
//						s_i++;
						
						temp_ans = Integer.parseInt(temp[1]) - Integer.parseInt(t2[0]);
					}
				
					ans = Math.max(ans, temp_ans);
					
					e_i++;
					
					if(k-temp_k>0)
					{
						String[] t2 = list.get(i).get(s_i).split(" ");
						
						temp_ans = Math.min(n, Integer.parseInt(temp[1])+k-temp_k) - Integer.parseInt(t2[0]);
						
						ans = Math.max(ans, temp_ans);
						
						temp_ans = Integer.parseInt(temp[1]) - Math.max(0, Integer.parseInt(t2[0])-k+temp_k);
						
						ans = Math.max(ans, temp_ans);
					}
				}
			}
			
			out.println(ans);
		}
		
		out.close();
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
