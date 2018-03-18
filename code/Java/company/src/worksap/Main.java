package worksap;

// September 2015 problem 5th Mustufa's code 

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
 

class Main {

    public static void main(String[] args) throws Exception
    {
    	prepro();
//    	for( int i=2 ; i<50 ; i++ ){
//    		System.out.println(i);
//    		for( int j=0 ; j<pre[i].size() ; j++ ){
//    			int x=(int)pre[i].poll();
//    			pre[i].add(x);
//    			System.out.print(x+" ");
//    		}
//    		System.out.println("\n");
//    	}
        int t = i();
        while( t-->0 ){
        	int n=i();
        	int m=i();
        	int[] a = new int[n];
        	Queue[] q = new LinkedList[n];
        	TreeSet<Integer> ts = new TreeSet<Integer>();
        	ts.add(n);
        	for( int i=0 ; i<n ; i++ ){
        		a[i]=i();
        		q[i]=new LinkedList<Integer>();
        		int len=pre[a[i]].size();
        		for( int j=0 ; j<len ; j++ ){
        			int poll=(int)pre[a[i]].poll();
        			q[i].add(poll);
        			pre[a[i]].add(poll);
        		}
        		if( len>1 ){
        			ts.add(i);
        		}
        	}
        	
        	long[] b = new long[n];
        	for( int i=0 ; i<n ; i++ ){
        		b[i]=Long.parseLong(q[i].peek().toString());
        	}
        	SegmentTree st = new SegmentTree(b);
        	for( int i=0 ; i<m ; i++ ){
        		int type=i();
        		int l=i()-1;
    			int r=i()-1;
        		if( type==0 ){
        			int curr=ts.ceiling(l);
        			while( curr<=r ){
        				int poll=(int)q[curr].poll();
        				b[curr]=Long.parseLong(q[curr].peek().toString());
        				st.update(1, 0, n-1, curr);
        				if( q[curr].size()==1 ){
        					ts.remove(curr);
        				}
        				curr=ts.higher(curr);
        			}
        		}
        		else{
        			out.print(st.query(1, 0, n-1, l, r)+" ");
        		}
        	}
        	out.println();
        }
        
        out.close();
        
    }
 
    static Queue[] pre;
    static int size=1000000;
    
    static void prepro(){
    	pre = new LinkedList[size+10];
    	for( int i=0 ; i<pre.length ; i++ ) pre[i]=new LinkedList<Integer>();
    	boolean[] prime=new boolean[size+10];
    	Arrays.fill(prime, true);
    	prime[0]=prime[1]=false;
    	for( int i=0 ; i<pre.length ; i++ ){
    		if( prime[i] ){
    			for( int j=i ; j<pre.length ; j+=i ){
    				prime[j]=false;
    				int k=j;
    				while( k%i==0 ){
    					pre[j].add(i);
    					k/=i;
    				}
    			}
    		}
    	}
    	for( int i=0 ; i<pre.length ; i++ ){
    		pre[i].add(1);
    	}
    	return;
    }
    
    static class SegmentTree // Range Max
	{
		long[] tree,arr;
		int size=0;
		public SegmentTree( long[] a )
		{
			arr=a;
			size = 4*a.length;//(int)(2*Math.pow(2, Math.ceil(Math.log(a.length)/Math.log(2)))-1);
			tree = new long[size];
			
			build( 1, 0, a.length-1 );
		}

		public void build(int node, int s, int e)
		{
			if (s == e)
			{
				tree[node] = arr[s];
			} 
			else
			{
				int mid = (s + e) >> 1;
				build(2 * node, s, mid);
				build(2 * node + 1, mid + 1, e);
				tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
			}
		}

		public void update(int node, int s, int e, int p) 
		{
			if (s == e) 
			{
				tree[node] = arr[s];
				return;
			}
			int mid = (s + e) >> 1;
			if (p <= mid) 
			{
				update(2 * node, s, mid, p);
			}
			else
			{
				update(2 * node + 1, mid + 1, e, p);
			}
			tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
		}

		public long query(int node, int s, int e, int l, int r) 
		{
			if (s == l && e == r)
			{
				return tree[node];
			}
			int mid = (s + e) >> 1;
			if (r <= mid)
			{
				return query(2 * node, s, mid, l, r);
			}
			if (l > mid)
			{
				return query(2 * node + 1, mid + 1, e, l, r);
			}
			return merge(query(2 * node, s, mid, l, mid), query(2 * node + 1, mid + 1, e, mid + 1, r));
		}

		public long merge(long tl, long tr)
		{
			return Math.max(tl, tr);
		}

	}
 	
    static InputReader in = new InputReader(System.in);
    static OutputWriter out = new OutputWriter(System.out);
    
    static int i()
    {
    	return in.readInt();
    }
    
    static long l()
    {
    	return in.readLong();
    }
    
    static double d()
    {
    	return in.readDouble();
    }
    
    static String s()
    {
    	return in.readString();
    }
    
    static void Iarr( int[] array, int no )
    {
    	for( int i=0 ; i<no ; i++ )
    	{
    		array[i] = i(); 
    	}
    }
    
    static void Larr( long[] array, int no )
    {
    	for( int i=0 ; i<no ; i++ )
    	{
    		array[i] = l(); 
    	}
    }
    
    static void Darr( double[] array, int no )
    {
    	for( int i=0 ; i<no ; i++ )
    	{
    		array[i] = d(); 
    	}
    }
    
    static void Sarr( String[] array, int no )
    {
    	for( int i=0 ; i<no ; i++ )
    	{
    		array[i] = s(); 
    	}
    }
    
    private static class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }
 
        
        
        
        
        
        
        public int read()
        {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars)
            {
                curChar = 0;
                try
                {
                    numChars = stream.read(buf);
                } catch (IOException e)
                {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public int readInt()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public String readString()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
        public double readDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, readInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
        public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        public boolean isSpaceChar(int c)
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public String next()
        {
            return readString();
        }
 
        public interface SpaceCharFilter
        {
            public boolean isSpaceChar(int ch);
        }
    }
 
    private static class OutputWriter
    {
        private final PrintWriter writer;
 
        public OutputWriter(OutputStream outputStream)
        {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }
 
        public OutputWriter(Writer writer)
        {
            this.writer = new PrintWriter(writer);
        }
 
        public void print(Object... objects)
        {
            for (int i = 0; i < objects.length; i++)
            {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }
 
        public void println(Object... objects)
        {
            print(objects);
            writer.println();
        }
 
        public void close()
        {
            writer.close();
        }
 
        public void flush()
        {
            writer.flush();
        }
     }
}
