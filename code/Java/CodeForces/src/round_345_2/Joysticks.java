package round_345_2;

import java.util.Scanner;

public class Joysticks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a1=sc.nextInt(),a2=sc.nextInt(),ans=0,temp;
		
		while(a1!=0 && a2!=0)
		{
			temp=0;
			if(a1<a2)
			{
				if(a2%2==0)
				{
					temp=(a2/2)-1;
					a2=2;
				}
				else
				{
					temp=a2/2;
					a2=1;
				}
				ans+=temp;
				a1+=temp;
			}
			else
			{
				if(a1%2==0)
				{
					temp=(a1/2)-1;
					a1=2;
				}
				else
				{
					temp=a1/2;
					a1=1;
				}
				a2+=temp;
				ans+=temp;
			}
			
			if(a1==2 && a2<=2)
			{
				ans++;
				a1=0;
				a2++;;
			}
			else if(a1<=2 && a2==2)
			{
				ans++;
				a1++;
				a2=0;
			}
			else if(a1==1 && a2==1)
				break;
			
			//System.out.println(a1+" "+a2);
		}
		
		System.out.println(ans);
		sc.close();
	}

}
