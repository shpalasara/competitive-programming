package May_16;

import java.util.*;
import java.io.*;

public class CHBLLS {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int out;
		System.out.println("1");
		System.out.println("3 1 1 2");
		System.out.println("3 3 3 4");
		System.out.flush();
		out=sc.nextInt();
		
		if(out==0)
		{
			System.out.println("2\n5");
			System.out.flush();
		}
		else if(out==2)
		{
			System.out.println("2\n1");
			System.out.flush();
		}
		else if(out==1)
		{
			System.out.println("2\n2");
			System.out.flush();
		}
		else if(out==-1)
		{
			System.out.println("2\n4");
			System.out.flush();
		}
		else
		{
			System.out.println("2\n3");
			System.out.flush();
		}
		sc.close();
	}
}
