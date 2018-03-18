package educ_round_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Comparing_Two_Long_Integers {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		PrintWriter pw=new PrintWriter(System.out);
		String a=sc.nextLine(),b=sc.nextLine();
		int l_a=a.length(),l_b=b.length(),index_a=0,index_b=0;
		boolean check=false;
		
		while(index_a<a.length() && a.charAt(index_a)=='0')
			index_a++;
		
		l_a-=index_a;
		
		while(index_b<b.length() && b.charAt(index_b)=='0')
			index_b++;
		
		l_b-=index_b;
		
		if(l_a==l_b)
		{
			//System.out.println(index_a+" "+index_b);
			while(index_a<a.length() && index_b<b.length())
			{
				//System.out.println(a.charAt(index_a));
				//System.out.println(b.charAt(index_b));
				//System.out.println(a.charAt(index_a)-b.charAt(index_b));
				
				if(a.charAt(index_a)-b.charAt(index_b)>0)
				{
					pw.print(">\n");
					//System.out.println(">");
					check=true;
					break;
				}
				else if(a.charAt(index_a)-b.charAt(index_b)<0)
				{
					pw.print("<\n");
					//System.out.println("<");
					check=true;
					break;
				}
				else
				{
					index_a++;
					index_b++;
				}
			}
			
			if(!check)
				pw.print("=\n");
				//System.out.println("=");
		}
		else if(l_a>l_b)
			pw.print(">\n");
			//System.out.println(">");
		else
			pw.print("<\n");
			//System.out.println("<");

		pw.close();
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
 
        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}
