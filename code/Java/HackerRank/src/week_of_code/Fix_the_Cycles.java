package week_of_code;

import java.util.*;

public class Fix_the_Cycles {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),d=sc.nextInt(),e=sc.nextInt(),f=sc.nextInt();
		int x,y,z,p;
		x=a+b+f;
		y=a+b+c+d;
		z=a+e+d;
		
		p=Math.min(x, Math.min(y, z));
		if(p<0)
			p=-p;
		else
			p=0;
		System.out.println(p);
		sc.close();
	}
}
