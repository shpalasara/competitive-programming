package May_16;

import java.util.*;

public class CHEFMATH {

	static long[] fib = new long[45];
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		long q=(long)sc.nextInt(),x;
		int count,k,size,i;
		fib[0]=1;
		fib[1]=2;
		
		for(i=2;i<45;i++)
			fib[i]=fib[i-1]+fib[i-2];
		
		Map<String,Integer> hm = new HashMap<String,Integer>();
		Map<String,Integer> hm1 = new HashMap<String,Integer>();
		PriorityQueue<String> queue1 = new PriorityQueue<String>();
		PriorityQueue<String> queue2 = new PriorityQueue<String>();
		
		String str,temp,_new;
		//x=15;
		//k=5;
		
		while(q-->0)
		{
			//x++;
			//System.out.println(x+" "+k);
			x=(long)sc.nextInt();
			k=sc.nextInt();
			
			String[] data = generate_Zekendrof(x,k).split(" ");
			
			str = data[0];
			count = Integer.parseInt(data[1]);
			
			if(count>k)
				System.out.println("0");
			else
			{
				//System.out.println(str);
				queue1.add(str);
				
				hm.put(str, 1);
				
				for(i=count;i<k;i++)
				{
					hm.clear();
					size=queue1.size();
					
					if(size<=0)
						break;
					
					//System.out.println();
					
					for(int j=0;j<size;j++)
					{
						temp = queue1.poll();
						
						for(int l=0;l<temp.length()-1;l++)
						{
							_new = "";
							
							if((int)(temp.charAt(l)-'0')>0)
							{
								if(l+2<temp.length())
								{
									if(l!=0)
										_new = temp.substring(0, l)+(""+(char)(temp.charAt(l)-1))+(""+(char)(temp.charAt(l+1)+1))+(""+(char)(temp.charAt(l+2)+1));
									else
										_new = (""+(char)(temp.charAt(l)-1))+(""+(char)(temp.charAt(l+1)+1))+(""+(char)(temp.charAt(l+2)+1));
									
									if(l+3<temp.length())
										_new +=temp.substring(l+3);
								}
								else
								{
									if(l!=0)
										_new = temp.substring(0, l)+(""+(char)(temp.charAt(l)-1))+(""+(char)(temp.charAt(l+1)+2));
									else
										_new = (""+(char)(temp.charAt(l)-1))+(""+(char)(temp.charAt(l+1)+2));
								}
								
								if(hm.isEmpty() || !hm.containsKey(_new))
								{
									queue2.add(_new);
									hm.put(_new,1);
									//System.out.println(x+" "+(i+1)+" !"+_new+"!");
								}
								
							}
						}
					}
					
					//System.out.println("size "+queue1.size());
					
					//queue1.clear();
					
					if(queue2.size()>0)
						queue1.addAll(queue2);
					else
					{
						hm.clear();
						break;
					}
					
					queue2.clear();
				}
				
				//System.out.println(hm.size());
				
				if(i==k || count==k)
				{
					//System.out.println("special case");

					hm1.clear();
					size=queue1.size();
					if(size<=0)
						break;
					
					//System.out.println(size);
					
					for(int j=0;j<size;j++)
					{
						temp = queue1.poll();
						//System.out.println("check "+temp);
						
						for(int l=0;l<temp.length()-1;l++)
						{
							_new = "";
							
							if((int)(temp.charAt(l)-'0')>0)
							{
								//System.out.println("in1");
								if(l+2<temp.length())
								{
									if(l!=0)
										_new = temp.substring(0, l)+(""+(char)(temp.charAt(l)-1))+(""+(char)(temp.charAt(l+1)+1))+(""+(char)(temp.charAt(l+2)+1));
									else
										_new = (""+(char)(temp.charAt(l)-1))+(""+(char)(temp.charAt(l+1)+1))+(""+(char)(temp.charAt(l+2)+1));
									
									if(l+3<temp.length())
										_new +=temp.substring(l+3);
								}
								else
								{
									if(l!=0)
										_new = temp.substring(0, l)+(""+(char)(temp.charAt(l)-1))+(""+(char)(temp.charAt(l+1)+2));
									else
										_new = (""+(char)(temp.charAt(l)-1))+(""+(char)(temp.charAt(l+1)+2));
								}
								
								if(!hm1.isEmpty() && hm1.containsKey(_new))
									continue;
								
								hm1.put(_new, 1);
								for(int m=_new.length()-1;m>1;m--)
								{
									if(m==_new.length()-1 && (int)(_new.charAt(m)-'0')>1)
									{
										str = _new.substring(0, m-1) + (""+(char)(_new.charAt(m-1)+1))+(""+(char)(_new.charAt(m)-2));
										
										if(hm.isEmpty() || !hm.containsKey(str))
										{
											size++;
											queue1.add(str);
											//queue2.add();
											hm.put(str,1);
											//System.out.println(x+" "+k+" !"+str+"!");
										}
									}
										
									if((int)(_new.charAt(m)-'0')>0 && (int)(_new.charAt(m-1)-'0')>0)
									{
										str = _new.substring(0, m-2) + (""+(char)(_new.charAt(m-2)+1))+(""+(char)(_new.charAt(m-1)-1))+(""+(char)(_new.charAt(m)-1))+_new.substring(m+1);

										if(hm.isEmpty() || !hm.containsKey(str))
										{
											size++;
											queue1.add(str);
											//queue2.add();
											hm.put(str,1);
											//System.out.println(x+" "+k+" !"+str+"!");
										}
									}
								}
							}
						}
					}
				}
				
				System.out.println(hm.size()%1000000007);
				queue1.clear();
				queue2.clear();
				hm.clear();
			}
		}
		sc.close();
	}
	
	public static String generate_Zekendrof(long x,long k){
		
		String out="";
		int count=0,i=0,length=0;
		
		while(x>=fib[i])
			i++;
		
		length=i;
		i--;
		x-=fib[i];
		out+="1";
		count++;
	
		while(x<fib[i] && i>0)
		{
			if(x>=fib[i-1])
			{
				x-=fib[i-1];
				out+="1";
				count++;
			}
			else
				out+="0";
			
			i--;
		}
		
		if(count>k)
			out="b";
		
		return (out+" "+count);
	}
}
