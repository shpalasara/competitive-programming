import java.util.*;

public class encryption {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int row,col;
		row=col=(int)Math.sqrt(input.length());
		if(row*row<input.length())
			row++;
		String[] output = new String[row];
		for(int i=0;i<row;i++)
		{
			output[i]="";
			for(int j=i;j<input.length();j+=row)
				output[i]+=input.charAt(j);
		}
		
		for(int i=0;i<row;i++)
			System.out.print(output[i]+" ");
		
		sc.close();
	}
}
