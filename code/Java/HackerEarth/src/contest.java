import java.util.*;

public class contest {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(),N,max,temp,gold,silver,bronze,g,s,b,madle;
		while(T-->0)
		{
			gold=0;
			silver=0;
			bronze=0;
			max=0;
			N=sc.nextInt();
			for(int i=0;i<N;i++)
			{
				g=sc.nextInt();
				gold+=g;
				temp=g;
				s=sc.nextInt();
				silver+=s;
				temp+=s;
				b=sc.nextInt();
				bronze+=b;
				temp+=b;
				if(max<temp)
					max=temp;
			}
			if(gold>=silver)
			{
				if(bronze>=gold)
					madle=bronze;
				else
					madle=gold;
			}
			else
			{
				if(bronze>=silver)
					madle=bronze;
				else
					madle=silver;
			}
			if(max<madle)
				max=madle;
			System.out.println(max);
		}
		sc.close();
	}
}
