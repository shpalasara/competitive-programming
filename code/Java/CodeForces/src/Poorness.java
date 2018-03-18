import java.util.*;

public class Poorness {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		double avg=0;
		double[] data = new double[n];
		//double copy_max=-100000000,copy_min=100000000;
		//double[] copy = new double[n];
		
		for(int i=0;i<n;i++)
		{
			data[i]=sc.nextDouble();
			avg+=data[i];
			
			//if(avg>copy_max)
			//	copy_max=avg;
			//if(avg<copy_min)
			//	copy_min=avg;
			//copy[i]=avg;
		}
		avg/=n;
		data[0]-=avg;
		
		double max=data[0],min=data[0];
		//System.out.print(data[0]+" ");
		for(int i=1;i<n;i++)
		{
			//System.out.print(data[i]+" ");
			data[i]=data[i]-avg+data[i-1];
			if(data[i]>max)
				max=data[i];
			if(data[i]<min)
				min=data[i];
		}
		//System.out.println();
		//if(Math.abs(copy_max-copy_min)>Math.abs(max-min))
			System.out.printf("%.6f\n",Math.abs(max-min));
		//else
		//	System.out.printf("%.6f\n",Math.abs(copy_max-copy_min));
		sc.close();
	}
}
