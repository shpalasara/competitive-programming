import java.util.*;

public class world_cup_team_formation {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int[] rating = new int[10];
		int ans=0;
		for(int i=0;i<10;i++)
			rating[i]=sc.nextInt();
		Arrays.sort(rating);
		for(int i=0;i<3;i++)
			ans+=rating[9-2*i];
		System.out.println(ans);
		sc.close();
	}
}
