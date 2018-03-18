import java.util.Comparator;
import java.util.PriorityQueue;

public class Test
{
    public static void main(String[] args)
    {
    	double output=1000000009;
		if(output>=1000000007)
			output %= 1000000007;
    	
    	System.out.println((int)output);
    }
}

