package placement_drive;

import java.io.PrintWriter;
import java.util.Scanner;

public class T04_Q01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt(),lines;
		lines = 4*n-1;
		String[] data = new String[2*n];
		
		StringBuilder str = new StringBuilder("");
		
		for(int i=0;i<lines;i++)
		{
			if(i==lines/2)
				str.append('x');
			else
				str.append('.');
		}
		
		out.println(str.toString());
		data[0] = str.toString();
		
		for(int i=1;i<2*n;i++)
		{
			str = new StringBuilder("");
			
			for(int j=0;j<lines;j++)
			{
				if(j==0)
				{
					if(data[i-1].charAt(j+1)=='x')
						str.append('x');
					else
						str.append('.');
				}
				else if(j==lines-1)
				{
					if(data[i-1].charAt(j-1)=='x')
						str.append('x');
					else
						str.append('.');
				}
				else
				{
					if(data[i-1].charAt(j+1)=='x' || data[i-1].charAt(j-1)=='x')
						str.append('x');
					else
						str.append('.');
				}
			}
			
			data[i]= str.toString();
			out.println(data[i]);
		}
		
		for(int i=2*n-2;i>=0;i--)
			out.println(data[i]);
		
		out.close();
	}

}
