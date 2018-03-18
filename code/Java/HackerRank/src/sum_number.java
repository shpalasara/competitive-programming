import java.util.*;

public class sum_number {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int count=0;
		long start,end,fin_sum,sqre;
		String str,temp;
		start=sc.nextLong();
		end=sc.nextLong();
		for(int i=(int)start;i<=end;i++)
		{
			temp=""+i;
			sqre=(long)i*(long)i;
			str=""+sqre;
			fin_sum=0;
			if(str.length()%2==0)
			{
				fin_sum=Integer.parseInt(str.substring(str.length()-temp.length()));
					//System.out.print(str.substring(str.length()-temp.length()));
				if(str.length()-temp.length()==1)
				{
					fin_sum+=str.charAt(0)-'0';
					//System.out.print(" "+str.charAt(0));
				}
				if(str.length()-temp.length()>1)
				{
					fin_sum+=Integer.parseInt(str.substring(0, str.length()-temp.length()));
					//System.out.print(" "+str.substring(0, str.length()-temp.length()));
				}
			}
			else
			{
				fin_sum=Integer.parseInt(str.substring(str.length()-str.length()/2-1));
					//System.out.print(str.substring(str.length()-temp.length()));
				if(str.length()-str.length()/2-1==1)
				{
					fin_sum+=str.charAt(0)-'0';
					//System.out.print(" "+str.charAt(0));
				}
				if(str.length()-str.length()/2-1>1)
				{
					fin_sum+=Integer.parseInt(str.substring(0, str.length()-str.length()/2-1));
					//System.out.print(" "+str.substring(0, str.length()-temp.length()));
				}
			}
			//System.out.println("  "+fin_sum+" sum");
			if(i==fin_sum)
			{
				System.out.print(i+" ");
				count++;
			}
		}
		if(count!=0)
			System.out.println();
		else
			System.out.println("INVALID RANGE");
		sc.close();
	}
}

//1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 
//1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999
