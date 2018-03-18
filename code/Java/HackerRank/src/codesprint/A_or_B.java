package codesprint;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;

public class A_or_B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int q=Integer.parseInt(sc.nextLine()),k,temp_k,extra=0;
		String A,B,C,a_b,b_b,c_b,t_a,t_b;
//		String ans_a,ans_b;
		
		HashMap<String,String> hm_h = new HashMap<String,String>();
		HashMap<String,String> hm_b = new HashMap<String,String>();
		
		hm_h.put("0", "0000");
		hm_h.put("1", "0001");
		hm_h.put("2", "0010");
		hm_h.put("3", "0011");
		hm_h.put("4", "0100");
		hm_h.put("5", "0101");
		hm_h.put("6", "0110");
		hm_h.put("7", "0111");
		hm_h.put("8", "1000");
		hm_h.put("9", "1001");
		hm_h.put("A", "1010");
		hm_h.put("B", "1011");
		hm_h.put("C", "1100");
		hm_h.put("D", "1101");
		hm_h.put("E", "1110");
		hm_h.put("F", "1111");
		
		hm_b.put("0000" , "0");
		hm_b.put("0001" , "1");
		hm_b.put("0010" , "2");
		hm_b.put("0011" , "3");
		hm_b.put("0100" , "4");
		hm_b.put("0101" , "5");
		hm_b.put("0110" , "6");
		hm_b.put("0111" , "7");
		hm_b.put("1000" , "8");
		hm_b.put("1001" , "9");
		hm_b.put("1010" , "A");
		hm_b.put("1011" , "B");
		hm_b.put("1100" , "C");
		hm_b.put("1101" , "D");
		hm_b.put("1110" , "E");
		hm_b.put("1111" , "F");
		
		while(q-->0)
		{
			k = Integer.parseInt(sc.nextLine());
			temp_k=0;
			
			A = sc.nextLine();
			B = sc.nextLine();
			C = sc.nextLine();
			
//			a_b = make_binary(A,hm_h);
//			b_b = make_binary(B,hm_h);
//			c_b = make_binary(C,hm_h);
			
//			ans_a = "";
//			ans_b = "";
			
			StringBuilder ans_a = new StringBuilder("");
			StringBuilder ans_b = new StringBuilder("");
			
			if(k>=8*A.length())
			{
				out.println("0");
				out.println(C);
			}
			else
			{
				for(int i=0;i<A.length();i++)
				{
					a_b = hm_h.get(A.charAt(i)+"");
					b_b = hm_h.get(B.charAt(i)+"");
					c_b = hm_h.get(C.charAt(i)+"");
					
					for(int j=0;j<4;j++)
					{
						if(c_b.charAt(j)=='0')
						{
							temp_k+=a_b.charAt(j)-'0';
							temp_k+=b_b.charAt(j)-'0';
						}
						else
						{
							if(a_b.charAt(j)=='0' && b_b.charAt(j)=='0')
								temp_k++;
						}
					}
				}
				
				if(temp_k<=k)
				{
					extra = k-temp_k;
					
					for(int j=0;j<C.length();j++)
					{
						a_b = hm_h.get(A.charAt(j)+"");
						b_b = hm_h.get(B.charAt(j)+"");
						c_b = hm_h.get(C.charAt(j)+"");
						
						t_a = "";
						t_b = "";
						
						for(int i=0;i<4;i++)
						{
							if(c_b.charAt(i)=='0')
							{
								t_a+="0";
								t_b+="0";
							}
							else
							{
								if(a_b.charAt(i)=='1')
								{
									if(b_b.charAt(i)=='1')
									{
										t_b+="1";
										if(extra>0)
										{
											t_a+="0";
											extra--;
										}
										else
											t_a+="1";
									}
									else
									{
										if(extra>1)
										{
											t_a+="0";
											t_b+="1";
											extra-=2;
										}
										else
										{
											t_a+="1";
											t_b+="0";
										}
									}
								}
								else
								{
									t_a+="0";
									t_b+="1";
								}
							}
						}
						
						ans_a.append(hm_b.get(t_a));
						ans_b.append(hm_b.get(t_b));
					}
					
//					String a1 = make_hexa(ans_a,hm_b);
//					String a2 = make_hexa(ans_b,hm_b);
					
					String a1 = ans_a.toString();
					String b1 = ans_b.toString();
					
					int i_i=0;
					while(i_i<a1.length() && a1.charAt(i_i)=='0')
						i_i++;
					
					if(i_i<a1.length())
						a1 = a1.substring(i_i);
					else
						a1 = "0";
					
					i_i=0;
					while(i_i<b1.length() && b1.charAt(i_i)=='0')
						i_i++;
					
					if(i_i<b1.length())
						b1 = b1.substring(i_i);
					else
						b1 = "0";
					
					out.println(a1);
					out.println(b1);
				}
				else
					out.println("-1");
			}
		}
		
		out.close();
	}

	static class FasterScanner {
		 
        private byte[] buf = new byte[8192];
        private int curChar;
        private int numChars;
 
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = System.in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
 
        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }
 
        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
 
        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
 
        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}


