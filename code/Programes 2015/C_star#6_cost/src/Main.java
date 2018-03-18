import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.io.PrintWriter;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer tokenizer=new StringTokenizer(br.readLine().trim());
		//PrintWriter pw = new PrintWriter(System.out);
		int T = Integer.parseInt(/*tokenizer.nextToken()*/br.readLine());
		//System.out.println(T);
		int N,K,temp,output=-1;
		for(int i=0;i<T;i++)
		{
			String[] _temp = br.readLine().split(" ");
			//tokenizer=new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(/*tokenizer.nextToken()*/_temp[0]);
			K = Integer.parseInt(/*tokenizer.nextToken()*/_temp[1]);
			String[] str = br.readLine().split(" ");
			for(int j=0;j<K;j++)
			{
				
				//tokenizer=new StringTokenizer(br.readLine().trim());
				temp = Integer.parseInt(str[j]);
				//System.out.println(temp);
				if(temp!=-1 && K%(j+1)==0 && ((K/(j+1))*temp<output || output==-1))
					output = temp*(K)/(j+1);
			}
			System.out.println(output);
			//pw.println(output);
			//pw.flush();
			output=-1;
		}
		br.close();
	}
}
