import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer=new StringTokenizer(br.readLine().trim());
		PrintWriter pw = new PrintWriter(System.out);
		double N= Integer.parseInt(tokenizer.nextToken());
		double k = Integer.parseInt(tokenizer.nextToken());
		double output=0;
		for(int i=0;i<N;i++)
		{
			tokenizer=new StringTokenizer(br.readLine().trim());
			double temp1 = Integer.parseInt(tokenizer.nextToken());
			double temp2 = Integer.parseInt(tokenizer.nextToken());
			if(k==1)
			{
				double temp=0;
				for(int j=(int)temp1;j<=temp2;j++)
				{
					if(j==temp1)
					{
						temp = Math.pow(2,j);
						output = (output+temp)%1000000007;
					}	
					else
					{
						temp = (temp*2)%1000000007;
						output = (output+temp)%1000000007; 
					}
					//output = (int)(output%Math.pow(2,j))%1000000007;
					//output %= 1000000007;
					//for(int l=0;l<j;l++)
						//output = (output*2)%1000000007; 
				}
				//if(output>=1000000007)
					
			}
			else
			{
				double[] data = new double[(int)k];
				int counter=0;
				for(int j=(int)temp1;j<=temp2;j++)
				{
					if(j-temp1>=k)
					{
						data[counter] = (data[counter]+data[(int)(counter+k-1)%(int)k])%1000000007;;
						output=(int)(output+data[counter])%1000000007;
					}
					else if(j<k)
					{
						data[counter]=1;
						output= (int)(output+1)%1000000007;
					}
					else if(j==k)
					{
						data[counter]=2;
						output=(int)(output+2)%1000000007;
					}
					else
					{
						int adder=1;
						for(int l=1;l<=j/k;l++)
							adder = (int)(adder+combination(j-(k-1)*l,l))%1000000007;
						output=(output+adder)%1000000007;
						data[counter]=adder;
					}
					counter++;
					counter = counter%(int)k;

					if(output>=1000000007)
						output %= 1000000007;
				}
			}
			pw.println((int)output);
			pw.flush();
			output=0;
		}
	//	pw.close();
		//br.close();
	}
	
	public static double combination(double x,double y)
	{
		double answer=1;
		y = Math.min(y, x-y);
		if(x==y)
			return answer;
		else
		{
			for(int i=0;i<y;i++)
				answer*=(x-i)/(i+1);
			//for(int i=1;i<=y;i++)
				//answer/=i;
			return answer;
		}
	}
}
