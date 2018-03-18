import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

	public static void main(String[] args) throws Exception{
		
		//Scanner sc = new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//sc.nextLine();
		int[] A = new int[N];
		int diff=0,same=0;
		int temp=0,x,length=0;
		String[] str;
		
		for(int i=0;i<N;i++)
		{
			str = br.readLine().split(" ");
			x = Integer.parseInt(str[1]);
			temp=0;
			
			if(str[0].charAt(0)=='i')
			{
				A[length] = x;
				++length;
				
					if(length>1 && A[length-1]!=A[length-2])
						++diff;
					for(int k=length-2;length>1 && k>=0;k--)
						if(A[length-1] == A[k])
						{
							++same;
							break;
						}
			}
			else if(str[0].charAt(0)=='d')
			{
				for(int j=0;j<length;j++)
				{
					if(A[j] == x && temp==0)
					{
						if(j!=0 && A[j]!=A[j-1])
							diff--;
						if(j+1<length && A[j+1]!=A[j])
							diff--;
						if(j+1<length && j!=0 && A[j+1]!=A[j-1])
							diff++;
						temp=1;
						--length;
					}
					else if(x==A[j] && temp==1)
					{
						--same;
						temp=2;
					}
					if(temp!=0)
						A[j] = A[j+1];
					
				}
			}
			if(length==1)
				diff=0;
			
			//System.out.println(same+"  "+diff);
			//for(int j=0;j<length;j++)
				//System.out.print(A[j]+" ");
			
			
			if(same>=1 && diff>=1)
				System.out.println("Both");
			else if(same>=1)
				System.out.println("OneMany");
			else if(diff>=1)
				System.out.println("ManyOne");
			else
				System.out.println("Niether");
		}
		br.close();
	}

	//private static Reader new_InputStreamReader(InputStream in) {
		// TODO Auto-generated method stub
		//return null;
	//}
}
