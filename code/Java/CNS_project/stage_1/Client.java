import java.net.*;
import java.io.*;

public class Client
{
   public static void main(String[] args)
   {
	   if(args.length==1){
		   try{
			   Socket client = new Socket("10.100.90.41", 4454);
			   
			   PrintWriter printWriter = new PrintWriter (client.getOutputStream(), true);
			   
			   printWriter.println(args[0]);
			   
			System.out.println(args[0]+" argument");
			   BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			   
			   System.out.println(br.readLine());
			   
			   
		   }
		   catch(Exception e){
			   System.out.println("exception listen socket "+e);
			   System.exit(1);
		   }
	   }
	   else{
		   System.err.println("Usage: Client <server> <name>");
	   }
	   
	  
   }
}
