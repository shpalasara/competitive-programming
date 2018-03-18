import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class read_data {
	
	public static void main(String[] args) throws IOException{
		
		FileInputStream input = new FileInputStream("mahir.txt");
		String str="";
		//byte[] b = new byte[5];
		int ch;
		while((ch=input.read())!=-1)
			str+=(char)ch;
		
		System.out.println(str);
		input.close();
	}
}