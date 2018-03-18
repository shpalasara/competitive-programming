package round_352_2;

//Accepted

import java.io.IOException;
import java.util.InputMismatchException;

public class Recycling_Bottles_1 {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		double ax,ay,bx,by,tx,ty;
		double max_a,max_b,p_max_a,p_max_b;
		double ans=0;
		
		ax=sc.nextInt();
		ay=sc.nextInt();
		bx=sc.nextInt();
		by=sc.nextInt();
		tx=sc.nextInt();
		ty=sc.nextInt();
		
		int n=sc.nextInt();
		int[][] xy = new int[n][2];
		
		double[] a = new double[n];
		double[] b = new double[n];
		double[] t = new double[n];
		
		for(int i=0;i<n;i++)
		{
			xy[i][0]=sc.nextInt();
			xy[i][1]=sc.nextInt();
			
			a[i] = Math.sqrt(Math.pow(xy[i][0]-ax, 2)+Math.pow(xy[i][1]-ay, 2));
			b[i] = Math.sqrt(Math.pow(xy[i][0]-bx, 2)+Math.pow(xy[i][1]-by, 2));
			t[i]= Math.sqrt(Math.pow(xy[i][0]-tx, 2)+Math.pow(xy[i][1]-ty, 2));
			
			ans+= (t[i]+t[i]);
		}
		/*
		for(int i=0;i<n;i++)
			System.out.print(t[i]-a[i]+" ");
		System.out.println();
		
		for(int i=0;i<n;i++)
			System.out.print(t[i]-b[i]+" ");
		System.out.println();
		
		System.out.println(ans);
		*/
		max_a=t[0]-a[0];
		max_b=t[0]-b[0];
		int ia=0,ib=0,count=0;
		
		for(int i=1;i<n;i++)
		{
			if(max_a<=(t[i]-a[i]))
			{	
				p_max_a = max_a;
				max_a = t[i]-a[i];
				ia=i;
				count=0;
				
				if(p_max_a==max_a)
					count++;
			}
			
			if(max_b<=(t[i]-b[i]))
			{
				p_max_b = max_b;
				max_b = t[i]-b[i];
				ib=i;
				count=0;
						
				if(p_max_b==max_b)	
					count++;
			}
		}
		double temp,temp1;
		
		if(ia!=ib || count>0)
		{
			//System.out.println("Not equal");
			if(max_a<=0 && max_b<=0)
				ans+=Math.min(-max_a, -max_b);
			else if(max_a>=0 && max_b>=0)
				ans-=(max_a+max_b);
			else if(max_a>=0)
				ans-=max_a;
			else
				ans-=max_b;
		}
		else
		{
			//System.out.println("equal");
			// first case
			temp=max_a;
			
			double max_b1= Double.MIN_VALUE;
			
			for(int i=0;i<n;i++)
			{
				if(i!=ia && max_b1<(t[i]-b[i]))
					max_b1 = t[i]-b[i];
			}
			if(max_b1>0)
				temp+=max_b1;
			
			//second case
			temp1=max_b;

			double max_a1= Double.MIN_VALUE;
				
			for(int i=0;i<n;i++)
			{
				if(i!=ib && max_a1<(t[i]-a[i]))
					max_a1 = t[i]-a[i];
			}
			if(max_a1>0)
				temp1+=max_a1;
			
			ans-=Math.max(temp, Math.max(temp1, Math.max(max_a, max_b)));
		}
		
		System.out.println(ans);
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
