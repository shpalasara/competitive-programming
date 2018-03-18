package June_17;

// Accepted

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class PRMQ_1 {

	public static void main(String[] args) {
	
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int size = 1005001,length=0;
		int[] not_prime = new int[size];
		//ArrayList<Integer> list = new ArrayList<Integer>();
		int[] prime = new int[79000];
		
		for(int i=2;i<size;i++)
		{
			if(not_prime[i]==0)
			{
				prime[length] = i;
				not_prime[i] = length++;
				for(int j=i+i;j<size;j+=i)
					not_prime[j] = -1;
			}
		}

		int n = sc.nextInt(),q,count;
		
		int[] data = new int[n];
		
		for(int i=0;i<n;i++)
			data[i] = sc.nextInt();
		
		int s_size = 1<<((int)(Math.ceil(Math.log(length)/Math.log(2))+1));
//		System.out.println(s_size);
		
		long[][] array = new long[s_size][2]; 
		
		q = sc.nextInt();
		long[] ans = new long[q+1];
		int L,R,X,Y,x_i,y_i;
		
		int[][] temp = new int[2*q][5];
		
		for(int i=0;i<q;i++)
		{
			L = sc.nextInt();
			R = sc.nextInt();
			X = sc.nextInt(); 
			Y = sc.nextInt();
			
			if(Y>=2)
			{
				if(not_prime[X]!=-1)
					x_i = not_prime[X];
				else
					x_i = -1*(Arrays.binarySearch(prime, X))-1;
				if(not_prime[Y]!=-1)
					y_i = not_prime[Y];
				else
					y_i = -1*(Arrays.binarySearch(prime, Y))-2;
				
//				System.out.println(x_i+" "+y_i);
				
				if(x_i<=y_i)
				{
					if(L-2>=0)
					{
						temp[2*i][0] = L-2;
						temp[2*i][1] = x_i;
						temp[2*i][2] = y_i;
						temp[2*i][3] = -1;
						temp[2*i][4] = i;
					}
					temp[2*i+1][0] = R-1;
					temp[2*i+1][1] = x_i;
					temp[2*i+1][2] = y_i;
					temp[2*i+1][3] = 1;
					temp[2*i+1][4] = i;
				}
			}
		}
		
		java.util.Arrays.sort(temp, new java.util.Comparator<int[]>() {
			  public int compare(int[] a,int[] b) {
			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));
			  }
		});
		
		int index = 0,t,d = q;
		
		for(int i=0;i<2*d;i++)
		{
			if(temp[i][3]==1 || temp[i][3]==-1)
			{
				while(index<n && index<=temp[i][0])
				{
					// Adding the prime factors to the segment tree
					q = data[index];
					for(int j=0;j<length && q>1;j++)
					{
						if(not_prime[q]!=-1)
						{
							t = not_prime[q];
							getUpdate(array, t, t, 0, length-1, 0, 1);
//							System.out.println("count "+q+" "+1);
							break;
						}
						count = 0;
						while(q!=1 && q%prime[j]==0)
						{
							q/=prime[j];
							count++;
						}
						if(count!=0)
							getUpdate(array, j, j, 0, length-1, 0, count);
//						System.out.println("count "+list.get(j)+" "+count);
					}
					index++;
				}
				
				ans[temp[i][4]] += ((long)temp[i][3])*getAns(array, temp[i][1], temp[i][2], 0, length-1, 0);
			}
		}
		
		for(int i=0;i<d;i++)
			out.println(ans[i]);
		out.close();
	}
	
	public static void getUpdate(long[][] array,int ql,int qr,int sl,int sr,int index,int update){
		
		if(array[index][1]!=0)
		{
			array[index][0]+=(long)(sr-sl+1)*array[index][1];
			
			if(sr!=sl)
			{
				array[2*index+1][1]+=array[index][1];
				array[2*index+2][1]+=array[index][1];
			}
			array[index][1]=0;
		}
		
		if(sr<ql || sl>qr)
			return;
		
		if(sl>=ql && sr<=qr)
		{
			array[index][0]+=(long)(sr-sl+1)*(long)update;
			
			if(sl!=sr)
			{
				array[2*index+1][1]+=(long)update;
				array[2*index+2][1]+=(long)update;
			}
			return;
		}
		int mid=getMid(sl,sr);
		
		getUpdate(array,ql,qr,sl,mid,2*index+1,update);
		getUpdate(array,ql,qr,mid+1,sr,2*index+2,update);
		
		array[index][0]=array[2*index+1][0]+array[2*index+2][0];
		
		return;
	}
	
	public static long getAns(long[][] array,int ql,int qr,int sl,int sr,int index){
		
		if(array[index][1]!=0)
		{
			array[index][0]+=(long)(sr-sl+1)*array[index][1];
			
			if(sr!=sl)
			{
				array[2*index+1][1]+=array[index][1];
				array[2*index+2][1]+=array[index][1];
			}
			array[index][1]=0;
		}
		if(sl>qr || sr<ql)
			return 0;
		
		if(ql<=sl && sr<=qr)
			return array[index][0];
		
		int mid=getMid(sl,sr);
		
		return(getAns(array,ql,qr,sl,mid,2*index+1)+getAns(array,ql,qr,mid+1,sr,2*index+2));
	}
	
	public static long constructST(long[][] array,long[] data,int st,int end,int index){
		
		if(st==end)
		{
			array[index][0]=data[st];
			return data[st];
		}
		else
		{
			int mid=getMid(st,end);
			array[index][0]=constructST(array,data,st,mid,2*index+1)+constructST(array,data,mid+1,end,2*index+2);
			return array[index][0];
		}
	}
	
	public static int getMid(int start,int end){
		return ((start+end)/2);
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