//public static String make_binary(String hexa,HashMap<String, String> hm)
//{
//	String binary="";
//	
//	for(int i=0;i<hexa.length();i++)
//		binary+=hm.get(""+hexa.charAt(i));
//	
//	return binary;
//}
//
//public static String make_hexa(String binary,HashMap<String, String> hm)
//{
//	String hexa="";
//	
//	for(int i=0;i<binary.length();i+=4)
//		hexa+=hm.get(binary.subSequence(i, i+4));
//	
//	return hexa;
//}

//public static String make_binary(String hexa){
//	
//	String a_b = "";
//	
//	for(int i=0;i<hexa.length();i++)
//	{
//		switch(hexa.charAt(i))
//		{
//			case '0':
//			{
//				a_b+="0000";
//				break;
//			}
//			case '1':
//			{
//				a_b+="0001";
//				break;
//			}
//			case '2':
//			{
//				a_b+="0010";
//				break;
//			}
//			case '3':
//			{
//				a_b+="0011";
//				break;
//			}
//			case '4':
//			{
//				a_b+="0100";
//				break;
//			}
//			case '5':
//			{
//				a_b+="0101";
//				break;
//			}
//			case '6':
//			{
//				a_b+="0110";
//				break;
//			}
//			case '7':
//			{
//				a_b+="0111";
//				break;
//			}
//			case '8':
//			{
//				a_b+="1000";
//				break;
//			}
//			case '9':
//			{
//				a_b+="1001";
//				break;
//			}
//			case 'A':
//			{
//				a_b+="1010";
//				break;
//			}
//			case 'B':
//			{
//				a_b+="1011";
//				break;
//			}
//			case 'C':
//			{
//				a_b+="1100";
//				break;
//			}
//			case 'D':
//			{
//				a_b+="1101";
//				break;
//			}
//			case 'E':
//			{
//				a_b+="1110";
//				break;
//			}
//			case 'F':
//			{
//				a_b+="1111";
//				break;
//			}
//			default :
//			{
//				a_b+="";
//				break;
//			}
//		}
//	}
//	
//	return a_b;
//}
//
//public static String make_hexa(String binary){
//	
//	String hexa="",temp;
//	
//	for(int i=0;i<binary.length();i+=4)
//	{
//		temp = binary.substring(i, i+4);
//		
//		switch(temp)
//		{
//			case "0000":
//			{
//				hexa+="0";
//				break;
//			}
//			case "0001":
//			{
//				hexa+="1";
//				break;
//			}
//			case "0010":
//			{
//				hexa+="2";
//				break;
//			}
//			case "0011":
//			{
//				hexa+="3";
//				break;
//			}
//			case "0100":
//			{
//				hexa+="4";
//				break;
//			}
//			case "0101":
//			{
//				hexa+="5";
//				break;
//			}
//			case "0110":
//			{
//				hexa+="6";
//				break;
//			}
//			case "0111":
//			{
//				hexa+="7";
//				break;
//			}
//			case "1000":
//			{
//				hexa+="8";
//				break;
//			}
//			case "1001":
//			{
//				hexa+="9";
//				break;
//			}
//			case "1010":
//			{
//				hexa+="A";
//				break;
//			}
//			case "1011":
//			{
//				hexa+="B";
//				break;
//			}
//			case "1100":
//			{
//				hexa+="C";
//				break;
//			}
//			case "1101":
//			{
//				hexa+="D";
//				break;
//			}
//			case "1110":
//			{
//				hexa+="E";
//				break;
//			}
//			case "1111":
//			{
//				hexa+="F";
//				break;
//			}
//			default :
//			{
//				hexa+="";
//				break;
//			}
//		}
//	}
//	
//	return hexa;
//}

