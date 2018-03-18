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
		long add=0;
		long[] data = new long[(int)k];
		long output=0;
		for(int i=0;i<N;i++)
		{
			tokenizer=new StringTokenizer(br.readLine().trim());
			double temp1 = Integer.parseInt(tokenizer.nextToken());
			double temp2 = Integer.parseInt(tokenizer.nextToken());
			if(k==1)
			{
				for(int j=(int)temp1;j<=temp2;j++)
					output += Math.pow(2,j);
			}
			else
			{
				long adder=0;
				data = new long[(int) k];
				for(int j=(int)temp1;j<=temp2;j++)
				{
					if(j>temp1+k-1 /*&& j-temp1>2*k && add==0*/)
					{
						System.out.println("good");
						adder = data[0]+data[(int)k-1];
						for(int l=0;l<k-1;l++)
							data[l] = data[l+1];
						data[(int)k-1] = adder;
						output+=adder;
					}
					else if(j<k)
					{
						adder=1;
						output++;
						data[(int) add] = 1;
						add+=1;
						add =add%(int)k;
					}
					else if(j==k)
					{			
						adder=2;
						output+=2;
						data[(int) add] = 2;
						add+=1;
						add =add%(int)k;
					}
					//else if()
					else
					{
						adder=1;
						//output++;
						//System.out.println("good1");
						for(int l=1;l<=j/k;l++)
						{
						//	adder=1;
						//	for(int m=1;m<=l;m++)
						//	{
						//		if(j!=m*l)
						//			adder*=j-(k-1)*l-m+1;
						//	}
						//	for(int m=1;m<=l;m++)
						//		adder/=m;
								
							
							adder += combination((int)(j-(k-1)*l),l);
							//System.out.print("adder"+adder+" ");
						}
						data[(int) add] = adder%1000000007;
						add+=1;
						add =add%(int)k;
						output +=adder;
					}
					//for(int l=0;l<k;l++)
						//System.out.println(data[l]);
					//System.out.println(adder);
				}
			}
			if(output>=1000000007)
				output = output%1000000007;
			pw.println((int)output);
			pw.flush();
			output=0;
		}
	//	pw.close();
		br.close();
	}
	
	public static long combination(long x,long y)
	{
		long answer=1;
		y = Math.min(y, x-y);
		//System.out.println(x+" "+y);
		if(y==0)
			return answer;
		else
		{
			for(int i=1;i<=y;i++)
				answer=answer*(x-i+1)/i;
			//System.out.print("an "+answer);
			//for(int i=1;i<=y;i++)
				//answer/=i;
			//System.out.println("   "+answer);
			return answer;
		}
	}
}
