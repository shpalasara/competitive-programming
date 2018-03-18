package stoch_3;

import java.util.*;

public class q1 {

    public static void main(String[] args) {
        
    	int t=100, n = 25;
        double S[] = new double[t];
        double u = 0.18/365, sigma = 0.3/365;
        S[0] = 100;
        Random r = new Random();
       
        for(int i=1;i<t;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(r.nextDouble() < 0.5)
                    count++;
                else count--;
            }
           
            double W = count/Math.sqrt(n);
            S[i] = S[0]*Math.exp(sigma*W + u*i);
        }
       
       for(int i=0;i<t;i++)
    	   System.out.println(i+" "+S[i]);
    }
}
