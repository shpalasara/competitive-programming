import java.util.LinkedList;

public class Data implements Comparable<Data>{

	int _data;
	LinkedList<Integer> l1 = new LinkedList<Integer>();
	int priority=0;
	
	public Data(int data){
		
		_data = data;
		//priority += add_priority; 
	}
	
	public boolean equals(Data other)
	{
		return this._data==other._data;
	}
	
	public int compareTo(Data other)
	{
		if(this.priority==other.priority)
		{
			//String str = (String)this._data;
			if(this._data>other._data)
				return 1;
			else
				return -1;
		}
		else if(this.priority>other.priority)
			return 1;
		else 
			return -1;
	}
}
