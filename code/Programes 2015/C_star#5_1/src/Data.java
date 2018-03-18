import java.util.LinkedList;

public class Data {

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
}
