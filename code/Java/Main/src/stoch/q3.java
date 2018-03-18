package stoch;

import java.util.Random;

public class q3 {

	public static void main(String[] args){
		
		Random rand = new Random();
		int ans=0,x=0,j;
		double temp;
		
		for(int i=0;i<100000;i++)
		{
			for(j=0;j<9;j++)
			{
				temp=rand.nextDouble();
				
				if(temp>0.5)
					x++;
				else 
					x--;
				
				if(x==3)
					break;
			}
			
			if(x==3 && j==8)
				ans++;

			x=0;
		}

		System.out.println("P(t_3==9) "+(double)ans/100000);
	}
}
