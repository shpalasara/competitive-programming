import java.util.*;

public class Apple_Bag_2 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),min1_1=1001,min1_2=1001,min2_1=1001,min2_2=1001,temp,counter1=0,counter2=0;
		int sum=0;
		while(n-->0)
		{
			temp=sc.nextInt();
			sum+=temp;
			if(temp%3==1)
			{
				if(temp<min1_1)
				{
					min1_2=min1_1;
					min1_1=temp;
				}
				else if(temp<min1_2)
					min1_2=temp;
				counter1++;
			}
			else if(temp%3==2)
			{
				if(temp<min2_1)
				{
					min2_2=min2_1;
					min2_1=temp;
				}
				else if(temp<min2_2)
					min2_2=temp;
				counter2++;
			}
		}
		/*if(min1_1==1001)
			min1_1=0;
		if(min1_2==1001)
			min1_2=0;
		if(min2_1==1001)
			min2_1=0;
		if(min2_2==1001)
			min2_2=0;*/
		temp=sum%3;
		if(temp==1)
		{
			if(counter2>=2 && min2_1+min2_2<min1_1)
				sum-=min2_1+min2_2;
			else
				sum-=min1_1;
		}
		else if(temp==2)
		{
			if(counter2>0 && min2_1<min1_1+min1_2)
				sum-=min2_1;
			else
				sum-=min1_1+min1_2;
		}
		System.out.println(sum);
		sc.close();
	}
}
