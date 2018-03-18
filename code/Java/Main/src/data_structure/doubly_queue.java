package data_structure;

import java.util.ArrayList;
import java.util.List;

public class doubly_queue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		
		public int[] data;
		public int s_i,e_i,size;
		public static int Def_size = 100001;

		public void reset(){
			
			data = new int[Def_size];
			s_i=0;
			e_i=0;
			size=0;
		}
		
		public boolean isEmpty(){
			
			if(size<=0)
				return true;
			return false;
		}
		
		public void push_back(int element){
			
			data[e_i++]=element;
			size++;
			e_i = e_i%Def_size;
		}
		
		public int pop_back(){
			
			e_i--;
			if(e_i<0)
				e_i+=Def_size;
			size--;
			return data[e_i];
		}
		
		public int get_back(){
			
			return data[e_i-1];
		}
		
		public int pop_front(){
			
			int index = s_i;
			s_i = (s_i+1)%Def_size;
			size--;
			if(size == 0)
				e_i = s_i;
			return data[index];
		}
		
		public int get_front(){
			
			return data[s_i];
		}
	
}

// Update

/*	private List<Integer> deque;
	
	private void reset(){
		
		deque= new ArrayList<Integer>();
	}
	
	private boolean isEmpty(){
		
		return deque.isEmpty();
	}
	
	private void puch_front(int element){
		
		deque.add(0,element);
	}
	
	private void push_back(int element){
		
		deque.add(element);
	}
	
	private int pop_back(){
		
		return deque.remove(deque.size()-1);
	}
	
	public int get_back(){
		
		return deque.get(deque.size()-1);
	}
	
	public int pop_front(){
		
		return deque.remove(0);
	}
	
	public int get_front(){
		
		return deque.get(0);
	}*/
