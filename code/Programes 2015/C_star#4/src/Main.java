import java.util.Scanner;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args){
		
		//BufferedReader br = null;
		//br = new BufferedReader(isr);
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int number[] = new int[N];
		int _temp[] = new int[N];
		sc.nextLine();
		//String _temp;
		String str[]  = new String[2];
		int x,length=0;
		int same=0,diff=0;
		int _length=0;
		int temp[] = new int[N];
		int t_length=0;
	
		for(int i=0;i<N;i++)
		{
			int j=0;
			str[0] = sc.nextLine();
			str= str[0].split(" ");
			//_temp = str[0];
			x = Integer.parseInt(str[1]);
			
			if(str[0].charAt(0)=='i')
			{
				number[length] = x;
				length++;
				_length++;
			}
			else if(str[0].charAt(0)=='d')
			{
				while(j<length && x!=number[j])
					j++;
				if(_length==0 && x<0)
				{
					temp[t_length]=x;
					t_length++;
				}
				if(j<length)
				{
					number[j] = -100001;
					_length--;
				}
			}
			
			if(t_length>0 && str[0].charAt(0)=='i')
			{
				int y=0;
				
				for(j=0;j<t_length;j++)
				{
					if(x==temp[j] && y==0)
					{
						number[i] = -100001;
						y++;
					}
					if(y>1)
					{
						temp[j-1] = temp[j];
					}
					y++;
				}
				if(y>0)
					t_length--;
			}
			
			_temp = new int[N];
			//for(j=0;j<length;j++)
				//_temp[j] = number[j];
				//System.out.print(number[j]+" ");
			//data = new int[N];
			//_temp = number;
			
			
			for(j=0;j<length;j++)
			{
				if(_temp[j]==0)
					_temp[j] = number[j];
				int temp1=0;
				if(_temp[j]!=-100001)
				{
					//_temp[j] = number[j];
					
					for(int k=j+1;k<length;k++)
					{	
						if(_temp[j]==number[k] )
						{
							//_temp[j] = -100001;
							_temp[k] = -100001;
							if(temp1==0)
								same++;
							temp1++;
							//break;
						}
					}
					if(temp1==0)
						diff++;
					//else
						//same++;
				}
			}
			
			//for(j=0;j<length;j++)
				//System.out.print(data[j]+" ");
			
			/*for(j=0;j<length && _length!=1;j++)
			{
				if(data[j]==0 )
					diff++;
				else if(data[j]>=1)
					same++;
			}
			*/
			
			if(same>=1 && diff+same>=2)
				System.out.println("Both");
			else if(same>=1)
				System.out.println("OneMany");
			else if(diff+same>=2)
				System.out.println("ManyOne");
			else
				System.out.println("Niether");
			
			diff=0;
			same=0;
		}	
		
		sc.close();
	}

}
