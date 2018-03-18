package round_A_17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Rain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File o1 = new File("Output/out_A_1_l");
		BufferedReader br= new BufferedReader(new FileReader("Input/A-large-practice.in"));
		PrintWriter out = new PrintWriter(o1);
		
		int t = Integer.parseInt(br.readLine()),r,c;
		
		while(t-->0)
		{
			String[] str = br.readLine().split(" ");
			r = Integer.parseInt(str[0]);
			c = Integer.parseInt(str[1]);
			
			int[][] h = new int[r][c];
			
			
			for(int i=0;i<r;i++)
			{
				String[] temp = br.readLine().split(" ");
				
				for(int j=0;j<c;j++)
					h[i][j] = Integer.parseInt(temp[j]);
			}
			
			
		}
		
		out.close();
		br.close();
	}

}

class pair{
	
	int i,j,value;
	
	
}