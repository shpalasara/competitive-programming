package edu_round_24;

import java.util.Scanner;

public class Diplomas_and_Certificates {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		
		long half = n>>1;
		long dip=0,cert=0,loss=0,temp;

		temp = half/(k+1); 
		if(temp>0)
		{
			dip = temp;
			cert = temp*k;
		}

		loss = n - dip - cert;
		
		System.out.println(dip+" "+cert+" "+loss);
		
		sc.close();
	}
}
