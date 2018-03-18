import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//ArrayList<Data> data = new ArrayList<Data>();
		//ArrayList<Data> _temp = new ArrayList<Data>();
		 PriorityQueue<Data> data = new PriorityQueue<Data>(100, new Comparator<Data>() {
		        
			 public int compare(Data data1, Data data2)
			 {
		        	if(data1.priority==data2.priority)
		    		{
		    			//String str = (String)this._data;
		    			if(data1._data>data2._data)
		    				return 1;
		    			else
		    				return -1;
		    		}
		    		else if(data1.priority>data2.priority)
		    			return 1;
		    		else 
		    			return -1;
		       }
		    });
		 PriorityQueue<Data> _temp = new PriorityQueue<Data>(100, new Comparator<Data>() {
		        
			 public int compare(Data data1, Data data2)
			 {
		        	if(data1.priority==data2.priority)
		    		{
		    			//String str = (String)this._data;
		    			if(data1._data>data2._data)
		    				return 1;
		    			else
		    				return -1;
		    		}
		    		else if(data1.priority>data2.priority)
		    			return 1;
		    		else 
		    			return -1;
		       }
		    });
		 
		int length=0;
		//int g=0;
		
		for(int i=0;i<N;i++)
		{
			int m = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			for(int j=0;j<m;j++)
			{
				//g++;
				Data d1 = new Data(Integer.parseInt(str[j]));
				if(j+1<m)
					d1.l1.add(Integer.parseInt(str[j+1]));
				if(j!=0)
					d1.priority++;
				int k=0,q=0;
				_temp.addAll(data);
				for(k=0;k<data.size();k++)
				{
					Data temp = _temp.remove();
					if(temp.equals(d1))
					{
						if(j!=0)
							temp.priority++;
						if(j+1<m)
							temp.l1.add(Integer.parseInt(str[j+1]));
						q=1;
						//System.out.println("good");
					}
				}
				if(k==length && q==0)
				{
					length++;
					data.add(d1);
				}	
			}
		}
		_temp.clear();
		
		//System.out.println(length+" "+data.size());
		int size = data.size();
		for(int i=0;i<size;i++)
		{
			//Collections.sort(data);
			Data temp = data.remove();
			System.out.print(temp._data+" ");
			int w = temp.l1.size();
			for(int l=0;l<w;l++)
			{
				int a = temp.l1.poll();
				int loop = data.size();
				_temp.addAll(data) ;
				data.clear();
				for(int k=0;k<loop;k++)
				{
					Data b = _temp.remove();
					if(b._data==a)
					{
						b.priority--;
					}
					data.add(b);
				}
			}
		
			br.close();
		}
	}
}