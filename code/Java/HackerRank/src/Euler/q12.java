package Euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class q12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(),n,max=0;
		
		int[] count = new int[100001];
		
		for(int i=2;i<100001;i++)
		{
			for(int j=i;j<100001;j+=i)
				count[j]++;
		}
		
		ArrayList<Long> data = new ArrayList<Long>();
		ArrayList<Integer> fact = new ArrayList<Integer>();
		
		data.add(1L);
		fact.add(0);
		
		int i=2,power;
		
		while(true)
		{
			if(i%2==0)
				power = (count[i/2]+1) * (count[i+1]+1) -1 ;
			else
				power = (count[i]+1) * (count[(i+1)/2]+1) -1;
			
			long mul = ((long)i*(long)(i+1))/2;
			int fac = power;
			
			if(fac>fact.get(fact.size()-1))
			{
				data.add(mul);
				fact.add(fac);
			}
			if(power>=1000)
				break;
			
			i++;
		}
		
//		for(i=0;i<data.size();i++)
//			System.out.println((i+1)+" "+data.get(i)+" "+fact.get(i));
			
		while(t-->0)
		{
			n =sc.nextInt();
			
			for(i=0;i<fact.size();i++)
			{
				if(n<=fact.get(i))
				{
					System.out.println(data.get(i));
					break;
				}
			}
		}
		
		sc.close();
	}
}
