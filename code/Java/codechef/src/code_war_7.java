import java.util.*;

public class code_war_7 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int stop=0;
		//while(true)
		//{
			String input = sc.nextLine();
			String[] word = input.split(" ");
			String temp,temp1;
			if(word[word.length-1].compareToIgnoreCase("done")==0)
			{
				stop=1;
			}
				
			for(int i=0;i<word.length-stop;i++)
			{
				temp="";
				temp1="";
				if(word[i].charAt(0)=='y' || word[i].charAt(0)=='Y' || word[i].charAt(0)=='a' || word[i].charAt(0)=='e' || word[i].charAt(0)=='i' || word[i].charAt(0)=='o' || word[i].charAt(0)=='u' || word[i].charAt(0)=='A' || word[i].charAt(0)=='E' || word[i].charAt(0)=='I' || word[i].charAt(0)=='O' || word[i].charAt(0)=='U')
				{
					if(word[i].charAt(word[i].length()-1)!='.')
						word[i]+="way";
					else 
						word[i]=word[i].substring(0, word[i].length()-1)+"way.";
				}
				else
				{
					int j=0;
					//if(i==0 && word[i].charAt(0)<'a')
						//temp+=(char)((int)word[i].charAt(0)+(int)'a'-(int)'A');
					//else
						temp+=word[i].charAt(0);
					for(j=1;j<word[i].length()-1;j++)
					{
						if(word[i].charAt(j)=='y' || word[i].charAt(j)=='Y' || word[i].charAt(j)=='a' || word[i].charAt(j)=='e' || word[i].charAt(j)=='i' || word[i].charAt(j)=='o' || word[i].charAt(j)=='u'|| word[i].charAt(j)=='A' || word[i].charAt(j)=='E' || word[i].charAt(j)=='I' || word[i].charAt(j)=='O' || word[i].charAt(j)=='U')
						{	
							if(i!=0 && i!=word.length-1-stop)
							{
								word[i]=word[i].substring(j);
								word[i]+=temp+"ay";
								break;
							}
							else if(i==0)
							{
								if(j+1<word[i].length())
									temp1=""+word[i].substring(j+1);
								//if(word[i].charAt(0)<'a')
									//word[i]=""+(char)((int)word[i].charAt(j)-(int)'a'+(int)'A');
								//else
									word[i]=""+word[i].charAt(j);
								word[i]+=temp1+temp+"ay";
								break;
							}
							else
							{
								if(/*j+1<word[i].length() && */word[i].charAt(word[i].length()-1)=='.')
								{
									temp1=""+word[i].substring(j,word[i].length()-2);
									word[i]=temp1+temp+"ay.";
								}
								else //if(j<word[i].length())
								{
									temp1=""+word[i].substring(j);
									word[i]=temp1+temp+"ay";
								}
								break;
							}
						}
						else
							temp+=word[i].charAt(j);
					}
					if(j==word[i].length()-1)
					{
						if(word[i].charAt(word[i].length()-1)=='.')
						{
							String t=word[i].substring(0, word[i].length()-2);
							word[i]=""+word[i].charAt(word[i].length()-2)+t+"ay.";
						}
						else
						{
							String t=word[i].substring(0, word[i].length()-1);
							word[i]=""+word[i].charAt(word[i].length()-1)+t+"ay";
						}
					}
				}
			}
			
			for(int i=0;i<word.length-stop;i++)
				System.out.print(word[i]+" ");
			System.out.println();
			//if(stop==1)
				//break;
		//}
		sc.close();
	}
}
//onoenfway eoinweofbway oubndewbwdnday efdbfbdway efepnway qjhay iqsay bsay efiewfnray
//Intelligent people participate in Aaruush. done 
//Intelligentway eoplepay articipatepay inway Aaruushway
//The game is on. Intelligent people participate in Aaruush. done
//Aaruushway isway away echtay estfay onductedcay ybay MSRay etLay usway ealstay ethay oryglay