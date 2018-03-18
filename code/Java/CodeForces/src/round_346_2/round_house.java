package round_346_2;

import java.util.Scanner;

public class round_house {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	int n=sc.nextInt(),a=sc.nextInt(),b=sc.nextInt();
	if(b<0)
	{
		b=Math.abs(b)%n;
		b=0-b;
	}
	else
		b=b%n;
		
	if(b<0)
	{
		b=n+b;
	}
	int sum=a+b;
	sum=sum%n;
	if(sum!=0)
	{
		
	System.out.println(sum);
	}
	else
		System.out.println(n);
	}

}
