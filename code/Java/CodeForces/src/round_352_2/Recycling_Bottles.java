package round_352_2;

//Not Accepted

import java.io.IOException;
import java.util.InputMismatchException;

public class Recycling_Bottles {

	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		double ax,ay,bx,by,tx,ty;
		double min_a1,min_b1;
		//int indexa1=0,indexa2=0,indexb1=0,indexb2=0,index_t=0,i1,i2;
		double tempa,tempb,tempt,ans=0;
		
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
			
			tempa = Math.sqrt(Math.pow(xy[i][0]-ax, 2)+Math.pow(xy[i][1]-ay, 2));
			a[i]=tempa;
			
			/*
			if(tempa<=min_a1)
			{
				indexa2=indexa1;
				min_a2=min_a1;
				indexa1=i;
				min_a1=tempa;
			}
			else if(tempa<=min_a2)
			{
				indexa2=i;
				min_a2=tempa;
			}
			*/
			
			tempb = Math.sqrt(Math.pow(xy[i][0]-bx, 2)+Math.pow(xy[i][1]-by, 2));
			b[i]=tempb;
			
			/*if(tempb<=min_b1)
			{
				indexb2=indexb1;
				min_b2=min_b1;
				indexb1=i;
				min_b1=tempb;
			}
			else if(tempb<=min_b2)
			{
				indexb2=i;
				min_b2=tempb;
			}
			*/
			
			tempt = Math.sqrt(Math.pow(xy[i][0]-tx, 2)+Math.pow(xy[i][1]-ty, 2));
			t[i]=tempt;
			
			/*
			if(tempt<min_t)
			{
				min_t=tempt;
				index_t=i;
			}*/
		}
		
		min_a1=a[0]+t[0];
		min_b1=b[0]+t[0];
		int i_a1=0,i_b1=0;
		
		for(int i=1;i<n;i++)
		{
			if((a[i]+t[i])<=min_a1)
			{
				if(min_a1!=a[i]+t[i])
				{
					min_a1=a[i]+t[i];
					i_a1=i;
				}
				else if(t[i_a1]<t[i])
				{
					min_a1=a[i]+t[i];
					i_a1=i;
				}
			}
			
			if((b[i]+t[i])<=min_b1)
			{
				if(min_b1!=b[i]+t[i])
				{
					min_b1=b[i]+t[i];
					i_b1=i;
				}
				else if(t[i_a1]<t[i])
				{
					min_b1=b[i]+t[i];
					i_b1=i;
				}
			}
		}
		
		int compl1,compl2;
		
		if(i_a1!=i_b1)
		{
			ans = min_a1+min_b1;
			compl1=i_a1;
			compl2=i_b1;
		}
		else if(min_a1<min_b1)
		{
			ans=min_a1;
			compl1=i_a1;
			
			min_b1=Double.MAX_VALUE;
			compl2=-1;
			
			for(int i=0;i<n;i++)
			{
				if(i!=compl1 && min_b1>=(b[i]+t[i]))
				{
					if(min_b1!=b[i]+t[i])
					{
						min_b1 = b[i]+t[i];
						compl2=i;
					}
					else if(compl2==-1 || t[compl2]<t[i])
					{
						min_b1 = b[i]+t[i];
						compl2=i;
					}
				}
			}
			
			if(compl2!=-1)
				ans+=min_b1;
		}
		else
		{
			ans=min_b1;
			compl1=i_b1;
			
			min_a1=Double.MAX_VALUE;
			compl2=-1;
			
			for(int i=0;i<n;i++)
			{
				if(i!=compl1 && min_a1>=(a[i]+t[i]))
				{
					if(min_a1!=a[i]+t[i])
					{
						min_a1 = a[i]+t[i];
						compl2=i;
					}
					else if(compl2==-1 || t[compl2]<t[i])
					{
						min_a1 = a[i]+t[i];
						compl2=i;
					}
				}
			}
			
			if(compl2!=-1)
				ans+=min_a1;
		}
		
		
		for(int i=0;i<n;i++)
		{
			if(i!=compl1 && i!=compl2)
				ans += (t[i]+t[i]);
		}
		
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		
		System.out.println();
		
		for(int i=0;i<n;i++)
			System.out.print(b[i]+" ");
		
		System.out.println();
		
		for(int i=0;i<n;i++)
			System.out.print(t[i]+" ");
		
		System.out.println();
		
		System.out.println(compl1+" "+compl2);
		
		//System.out.println(compl1);
		//System.out.println(compl2);
		
		/*
		if(indexa1!=indexb1)
		{
			ans=min_a1+min_a2;
			i1=indexa1;
			i2=indexb1;
		}
		else
		{
			if(min_a1>min_b1)
			{
				ans+=min_b1+min_a2;
				i1=indexb1;
				i2=indexa2;
			}
			else
			{
				ans+=min_a1+min_b2;
				i1=indexa1;
				i2=indexb2;
			}
		}
		
		System.out.println(i1);
		System.out.println(i2);
		
		for(int i=0;i<n;i++)
		{
			if(i==i1 || i==i2)
				ans += Math.sqrt(Math.pow(xy[i][0]-tx, 2)+Math.pow(xy[i][1]-ty, 2));
			else
				ans += ((double)2)*Math.sqrt(Math.pow(xy[i][0]-tx, 2)+Math.pow(xy[i][1]-ty, 2));
		}
		*/
		
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
