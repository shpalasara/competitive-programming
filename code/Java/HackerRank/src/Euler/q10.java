package Euler;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class q10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		boolean[] check = new boolean[1000001];
		ArrayList<Long> prime = new ArrayList<Long>();
		ArrayList<Long> sum = new ArrayList<Long>();
		
		for(int i=2;i<1000001;i++)
		{
			if(!check[i])
			{
				prime.add((long)i);
				
				for(int j=i+i;j<1000001;j+=i)
					check[j] = true;
			}
		}
		
		sum.add(prime.get(0));
		
		for(int i=1;i<prime.size();i++)
			sum.add(sum.get(i-1)+prime.get(i));
		
		int t =sc.nextInt(),n;
		
		while(t-->0)
		{
			n = sc.nextInt();
			
			if(n<2)
				out.println(0);
			else if(n==2)
				out.println(2);
			else
				out.println(sum.get(binary_search(prime,n,0,prime.size()-1)));
		}
		
		out.close();
		sc.close();
	}

	public static int binary_search(ArrayList<Long> data,long val,int si,int ei){
		
		int mid = (si+ei)/2;
		
		if(mid>0 && (data.get(mid)-val)>0 && (val-data.get(mid-1))>=0)
			return (mid-1);
		if(mid+1<=ei && (val-data.get(mid))>=0 && (data.get(mid+1)-val)>0)
			return mid;
		
		if((val-data.get(mid))>0)
			return binary_search( data, val, mid+1, ei);
		else
			return binary_search( data, val, si, mid-1);
	}
	
}
