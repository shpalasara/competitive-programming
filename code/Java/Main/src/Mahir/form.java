package Mahir;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class form extends JFrame{
	JFrame f1;            
		public form() {
			String name="     "+"\u0AA8"+"\u0ABE"+"\u0AAE";
			String city = "     "+"\u0AB6"+"\u0AB9"+"\u0AC7"+"\u0AE8";
			String state = "     "+"\u0AB0"+"\u0ABE"+"\u0A9C"+"\u0ACD"+"\u0AAF";
			String email = "     "+"\u0a87"+"-"+"\u0aae"+"\u0ac7"+"\u0a87"+"\u0ab2";
			String close = "\u0aac"+"\u0A82"+"\u0aa7"+" "+"\u0a95"+"\u0AB0"+"\u0ab5"+"\u0ac1";
			String save="\u0ab8"+"\u0ABE"+"\u0a9a"+"\u0ab5"+"\u0ab5"+"\u0ac1";
			String update = "\u0aac"+"\u0aa6"+"\u0ab2"+"\u0ab5"+"\u0ac1";
			System.out.println(name+" "+ city+" "+state+" "+email+" "+close+" "+save+" "+update );
		  f1=new JFrame("Simple form");    
		  JLabel JL=new JLabel(name);    
		  JLabel JL1=new JLabel(city);    
		  JLabel JL2=new JLabel(state);
		  JLabel JL3=new JLabel(email);    
		  
		  JTextField JF=new JTextField(100);    
		  JTextField JF1=new JTextField(100);    
		  JTextField JF2=new JTextField(100);    
		  JTextField JF3=new JTextField(100);
		  
		  JButton b=new JButton(close);    
		  JButton b1=new JButton(save);        
		  JButton b3=new JButton(update);           
		  
		  JPanel p1=new JPanel();    
		  JPanel p2=new JPanel();    
		  
		  GridLayout gl42=new GridLayout(4,2);    
		  GridLayout gl21=new GridLayout(2,1);    
		  FlowLayout fl=new FlowLayout();    
		  
		  p1.setLayout(gl42);    
		  p1.add(JL);    
		  p1.add(JF);    
		  p1.add(JL1);    
		  p1.add(JF1);    
		  p1.add(JL2);    
		  p1.add(JF2);    
		  p1.add(JL3);    
		  p1.add(JF3);   
		  
		  p2.setLayout(fl);        
		  p2.add(b);    
		  p2.add(b1);        
		  p2.add(b3);    
		  
		  f1.setLayout(gl21);    
		  f1.add(p1);    
		  f1.add(p2);    
		  f1.setSize(400,200);    
		  f1.setVisible(true); 
	}
		public static void main(String[] args) {
			new form();
			
		}
}
	