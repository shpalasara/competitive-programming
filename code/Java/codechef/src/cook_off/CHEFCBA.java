package cook_off;

import java.util.Arrays;
import java.util.Scanner;

public class CHEFCBA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] data = new int[4];
		
		for(int i=0;i<4;i++)
			data[i] = sc.nextInt();
		
		Arrays.sort(data);
		
		if((data[1]*data[2]) == (data[0]*data[3]))
			System.out.println("Possible");
		else
			System.out.println("Impossible");
		
		sc.close();
	}

}
