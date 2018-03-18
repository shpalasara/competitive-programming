package cook_off;

// Incomplete

import java.util.Scanner;

public class CHEFIHG {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		String[] data = new String[n];
		
		for(int i=0;i<n;i++)
			data[i] = sc.nextLine();
		
		StringBuilder ans = new StringBuilder("");
		
		int down,left,end;
		int city_x,city_y;
		
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				//if(i!=)
			}
		}
		
		sc.close();
	}

}
