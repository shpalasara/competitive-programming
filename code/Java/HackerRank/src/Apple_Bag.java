import java.util.*;

public class Apple_Bag {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n,temp=0,_temp,input,count_1=0,count_2=0;
		int[] divide_1 = new int[4];
		int[] divide_2 = new int[4];
		long ans=0;
		n= sc.nextInt();
		while(n-->0)
		{
			input = sc.nextInt();
			if(input%3==0)
				ans+=input;
			else if(input%3==1)
				divide_1[count_1++]=input;
			else
				divide_2[count_2++]=input;
			if(count_1==4)
			{
				Arrays.sort(divide_1);
				ans+=divide_1[1]+divide_1[2]+divide_1[2];
				count_1=1;
			}
			if(count_2==4)
			{
				Arrays.sort(divide_2);
				ans+=divide_2[1]+divide_2[2]+divide_2[3];
				count_2=1;
			}
		}
		
		for(int i=0;i<count_1;i++)
		{
			//int max=0;
			for(int j=i;j<count_1;j++)
			{
				if(divide_1[i]>divide_1[j])
				{
					int t=divide_1[i];
					divide_1[i]=divide_1[j];
					divide_1[j]=t;
				}
					
			}
		}
		
		for(int i=0;i<count_2;i++)
		{
			//int max=0;
			for(int j=i;j<count_2;j++)
			{
				if(divide_2[i]>divide_2[j])
				{
					int t=divide_2[i];
					divide_2[i]=divide_2[j];
					divide_2[j]=t;
				}
					
			}
		}
		if(count_1==3 && count_2==3)
		{
			ans+=divide_1[0]+divide_1[1]+divide_1[2]+divide_2[0]+divide_2[1]+divide_2[2];
		}
		else if(count_1==3 && count_2==0)
		{
			ans+=divide_1[count_1-1]+divide_1[count_1-2]+divide_1[count_1-3];
		}
		else if(count_1==0 && count_2==3)
		{
			ans+=divide_2[count_2-1]+divide_2[count_2-2]+divide_2[count_2-3];
		}
		else if(count_2==1 && count_1>0)
		{
			temp=divide_1[count_1-1]+divide_2[0];
			if(count_1==3)
			{
				if(divide_1[0]+divide_1[1]+divide_1[2]>temp)
					temp=divide_1[0]+divide_1[1]+divide_1[2];
			}
			ans+=temp;
		}
		else if(count_1>=1 && count_2==2)
		{
			if(count_1==3 && divide_1[0]>divide_2[0]+divide_2[1])
				ans+=divide_2[0]+divide_2[1]+divide_1[2]+divide_1[1];
			else
				ans+=divide_1[2]+divide_1[1]+divide_1[0];
		
		}
		else if(count_1==1 && count_2==3)
		{
			ans+=divide_2[2];
			if(divide_2[0]+divide_2[1]<divide_1[0])
				ans+=divide_1[0];
			else
				ans+=divide_2[0]+divide_2[1];
		}
		else if(count_1==2 && count_2==3)
		{
			ans+=divide_2[1]+divide_2[2];
			if(divide_1[0]+divide_1[2]<divide_2[0])
				ans+=divide_2[0];
			else
				ans+=divide_1[0]+divide_1[2];
		}
			
		System.out.println(ans);
		sc.close();
	}
}
