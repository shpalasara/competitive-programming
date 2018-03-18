import java.util.*;

public class matrix_rotation {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int M,N,R,temp_R,rotate;
		M=sc.nextInt();
		N=sc.nextInt();
		R=sc.nextInt();
		int[][] data=new int[M][N]; 
		//int[][] out=new int[M][N];
		
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<N;j++)
			{
				data[i][j]=sc.nextInt();
			}
		}
		
		int loop = Math.min(M,N);
		
		for(int i=0;i<loop/2;i++)
		{
			temp_R=2*(M-2*i)+2*(N-2*i)-4;
			int[] temp = new int[temp_R];
			int count=0;
			
			for(int j=i;j<N-i;j++)
				temp[count++]=data[i][j];
			
			for(int j=i+1;j<M-i;j++)
				temp[count++]=data[j][N-i-1];
			
			for(int j=N-i-2;j>=i;j--)
				temp[count++]=data[M-i-1][j];
			
			for(int j=M-i-2;j>i;j--)
				temp[count++]=data[j][i];
			
			int[] temp_out = new int[temp_R];
			if(temp_R<R)
				rotate=R%temp_R;
			else
				rotate=R;
			
			for(int j=0;j<temp_R;j++)
				temp_out[j]=temp[(rotate+j)%temp_R];
			
			//System.out.println("check");
			
			//for(int j=0;j<temp_R;j++)
			//	System.out.print(temp[j]+" ");
			//System.out.println();
			
			//for(int j=0;j<temp_R;j++)
			//	System.out.print(temp_out[j]+" ");
			//System.out.println();
			
			count=0;
			for(int j=i;j<N-i;j++)
				data[i][j]=temp_out[count++];
			
			for(int j=i+1;j<M-i;j++)
				data[j][N-i-1]=temp_out[count++];
			
			for(int j=N-i-2;j>=i;j--)
				data[M-i-1][j]=temp_out[count++];;
			
			for(int j=M-i-2;j>i;j--)
				data[j][i]=temp_out[count++];;
			
		}
		
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
