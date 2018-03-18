import java.util.Scanner;

public class Main {

	public static void main(String[] args){

		Scanner sc =new Scanner(System.in);
		int pen,cap;
		int match=0,same_match=0;
		
		pen = sc.nextInt();
		cap = sc.nextInt();
		
		short colour[] = new short[pen+cap];
		short size[] = new short[pen+cap];
		boolean use[] = new boolean[pen+cap];
		
		for(int i=0;i<pen+cap;i++)
		{
			colour[i] = sc.nextShort();
			size[i] = sc.nextShort();
			use[i] = false;
		}
		
		for(int i=0;i<pen;i++)
		{
			for(int j=pen;j<pen+cap;j++)
			{
				if(use[j]==false && colour[i]==colour[j] && size[i]==size[j])
				{
					use[j] = true;
					use[i] = true;
					match++;
					same_match++;
					break;
				}
			}
		}
		
		for(int i=0;i<pen;i++)
		{
			if(use[i]==false)
			{
				for(int j=pen;j<pen+cap;j++)
				{
					if(use[j]==false && size[i]==size[j])
					{
						use[j] = true;
						use[i] = true;
						match++;
						break;
					}
				}
			}
		}
		
		System.out.println(match+" "+same_match);
		sc.close();
	}
}


