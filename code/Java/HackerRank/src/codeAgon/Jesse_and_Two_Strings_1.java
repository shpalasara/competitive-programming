package codeAgon;

import java.io.IOException;
import java.util.InputMismatchException;

public class Jesse_and_Two_Strings_1 {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int t=Integer.parseInt(sc.nextLine()),len_a,len_b,max_a,max_b,j;
		String a,b;
		
		while(t-->0)
		{
			a=sc.nextLine();
			b=sc.nextLine();
			len_a=a.length();
			len_b=b.length();

			int[][] check1 = new int[len_a][len_a];
			int[][] check2 = new int[len_b][len_b];
			int[][] dp1 = new int[len_a][len_a];
			int[][] dp2 = new int[len_b][len_b];
			max_a=0;
			max_b=0;
			
			for(int i=0;i<len_a;i++)
			{
				check1[i][i]=1<<(a.charAt(i)-'a');
				dp1[i][i]=1;
			}
			
			for(int sz=2;sz<=len_a;sz++)
			{
				for(int i=0;i<len_a-sz+1;i++)
				{
					j=i+sz-1;
					if(a.charAt(i)==a.charAt(j) && sz==2)
						dp1[i][j]=2;
					else if(a.charAt(i)==a.charAt(j))
					{
						dp1[i][j]=dp1[i+1][j-1]+2;
							
						check1[i][j]=check1[i+1][j-1];
						//for(int k=0;k<26;k++)
						//	check1[i][j][k]=check1[i+1][j-1][k];
						
						//if(i+1==j-1)
							//check1[i][j]|=1<<(a.charAt(i+1)-'a');
							//check1[i][j][a.charAt(i+1)-'a']=true;
					}
					else
					{
						if(dp1[i][j-1]>dp1[i+1][j])
						{
							dp1[i][j]=dp1[i][j-1];
							
							check1[i][j]=check1[i][j-1];
							//for(int k=0;k<26;k++)
							//	check1[i][j][k]=check1[i][j-1][k];
							
							//check1[i][j][a.charAt(j)-'a']=true;
						}
						else if(dp1[i][j-1]<dp1[i+1][j])
						{
							dp1[i][j]=dp1[i+1][j];
							
							check1[i][j]=check1[i+1][j];
							//for(int k=0;k<26;k++)
							//	check1[i][j][k]=check1[i+1][j][k];
							
							//check1[i][j][a.charAt(i)-'a']=true;
						}
						else
						{
							dp1[i][j]=dp1[i+1][j];
							
							check1[i][j]=check1[i+1][j]|check1[i][j-1];
							//for(int k=0;k<26;k++)
							//	check1[i][j][k]=check1[i+1][j][k]||check1[i][j-1][k];
							
							//check1[i][j][a.charAt(i)-'a']=true;
							//check1[i][j][a.charAt(j)-'a']=true;
						}
					}
				}
			}
			max_a=dp1[0][len_a-1];
			
			
			for(int i=0;i<len_b;i++)
			{
				check2[i][i]=1<<(b.charAt(i)-'a');
				dp2[i][i]=1;
			}
			
			for(int sz=2;sz<=len_b;sz++)
			{
				for(int i=0;i<len_b-sz+1;i++)
				{
					j=i+sz-1;
					if(b.charAt(i)==b.charAt(j) && sz==2)
						dp2[i][j]=2;
					else if(b.charAt(i)==b.charAt(j))
					{
						dp2[i][j]=dp2[i+1][j-1]+2;
							
						check2[i][j]=check2[i+1][j-1];
						//for(int k=0;k<26;k++)
						//	check2[i][j][k]=check2[i+1][j-1][k];
						
						//if(i+1==j-1)
						//	check2[i][j]|=1<<(b.charAt(i+1)-'a');
						//	check2[i][j][b.charAt(i+1)-'a']=true;
					}
					else
					{
						if(dp2[i][j-1]>dp2[i+1][j])
						{
							dp2[i][j]=dp2[i][j-1];
							
							check2[i][j]=check2[i][j-1];
							//for(int k=0;k<26;k++)
							//	check2[i][j][k]=check2[i][j-1][k];
							
							//check2[i][j][b.charAt(j)-'a']=true;
						}
						else if(dp2[i][j-1]<dp2[i+1][j])
						{
							dp2[i][j]=dp2[i+1][j];
							
							check2[i][j]=check2[i+1][j];
							//for(int k=0;k<26;k++)
							//	check2[i][j][k]=check2[i+1][j][k];
							
							//check2[i][j][b.charAt(i)-'a']=true;
						}
						else
						{
							dp2[i][j]=dp2[i+1][j];
							
							check2[i][j]=check2[i+1][j]|check2[i][j-1];
							//for(int k=0;k<26;k++)
							//	check2[i][j][k]=check2[i+1][j][k]||check2[i][j-1][k];
							
							//check2[i][j][b.charAt(i)-'a']=true;
							//check2[i][j][b.charAt(j)-'a']=true;
						}
					}
				}
			}
			max_b=dp2[0][len_b-1];
			
			//System.out.println("a "+max_a+" b "+max_b);
			
			if(max_a%2==1 && max_b%2==1)
			{
				boolean temp=false;
				
				//for(int i=0;i<26;i++)
				//	if(check1[0][len_a-1][i])
				//		System.out.print('a'+i+" ");
				
				//for(int i=0;i<26;i++)
				//	if(check2[0][len_b-1][i])
				//		System.out.print('a'+i+" ");
				
				//for(int i=0;i<26 && !temp;i++)
				//{
				//	if(check1[0][len_a-1][i] && check2[0][len_b-1][i])
				//		temp=true;
				//}
				//System.out.println(check1[0][len_a-1]);
				//System.out.println(check2[0][len_b-1]);
				
				if((check1[0][len_a-1]&check2[0][len_b-1])!=0)
					temp=true;
				
				if(temp)
					System.out.println(max_a+max_b);
				else
					System.out.println(max_a+max_b-1);
			}
			else
				System.out.println(max_a+max_b);
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
