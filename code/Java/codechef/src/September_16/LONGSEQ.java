package September_16;

//Accepted

import java.util.Scanner;

public class LONGSEQ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine()),length,z,o;
		
		while(n-->0)
		{
			char[] str = sc.nextLine().toCharArray();
			length = str.length;
			z = 0;
			o = 0;
			
			for(int i=0;i<length;i++)
			{
				if(str[i]=='0')
					z++;
				else
					o++;
			}
			
			if(z==1 || o==1)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		sc.close();
	}

}
