package December_15;

import java.io.IOException;
import java.util.*;

public class CHEFFILT {

	public static long power;
	
	public static void main(String[] args){
		
		FasterScanner sc = new FasterScanner();
		
		int t,out,temp,n,filter,count;
		String inp,fil;
		t=Integer.parseInt(sc.nextLine());
		HashMap <Integer,Long> filters = new HashMap <Integer,Long>();
		//int[] data = new int[1025];
		ArrayList<Integer> _data = new ArrayList<Integer>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		while(t-->0)
		{
			out=0;
			filters.clear();
			_data.clear();
			temp=1;
			inp=sc.nextLine();
			
			for(int i=9;i>=0;i--)
			{
				if(inp.charAt(i)=='w')
					out=out|temp;
				
				temp<<=1;
			}
			
			n=Integer.parseInt(sc.nextLine());
			
			while(n-->0)
			{
				fil=sc.nextLine();
				temp=1;
				filter=0;
				
				for(int i=9;i>=0;i--)
				{
					if(fil.charAt(i)=='+')
						filter|=temp;
					temp<<=1;
				}
				
				if(filters.containsKey(filter))
				{
					/*long a1=0,a2=0;
					
					if(filters.containsKey(0))
					{
						power=filters.get(0);
						a1=power_mod(power,1,2);
					}
					
					power=filters.get(filter);
					a2=power_mod(power-1,1,2);
	
					filters.put(filter, (a1+a2)%1000000007);
					*/
					filters.put(filter,filters.get(filter)+1);
				}
				else
				{
					filters.put(filter,(long)1);
					_data.add(filter);
					index.add(-1);
					//data[data_size++]=filter;
				}
			}
			
			/*if(filters.containsKey(0))
			{
				power=filters.get(0);
				long a=power_mod(power,1,2);
				
				filters.put(0, a);
			}*/
			
			for(int i=0;i<_data.size();i++)
			{
				count=_data.size();
				//System.out.println("counter "+count);
				/*
				if(data[i]!= 0 && filters.get(data[i])>1)
				{
					long a1=0,a2=0;
					
					if(filters.containsKey(0))
					{
						power=filters.get(0);
						a1=power_mod(power,1,2);
					}
					
					power=filters.get(data[i]);
					a2=power_mod(power-1,1,2);
	
					filters.put(data[i], (a1*a2)%1000000007);
					filters.put(0, (a1*a2)%1000000007);
				}
				*/
				for(int j=i+1;j<count/* && _data.get(i)!=0*/;j++)
				{
					if(index.get(j)==-1 || index.get(i)!=_data.get(j))
					{
						//System.out.println("index "+i+" "+j);
						long a1=0,a2=0;
						
						//if(filters.containsKey(_data.get(i)))
						//{
							power=filters.get(_data.get(i));
							a1=power_mod(power-1,1,2);
						//}
						
						power=filters.get(_data.get(j));
						a2=power_mod(power-1,1,2);
						
						long mul=(a1*a2)%1000000007;
						int xor = _data.get(i)^_data.get(j);
						
						if(filters.containsKey(xor))
						{
							a1=filters.get(xor);
						}
						else
						{
							a1=0;
							index.add(_data.get(j));
							_data.add(xor);
							//index.add(j,_data.get(j));
							//_data.add(j, xor);
							//j++;
						}
						filters.put(xor, mul+a1);
						
						filters.put(_data.get(i), mul);
						filters.put(_data.get(j), mul);
						
						if(filters.containsKey(0))
							a1=filters.get(0);
						
						filters.put(0, mul+a1);	
					}
				}
			}
			//if(filters.containsKey(out) && filters.containsKey(0))
			//	System.out.println(filters.get(out)*filters.get(0));
			//else 
			if(filters.containsKey(out))
				System.out.println(filters.get(out));
			else
				System.out.println("0");
		}
	}
	
	//finding a^b in log(b) time
	public static long power_mod(long b,long temp,long pow){
		
		if(temp<=b)
		{
			long ans=power_mod(b,temp<<1,(pow*pow)%1000000007);
			
			if(power>=temp)
			{
				ans=(ans*pow)%1000000007;
				power-=temp;
			}
			
			return ans;
		}
		else
			return 1;
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
/*
3
wwwwwwwwww
3
+-+-+-+-+-
----------
+---------
wbwbwbwbwb
3
+-+-+-+-+-
+-+-------
----+-+-+-
bbbbbbbbbb
2
----------
----------
*/