package round_355_2;

import java.util.Scanner;

public class Vanya_and_Label {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		long[] perm = new long[64];
		int ones,temp;
		long[][] nCr = new long[7][7];
		
		for(int i=0;i<7;i++)
		{
			nCr[0][i] = 0;
			nCr[i][0] = 1;
		}	
		
		for(int i=1;i<7;i++)
			for(int j=1;j<7;j++)
				nCr[i][j] = nCr[i-1][j] + nCr[i-1][j-1];
		
		
		for(int i=0;i<64;i++)
		{
			ones=0;
			temp = i;
			
			while(temp!=0)
			{
				if(temp%2==1)
					ones++;
				temp = temp>>1;
			}
			
			for(int j=0;j<=(6-ones);j++)
			{
				temp = 1<<(6-ones-j);
				perm[i] = (perm[i]+ nCr[6-ones][j]*temp)%1000000007;
			}
		}
		
		//System.out.println(perm[61]);
		
		long ans=1;
		
		for(int i=0;i<str.length();i++)
		{
			if((int)str.charAt(i)>=(int)'0' && str.charAt(i)<=(int)'9')
				ans = (ans *perm[str.charAt(i)-'0'])%1000000007;
			else if((int)str.charAt(i)>=(int)'A' && str.charAt(i)<=(int)'Z')
				ans = (ans*perm[str.charAt(i)-'A'+10])%1000000007;
			else if((int)str.charAt(i)>=(int)'a' && str.charAt(i)<=(int)'z')
				ans = (ans*perm[str.charAt(i)-'a'+36])%1000000007;
			else if(str.charAt(i)=='-')
				ans = (ans*perm[62])%1000000007;
			else if(str.charAt(i)=='_')
				ans = (ans*perm[63])%1000000007;
		}
		//ans = ans<<1;
		//ans = (ans-1)%1000000007;
		
		if(ans<0)
			ans+=1000000007;
		
		System.out.println(ans);
		sc.close();
	}

}
