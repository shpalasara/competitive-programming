package January_16;

import java.util.*;
import java.io.IOException;

public class SEAKAM {
	
	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		HashMap<String,Integer> hash = new HashMap<String,Integer>();
		
		long[] fact = new long[100010];
		fact[1]=1;
		
		for(int i=2;i<100010;i++)
			fact[i]=(fact[i-1]*(long)i)%1000000007;
		
		int t=sc.nextInt(),n,m,a,b,f_count,t_count,freq_a,freq_b,c_11,c_12,c_22,c1_22,c_h,index;
		long ans,sum;
		
		while(t-->0)
		{
			index=0;
			hash.clear();
			f_count=1;
			t_count=1;
			n=sc.nextInt();
			m=sc.nextInt();
			
			int[][] elem = new int[(1<<m)+1][2*m];
			int[][] freq = new int[(1<<m)+1][2*m];
			int[] length = new int[(1<<m)+1];
			
			for(int i=0;i<m;i++)
			{
				a=sc.nextInt();
				b=sc.nextInt();
				
				if(hash.isEmpty() || !(hash.containsKey(a+" "+b) || hash.containsKey(b+" "+a)))
				{
					index++;
					hash.put(a+" "+b, 1);
					for(int j=0;j<t_count;j++)
					{
						freq_a=0;
						freq_b=0;
						for(int k=0;k<length[j];k++)
						{
							elem[f_count][k]=elem[j][k];
							freq[f_count][k]=freq[j][k];
							
							if(elem[j][k]==a)
							{
								freq[f_count][k]++;
								freq_a++;
							}
							else if(elem[j][k]==b)
							{
								freq[f_count][k]++;
								freq_b++;
							}
						}
						
						elem[f_count][length[j]]=a;
						elem[f_count][length[j]+1]=b;
						freq[f_count][length[j]]=freq_a+1;
						freq[f_count][length[j]+1]=freq_b+1;
						length[f_count]=length[j]+2;
	
						f_count++;
					}
					t_count=f_count;	
				}
			}
			
			//ans=(fact[n]-(((long)(2*index))*fact[n-1])%MOD)%MOD;
			ans=fact[n];
			
			//while(ans<0)
			//{
			//	ans+=MOD;
			//}
			
			//System.out.println(index);
			//System.out.println(ans);
			
			for(int i=1;i<f_count;i++)
			{
				//if(length[i]>2)
				//{
					
					//System.out.println("f_count "+f_count+" i "+i+" j "++" length "+length[f_count]);
					
					/*for(int k=0;k<length[i];k++)
						System.out.print(elem[i][k]+" ");
					
					System.out.println();
					
					for(int k=0;k<length[i];k++)
						System.out.print(freq[i][k]+" ");
					
					System.out.println();
					*/
					
					index=-1;
					c_11=0;
					c_12=0;
					c_22=0;
					c_h=0;
					c1_22=0;
					
					for(int j=0;j<length[i];j+=2)
					{
						if(freq[i][j]==1 && freq[i][j+1]==1)
							c_11++;
						else if((freq[i][j]==1 && freq[i][j+1]==2) || (freq[i][j]==2 && freq[i][j+1]==1))
							c_12++;
						else if(freq[i][j]==2 && freq[i][j+1]==2)
						{
							c_22++;
							/*if(index==-1)
							{
								c_22++;
								index=j;
							}
							else
							{
								if(elem[i][j]==elem[i][index] || elem[i][j+1]==elem[i][index] || elem[i][j]==elem[i][index+1] || elem[i][j+1]==elem[i][index+1])
									c_22++;
								else
									c1_22++;
							}
							
							*/
						}
						else
							c_h++;
					}
					
					if(c_h==0)
					{
						if(c_22==0 || (c_22>0 && c_12>=2))
						{
							sum=((long)(1<<(c_11+c_12/2))*fact[n-(c_11+c_12)])%1000000007;
							
							if((length[i]/2)%2==0)
								ans=(ans+sum)%1000000007;
							else
							{
								ans=(ans-sum)%1000000007;
								
								while(ans<0)
									ans+=(long)1000000007;
							}
						}
					}
					
					//System.out.println("c_11 "+c_11+" c_12 "+c_12+" ans "+ans);
				//}
			}
			
			while(ans<0)
				ans+=(long)1000000007;
			
			ans%=1000000007;
			
			System.out.println(ans);
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
