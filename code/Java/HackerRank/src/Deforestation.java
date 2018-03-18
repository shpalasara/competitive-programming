import java.util.ArrayList;
import java.util.Scanner;


public class Deforestation {

	/**
	 * @param args
	 */
	public static ArrayList<ArrayList<Integer>> graph;
	//public static ArrayList<Node> node;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(),n,u,v;
		
		while(t-->0)
		{
			n = sc.nextInt();
			graph = new ArrayList<ArrayList<Integer>>();
			//node = new ArrayList<Node>();
			
//			for(int i=0;i<n;i++)
//				node.add(new Node(i));
			
			for(int i=0;i<n;i++)
				graph.add(new ArrayList<Integer>());

			for(int i=0;i<n-1;i++)
			{
				u = sc.nextInt()-1;
				v = sc.nextInt()-1;
				
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			
			if(dfs(0,-1)==0)
				System.out.println("Bob");
			else
				System.out.println("Alice");
		}
		sc.close();
	}
	
	public static int dfs(int n_index,int parent){
		
		int ans=0;
		
		for(int i=0;i<graph.get(n_index).size();i++)
		{
			if(graph.get(n_index).get(i)!=parent)
				ans = ans^(1+dfs(graph.get(n_index).get(i),n_index));
//			if(!node.get(graph.get(n_index).get(i)).check)
//			{
//				
//			}
		}
		
		return ans;
	}
	
//	public static class Node {
//		
//		int index;
//		boolean check;
//		
//		public Node(int i){
//			index = i;
//			check = false;
//		}
//	}
}

