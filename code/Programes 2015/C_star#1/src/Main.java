import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int a,b=0;
		a = sc.nextInt();
		int A[] = new int[a];
		for(int i=0;i<a;i++)
		{
			A[b] = sc.nextInt();
			if(A[b]!=-1)
				b++;
		}
		
		b = sc.nextInt();
		int temp;
		int count=0;
		
		for(int j=0;j<b;j++)
		{
			temp = sc.nextInt();
			
			for(int i=count;i<a;i++)
			{
				if(A[i]==-1 || A[i]==0)
				{
					A[i] = temp;
					break;
				}
				if(A[i]>=temp)
				{
					int _temp;
					for(int k=i;k<a-b+j+1;k++)
					{
						_temp = A[k];
						A[k] = temp;
						temp = _temp;
					}
					count=i;
					break;
				}
			}
		}
		
		for(int i=0;i<a;i++)
			System.out.println(A[i]);
		sc.close();
	}
}
