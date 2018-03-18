package round_A_17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Country_Leader {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//File file = new File("A-small-practice.in");
		File o1 = new File("Output/out_A_1_l");
		//Scanner sc = new Scanner(file);
		
		BufferedReader br= new BufferedReader(new FileReader("Input/A-large-practice.in"));
		PrintWriter out = new PrintWriter(o1);
		//System.out.println(sc.nextInt());
		
		int t = Integer.parseInt(br.readLine()),n,max,temp_max,t1=0;
		boolean[] count = new boolean[26];
		String ans;
		
		while(t-->0)
		{
			t1++;
			n = Integer.parseInt(br.readLine());
			max = 0;
			ans = "";
			
			while(n-->0)
			{
				temp_max = 0;
				String str = br.readLine();
				
				for(int i=0;i<26;i++)
					count[i] = false;
				
				for(int i=0;i<str.length();i++)
				{
					if(str.charAt(i)!=' ' && !count[(int)str.charAt(i)-'A'])
					{
						temp_max++;
						count[(int)str.charAt(i)-'A']=true;
					}
				}
				
				if(temp_max>max)
				{
					ans = str;
					max = temp_max;
				}
				else if(temp_max==max)
				{
					if(str.compareTo(ans)<0)
						ans = str;
				}
			}
			
			out.println("Case #"+(t1)+": "+ans);
		}
		System.out.println("Done");
		
		out.close();
		br.close();
	}

}
