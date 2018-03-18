package Euler;

import java.util.ArrayList;
import java.util.Scanner;

public class q7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt(),n;
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean[] check = new boolean[1000001];
		
		for(int i=2;i<1000001;i++)
		{
			if(!check[i])
			{
				list.add(i);
				for(int j=i+i;j<1000001;j+=i)
					check[j] = true;
			}
			
			if(list.size()>10000)
				break;
		}
		
		while(t-->0)
		{
			n = sc.nextInt()-1;
			System.out.println(list.get(n));
		}
		
		sc.close();
	}

}
