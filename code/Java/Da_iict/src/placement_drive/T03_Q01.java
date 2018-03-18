package placement_drive;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class T03_Q01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n=sc.nextInt(),j,size;
		long data;
		ArrayList<Long> list = new ArrayList<Long>();
		StringBuilder str = new StringBuilder("");
		
		//System.out.println("Hii1");
		list.add((long)1);
		
		for(int i=0;i<n;i++)
		{
			data = sc.nextInt();
			
			//if(data!=0)
			{
				j=0;
				size = list.size();
				while(j<size)
				{
					list.add(((long)list.get(j)*(long)data));
					j++;
				}
				list.add(data);
			}
		}
		
		//System.out.println("Hii2");
		Collections.sort(list);
		size=1;
		
		for(int i=1;i<list.size();i++)
		{
			if(list.get(i)-list.get(i-1)!=0)
				size++;
		}
			
		out.println(size);
		out.print(list.get(0)+" ");
		
		for(int i=1;i<list.size();i++)
			if(list.get(i)-list.get(i-1)!=0)
				out.print(list.get(i)+" ");
			
		out.close();
		sc.close();
	}

}
