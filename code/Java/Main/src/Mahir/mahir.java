package Mahir;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class mahir {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader("/home/shalin/Desktop/compititive_prog/code/Java/Main/src/Mahir/mahir.txt"));
		
		String line;
		while ((line = br.readLine()) != null) {
		    System.out.println(line);
		}
		
		br.close();
//		try {
//			
//			FileOutputStream f1 = new FileOutputStream("mahir.txt");
//			String s = "Hello world.....new world";
//			byte b[] = s.getBytes();
//			
//			f1.write(b);
//			f1.close();
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}
}
