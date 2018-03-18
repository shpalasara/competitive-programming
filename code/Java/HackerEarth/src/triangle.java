import java.util.*;

public class triangle {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		float[][] data = new float[3][2];
		float tot_x=0,tot_y=0;
		for(int i=0;i<3;i++)
		{
			data[i][0]=sc.nextFloat();
			tot_x+=data[i][0];
			data[i][1]=sc.nextFloat();
			tot_y+=data[i][1];
		}
		for(int i=0;i<3;i++)
		{
			data[i][0]=tot_x-2*data[i][0];
			data[i][1]=tot_y-2*data[i][1];
		}
		
		java.util.Arrays.sort(data, new java.util.Comparator<float[]>() {

			  public int compare(float[] a, float[] b) {

			    return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));

			  }

			});
		for(int i=0;i<3;i++)
		{
			if(i+1<3 && data[i][0]==data[i+1][0] && data[i][1]>data[i+1][1])
			{
				if(i==0 && data[0][0]==data[2][0] && data[0][1]>data[2][1])
				{
					float temp=data[0][0];
					data[0][0]=data[2][0];
					data[2][0]=temp;
					temp=data[0][1];
					data[0][1]=data[2][1];
					data[2][1]=temp;
				}
				else
				{
					float temp=data[i][0];
					data[i][0]=data[i+1][0];
					data[i+1][0]=temp;
					temp=data[i][1];
					data[i][1]=data[i+1][1];
					data[i+1][1]=temp;
				}
				
				System.out.printf("%.4f %.4f\n",data[i][0],data[i][1]);
			}
			else
				System.out.printf("%.4f %.4f\n",data[i][0],data[i][1]);
		}
		sc.close();
	}
}
