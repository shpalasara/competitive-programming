package June_17;

// Wrong Answer And NZEC

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.TreeSet;

public class PRMQ {

	public static void main(String[] args) {
	
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int size = 1000001,length=0;
		boolean[] not_prime = new boolean[size];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=2;i<size;i++)
		{
			if(!not_prime[i])
			{
				if(length==0 && i>1000)
					length = list.size();
				list.add(i);
				for(int j=i+i;j<size;j+=i)
					not_prime[j] = true;
			}
		}
		
//10
//25 10 101534 21564 89465 67 74658 845621 91 134560
//5
//1 10 2 10
//1 10 2 100
//1 10 2 500
//1 10 2 600
//1 10 2 1000
		int n = sc.nextInt(),q,count;
		int[] data = new int[n];
		
		for(int i=0;i<n;i++)
			data[i] = sc.nextInt();
		
		int[][] matrix = new int[n+1][length+1];
		int[] high_prime_factor = new int[n]; 				// Maximum one prime factor of data[i] can be possible having higher value than 1000
		
		for(int i=0;i<n;i++)
		{
			q = data[i];
			for(int j=0;j<length;j++)
			{
				if(!not_prime[q] && q>1000)
				{
					high_prime_factor[i] = q;
					break;
				}
				count = 0;
				while(q!=1 && q%list.get(j)==0)
				{
					q/=list.get(j);
					count++;
				}
				matrix[i+1][j+1] = count;
			}
		}
		
//		for(int i=0;i<n+1;i++)
//		{
//			for(int j=0;j<20;j++)
//				System.out.print(matrix[i][j]+" ");
//			System.out.println();
//		}
//		
		for(int i=0;i<length;i++)
			for(int j=0;j<n;j++)
				matrix[j+1][i+1] += matrix[j][i+1];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<length;j++)
				matrix[i+1][j+1] += matrix[i+1][j];
//		System.out.println();
//		for(int i=0;i<n;i++)
//		{
//			for(int j=0;j<20;j++)
//				System.out.print(matrix[i][j]+" ");
//			System.out.println();
//		}
		
		q = sc.nextInt();
		long[] ans = new long[q+1];
		int L,R,X,Y,X1_i,Y1_i,t=0;
		
		int[][] temp = new int[2*q][5];
		
		for(int i=0;i<q;i++)
		{
			L = sc.nextInt();
			R = sc.nextInt();
			X = sc.nextInt();
			Y = sc.nextInt();
			
			X1_i = BinarySerach_lowerValue(list, X)+1;
			Y1_i = BinarySerach_lowerEqualValue(list, Y)+1;
//			System.out.println(X1_i+" "+Y1_i);
//			X11_i = BinarySerach_upperValue(list, X);
			
			if(list.get(X1_i)<1000)
			{
				if(list.get(Y1_i)<1000)
				{
					ans[i] = matrix[R][Y1_i] - matrix[R][X1_i] - matrix[L-1][Y1_i] + matrix[L-1][X1_i];
					t++;
				}
				else
				{
					ans[i] = matrix[R][length] - matrix[R][X1_i] - matrix[L-1][length] + matrix[L-1][X1_i];
					
					if(L-2>=0)
					{
						temp[2*i][0] = L-2;
						temp[2*i][1] = X;
						temp[2*i][2] = Y;
						temp[2*i][3] = -1;
						temp[2*i][4] = i;
					}
					temp[2*i+1][0] = R-1;
					temp[2*i+1][1] = X;
					temp[2*i+1][2] = Y;
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
		
		TreeSet<Integer> prime = new TreeSet<Integer>();
		int index = 0;
		
		for(int i=2*t;i<2*q;i++)
		{
			if(temp[i][1]!=0)
			{
				while(index<n && index<=temp[i][0])
				{
					if(high_prime_factor[index]!=0)
						prime.add(high_prime_factor[index]);
					index++;
				}
				if(!prime.isEmpty())
					ans[temp[i][4]] += temp[i][3]*(prime.subSet(temp[i][1], temp[i][2]+1).size());
			}
		}
		
		for(int i=0;i<q;i++)
			out.println(ans[i]);
		out.close();
	}
	
	// index of element which satisfies (ith value would be the first greater or equal value of the integer )
	
	static int BinarySerach_upperValue(ArrayList<Integer> list , int value){ 
		
		int mid,l,r;
		
		l = 0;
		r = list.size()-1;
		
		if(value>=list.get(r))
			return r;
		if(value<=list.get(l))
			return l;
		
		mid = (l+r)/2;
		
		while(l<r){
			
			mid = (l+r)/2;
			
			if(list.get(mid)==value)
				return mid;
			
			if(mid+1<list.size() && list.get(mid)<value && list.get(mid+1)>=value)
				return mid+1;
			if(mid-1>0 && list.get(mid-1)<value && list.get(mid)>=value)
				return mid;
			if(list.get(mid)<value)
				l = mid+1;
			else
				r = mid-1;
		}
			
		return -1;
	}
	
	// Returns the index of the just lower value in the list than the given value
	
	static int BinarySerach_lowerValue(ArrayList<Integer> list , int value){
		
		int mid,l,r;
		
		l = 0;
		r = list.size()-1;
		
		if(value>=list.get(r))
			return r;
		if(value<=list.get(l))
			return -1;
		
		mid = (l+r)/2;
		
		while(l<r){
			
			mid = (l+r)/2;
			
			if(list.get(mid)==value)
				return mid-1;
			
			if(mid+1<list.size() && list.get(mid)<value && list.get(mid+1)>=value)
				return mid;
			if(mid-1>0 && list.get(mid-1)<value && list.get(mid)>=value)
				return mid-1;
			if(list.get(mid)<value)
				l = mid+1;
			else
				r = mid-1;
		}
			
		return -1;
	}
	 
	// Returns the index of the just lower value in the list than the given value
	
		static int BinarySerach_lowerEqualValue(ArrayList<Integer> list , int value){
			
			int mid,l,r;
			
			l = 0;
			r = list.size()-1;
			
			if(value>=list.get(r))
				return r;
			if(value<=list.get(l))
				return l;
			
			mid = (l+r)/2;
			
			while(l<r){
				
				mid = (l+r)/2;
				
				if(list.get(mid)==value)
					return mid;
				
				if(mid+1<list.size() && list.get(mid)<=value && list.get(mid+1)>value)
					return mid;
				if(mid-1>0 && list.get(mid-1)<=value && list.get(mid)>value)
					return mid-1;
				if(list.get(mid)<value)
					l = mid+1;
				else
					r = mid-1;
			}
				
			return -1;
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
