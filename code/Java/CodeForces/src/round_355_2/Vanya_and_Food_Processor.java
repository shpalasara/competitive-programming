package round_355_2;

import java.util.Scanner;

public class Vanya_and_Food_Processor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long h=sc.nextInt(),k=sc.nextInt(),time=0,temp=0;
		long[] data = new long[n];
		
		for(int i=0;i<n;i++)
			data[i]=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			temp += data[i];
			time += temp/k;
			
			temp = temp%k;
			
			if(temp>0)
			{
				if(i+1<n)
				{
					if(data[i+1]+temp>h)
					{
						time++;
						temp=0;
					}
				}
				else
					time++;
			}
		}
		System.out.println(time);
		
		sc.close();
	}

}
