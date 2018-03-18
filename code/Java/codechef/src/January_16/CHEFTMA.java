package January_16;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class CHEFTMA {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		int t=sc.nextInt(),n,k,m,count,index;
		//ArrayList<Integer> bw = new ArrayList<Integer>();
		long ans;
		
		while(t-->0)
		{
			index=0;
			//bw.clear();
			ans=0;
			n=sc.nextInt();
			k=sc.nextInt();
			m=sc.nextInt();
			
			int[] diff = new int[n];
			int[] w_b = new int[k+m];
			
			for(int i=0;i<n;i++)
				diff[i]=sc.nextInt();
			
			for(int i=0;i<n;i++)
				diff[i]-=sc.nextInt();
		
			Arrays.sort(diff);
			
			for(int i=0;i<k+m;i++)
			{
				count=sc.nextInt();
				if(count<=diff[n-1])
					w_b[index++]=count;
			}
			Arrays.sort(w_b, 0, index);
			
			//for(int i=0;i<index;i++)
			//{
				//System.out.print(w_b[i]+" ");
			//	bw.add(w_b[i]);
			//}
			//System.out.println();
			int i=0;
			count=index-1;
			
			while(i<n && diff[i]==0)
				i++;
			index=i;
			
			/*while(i<n)
			{
				if((bw.size()>0 && bw.get(0)>diff[i]) || bw.size()==0)
					ans+=(long)diff[i];
				else if(bw.size()>0)
				{
					while(count<bw.size() && diff[i]>=bw.get(count))
						count++;
					
					if(count>=bw.size())
						count=bw.size();
					
					if(count==0)
							ans+=(long)diff[i];
					else
					{
						ans+=(long)(diff[i]-bw.remove(--count));
						count=Math.min(--count, bw.size()-1);
						count=Math.max(count, 0);
					}
				}
				i++;
			}*/
			
			i=n-1;
			while(i>=index)
			{
				//System.out.println(bw.get(count)+" count "+count);
				while(count>=0 && diff[i]<w_b[count])
				{
					//System.out.println(bw.get(count)+" in count "+count);
					count--;
				}
				if(count<0)
					ans+=(long)diff[i];
				else
					ans+=(long)(diff[i]-w_b[count--]);
				i--;
			}
			
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
