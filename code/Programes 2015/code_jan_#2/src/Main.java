//Sereja and Votes
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N,temp,total=0,temp1;
		while(T>0)
		{
			temp =0;
			total=0;
			N = sc.nextInt();
			temp1=N;
			//int[] A = new int[N];
			for(int i=0;i<N;i++)
			{
				temp = sc.nextInt();
				if(temp==0)
					temp1--;
				total +=temp;
			}
			
			if(total>=100 && total<100+temp1)
				System.out.println("YES");
			else
				System.out.println("NO");
			T--;
		}
		sc.close();
	}
}
