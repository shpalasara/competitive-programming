import java.util.*;

public class tithi_code {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int t;
		System.out.println("How many data you want to convert : ");
		t=sc.nextInt();
		System.out.println("User manual :(Number relation with prefixes)");
		System.out.println(" 0)Normal 10^0\n 1) deca 10^1 \t 11) deci 10^-1\n 2) hecto 10^2 \t 12) centi 10^-2\n 3) kilo 10^3 \t 13) milli 10^-3\n 4) mega 10^6 \t 14) micro 10^-6\n 5) giga 10^9 \t 15) nano 10^-9\n 6) tera 10^12 \t 16) pico 10^-12\n 7) peat 10^15 \t 17) femto 10^-15\n 8) exa 10^18 \t 18) atto 10^-18\n 9) zetta 10^21 \t 19) zepto 10^-21\n 10) yotta 10^24 \t 20) yocto 10^-24\n");
		int[] arr = {0,1,2,3,6,9,12,15,18,21,24,-1,-2,-3,-6,-9,-12,-15,-18,-21,-24};
		
		
		int ini_unit,fin_unit;
		double data,ans;
		
		while(t-->0)
		{
			System.out.println("Enter the data:");
			data=sc.nextDouble();
			
			System.out.println("Enter the unit number of your data:");
			ini_unit=sc.nextInt();
			System.out.println("Enter the unit number in which you want to convert your data:");
			fin_unit=sc.nextInt();
			
			ans=data*Math.pow(10, arr[fin_unit]-arr[ini_unit]);
			
			System.out.println(ans);
		}
		sc.close();
	}
}
