package December_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CPLAY {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		FasterScanner br = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int S_A,S_B,T_A,T_B;
		int winner,shots;

		String str;
		
		while((str = br.readLine()) != null) {
			
			int len = str.length();
			
			// 0 represents TEAM-A Win , 1 For TEAM-B win
			winner = -1;
			shots = 0;
			
			S_A = S_B = T_A = T_B = 0;
			for(int i=0;i<len;i++) {
				
				if(i%2==0) {
					if(str.charAt(i)=='1')
						S_A++;
					T_A++;	
				}else {
					if(str.charAt(i)=='1')
						S_B++;
					T_B++;
				}
				
				if(T_A<=5 && T_B<=5) {
					if( (S_A + T_B) > (S_B + 5)) {
						winner = 0;
						shots = i+1;
						break;
					}
					if( (S_B + T_A) > (S_A + 5)) {
						winner = 1;
						shots = i+1;
						break;
					}
				}else if(T_A==T_B) {
					if(S_A > S_B) {
						winner = 0;
						shots = i+1;
						break;
					}
					if(S_A < S_B) {
						winner = 1;
						shots = i+1;
						break;
					}
				}
			}
			
			if(winner!=-1) {
				if(winner==0)
					out.println("TEAM-A "+shots);
				else
					out.println("TEAM-B "+shots);
			}else
				out.println("TIE");
		}
		
		out.close();
	}
}
